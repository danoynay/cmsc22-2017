import tester.Tester;

class Line {
  int x1;
  int y1;
  int x2;
  int y2;

  Line(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  // TEMPLATE
  /*
    Fields:
      this.x1
      this.y1
      this.x2
      this.y2

    Methods:
      this.isHorizontal() -- boolean
      this.slope()        -- double
   */

  //  -> boolean
  // Returns true if this Line is horizontal
  boolean isHorizontal() {
    return this.slope() == 0;
  }

  // -> double
  // Returns the slope of this Line
  double slope() {
    return (this.y2 - this.y1) / (this.x2 - this.x1);
  }
}

class ExamplesLine {
  ExamplesLine() {}

  Line a = new Line(1, 1, 4, 1);
  Line b = new Line(1, 1, 3, 3);
  Line c = new Line(-2, 3, 1, 3);

  boolean testIsHorizontal(Tester t) {
    return
      t.checkExpect(a.isHorizontal(), true) &&
      t.checkExpect(b.isHorizontal(), false) &&
      t.checkExpect(c.isHorizontal(), true);

  }

  boolean testSlope(Tester t) {
    return
      t.checkExpect(a.slope(), 0.0) &&
      t.checkExpect(b.slope(), (3.0 - 1) / (3 - 1)) &&
      t.checkExpect(c.slope(), 0.0);
  }
}
