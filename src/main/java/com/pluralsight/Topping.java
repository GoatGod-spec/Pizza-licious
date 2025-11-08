package com.pluralsight;

public class Topping {

    private String name;
    private String type;
    private int extra;

    public Topping(String name, String type, int extra) {
        this.name = name;
        this.type = type;
        this.extra = extra;
    }
    public Topping(String name, String type) {
        this(name, type, 0);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getExtra() {
        return extra;
    }

    @Override
    public String toString() {
        if (extra > 0) {
            return name + " (" + type + ", extra x" + extra + ")";
        } else {
            return name + " (" + type + ")";
        }
    }
}
