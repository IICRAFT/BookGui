package com.willzcode;


import java.util.ArrayList;
import java.util.List;

public class PageBuilder {
    List<Component> componentList;

    public PageBuilder() {
        componentList = new ArrayList<>();
    }

    public static PageBuilder create() {
        return new PageBuilder();
    }

    public PageBuilder addComponent(Component component) {
        componentList.add(component);
        return this;
    }

    public String getPage() {
        String page = "[";
        for(int i = 0; i < componentList.size(); i++) {
            if(i > 0)
                page += ",";
            page += componentList.get(i).toString();
        }
        page += "]";
        return page;
    }
}
