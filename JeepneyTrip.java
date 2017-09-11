import tester.Tester;

class JeepneyTrip {
  int passengers;
  double distance;

  final int BASE_FARE = 7;
  final double BASE_DIST = 5.0;
  final double EXCESS = 0.5;

  JeepneyTrip(int passengers, double distance) {
    this.passengers = passengers;
    this.distance = distance;
  }

  // TEMPLATE
  /*
    this.passengers   -- int
    this.distance     -- double

    this.BASE_FARE
    this.BASE_DIST
    this.EXCESS
   */

  // double -> double
  // Computes the change, given this JeepneyTrip
  // and the actual amount paid
  double change(double paid) {
    return paid - fare();
  }

  // -> double
  // Computes the fare for this JeepneyTrip
  double fare() {
    return this.passengers * (this.BASE_FARE + (excessDistance() * this.EXCESS));
  }

  // -> double
  // Computes the distance of this JeepneyTrip
  // in excess of 5kms
  double excessDistance() {
    if (this.distance > this.BASE_DIST) {
      return this.distance - this.BASE_DIST;
    } else {
      return 0.0;
    }
  }
}

class ExamplesJeepneyTrip {
  ExamplesJeepneyTrip() {}

  JeepneyTrip a = new JeepneyTrip(1, 5);
  JeepneyTrip b = new JeepneyTrip(2, 5);
  JeepneyTrip c = new JeepneyTrip(1, 7);
  JeepneyTrip d = new JeepneyTrip(2, 7);

  boolean testChange(Tester t) {
    return
      t.checkExpect(a.change(7), 0.0) &&
      t.checkExpect(a.change(10), 3.0) &&
      t.checkExpect(b.change(14), 0.0) &&
      t.checkExpect(b.change(20), 6.0) &&
      t.checkExpect(c.change(8), 0.0) &&
      t.checkExpect(c.change(10), 2.0) &&
      t.checkExpect(d.change(16), 0.0) &&
      t.checkExpect(d.change(20), 4.0);
  }

  boolean testFare(Tester t) {
    return
      t.checkExpect(a.fare(), 7.0) &&
      t.checkExpect(b.fare(), 14.0) &&
      t.checkExpect(c.fare(), 8.0) &&
      t.checkExpect(d.fare(), 16.0);
  }

  boolean testExcessDistance(Tester t) {
    return
      t.checkExpect(a.excessDistance(), 0.0) &&
      t.checkExpect(b.excessDistance(), 0.0) &&
      t.checkExpect(c.excessDistance(), 2.0) &&
      t.checkExpect(d.excessDistance(), 2.0);
  }

}
