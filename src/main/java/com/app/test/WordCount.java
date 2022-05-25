package com.app.test;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WordCount {

    private Map<String, Integer> wordCount = new HashMap<>();

    public void add(final String word) {
        if (!word.matches("[a-zA-Z ]+")) throw new RuntimeException("word should contain only alphabets : "+ word );
        final String translatedWord = Translate.translate(word);
	wordCount.compute(translatedWord,(k, v) -> (v == null) ? 1 : v+1);
    }

    public int getCount(final String word) {
	return Optional.ofNullable(wordCount.get(word)).orElse(0);
    }
}
