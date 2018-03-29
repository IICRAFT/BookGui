package com.willzcode;

import org.bukkit.entity.Player;

public class TestMain {
    public static void main(String[] args) {
        String page = PageBuilder.create()
                .addComponent(ComponentBuilder.create().setText("测试1 ").setColor("red").setClickOpenUrl("http://www.baidu.com").getComponent())
                .addComponent(ComponentBuilder.create().setText("测试2 ").setColor("green").setClickSuggestCommand("/help").getComponent())
                .addComponent(ComponentBuilder.create().setText("测试3 ").setColor("gold").setHoverShowText("test hover").getComponent())
                .addComponent(ComponentBuilder.create().setText("测试4").setColor("blue").setHoverRawValueWithoutQuote("show_text", "{\"text\":\"hello again\",\"color\":\"green\"}").getComponent())
                .getPage();
        System.out.println(page);


    }
}
