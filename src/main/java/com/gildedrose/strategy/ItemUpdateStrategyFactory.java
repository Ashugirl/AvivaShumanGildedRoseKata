package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ItemUpdateStrategyFactory {

    private final UpdateQuality standardItemUpdate = new StandardItemUpdate();
    private final UpdateQuality agedBrieUpdate = new AgedBrieUpdate();
    private final UpdateQuality backstagePassesUpdate = new BackstagePassesUpdate();
    private final UpdateQuality sulfurasUpdate = new SulfurasUpdate();



    public UpdateQuality getUpdateItemStrategy(Item item) {
        UpdateQuality updateQuality;
        if(item.name.equalsIgnoreCase("Aged Brie")){
            updateQuality = agedBrieUpdate;
        } else if (item.name.contains("Backstage passes")) {
            updateQuality = backstagePassesUpdate;
        } else if (item.name.contains("Sulfuras")) {
            updateQuality = sulfurasUpdate;
        } else {
            updateQuality = standardItemUpdate;
        }
        return updateQuality;
    }
}
