package com.gildedrose

class GildedRose(val items: Array[Item]) {
  def updateQuality() {
    for (i <- 0 until items.length) {
      ItemQualityDegredation(items(i).name).update(items(i))
    }
  }
}
