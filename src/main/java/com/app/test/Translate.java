package com.app.test;

public class Translate {

    public static String translate(final String word) {
        if (word.equalsIgnoreCase("die Rose")) {
	    return "Rose";
	}
        else if (word.equalsIgnoreCase("lirio")) {
            return "Lily";
	}
        return word;
    }
}
