package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredItemUpdate implements UpdateQualityStrategy {
    @Override
    public void updateQualityStrategy(Item item) {
        item.sellIn -= 1;
        if (item.quality > 0 && item.quality < 50) {
            if(item.sellIn >= 0) {
                item.quality -= 2;
            } else {
                item.quality -= 4;
            }
        }
    }
}
