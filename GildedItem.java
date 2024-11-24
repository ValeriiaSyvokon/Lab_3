package com.gildedrose;

abstract class GildedItem {
    protected final Item item;

    protected GildedItem(Item item) {
        this.item = item;
    }

    public static GildedItem create(Item item) {
        switch (item.getName()) {
            case "Aged Brie":
                return new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            default:
                return new RegularItem(item);
        }
    }

    public abstract void update();
}

class AgedBrie extends GildedItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        item.getQuality().increase();
        item.getSellIn().decrease();
        if (item.getSellIn().isExpired()) {
            item.getQuality().increase();
        }
    }
}

class BackstagePass extends GildedItem {
    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    public void update() {
        item.getQuality().increase();
        if (item.getSellIn().getValue() < 10) {
            item.getQuality().increase();
        }
        if (item.getSellIn().getValue() < 5) {
            item.getQuality().increase();
        }
        item.getSellIn().decrease();
        if (item.getSellIn().isExpired()) {
            item.getQuality().reset();
        }
    }
}

class Sulfuras extends GildedItem {
    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void update() {
        // Legendary item does not change
    }
}

class RegularItem extends GildedItem {
    public RegularItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        item.getQuality().decrease();
        item.getSellIn().decrease();
        if (item.getSellIn().isExpired()) {
            item.getQuality().decrease();
        }
    }
}
