package com.university.presantation;


import java.awt.Dimension;
import java.awt.Toolkit;

public class Settings {
   
	private Settings () {}
	
	public static Dimension getScreenSize(){
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        return d;   
    }
    
    
}
