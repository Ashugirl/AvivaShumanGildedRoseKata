package com.gildedrose.strategy.strategyFactory;

import com.gildedrose.Item;
import com.gildedrose.strategy.*;

public class ItemUpdateStrategyFactory {

    private final UpdateQualityStrategy standardItemUpdate = new StandardItemUpdate();
    private final UpdateQualityStrategy agedBrieUpdate = new AgedBrieUpdate();
    private final UpdateQualityStrategy backstagePassesUpdate = new BackstagePassesUpdate();
    private final UpdateQualityStrategy sulfurasUpdate = new SulfurasUpdate();
    private final UpdateQualityStrategy conjuredItemUpdate = new ConjuredItemUpdate();


    public UpdateQualityStrategy getUpdateItemStrategy(Item item) {
        UpdateQualityStrategy updateQualityStrategy;
        if (item.name.equalsIgnoreCase("Aged Brie")) {
            updateQualityStrategy = agedBrieUpdate;
        } else if (item.name.regionMatches(true, 0, "Backstage passes", 0, 16)) {
            updateQualityStrategy = backstagePassesUpdate;
        } else if (item.name.regionMatches(true, 0, "Sulfuras", 0, 8)) {
            updateQualityStrategy = sulfurasUpdate;
        } else if (item.name.regionMatches(true, 0, "Conjured", 0, 8)) {
            updateQualityStrategy = conjuredItemUpdate;
        } else {
            updateQualityStrategy = standardItemUpdate;
        }
        return updateQualityStrategy;
    }
}
