import tester.Tester;

class Train {
  Route r;

  Train(Route r) {
    this.r = r;
  }

  // TEMPLATE
  /*
      Fields:

        this.r  -- Route

      Methods:
        canTransfer(Train that) -- boolean

      Methods on r:
        this.r.destSameAsOriginOf(Route that) -- boolean

   */

  // Train -> boolean
  // Determine whether transfers are possible from this Train
  // to another Train
  boolean canTransfer(Train that) {
    return this.r.destSameAsOriginOf(that.r);
  }

}

class Route {
  String origin;
  String dest;

  Route(String origin, String dest) {
    this.origin = origin;
    this.dest = dest;
  }

  // TEMPLATE
  /*
     Fields:
      this.origin -- String
      this.dest   -- String

     Methods:
      destSameAsOriginOf(Route that)   -- boolean

   */

  // Route -> boolean
  // Returns true if the destination of this Route
  // matches the origin of another Route
  boolean destSameAsOriginOf(Route that) {
    return this.dest.equals(that.origin);
  }


}

class ExamplesTrain {
  ExamplesTrain() {}

  Route talisayFuente = new Route("Talisay", "Fuente");
  Route fuenteBanilad = new Route("Fuente", "Banilad");
  Route ayalaBanilad = new Route("Ayala", "Banilad");

  Train a = new Train(talisayFuente);
  Train b = new Train(fuenteBanilad);
  Train c = new Train(ayalaBanilad);

  boolean testCanTransfer(Tester t) {
    return
      t.checkExpect(a.canTransfer(b), true) &&
      t.checkExpect(b.canTransfer(c), false) &&
      t.checkExpect(b.canTransfer(a), false);
  }

  boolean testDestSameAsOriginOf(Tester t) {
    return
      t.checkExpect(talisayFuente.destSameAsOriginOf(fuenteBanilad), true) &&
      t.checkExpect(fuenteBanilad.destSameAsOriginOf(ayalaBanilad), false) &&
      t.checkExpect(fuenteBanilad.destSameAsOriginOf(talisayFuente), false);
  }

}
