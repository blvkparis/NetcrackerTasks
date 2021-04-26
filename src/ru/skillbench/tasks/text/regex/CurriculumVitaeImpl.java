package ru.skillbench.tasks.text.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Anton Popkov
 */
public class CurriculumVitaeImpl implements CurriculumVitae {
    private String CVText;
    private Map<String, String> hiddenStrings = new HashMap<>();

    @Override
    public void setText(String text) {
        this.CVText = text;
        hiddenStrings.clear();
    }

    @Override
    public String getText() {
        if (this.CVText == null) {
            throw new IllegalStateException();
        }
        return this.CVText;
    }

    @Override
    public List<Phone> getPhones() {
        List<Phone> phones = new ArrayList<>();
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(getText());

        while (matcher.find()) {
            int areaCode = -1;
            int ext = -1;
            if (matcher.group(2) != null) {
                areaCode = Integer.parseInt(matcher.group(2));
            }
            if (matcher.group(7) != null) {
                ext = Integer.parseInt(matcher.group(7));
            }
            Phone newPhone = new Phone(matcher.group(), areaCode, ext);
            phones.add(newPhone);
        }
        return phones;
    }

    @Override
    public String getFullName() {
        getText();

        String fullNamePattern = "^([A-Z][a-z]+[a-zA-Z])(?:\\s[A-Z][a-z]+[a-zA-Z]){1,2}\\.*$";
        Pattern pattern = Pattern.compile(fullNamePattern);
        Matcher matcher = pattern.matcher(CVText);

        if (matcher.find()) {
            return matcher.group();
        } else throw new NoSuchElementException();
    }

    @Override
    public String getFirstName() {
        getText();
        return getFullName().split(" ")[0];
    }

    @Override
    public String getMiddleName() {
        getText();
        String fullName = getFullName();
        if (fullName.split(" ").length == 3) {
            return fullName.split(" ")[1];
        } else {
            return null;
        }
    }

    @Override
    public String getLastName() {
        getText();
        String fullName = getFullName();
        return fullName.split(" ")[fullName.split(" ").length - 1];
    }

    @Override
    public void updateLastName(String newLastName) {
        getText();
        String lastName = getLastName();
        CVText = CVText.replace(lastName, newLastName);
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        getText();
        if (!CVText.contains(oldPhone.getNumber())) {
            throw new IllegalArgumentException();
        }
        CVText = CVText.replace(oldPhone.getNumber(), newPhone.getNumber());
    }

    @Override
    public void hide(String piece) {
        getText();
        if (!CVText.contains(piece)) {
            throw new IllegalArgumentException();
        }
        String hiddenString = piece.replaceAll("[^. @]", "X");
        hiddenStrings.put(hiddenString, piece);
        CVText = CVText.replace(piece, hiddenString);
    }

    @Override
    public void hidePhone(String phone) {
        getText();
        if (!CVText.contains(phone)) {
            throw new IllegalArgumentException();
        }
        String hiddenPhone = phone.replaceAll("[0-9]", "X");
        hiddenStrings.put(hiddenPhone, phone);
        CVText = CVText.replace(phone, hiddenPhone);
    }

    @Override
    public int unhideAll() {
        getText();

        int count = 0;
        for (HashMap.Entry<String, String> entry : hiddenStrings.entrySet()) {
            CVText = CVText.replaceAll(entry.getKey()
                            .replaceAll("\\(", "\\\\\\(").replaceAll("\\)", "\\\\\\)"),
                    entry.getValue());
            count++;
        }
        return count;
    }
}