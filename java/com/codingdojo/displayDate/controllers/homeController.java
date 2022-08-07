package com.codingdojo.displayDate.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

	// Home location
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// Current Date - WeekDay, the DD of Month, YYYY
	@RequestMapping("/date")
	public String datePage(Model model) {
		LocalDate date = LocalDate.now();
		// Get Day of week
		int dow = date.getDayOfWeek().getValue();
		ArrayList<String> daysOfWeek = new ArrayList<String>();
		daysOfWeek.add("Monday");
		daysOfWeek.add("Tuesday");
		daysOfWeek.add("Wednesday");
		daysOfWeek.add("Thursday");
		daysOfWeek.add("Friday");
		daysOfWeek.add("Saturday");
		daysOfWeek.add("Sunday");
		String stringDow = daysOfWeek.get(dow-1);
		
		// Get day of month
		int dom = date.getDayOfMonth();
		
		// Get month name
		int monthVal = date.getMonthValue();
		ArrayList<String> monthofyear = new ArrayList<String>();
		monthofyear.add("January");
		monthofyear.add("February");
		monthofyear.add("March");
		monthofyear.add("April");
		monthofyear.add("May");
		monthofyear.add("June");
		monthofyear.add("July");
		monthofyear.add("August");
		monthofyear.add("September");
		monthofyear.add("October");
		monthofyear.add("November");
		monthofyear.add("December");
		String month = monthofyear.get(monthVal);
		
		// Get year
		int thisYear = date.getYear();
		
		// Insert into DOM
		model.addAttribute("DOW", stringDow);
		model.addAttribute("numDay", dom);
		model.addAttribute("month", month);
		model.addAttribute("year", thisYear);
		return "date.jsp";
	}
	
	// Current Time
	@RequestMapping("/time")
	public String timePage(Model model) {
		String totalTime;
		// Get FUll Time
		LocalTime thisDate = LocalTime.now();
		// Get Hour
		int hour = thisDate.getHour();
		String AMPM = (hour >= 12) ? "PM" : "AM";
		int formattedHour = (hour > 12) ? hour - 12 : hour;
		
		// Get Minute
		int minute = thisDate.getMinute();
		
		
		model.addAttribute("hour", formattedHour);
		model.addAttribute("minute", minute);
		model.addAttribute("ampm", AMPM);
		
		return "time.jsp";
		
	}
}
