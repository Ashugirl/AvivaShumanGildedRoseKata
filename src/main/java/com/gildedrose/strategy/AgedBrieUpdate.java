package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieUpdate implements UpdateQuality {

    public AgedBrieUpdate() {

    }

    @Override
    public void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.quality <= 50) {
            item.quality = item.quality + 1;
        }
    }

}

