package com.exorath.plugin.shopItem;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by toonsev on 5/11/2017.
 */
public class ItemHandler implements Listener {
    private Integer itemSlot;

    public ItemHandler(YamlConfigProvider configProvider) {
        this.itemSlot = configProvider.getSlot();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(itemSlot == null)
            return;
        event.getPlayer().getInventory().setItem(itemSlot, getItemStack(event.getPlayer()));
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(itemSlot == null)
            return;
        if(event.getPlayer().getInventory().getHeldItemSlot() != itemSlot)
            return;
        event.setCancelled(true);
        event.getPlayer().sendMessage(ChatColor.WHITE + "Visit The Store at: " + ChatColor.GOLD + ChatColor.UNDERLINE.toString() + "https://store.exorath.com");
    }

    public ItemStack getItemStack(Player player){
        ItemStack itemStack = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Go To " + ChatColor.GOLD + "Store " + ChatColor.GRAY + "(Right Click for Link)");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
