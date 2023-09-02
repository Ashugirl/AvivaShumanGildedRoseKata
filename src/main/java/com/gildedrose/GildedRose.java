package com.gildedrose;

import com.gildedrose.strategy.ItemUpdateStrategyFactory;
import com.gildedrose.strategy.UpdateQuality;

class GildedRose {
    Item[] items;

    private final ItemUpdateStrategyFactory itemUpdateStrategyFactory = new ItemUpdateStrategyFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // Implemented combined Strategy/Factory design pattern. Moved logic from this (context) class to strategy classes.
    // TODO - add update for conjured item.
    // TODO - create more tests
    // TODO - clean up formatting
    // TODO - create README.md
    public void updateQuality() {
        for(Item item  : items) {
            UpdateQuality updateQuality = itemUpdateStrategyFactory.getUpdateItemStrategy(item);
            updateQuality.updateQuality(item);
        }
    }
}
