package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePassesUpdate implements UpdateQualityStrategy {

    @Override
    public void updateQualityStrategy(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.sellIn <= 10 && item.sellIn > 5) {
            item.quality = item.quality + 2;
        } else if (item.sellIn <= 5 && item.sellIn >= 0) {
            item.quality = item.quality + 3;
        } else if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            item.quality = item.quality - 1;
        }
    }
}


