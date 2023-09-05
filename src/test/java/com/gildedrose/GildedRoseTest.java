package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    Item standardItem = new Item("foo", 1, 10);
    Item agedBrie = new Item("Aged brie", 2, 49);
    Item backStagePassesJustOut = new Item("Backstage passes", 20, 15);
    Item backStagePassesConcertSoonish = new Item("Backstage passes", 9, 48);
    Item backStagePassesConcertReallySoon = new Item("Backstage passes", 4, 47);
    Item backStagePassesConcertOver = new Item("Backstage PaSSes", 0, 2);
    Item sulfuras = new Item("SuLfuras", 0, 80);
    Item conjuredItem = new Item("conjured", 5, 4);
    Item oldConjuredItem = new Item("conjured1", 1, 10);
    Item oldStandardItem = new Item("bar", 9, 1);
    Item[] items = {
        standardItem,
        agedBrie,
        backStagePassesJustOut,
        backStagePassesConcertSoonish,
        backStagePassesConcertReallySoon,
        backStagePassesConcertOver,
        sulfuras,
        conjuredItem,
        oldConjuredItem,
        oldStandardItem
    };


    @Test
    void checkThatSellInGoesDownByOneDaily() {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[0].sellIn);
        assertEquals(1, gildedRose.items[1].sellIn);
        assertEquals(19, gildedRose.items[2].sellIn);
        assertEquals(8, gildedRose.items[3].sellIn);
        assertEquals(3, gildedRose.items[4].sellIn);
        assertEquals(-1, gildedRose.items[5].sellIn);
        assertEquals(-1, gildedRose.items[6].sellIn);
        assertEquals(4, gildedRose.items[7].sellIn);
        gildedRose.updateQuality();
        assertEquals(-1, gildedRose.items[0].sellIn);
        assertEquals(0, gildedRose.items[1].sellIn);
        assertEquals(18, gildedRose.items[2].sellIn);
        assertEquals(7, gildedRose.items[3].sellIn);
        assertEquals(2, gildedRose.items[4].sellIn);
        assertEquals(-2, gildedRose.items[5].sellIn);
        assertEquals(-2, gildedRose.items[6].sellIn);
        assertEquals(3, gildedRose.items[7].sellIn);
    }

    @Test
    void checkThatStandardItemQualityUpdatesByOneButDoesNotGoNegative() {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[9].quality);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[9].quality);
    }

    @Test
    void checkThatStandardAndConjuredItemsDegradeTwiceAsFastAfterSellByDate(){
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(9, gildedRose.items[0].quality);
        assertEquals(8, gildedRose.items[8].quality);
        gildedRose.updateQuality();
        assertEquals(7, gildedRose.items[0].quality);
        assertEquals(4, gildedRose.items[8].quality);
    }

    @Test
    void checkThatAgedBrieQualityGoesUpButNotOver50() {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[1].quality);
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[1].quality);
    }

    @Test
    void checkThatBackstagePassesUpdateByRightIncrementsButNotOver50() {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        // > 10 days to concert
        assertEquals(14, gildedRose.items[2].quality);
        // between 10 and 5 days to concert
        assertEquals(50, gildedRose.items[3].quality);
        // fewer than 5 days to concert
        assertEquals(50, gildedRose.items[4].quality);
        // concert passed
        assertEquals(0, gildedRose.items[5].quality);

        gildedRose.updateQuality();
        // > 10 days to concert
        assertEquals(13, gildedRose.items[2].quality);
        // between 10 and 5 days to concert
        assertEquals(50, gildedRose.items[3].quality);
        // fewer than 5 days to concert
        assertEquals(50, gildedRose.items[4].quality);
        // concert passed
        assertEquals(0, gildedRose.items[5].quality);
    }

    @Test
    void checkThatSulfurasQualityStaysSame() {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(80, gildedRose.items[6].quality);
        gildedRose.updateQuality();
        assertEquals(80, gildedRose.items[6].quality);
    }

    @Test
    void checkThatConjuredItemsDegradeTwiceAsFast() {
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(2, gildedRose.items[7].quality);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[7].quality);
        gildedRose.updateQuality();
        assertEquals(0, gildedRose.items[7].quality);
    }
}
