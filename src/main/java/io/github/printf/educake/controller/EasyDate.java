package io.github.printf.educake.controller;

import java.util.Date;
import java.util.GregorianCalendar;

public class EasyDate {

  int day, month, year;

  public EasyDate(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Date toDate(){
    GregorianCalendar fullDate = new GregorianCalendar(year, month, day);
    Date date = new Date(fullDate.getTimeInMillis());
    return date;
  }
}
