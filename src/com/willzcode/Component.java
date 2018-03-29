package com.willzcode;

import org.bukkit.inventory.ItemStack;

public class Component {
    String text;
    String color;
    boolean bold;
    boolean italic;
    boolean underlined;
    boolean strikethrough;
    boolean obfuscated;

    String clickAction;
    String clickValue;

    String hoverAction;
    String hoverValue;
    boolean hoverValueQuote;

    //todo insertion

    //todo
    //hoverItemStack
    //hoverEntity
    //hoverAchievement

    //todo
    //compataple with placeholderApi


    public Component() {
        text = "";
        color = "";
        bold = false;
        italic = false;
        underlined = false;
        strikethrough = false;
        obfuscated = false;
        clickAction = "";
        clickValue = "";
        hoverAction = "";
        hoverValue = "";
        hoverValueQuote = true;
    }

    @Override
    public String toString() {
        String s = "{\"text\":\"" + text + "\"";
        if(!color.isEmpty())
            s += ",\"color\":\"" + color + "\"";
        else
            s += ",\"color\":\"black\"";
        if(bold)
            s += ",\"bold\":true";
        if(italic)
            s += ",\"italic\":true";
        if(underlined)
            s += ",\"underlined\":true";
        else
            s += ",\"underlined\":false";
        if(strikethrough)
            s += ",\"strikethrough\":true";
        if(obfuscated)
            s += ",\"obfuscated\":true";
        if(!clickAction.isEmpty())
            s += ",\"clickEvent\":{\"action\":\"" + clickAction + "\",\"value\":\""+clickValue+"\"}";
        else
            s += ",\"clickEvent\":{\"action\":\"\",\"value\":\"\"}";
        if(!hoverAction.isEmpty())
            if(hoverValueQuote)
                s += ",\"hoverEvent\":{\"action\":\"" + hoverAction + "\",\"value\":\""+hoverValue+"\"}";
            else
                s += ",\"hoverEvent\":{\"action\":\"" + hoverAction + "\",\"value\":"+hoverValue+"}";
        s += "}";
        return s;
    }
    public void setText(String text) {
        this.text = text;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBold() {
        this.bold = true;
    }

    public void setItalic() {
        this.italic = true;
    }

    public void setUnderlined() {
        this.underlined = true;
    }

    public void setStrikethrough() {
        this.strikethrough = true;
    }

    public void setObfuscated() {
        this.obfuscated = true;
    }

    public void setClickAction(String clickAction) {
        this.clickAction = clickAction;
    }

    public void setClickValue(String clickValue) {
        this.clickValue = clickValue;
    }

    public void setHoverAction(String hoverAction) {
        this.hoverAction = hoverAction;
    }

    public void setHoverValue(String hoverValue) {
        this.hoverValue = hoverValue;
    }

    public void setHoverValueQuote(boolean quote) {
        this.hoverValueQuote = quote;
    }
}
