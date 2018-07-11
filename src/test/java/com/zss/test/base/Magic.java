package com.zss.test.base;

public class Magic {
    private static Magic instance = new Magic();
    public static  int a = 1;
    public static  final int b = 1;
    public static Magic getInstance(){
    	System.out.println("***"+a);
    	System.out.println("***"+b);
        return instance;
    }
    private Magic(){
        System.out.println("==="+a);
        System.out.println("==="+b);
    }

    public static void main(String[] args) {
        Magic.getInstance();
    }
}
