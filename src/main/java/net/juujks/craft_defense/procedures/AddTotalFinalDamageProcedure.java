package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import java.util.ArrayList;

public class AddTotalFinalDamageProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        for (Entity entityiterator : new ArrayList<>(world.players())) {
            if (entityiterator.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
                for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
                    ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx); // removido .copy()
                    if ((entity.getPersistentData().getString("itemOwner"))
                            .equals(itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
                            .copyTag().getString("itemUUID"))) {
                        double currentDamage = itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
                                .copyTag().getDouble("totalDamage");
                        double damageToAdd = entity.getPersistentData().getDouble("finalDamage");
                        CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator,
                                tag -> tag.putDouble("totalDamage", currentDamage + damageToAdd));
                        _modHandlerIter.setStackInSlot(_idx, itemstackiterator); // re-inserir no slot
                        return; // item encontrado, encerra tudo
                    }
                }
            }
        }
    }
}