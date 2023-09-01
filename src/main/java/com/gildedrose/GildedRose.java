package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // Changed tactic for moment given time constraints. Cleaned up method.
    // TODO - add update for conjured item.
    // TODO - simplify more if time allows (ideally use Strategy Design pattern?)
    // TODO - create tests
    public void updateQuality() {
        for (Item item : items) {
            item.sellIn = item.sellIn - 1;
            if (item.name.equalsIgnoreCase("Aged Brie") && item.quality <= 50) {
                item.quality = item.quality + 1;
            } else if (item.name.contains("Sulfuras")) {
                item.sellIn = 0;
                item.quality = 80;
            } else if (item.name.contains("Backstage passes") && (item.sellIn <= 10 && item.sellIn > 5)) {
                item.quality = item.quality + 2;
            } else if (item.name.contains("Backstage passes") && item.sellIn <= 5 && item.sellIn >= 0) {
                item.quality = item.quality + 3;
            } else if (item.quality > 0) {
                item.quality = item.quality - 1;
            } else {
                item.quality = 0;
            }
        }
    }
}
