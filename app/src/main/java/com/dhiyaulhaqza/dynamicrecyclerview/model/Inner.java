package com.dhiyaulhaqza.dynamicrecyclerview.model;

/**
 * Created by dhiyaulhaqza on 1/7/18.
 */

public class Inner {
    private int drawableId;
    private String name;

    public Inner(int drawableId, String name) {
        this.drawableId = drawableId;
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
