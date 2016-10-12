package com.gildedrose

import org.scalatest._

class GildedRoseTest extends FlatSpec with Matchers {
  it should "reduce an item's quality by 1 if before the sell by date" in {
    var items = Array[Item](new Item("foo", 1, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (9)
  }

  it should "reduce an item's quality by 2 if past the sell by date" in {
    var items = Array[Item](new Item("foo", 0, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (8)
  }

  it should "cannot reduce an item's quality below 0" in {
    var items = Array[Item](new Item("foo", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (0)
  }

  it should "increase the quality of Aged Brie by 1 if before sell by date" in {
    var items = Array[Item](new Item("Aged Brie", 1, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (11)
  }

  it should "increase the quality of Aged Brie by 2 if after sell by date" in {
    var items = Array[Item](new Item("Aged Brie", 0, 10))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (12)
  }

  it should "not increase the quality of an item above 50" in {
    var items = Array[Item](new Item("Aged Brie", 10, 50))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (50)
  }

  it should "not dimish the awesome power of Sulfuras" in {
    var items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 0, 80))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (80)
  }

  it should "increase the quality of backstage passes by 2 when there are 10 days or less" in {
    var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (22)
  }

  it should "increase the quality of backstage passes by 3 when there are 3 days or less" in {
    var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (23)
  }

  it should "decrease the quality of backstage passes to 0 when the concert has passed" in {
    var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (0)
  }

  it should "decrease the quality of conjured items by 2 before sell by date" in {
    var items = Array[Item](new Item("Conjured Water", 1, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (18)
  }

  it should "decrease the quality of conjured items by 4 after sell by date" in {
    var items = Array[Item](new Item("Conjured Water", 0, 20))
    val app = new GildedRose(items)
    app.updateQuality()
    (app.items(0).quality) should equal (16)
  }
}
