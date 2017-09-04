interface IShape {}

class Circle implements IShape {
  Coord center;
  int radius;

  Circle(Coord center, int radius) {
    this.center = center;
    this.radius = radius;
  }
}

class Square implements IShape {
  Coord corner;
  int size;

  Square(Coord corner, int size) {
    this.corner = corner;
    this.size = size;
  }
}

class Point implements IShape {
  Coord coord;

  Point(Coord coord) {
    this.coord = coord;
  }
}

class Coord {
  int x;
  int y;

  Coord(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class ExamplesShapes {
  ExamplesShapes() {}

  Coord c = new Coord(1, 1);

  IShape cs = new Circle(this.c, 5);

}
