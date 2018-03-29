package com.willzcode;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import com.comphenix.protocol.wrappers.nbt.NbtFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.Configuration;
import java.util.*;

public class BookGui extends JavaPlugin {
    public static void openBook(Player p, ItemStack book) {
        int slot = p.getInventory().getHeldItemSlot();
        ItemStack old = p.getInventory().getItem(slot);
        p.getInventory().setItem(slot, book);
        try {
            PacketContainer pc = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.CUSTOM_PAYLOAD);
            pc.getModifier().writeDefaults();

            Class bfc, upc;
            try {
                bfc = MinecraftReflection.class.getClassLoader().loadClass("io.netty.buffer.ByteBuf");
                upc = MinecraftReflection.class.getClassLoader().loadClass("io.netty.buffer.Unpooled");
            } catch (Throwable var1) {
                bfc = MinecraftReflection.class.getClassLoader().loadClass("net.minecraft.util.io.netty.buffer.ByteBuf");
                upc = MinecraftReflection.class.getClassLoader().loadClass("net.minecraft.util.io.netty.buffer.Unpooled");
            }
            Object bf = upc.getMethod("buffer", int.class).invoke(null, 256);
            bfc.getMethod("setByte", int.class, int.class).invoke(bf, 0, 0);
            bfc.getMethod("writerIndex", int.class).invoke(bf, 1);

            pc.getModifier().write(1, MinecraftReflection.getPacketDataSerializer(bf));

            pc.getStrings().write(0, "MC|BOpen");
            ProtocolLibrary.getProtocolManager().sendServerPacket(p, pc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        p.getInventory().setItem(slot, old);
    }

    public static void openBook(Player p, List<String> pages){
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        book = BukkitConverters.getItemStackConverter().getSpecific(book);
        NbtCompound nbt = NbtFactory.asCompound(NbtFactory.fromItemTag(book));
        for(int i = 0; i < pages.size(); i++) {
            nbt.getListOrDefault("pages").add(pages.get(i));
        }
        NbtFactory.setItemTag(book, nbt);

        openBook(p, book);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§c[BookGui] By Willz copyright 2017-2017,IICraft.Com");
            sender.sendMessage("§f/bgui test§7 - Test the plugin");
            if(sender.isOp()){
                sender.sendMessage("§f/bgui reload§7 - Reloads the plugin");
                sender.sendMessage("§f/bgui update§7 - Updates the plugin");
            }
            return true;
        } else if (args[0].equalsIgnoreCase("test")) {
            if(sender instanceof Player){
                openBook((Player)sender, BookBuilder.create()
                    .addPage(PageBuilder.create()
                        .addComponent(ComponentBuilder.create().setText("测试1 ").setColor("red").setClickOpenUrl("http://www.baidu.com").getComponent())
                        .addComponent(ComponentBuilder.create().setText("测试2 ").setColor("green").setClickRunCommand("/help").getComponent())
                        .addComponent(ComponentBuilder.create().setText("测试3 ").setColor("gold").setHoverShowText("test hover").getComponent())
                        .addComponent(ComponentBuilder.create().setText("测试4").setColor("blue").setHoverRawValueWithoutQuote("show_text", "{\"text\":\"hello again\",\"color\":\"green\"}").getComponent())
                        .getPage())
                    .addPage(PageBuilder.create()
                            .addComponent(ComponentBuilder.create().setText("测试第二页 ").setColor("red").setClickOpenUrl("http://www.baidu.com").getComponent())
                            .addComponent(ComponentBuilder.create().setText("测试2 ").setColor("green").setClickRunCommand("/help").getComponent())
                            .addComponent(ComponentBuilder.create().setText("测试3 ").setColor("gold").setHoverShowText("test hover").getComponent())
                            .addComponent(ComponentBuilder.create().setText("测试4").setColor("blue").setHoverRawValueWithoutQuote("show_text", "{\"text\":\"hello again\",\"color\":\"green\"}").getComponent())
                            .getPage())
                    .getBook());
                sender.sendMessage("§aTest BookGui has sent!");
            }

            return true;
        } else if (args[0].equalsIgnoreCase("reload") && sender.isOp()) {
            load();
            sender.sendMessage("§aConfiguration reloaded!");
            return true;
        } else if (args[0].equalsIgnoreCase("update") && sender.isOp()) {
            //todo
//            Thread updaterThread = new Thread(new Runnable() {
//                public void run() {
//                    UpdaterHandler.manuallyCheckUpdates(sender);
//                }
//            });
//            updaterThread.start();
            return true;
        } else {
            sender.sendMessage("§cUnknown command. Type /bgui for help.");
            return true;
        }
    }

    public static void load() {
        //todo
        //Configuration.load();
    }
}
