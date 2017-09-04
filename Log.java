class Entry {
  double dist;
  int duration;
  String mood;
  Date date;
  
  Entry(double dist, int duration, String mood, Date date) {
    this.dist = dist;
    this.duration = duration;
    this.mood = mood;
    this.date = date;
  }
}

class Date {
  int month;
  int day;
  int year;
  
  Date(int month, int day, int year) {
    this.month = month;
    this.day = day;
    this.year = year;
  }
}