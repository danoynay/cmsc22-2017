/*
xSignature, purpose, stub
xExamples
xTemplate
xBody
xTest and debug
*/

import tester.Tester;

class Greeting {
  String greeting;

  Greeting(String greeting) {
    this.greeting = greeting;
  }

  // TEMPLATE
  /*
    Fields:
     ... this.greeting ... -- String

    Methods:
     ... this.yell() ... -- String
   */

  // -> String
  // Returns this greeting, but capitalized
  // and with an exclamation point at the end
  String yell() {
     return this.greeting.toUpperCase() + "!";
  }

}

class ExamplesGreeting {
  ExamplesGreeting() {}

  Greeting hi = new Greeting("hi");
  Greeting hello = new Greeting("hello");
  Greeting bye = new Greeting("BYE");
  Greeting kthxbye = new Greeting("kthxbye");
  Greeting kthxbyejeje = new Greeting("kthXbyE");


  boolean testYell(Tester t) {
    return
      t.checkExpect(this.hi.yell(), "HI!") &&
      t.checkExpect(this.hello.yell(), "HELLO!") &&
      t.checkExpect(this.bye.yell(), "BYE!") &&
      t.checkExpect(this.kthxbyejeje.yell(), "KTHXBYE!") &&
      t.checkExpect(this.kthxbye.yell(), "KTHXBYE!");
  }


}
