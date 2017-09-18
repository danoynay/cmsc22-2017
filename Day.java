import tester.Tester;

class Day {
  int day;

  final int DAYS_IN_WEEK = 7;
  final int DAYS_IN_YEAR = 365;

  Day(int day) {
    this.day = day;
  }

  // xSignature, purpose, stub
  // xExamples
  // xTemplate
  // xBody
  // xTest and debug

  // TEMPLATE
  /*
      Fields:
        this.day            -- int

      Methods:
        this.weeksElapsed() -- int
   */

  // Day -> int
  // Computes the number of full weeks between
  // this Day and another given Day
  int weeksElapsed(Day that) {
    return Math.abs(that.day - this.day) / DAYS_IN_WEEK;
  }


  // int -> Day
  // Produces a new day n number of weeks away from
  // this Day
  Day addWeeks(int n) {
    return new Day((this.day + (n * DAYS_IN_WEEK)) % DAYS_IN_YEAR);
  }

}

class ExamplesDay {
  ExamplesDay() {}

  Day newYear = new Day(1);
  Day endJan = new Day(31);
  Day leapYear = new Day(59);
  Day lastDay = new Day(365);

  boolean testWeeksElapsed(Tester t) {
    return
      t.checkExpect(this.newYear.weeksElapsed(this.leapYear), 8) &&
      t.checkExpect(this.leapYear.weeksElapsed(this.newYear), 8) &&
      t.checkExpect(this.newYear.weeksElapsed(this.endJan), 4);
  }

  boolean testAddWeeks(Tester t) {
    Day newYearPlus4 = this.newYear.addWeeks(4);
    Day lastDayPlus1 = this.lastDay.addWeeks(1);

    return
      t.checkExpect(newYearPlus4.day, 29) &&
      t.checkExpect(lastDayPlus1.day, 7);
  }


}
