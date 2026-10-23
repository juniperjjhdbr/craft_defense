package net.juujks.craft_defense.cdmap;

import java.nio.file.Path;

/**
 * Represents a single imported custom map entry.
 */
public class CdmapEntry {

    private final int id;
    private final String name;
    private final int act;
    private final String folderName;

    public CdmapEntry(int id, String name, int act, String folderName) {
        this.id = id;
        this.name = name;
        this.act = act;
        this.folderName = folderName;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAct() { return act; }

    /**
     * The folder name inside cdmaps/ (e.g. "1_fortress_of_doom")
     */
    public String getFolderName() { return folderName; }

    /**
     * Full path to this map's thumbnail.png on disk.
     */
    public Path getThumbnailPath() {
        return CdmapIndex.getCdmapsFolder()
                .resolve(folderName)
                .resolve("thumbnail.png");
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " (Act " + act + ")";
    }
}