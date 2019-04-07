package com.university.presantation;
import java.util.Locale;
import java.util.ResourceBundle;

public class Application {

	public static void main(String[] args) {

		// en_US
		System.out.println("Current Locale: " + Locale.getDefault());
		

		ResourceBundle mybundle = ResourceBundle.getBundle("Bundle");

		// read Bundle_en_US.properties
		System.out.println("Say how are you in US English: " + mybundle.getString("how_are_you"));

		Locale.setDefault(new Locale("sq", "AL"));
		// read Bundle_sq_AL.properties
		System.out.println("Current Locale: " + Locale.getDefault());
		mybundle = ResourceBundle.getBundle("Bundle");
		System.out.println("Say how are you in Albanian language: " + mybundle.getString("how_are_you"));

	}

}
