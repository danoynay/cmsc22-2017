class Temperature {
  double temp;
  String unit;

  Temperature(double temp, String unit) {
    this.temp = temp;
    this.unit = unit;
  }

  Temperature convertTo(String unit) {
    return this.convertToC().convertFromC(unit);
  }

  Temperature convertToC() {
    return new Temperature(0, "C");
  }

  Temperature convertFromC(String unit) {
    return new Temperature(0, "C");
  }
}

class ExamplesTemperature {
  ExamplesTemperature() {}

  Temperature absoluteZero = new Temperature(0.0, "K");
  Temperature sunSurface = new Temperature(5500.0, "C");
  Temperature humanBody = new Temperature(98, "F");

}
