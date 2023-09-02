package com.gildedrose;

import com.gildedrose.strategy.ItemUpdateStrategyFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private Item item;
    ItemUpdateStrategyFactory itemUpdateStrategyFactory = new ItemUpdateStrategyFactory();
    Item standardItem = new Item("foo", 10, 5);
    Item agedBrie = new Item("Aged Brie", 2, 2);
    Item backStagePasses = new Item("Backstage passes", 9, 3);
    Item backStagePasses1 = new Item("Backstage passes", 4, 6);
    Item sulfuras = new Item("Sulfuras", 0, 80);

    // TODO create tests that test more contingencies

    @Test
    void checkThatItemUpdateFactoryWorks(){
        Item[] items = {standardItem, agedBrie, backStagePasses, backStagePasses1, sulfuras};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals("foo", gildedRose.items[0].name);
        assertEquals(9, gildedRose.items[0].sellIn);
        assertEquals(4, gildedRose.items[0].quality);
        assertEquals("Aged Brie", gildedRose.items[1].name);
        assertEquals(1, gildedRose.items[1].sellIn);
        assertEquals(3, gildedRose.items[1].quality);
        assertEquals("Backstage passes", gildedRose.items[2].name);
        assertEquals(8, gildedRose.items[2].sellIn);
        assertEquals(5, gildedRose.items[2].quality);
        assertEquals("Backstage passes", gildedRose.items[3].name);
        assertEquals(3, gildedRose.items[3].sellIn);
        assertEquals(9, gildedRose.items[3].quality);
        assertEquals("Sulfuras", gildedRose.items[4].name);
        assertEquals(-1, gildedRose.items[4].sellIn);
        assertEquals(80, gildedRose.items[4].quality);

    }
}
