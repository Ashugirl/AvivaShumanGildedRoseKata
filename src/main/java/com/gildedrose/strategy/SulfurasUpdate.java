package com.gildedrose.strategy;

import com.gildedrose.Item;

public class SulfurasUpdate implements UpdateQualityStrategy {

    @Override
    public void updateQualityStrategy(Item item) {
        item.sellIn = 0;
        item.quality = 80;
    }
}
