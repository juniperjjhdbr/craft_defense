package net.juujks.craft_defense.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.juujks.craft_defense.cdmap.CdmapEntry;
import net.juujks.craft_defense.cdmap.CdmapImporter;
import net.juujks.craft_defense.cdmap.CdmapIndex;
import net.juujks.craft_defense.network.EditCustomMapMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CustomMapsScreen extends Screen {

    // ── Texturas estáticas ────────────────────────────────────────────────────

    private static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/cmaps.png");
    private static final ResourceLocation IMPORT_TEX = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/import.png");
    private static final ResourceLocation IMPORT_TEX_H = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/importh.png");
    private static final ResourceLocation PLAY_TEX = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/play.png");
    private static final ResourceLocation PLAY_TEX_H = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/playh.png");
    private static final ResourceLocation EDIT_TEX = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/edit.png");
    private static final ResourceLocation EDIT_TEX_H = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/edith.png");
    private static final ResourceLocation CANCEL_TEX = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/cancel.png");
    private static final ResourceLocation CANCEL_TEX_H = ResourceLocation.fromNamespaceAndPath(
            "craft_defense", "textures/screens/cancelh.png");

    // ── Layout ────────────────────────────────────────────────────────────────

    private static final int TEX_W = 928;
    private static final int TEX_H = 522;
    private static final int GUI_W = TEX_W / 2; // 464
    private static final int GUI_H = TEX_H / 2; // 261
    private static final int BTN_W = 24;
    private static final int BTN_H = 24;

    // Thumbnail na lista: 16:9 pequeno
    private static final int THUMB_LIST_W = 57;
    private static final int THUMB_LIST_H = 32;

    // Thumbnail no painel de edição: maior
    private static final int THUMB_EDIT_W = 160;
    private static final int THUMB_EDIT_H = 90;

    // ── Cache de thumbnails ───────────────────────────────────────────────────

    // mapId → ResourceLocation da DynamicTexture registrada
    private final Map<Integer, ResourceLocation> thumbnailCache = new HashMap<>();

    // ── Estado ────────────────────────────────────────────────────────────────

    private final Screen parent;
    private MapListWidget mapList;
    private Component statusMessage = Component.empty();
    private int statusTimer = 0;
    private static final int COLOR_OK  = 0x55FF55;
    private static final int COLOR_ERR = 0xFF5555;
    private int statusColor = COLOR_OK;
    private int guiLeft, guiTop;

    // Estado do painel de edição
    private CdmapEntry editingEntry = null;
    private int editChallenge = 0;
    private int editDifficulty = 1;

    public CustomMapsScreen(Screen parent) {
        super(Component.empty());
        this.parent = parent;
    }

    // ── Thumbnail loader ──────────────────────────────────────────────────────

    /**
     * Carrega a thumbnail do disco e registra como DynamicTexture.
     * Retorna null se não encontrar ou falhar.
     */
    private ResourceLocation loadThumbnail(CdmapEntry entry) {
        if (thumbnailCache.containsKey(entry.getId()))
            return thumbnailCache.get(entry.getId());

        Path path = entry.getThumbnailPath();
        if (!java.nio.file.Files.exists(path)) return null;

        try {
            BufferedImage img = ImageIO.read(path.toFile());
            if (img == null) return null;

            // Converte BufferedImage → NativeImage
            int w = img.getWidth();
            int h = img.getHeight();
            com.mojang.blaze3d.platform.NativeImage nativeImage =
                    new com.mojang.blaze3d.platform.NativeImage(w, h, false);

            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    int argb = img.getRGB(x, y);
                    // Minecraft NativeImage usa ABGR
                    int a = (argb >> 24) & 0xFF;
                    int r = (argb >> 16) & 0xFF;
                    int gg = (argb >> 8) & 0xFF;
                    int b = argb & 0xFF;
                    nativeImage.setPixelRGBA(x, y, (a << 24) | (b << 16) | (gg << 8) | r);
                }
            }

            DynamicTexture dynTex = new DynamicTexture(nativeImage);
            ResourceLocation loc = ResourceLocation.fromNamespaceAndPath(
                    "craft_defense", "dynamic/cdmap_thumb_" + entry.getId());
            Minecraft.getInstance().getTextureManager().register(loc, dynTex);
            thumbnailCache.put(entry.getId(), loc);
            return loc;

        } catch (IOException e) {
            System.err.println("[CraftDefense] Failed to load thumbnail for map " + entry.getId() + ": " + e.getMessage());
            return null;
        }
    }

    /** Libera todas as texturas dinâmicas ao fechar a tela */
    private void releaseThumbnails() {
        thumbnailCache.forEach((id, loc) ->
                Minecraft.getInstance().getTextureManager().release(loc));
        thumbnailCache.clear();
    }

    // ── Init ─────────────────────────────────────────────────────────────────

    @Override
    protected void init() {
        guiLeft = (this.width  - GUI_W) / 2;
        guiTop  = (this.height - GUI_H) / 2;
        buildListView();
    }

    private void buildListView() {
        clearWidgets();
        editingEntry = null;

        // Altura da linha aumentada para caber thumbnail
        int rowH = THUMB_LIST_H + 8;

        int listTop    = guiTop + 20;
        int listBottom = guiTop + GUI_H - 30;

        mapList = new MapListWidget(this.minecraft, GUI_W - 16,
                listBottom - listTop, listTop, listBottom, rowH);
        mapList.setX(guiLeft + 8);
        mapList.refreshList();
        this.addWidget(mapList);

        // Botão import
        this.addRenderableWidget(new AbstractWidget(guiLeft + 8, guiTop + GUI_H - 28, BTN_W, BTN_H,
                Component.literal("Import .cdmap")) {
            @Override
            public void renderWidget(GuiGraphics g, int mx, int my, float pt) {
                g.blit(isHovered() ? IMPORT_TEX_H : IMPORT_TEX,
                        getX(), getY(), 0, 0, BTN_W, BTN_H, BTN_W, BTN_H);
            }
            @Override
            public void onClick(double mx, double my) { onImportClicked(); }
            @Override
            public void updateWidgetNarration(NarrationElementOutput o) {
                this.defaultButtonNarrationText(o);
            }
        });
    }

    private void buildEditView(CdmapEntry entry) {
        clearWidgets();
        editingEntry = entry;

        int cx = guiLeft + GUI_W / 2;
        int cy = guiTop  + GUI_H / 2 + 20; // deslocado para dar espaço à thumbnail

        // Challenge
        this.addRenderableWidget(Button.builder(Component.literal("<"),
                b -> { editChallenge = Math.max(0, editChallenge - 1); })
                .bounds(cx - 80, cy - 10, 20, 20).build());
        this.addRenderableWidget(Button.builder(Component.literal(">"),
                b -> { editChallenge = Math.min(5, editChallenge + 1); })
                .bounds(cx + 60, cy - 10, 20, 20).build());

        // Difficulty
        this.addRenderableWidget(Button.builder(Component.literal("<"),
                b -> { editDifficulty = Math.max(1, editDifficulty - 1); })
                .bounds(cx - 80, cy + 20, 20, 20).build());
        this.addRenderableWidget(Button.builder(Component.literal(">"),
                b -> { editDifficulty = Math.min(7, editDifficulty + 1); })
                .bounds(cx + 60, cy + 20, 20, 20).build());

        // Confirm / Cancel
        this.addRenderableWidget(Button.builder(Component.literal("Confirm"),
                b -> onConfirmEdit())
                .bounds(cx - 42, cy + 50, 80, 20).build());
        this.addRenderableWidget(Button.builder(Component.literal("Cancel"),
                b -> buildListView())
                .bounds(cx - 42, cy + 75, 80, 20).build());
    }

    // ── Render ───────────────────────────────────────────────────────────────

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(g, mouseX, mouseY, partialTick);

        // Background da GUI
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        g.pose().pushPose();
        g.pose().translate(guiLeft, guiTop, 0);
        g.pose().scale(0.5f, 0.5f, 1f);
        g.blit(BACKGROUND, 0, 0, 0, 0, TEX_W, TEX_H, TEX_W, TEX_H);
        g.pose().popPose();
        RenderSystem.disableBlend();

        super.render(g, mouseX, mouseY, partialTick);

        if (editingEntry == null) {
            // ── Vista da lista ────────────────────────────────────────────────
            mapList.render(g, mouseX, mouseY, partialTick);

            if (mapList.children().isEmpty()) {
                g.drawCenteredString(this.font,
                        Component.literal("No maps imported yet."),
                        this.width / 2, this.height / 2, 0xAAAAAA);
            }
        } else {
            // ── Vista do editor ───────────────────────────────────────────────
            int cx = guiLeft + GUI_W / 2;
            int cy = guiTop  + GUI_H / 2 + 20;

            // Título
            g.drawCenteredString(this.font,
                    Component.literal("Editing: " + editingEntry.getName()),
                    cx, guiTop + 8, 0xFFFFFF);

            // Thumbnail centralizada no topo do painel
            ResourceLocation thumb = loadThumbnail(editingEntry);
            int thumbX = cx - THUMB_EDIT_W / 2;
            int thumbY = guiTop + 20;
            if (thumb != null) {
                g.blit(thumb, thumbX, thumbY, 0, 0,
                        THUMB_EDIT_W, THUMB_EDIT_H, THUMB_EDIT_W, THUMB_EDIT_H);
            } else {
                g.fill(thumbX, thumbY, thumbX + THUMB_EDIT_W, thumbY + THUMB_EDIT_H, 0xFF333333);
                g.drawCenteredString(this.font, Component.literal("No preview"),
                        cx, thumbY + THUMB_EDIT_H / 2 - 4, 0x888888);
            }

            // Challenge
            g.drawCenteredString(this.font,
                    Component.literal("Challenge: " + challengeName(editChallenge)),
                    cx, cy - 14, 0xFFFFFF);

            // Difficulty
            g.drawCenteredString(this.font,
                    Component.literal("Difficulty: " + editDifficulty),
                    cx, cy + 16, 0xFFFFFF);
        }

        if (statusTimer > 0) {
            g.drawCenteredString(this.font, statusMessage,
                    this.width / 2, guiTop + GUI_H - 12, statusColor);
            statusTimer--;
        }
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private String challengeName(int c) {
        return switch (c) {
            case 0 -> "Default";
            case 1 -> "Half Money";
            case 2 -> "Unsellable";
            case 3 -> "Aerial Enemies";
            case 4 -> "No Unit Level";
            case 5 -> "Single Units";
            default -> String.valueOf(c);
        };
    }

    private void onConfirmEdit() {
        if (editingEntry == null) return;
        net.neoforged.neoforge.network.PacketDistributor.sendToServer(
                new EditCustomMapMessage(editChallenge, editDifficulty));
        statusMessage = Component.literal("Settings applied!");
        statusColor = COLOR_OK;
        statusTimer = 100;
        buildListView();
    }

    private void onImportClicked() {
        new Thread(() -> {
            File file = CdmapImporter.openFilePicker();
            if (file == null) return;
            CdmapImporter.ImportResult result = CdmapImporter.importCdmap(file);
            this.minecraft.execute(() -> showResult(result));
        }, "cdmap-import-thread").start();
    }

    private void showResult(CdmapImporter.ImportResult result) {
        switch (result) {
            case SUCCESS           -> { statusMessage = Component.literal("Map imported successfully!"); statusColor = COLOR_OK; if (mapList != null) mapList.refreshList(); }
            case FILE_TOO_LARGE    -> setError("File exceeds 64MB limit.");
            case NOT_A_ZIP         -> setError("Invalid .cdmap file.");
            case MISSING_MANIFEST  -> setError("Missing manifest.json.");
            case MISSING_NBT       -> setError("Missing map.nbt.");
            case MISSING_THUMBNAIL -> setError("Missing thumbnail.png.");
            case INVALID_MANIFEST  -> setError("Invalid or incomplete manifest.");
            case ALREADY_IMPORTED  -> setError("This map is already imported.");
            case IO_ERROR          -> setError("IO error during import.");
        }
        statusTimer = 100;
    }

    private void setError(String msg) {
        statusMessage = Component.literal(msg);
        statusColor = COLOR_ERR;
    }

    @Override
    public void onClose() {
        releaseThumbnails();
        this.minecraft.setScreen(parent);
    }

    @Override
    public boolean isPauseScreen() { return false; }

    // ── Map List Widget ───────────────────────────────────────────────────────

    class MapListWidget extends ObjectSelectionList<MapListWidget.MapEntry> {

        private final int rowHeight;

        public MapListWidget(Minecraft mc, int width, int height, int y0, int y1, int rowHeight) {
            super(mc, width, height, y0, rowHeight);
            this.rowHeight = rowHeight;
        }

        public void refreshList() {
            this.clearEntries();
            for (CdmapEntry entry : CdmapIndex.loadIndex())
                this.addEntry(new MapEntry(entry));
        }

        @Override public int getRowWidth() { return GUI_W - 32; }
        @Override protected int getScrollbarPosition() { return this.getX() + this.getWidth() - 6; }

        class MapEntry extends ObjectSelectionList.Entry<MapEntry> {

            private final CdmapEntry data;
            public MapEntry(CdmapEntry data) { this.data = data; }

            @Override
            public void render(GuiGraphics g, int index, int top, int left,
                               int width, int height, int mouseX, int mouseY,
                               boolean isHovered, float partialTick) {

                if (isHovered)
                    g.fill(left, top, left + width, top + height, 0x44FFFFFF);

                // Thumbnail na lista
                ResourceLocation thumb = loadThumbnail(data);
                int thumbY = top + (height - THUMB_LIST_H) / 2;
                if (thumb != null) {
                    g.blit(thumb, left + 4, thumbY, 0, 0,
                            THUMB_LIST_W, THUMB_LIST_H, THUMB_LIST_W, THUMB_LIST_H);
                } else {
                    g.fill(left + 4, thumbY, left + 4 + THUMB_LIST_W, thumbY + THUMB_LIST_H, 0xFF222222);
                }

                // Texto ao lado da thumbnail
                int textX = left + 4 + THUMB_LIST_W + 6;
                g.drawString(CustomMapsScreen.this.font,
                        data.getName(), textX, top + 8, 0xFFFFFF);
                g.drawString(CustomMapsScreen.this.font,
                        "ID: " + data.getId() + "  |  Act: " + data.getAct(),
                        textX, top + 19, 0xAAAAAA);

                // 3 botões: play, edit, delete
                int bx = left + width - (BTN_W * 3) - 14;
                int by = top  + (height - BTN_H) / 2;

                boolean ph = isHov(mouseX, mouseY, bx, by);
                boolean eh = isHov(mouseX, mouseY, bx + BTN_W + 4, by);
                boolean dh = isHov(mouseX, mouseY, bx + (BTN_W + 4) * 2, by);

                g.blit(ph ? PLAY_TEX_H   : PLAY_TEX,   bx,                   by, 0, 0, BTN_W, BTN_H, BTN_W, BTN_H);
                g.blit(eh ? EDIT_TEX_H   : EDIT_TEX,   bx + BTN_W + 4,       by, 0, 0, BTN_W, BTN_H, BTN_W, BTN_H);
                g.blit(dh ? CANCEL_TEX_H : CANCEL_TEX, bx + (BTN_W + 4) * 2, by, 0, 0, BTN_W, BTN_H, BTN_W, BTN_H);
            }

            private boolean isHov(int mx, int my, int bx, int by) {
                return mx >= bx && mx < bx + BTN_W && my >= by && my < by + BTN_H;
            }

            @Override
            public boolean mouseClicked(double mx, double my, int btn) {
                int left  = MapListWidget.this.getRowLeft();
                int width = MapListWidget.this.getRowWidth();
                int bx    = left + width - (BTN_W * 3) - 14;
                int idx   = MapListWidget.this.children().indexOf(this);
                int top   = MapListWidget.this.getRowTop(idx);
                int by    = top + (rowHeight - BTN_H) / 2;

                if (isHov((int)mx, (int)my, bx, by)) {
                    onPlayClicked(data); return true;
                }
                if (isHov((int)mx, (int)my, bx + BTN_W + 4, by)) {
                    onEditClicked(data); return true;
                }
                if (isHov((int)mx, (int)my, bx + (BTN_W + 4) * 2, by)) {
                    onDeleteClicked(data); return true;
                }
                return false;
            }

            private void onPlayClicked(CdmapEntry data) {
                net.neoforged.neoforge.network.PacketDistributor.sendToServer(
                        new net.juujks.craft_defense.network.LoadCustomMapMessage(
                                data.getId(), 0, 0, 0));
                CustomMapsScreen.this.onClose();
            }

            private void onEditClicked(CdmapEntry data) {
                editChallenge = 0;
                editDifficulty = 1;
                buildEditView(data);
            }

            private void onDeleteClicked(CdmapEntry data) {
                // Remove do índice
                CdmapIndex.removeEntry(data.getId());
                // Libera a textura do cache
                ResourceLocation cached = thumbnailCache.remove(data.getId());
                if (cached != null)
                    Minecraft.getInstance().getTextureManager().release(cached);
                // Apaga a pasta do disco
                try {
                    java.nio.file.Path folder = CdmapIndex.getCdmapsFolder().resolve(data.getFolderName());
                    if (java.nio.file.Files.exists(folder)) {
                        java.nio.file.Files.walk(folder)
                                .sorted(java.util.Comparator.reverseOrder())
                                .forEach(p -> { try { java.nio.file.Files.delete(p); } catch (Exception ignored) {} });
                    }
                } catch (Exception e) {
                    System.err.println("[CraftDefense] Failed to delete map folder: " + e.getMessage());
                }
                statusMessage = Component.literal("Map deleted.");
                statusColor = COLOR_ERR;
                statusTimer = 100;
                buildListView();
            }

            @Override
            public Component getNarration() { return Component.literal(data.getName()); }
        }
    }
}