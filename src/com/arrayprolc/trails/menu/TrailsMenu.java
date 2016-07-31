package com.arrayprolc.trails.menu;

import java.util.HashMap;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.arrayprolc.trails.effects.EffectManager;
import com.arrayprolc.trails.effects.EffectManager.EffectType;
import com.arrayprolc.trails.extra.LoreManager;
import com.arrayprolc.trails.item.ItemTools;
import com.arrayprolc.trails.util.UtilMath;
import com.arrayprolc.trails.util.UtilMenu;
import com.arrayprolc.trails.util.UtilPermission;

public class TrailsMenu {

    public static Inventory openMenu(Player p) {
        return openMenu(p, true);
    }

    public static Inventory openMenu(Player p, boolean b) {

        int size = UtilMath.roundToNearest(9, EffectType.values().length + 9 * 2);

        // 38, 42
        size = size + 18;

        Inventory menu = Bukkit.createInventory(null, size, "§lParticles");
        HashMap<EffectType, Integer> allowed = new HashMap<EffectType, Integer>();
        int current = 0;
        int[] allow = UtilMenu.getAllowedSlots();

        for (EffectType e : EffectType.values()) {
            try {
                int slot = allow[current];
                allowed.put(e, slot);
                current++;
            } catch (Exception ex) {
                // The item is null, that's okay, just ignore it.
            }
        }

        for (EffectType e : allowed.keySet()) {
            if (!e.equals(EffectType.Footstep)) {
                ItemStack i;

                if (EffectManager.getEffect(p) == e) {
                    if (UtilPermission.hasPermission(p, e)) {
                        i = ItemTools.setName(new ItemStack(Material.INK_SACK, 1, (byte) 5), "§b" + e.toString() + " §7Trail", new String[] { LoreManager.getExclusive(e), "§a§lEnabled" });
                    } else {
                        i = ItemTools.setName(new ItemStack(Material.INK_SACK, 1, (byte) 5), "§b" + e.toString() + " §7Trail", new String[] { LoreManager.getExclusive(e), "§a§lEnabled" });
                    }
                    // i.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 32);
                    // i = addGlow(i);
                } else {
                    if (UtilPermission.hasPermission(p, e)) {
                        i = ItemTools.setName(new ItemStack(Material.INK_SACK, 1, (byte) 10), "§b" + e.toString() + " §7Trail", new String[] { LoreManager.getExclusive(e) });
                    } else {
                        i = ItemTools.setName(new ItemStack(Material.INK_SACK, 1, (byte) 8), "§b" + e.toString() + " §7Trail", new String[] { LoreManager.getExclusive(e) });
                    }
                }
                int slot = allowed.get(e).intValue();
                menu.setItem(slot, i);
            }
        }
        ItemStack i;
        i = ItemTools.setName(new ItemStack(Material.STONE, 1, (byte) 6), "§a§lFREE §bFootstep §7Trail");
        if (EffectManager.getEffect(p) == EffectType.Footstep) {
            i = ItemTools.setName(new ItemStack(Material.STONE, 1, (byte) 2), "§a§lFREE §bFootstep §7Trail", "§a§lEnabled");
            // i.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
            // i = addGlow(i);
        }
        menu.setItem(38, i);

        ItemStack i2;
        i2 = ItemTools.setName(new ItemStack(Material.BARRIER), "§cDisable All");
        menu.setItem(42, i2);
        if (b) {
            p.openInventory(menu);
        }
        return menu;

    }

    public static ItemStack addGlow(ItemStack item) {
        net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = null;
        if (!nmsStack.hasTag()) {
            tag = new NBTTagCompound();
            nmsStack.setTag(tag);
        }
        if (tag == null)
            tag = nmsStack.getTag();
        NBTTagList ench = new NBTTagList();
        tag.set("ench", ench);
        nmsStack.setTag(tag);
        return CraftItemStack.asCraftMirror(nmsStack);
    }

}
