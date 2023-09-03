package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StandardItemUpdate implements UpdateQualityStrategy {


    @Override
    public void updateQualityStrategy(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.quality > 0 && item.quality < 50) {
            item.quality = item.quality - 1;
        }

    }
}
