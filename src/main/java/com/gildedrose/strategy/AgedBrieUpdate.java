package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieUpdate implements UpdateQualityStrategy {


    @Override
    public void updateQualityStrategy(Item item) {
        item.sellIn -= 1;
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

}

