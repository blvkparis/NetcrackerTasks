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
    private final Map<String, Long> wordCounts = new HashMap<>();

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
            String lower = word.toLowerCase(Locale.ROOT);

            if (lower.startsWith("<") && lower.endsWith(">"))
                continue;

            if (lower.length() > 1) {
                wordCounts.merge(lower, 1L, Long::sum);
            }
        }

        return wordCounts;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        if (getText() == null)
            throw new IllegalStateException();

        List<Map.Entry<String, Long>> list = this.sort(wordCounts, Map.Entry.<String, Long>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey()).reversed());

        return list;
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        List<Map.Entry<K, V>> sortedList = new ArrayList<>(map.entrySet());

        sortedList.sort(comparator);
        return sortedList;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {
        for (Map.Entry<K, V> me : entries) {
            ps.println(me.getKey() + " " + me.getValue());
        }
    }
}
