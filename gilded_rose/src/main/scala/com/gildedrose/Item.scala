package com.gildedrose

class Item(val name: String, var sellIn: Int, var quality: Int) {

}

trait ItemQualityDegredation {
  def update(item: Item)
  def delta(item: Item): Int
}

object ItemQualityDegredation {
  def apply(name: String): ItemQualityDegredation = {
    name match {
      case "Aged Brie" => new AgedBrieQualityAppreciation
      case "Sulfuras, Hand of Ragnaros" => new AgedBrieQualityAppreciation
      case "Backstage passes to a TAFKAL80ETC concert" => new BackstagePassesDegredation
      case "Conjured Water" => new ConjuredItemDegredation
      case _ => new BaseQualityDegredation
    }
  }

  private class BaseQualityDegredation extends ItemQualityDegredation {
    def update(item: Item) = {
      item.quality = item.quality - delta(item)
    }

    def delta(item: Item): Int = {
      item match {
        case item if item.quality == 0 => 0
        case item if item.sellIn > 0 => 1
        case _ => 2
      }
    }
  }

  private class AgedBrieQualityAppreciation extends BaseQualityDegredation {
    override def delta(item: Item): Int = {
      if(item.quality < 50) {
        super.delta(item) * -1
      } else {
        0
      }
    }
  }

  private class SulfurasQualityDegredation extends BaseQualityDegredation {
    override def delta(item: Item): Int = {
      0
    }
  }

  private class BackstagePassesDegredation extends BaseQualityDegredation {
    override def delta(item: Item): Int = {
      item.sellIn match {
        case sellIn if sellIn <= 0 => item.quality
        case sellIn if sellIn <= 5 => -3
        case sellIn if sellIn <= 10 => -2
      }
    }
  }

  private class ConjuredItemDegredation extends BaseQualityDegredation {
    override def delta(item: Item): Int = {
      super.delta(item) * 2
    }
  }
}

