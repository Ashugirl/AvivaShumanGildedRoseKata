package com.gildedrose.strategy;

import com.gildedrose.Item;

// changed name of interface and class to avoid confusion with updateQuality() method in GildedRose class.
public interface UpdateQualityStrategy {
    void updateQualityStrategy(Item item);
}
