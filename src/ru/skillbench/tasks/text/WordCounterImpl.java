package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Anton Popkov
 */
public class WordCounterImpl implements WordCounter {
    private String text;
    private Map<String, Long> words = new HashMap<>();

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Map<String, Long> getWordCounts() {
        if (getText() == null)
            throw new IllegalStateException();

        String regex = "\\<(.*?)\\>";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            text = text.replaceAll(regex, "");
        }

        String[] lines = text.split("\\s+");

        for (String word : lines) {
            Long count = 1L;
            String lower = word.toLowerCase(Locale.ROOT);

            if (lower.startsWith("<") && lower.endsWith(">"))
                continue;

            if (lower.length() > 1) {
                if (words.containsKey(lower)) {
                    words.put(lower, words.get(lower) + 1L);
                } else words.put(lower, count);
            }
        }

        return words;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {

        //List<Map.Entry<String, Long>> list = new ArrayList<>(words.entrySet());
        //list.sort(new WordCounterImpl<>());

        List<Map.Entry<String, Long>> sortedList = new ArrayList<>(words.entrySet());
        sortedList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        return sortedList;
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        List<Map.Entry<K, V>> sortedList = new ArrayList<>(map.entrySet());

        sortedList.sort(Collections.reverseOrder(comparator));
        return sortedList;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {
        for (Map.Entry<K, V> me : entries) {
            ps.println(me.getKey() + " " + me.getValue());
        }
    }
}
