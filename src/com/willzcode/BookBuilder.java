package com.willzcode;

import com.comphenix.protocol.wrappers.BukkitConverters;
import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import com.comphenix.protocol.wrappers.nbt.NbtFactory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BookBuilder {
    ItemStack book;
    NbtCompound nbt;

    public BookBuilder() {
        book = new ItemStack(Material.WRITTEN_BOOK);
        book = BukkitConverters.getItemStackConverter().getSpecific(book);
        nbt = NbtFactory.asCompound(NbtFactory.fromItemTag(book));
    }

    public static BookBuilder create() {
        return new BookBuilder();
    }

    public BookBuilder addPage(String page) {
        nbt.getListOrDefault("pages").add(page);
        return this;
    }

    public ItemStack getBook() {
        NbtFactory.setItemTag(book, nbt);
        return book;
    }
}
