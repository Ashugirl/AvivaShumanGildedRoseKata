package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StandardItemUpdate implements UpdateQuality {

    public StandardItemUpdate(){

    }

    @Override
    public void updateQuality(Item item) {
            item.sellIn = item.sellIn - 1;
            if (item.quality >= 0 && item.quality <=50) {
                item.quality = item.quality - 1;
            }

    }
}
