package io.github.printf.educake.controller;

import java.util.Date;
import java.util.GregorianCalendar;

public class EasyDate {

  static int day, month, year;

  public static Date toDate(int day, int month, int year){
    GregorianCalendar fullDate = new GregorianCalendar(year, month, day);
    return new Date(fullDate.getTimeInMillis());
  }
}
