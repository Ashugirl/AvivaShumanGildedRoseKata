package com.gildedrose;

import com.gildedrose.strategy.UpdateQualityStrategy;
import com.gildedrose.strategy.strategyFactory.ItemUpdateStrategyFactory;

class GildedRose {
    Item[] items;

    private final ItemUpdateStrategyFactory itemUpdateStrategyFactory = new ItemUpdateStrategyFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // Implemented combined Strategy/Factory design pattern. Moved logic from this (context) class to strategy classes.
    // TODO - create more tests
    // TODO - create README.md
    public void updateQuality() {
        for (Item item : items) {
            UpdateQualityStrategy updateQualityStrategy = itemUpdateStrategyFactory.getUpdateItemStrategy(item);
            updateQualityStrategy.updateQualityStrategy(item);
        }
    }
}
