package ru.skillbench.tasks.text;

import java.util.List;
import java.util.Map;

/**
 * @author Anton Popkov
 */
public class MainWord {
    public static void main(String[] args) {
        WordCounterImpl wordCounter = new WordCounterImpl();

        wordCounter.setText("             Катрин  катерина Алекс  Катерина    Антон      ");
        //wordCounter.setText("пучки пучки средств современные инспекции среды с пластик несмотря американская конструкция зря m1 последний");
        //wordCounter.setText("           ");
        System.out.println(wordCounter.getWordCounts());

        List<Map.Entry<String, Long>> sorted = wordCounter.getWordCountsSorted();
        System.out.println(sorted);
    }
}
