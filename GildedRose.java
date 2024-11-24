package com.gildedrose;

class GildedRose {
    private final ItemCollection items;

    public GildedRose(ItemCollection items) {
        this.items = items;
    }

    public void updateQuality() {
        items.updateQuality();
    }
}
