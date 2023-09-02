package com.gildedrose.strategy;

import com.gildedrose.Item;
import com.gildedrose.strategy.UpdateQuality;

public class SulfurasUpdate implements UpdateQuality {

    public SulfurasUpdate() {

    }

    public SulfurasUpdate(Item item) {
    }

    @Override
    public void updateQuality(Item item) {
        item.sellIn = item.sellIn - 1;
        item.quality = 80;
    }
}
