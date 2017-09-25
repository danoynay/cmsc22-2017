import tester.*;

/*
  +---------------+
  | Book          |
  +---------------+
  | String title  |
  | String author |
  | int price     |
  +---------------+
*/


// to represent a book in a bookstore
class Book {
  String title;
  String author;
  int year;
  double price;

  // the constructor
  Book(String title, String author, int year, double price) {
      this.title = title;
      this.author = author;
      this.year = year;
      this.price = price;
  }
  /* TEMPLATE:
     Fields:
     ... this.title ...         -- String
     ... this.author ...        -- String
     ... this.price ...         -- double

     Methods:
     ... this.salePrice(int) ...   -- int
  */

  // Computes the sale price of this Book,
  // given a percentage sale value
  double salePrice(double saleValue) {
    return this.price * (1 - saleValue);
  }

}


interface ILoBook {
  // In ILoBook
  // -------
  // count the books in this list
  int count();

  // produce a list of all books published before the given date
  // from this list of books
  ILoBook allBefore(int year);

  // calculate the total sale price of all books in this list for a given discount
  double salePrice(double discount);

  // produce a list of all books in this list, sorted by their price
  ILoBook sortByPrice();
}

class MtLoBook implements ILoBook {

  // TEMPLATE
  /*
    Methods:
      this.count() -- int
      this.allBefore() -- ILoBook
      this.salePrice()  -- double
   */


  // count the books in this list
  public int count() {
    return 0;
  }

  // produce a list of all books published before the given date
  // from this list of books
  public ILoBook allBefore(int year) {
    return this;
  }

  // calculate the total sale price of all books in this list for a given discount
  public double salePrice(double discount) {
    return 0;
  }

  // produce a list of all books in this list, sorted by their price
  public ILoBook sortByPrice() {
    return this;
  }

}

class ConsLoBook implements ILoBook {
  Book first;
  ILoBook rest;

  public ConsLoBook(Book first, ILoBook rest) {
    this.first = first;
    this.rest = rest;
  }

  /*
    TEMPLATE:
    ---------
    Fields:
    ... this.first ...                             -- Book
    ... this.rest ...                              -- ILoBook
    Methods:
    ... this.count() ...                           -- int
    ... this.salePrice(double discount) ...           -- double
    ... this.allBefore(int year) ...               -- ILoBook

    Methods on this.first:
    ... this.first.salePrice(double discount)   -- double

    Methods on this.rest:
        this.rest.count() ...                           -- int
    ... this.rest.salePrice(double discount) ...           -- double
    ... this.rest.allBefore(int year) ...
  */

  public int count() {
    return 1 + this.rest.count();
  }

  // produce a list of all books published before the given date
  // from this list of books
  public ILoBook allBefore(int year) {
    return this;
  }

  // calculate the total sale price of all books in this list for a given discount
  public double salePrice(double discount) {
    return this.first.salePrice(discount)
            + this.rest.salePrice(discount);
  }

  // produce a list of all books in this list, sorted by their price
  public ILoBook sortByPrice() {
    return this;
  }
}

class ExamplesBook {
  ExamplesBook() {}

  Book harryPotter = new Book("Harry Potter", "J.K. Rowling", 1997, 400);
  Book introProg = new Book("Introduction to Programming", "Ada Lovelace", 1932, 700);

  //Books
  Book htdp = new Book("HtDP", "MF", 2001, 60);
  Book lpp = new Book("LPP", "STX", 1942, 25);
  Book ll = new Book("LL", "FF", 1986, 10);

  // lists of Books
  ILoBook mtlist = new MtLoBook();
  ILoBook lista = new ConsLoBook(this.lpp, this.mtlist);
  ILoBook listb = new ConsLoBook(this.htdp, this.mtlist);
  ILoBook listc = new ConsLoBook(
                    this.lpp,
                    new ConsLoBook(
                      this.ll,
                      this.listb
                    )
                  );

  // (LL, LPP, HtDP)

  ILoBook listd = new ConsLoBook(
                    this.ll,
                    new ConsLoBook(
                      this.lpp,
                      new ConsLoBook(
                        this.htdp,
                        this.mtlist
                      )
                    )
                  );


  boolean testSalePrice(Tester t) {
    return t.checkExpect(this.harryPotter.salePrice(0.10), 360.0)
            && t.checkExpect(this.introProg.salePrice(0.15), 595.0);

  }

  boolean testCountMt(Tester t) {
    return t.checkExpect(this.mtlist.count(), 0);
  }

  boolean testCount(Tester t) {
    return
      t.checkExpect(this.lista.count(), 1) &&
      t.checkExpect(this.listb.count(), 1) &&
      t.checkExpect(this.listc.count(), 3) &&
      t.checkExpect(this.listd.count(), 3);
  }
}
