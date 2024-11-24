package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class ItemCollection {
    private final List<GildedItem> items;

    public ItemCollection(Item[] items) {
        this.items = new ArrayList<>();
        for (Item item : items) {
            this.items.add(GildedItem.create(item));
        }
    }

    public void updateQuality() {
        for (GildedItem item : items) {
            item.update();
        }
    }
}
