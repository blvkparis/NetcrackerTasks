package ru.skillbench.tasks.javaapi.collections;

import java.util.*;

/**
 * @author Anton Popkov
 */
public class StringFilterImpl implements StringFilter {

    private Set<String> hashSet = new LinkedHashSet<>();

    @Override
    public void add(String s) {
        hashSet.add(s.toLowerCase(Locale.ROOT));
    }

    @Override
    public boolean remove(String s) {
        return hashSet.remove(s.toLowerCase(Locale.ROOT));
    }

    @Override
    public void removeAll() {

    }

    @Override
    public Collection<String> getCollection() {
        return null;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        return null;
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        return null;
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        return null;
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        return null;
    }
}
