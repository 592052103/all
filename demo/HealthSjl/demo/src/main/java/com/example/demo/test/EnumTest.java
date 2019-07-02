package com.example.demo.test;

public enum EnumTest {
	   
    
    PALADIN ("Paladin"),ROUGE("ROUGE"),
	
	MONDAY(1),TUESDAY(2);
	
	private String s;
	
	private int i;
	
    EnumTest(String s) {
    
    	this.s = s;
    }
    
    EnumTest(int i){
    	this.i = i;
    }
    
    public static void main(String[] arg) {
    	
    	System.out.println(EnumTest.PALADIN.name());
    	System.out.println(EnumTest.PALADIN.ordinal());
    	System.out.println(EnumTest.PALADIN.s);
    	System.out.println(EnumTest.PALADIN.i);
    	System.out.println(EnumTest.ROUGE.name());
    	System.out.println(EnumTest.ROUGE.ordinal());
    	System.out.println(EnumTest.MONDAY.name());
    	System.out.println(EnumTest.MONDAY.ordinal());
    	System.out.println(EnumTest.TUESDAY.name());
    	System.out.println(EnumTest.TUESDAY.ordinal());
    }
	
    

}
