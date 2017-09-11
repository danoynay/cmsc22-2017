import tester.Tester;

class GroceryItem {
  String name;
  double price;

  GroceryItem(String name, double price) {
    this.name = name;
    this.price = price;
  }


  // TEMPLATE
  /*
    Fields:
    ... this.name ...  -- String
    ... this.price ... -- double
   */

  // double -> double
  // Returns the sale price of this GroceryItem
  // given a sale percentage
  double salePrice(double sale) {
    return this.price * (1 - sale);
  }
}

class ExamplesGroceryItem {
  ExamplesGroceryItem() { }

  GroceryItem carrots = new GroceryItem("Carrots", 25);
  GroceryItem tissue = new GroceryItem("Tissue", 35);

  boolean testSalePrice(Tester t) {
    return t.checkExpect(carrots.salePrice(0.10), 25 * 0.9) &&
      t.checkExpect(carrots.salePrice(0.15), 25 * 0.85) &&
      t.checkExpect(tissue.salePrice(0.10), 35 * 0.9) &&
      t.checkExpect(tissue.salePrice(0.15), 35 * 0.85);

  }
}
