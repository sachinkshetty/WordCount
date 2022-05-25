package com.app.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordCountTest {

    private WordCount wordCount;

    @BeforeEach
    public  void setup(){
	wordCount = new WordCount();
    }

    @Test
    public void testShouldReturnCountForWordAdded(){
        wordCount.add("Rose");
        int count = wordCount.getCount("Rose");
	Assertions.assertEquals(1, count);
    }

    @Test
    public void testShouldReturnCountForTwoDifferentWordAdded(){
        wordCount.add("Rose");
        wordCount.add("Lily");
        int count = wordCount.getCount("Rose");

    }

    @Test
    public void testShouldReturnCountForSameWordAddedAgain(){
        wordCount.add("Rose");
        wordCount.add("Lily");
        wordCount.add("Rose");
        int count = wordCount.getCount("Rose");
        Assertions.assertEquals(2,  count);
    }

    @Test
    public void testShouldReturnCountForMultipleSimiliarWordAdded(){
        wordCount.add("Rose");
        wordCount.add("Lily");
        wordCount.add("Rose");
        wordCount.add("Lily");
        int roseCount = wordCount.getCount("Rose");
        int lilyCount = wordCount.getCount("Lily");
        Assertions.assertEquals(2,  roseCount);
        Assertions.assertEquals(2,  lilyCount);
    }

    @Test
    public void testShouldReturnCountForOnlyAlphabeticalWordsAdded(){
        wordCount.add("Rose");
        wordCount.add("Lily");
        wordCount.add("Rose");

       Throwable message = Assertions.assertThrows(RuntimeException.class,
           ()-> {
                wordCount.add("Lily1");
            }
       );

        Assertions.assertEquals("word should contain only alphabets : Lily1", message.getMessage()) ;
    }

    @Test
    public void testShouldReturnCountForWordsAddedInHGermanAndEnglish(){
        wordCount.add("Rose");
        wordCount.add("Lily");
        wordCount.add("die Rose"); //rose in german
        wordCount.add("Lily");
        int roseCount = wordCount.getCount("Rose");
        int lilyCount = wordCount.getCount("Lily");
        Assertions.assertEquals(2,  roseCount);
        Assertions.assertEquals(2,  lilyCount);
    }

    @Test
    public void testShouldReturnCountForTranslatedWords(){
        wordCount.add("Rose");
        wordCount.add("Lily");
        wordCount.add("die Rose"); //rose in german
        wordCount.add("lirio"); // lily in portugal
        int roseCount = wordCount.getCount("Rose");
        int lilyCount = wordCount.getCount("Lily");
        Assertions.assertEquals(2,  roseCount);
        Assertions.assertEquals(2,  lilyCount);
    }

    @Test
    public void testShouldReturnCountForTranslatedWordsOnly(){
        wordCount.add("die Rose"); //rose in german
        wordCount.add("lirio"); // lily in portugal
        int roseCount = wordCount.getCount("Rose");
        int lilyCount = wordCount.getCount("Lily");
        Assertions.assertEquals(1,  roseCount);
        Assertions.assertEquals(1,  lilyCount);
    }
    
    @Test
    public void testShouldReturnMessageForWordNotPresent(){
        wordCount.add("Rose");
        int count = wordCount.getCount("Jasmine");
        Assertions.assertEquals(0,count);
    }
}
