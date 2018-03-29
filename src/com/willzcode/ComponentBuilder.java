package com.willzcode;

public class ComponentBuilder {
    Component component;

    public ComponentBuilder() {
        component = new Component();
    }

    public static ComponentBuilder create(){
        return new ComponentBuilder();
    }

    public Component getComponent() {
        return component;
    }

    public ComponentBuilder setText(String text) {
        component.setText(text);
        return this;
    }

    public ComponentBuilder setColor(String color) {
        component.setColor(color);
        return this;
    }

    public ComponentBuilder setBold() {
        component.setBold();
        return this;
    }

    public ComponentBuilder setItalic() {
        component.setItalic();
        return this;
    }

    public ComponentBuilder setUnderlined() {
        component.setUnderlined();
        return this;
    }

    public ComponentBuilder setStrikethrough() {
        component.setStrikethrough();
        return this;
    }

    public ComponentBuilder setObfuscated() {
        component.setObfuscated();
        return this;
    }

    public ComponentBuilder setClickRunCommand(String cmd) {
        component.setClickAction("run_command");
        component.setClickValue(cmd);
        return this;
    }

    public ComponentBuilder setClickSuggestCommand(String cmd) {
        component.setClickAction("suggest_command");
        component.setClickValue(cmd);
        return this;
    }

    public ComponentBuilder setClickOpenUrl(String url) {
        component.setClickAction("open_url");
        component.setClickValue(url);
        return this;
    }

    public ComponentBuilder setClickChangePage(int page) {
        component.setClickAction("change_page");
        component.setClickValue(String.valueOf(page));
        return this;
    }

    public ComponentBuilder setClickRawValue(String action, String value) {
        component.setClickAction(action);
        component.setClickValue(value);
        return this;
    }

    //todo insertion

    public ComponentBuilder setHoverShowText(String text) {
        component.setHoverAction("show_text");
        component.setHoverValue(text);
        return this;
    }

    //todo
    //public ComponentBuilder setHoverShowItem()

    public ComponentBuilder setHoverRawValue(String action, String value) {
        component.setHoverAction(action);
        component.setHoverValue(value);
        component.setHoverValueQuote(true);
        return this;
    }

    public ComponentBuilder setHoverRawValueWithoutQuote(String action, String value) {
        component.setHoverAction(action);
        component.setHoverValue(value);
        component.setHoverValueQuote(false);
        return this;
    }
}
