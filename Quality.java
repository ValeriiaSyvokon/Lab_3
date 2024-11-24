package com.gildedrose;

public class Quality {
    private int value;

    public Quality(int value) {
        this.value = Math.max(0, Math.min(50, value));
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        if (value < 50) {
            value++;
        }
    }

    public void decrease() {
        if (value > 0) {
            value--;
        }
    }

    public void reset() {
        value = 0;
    }
}
