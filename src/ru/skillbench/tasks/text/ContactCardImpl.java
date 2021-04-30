package ru.skillbench.tasks.text;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ContactCardImpl implements ContactCard {
    private String name;
    private String organization;
    private String gender;
    private String birthday;
    private final ArrayList<String> telephones = new ArrayList<>();
    private final Map<String, String> telephone = new HashMap<>();

    @Override
    public ContactCard getInstance(Scanner scanner) {
        String line = scanner.nextLine();
        if (!line.startsWith("BEGIN:VCARD"))
            throw new NoSuchElementException();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (!line.contains(":")) {
                throw new InputMismatchException();
            }

            if (line.contains("FN:")) name = line.substring(3);
            else if (line.contains("ORG:")) organization = line.substring(4);
            else if (line.contains("GENDER:")) gender = line.substring(7);
            else if (line.contains("BDAY:")) birthday = line.substring(5);
            else if (line.contains("TEL;")) telephones.add(line.substring(4));
            else if (line.equals("END:VCARD")) break;
            else throw new InputMismatchException();
        }

        if (name == null || organization == null)
            throw new NoSuchElementException();

        for (String tel : telephones) {
            if (tel.startsWith("TYPE=")) {
                String key = tel.substring(5, tel.indexOf(":"));
                String value = tel.substring(tel.indexOf(":") + 1);
                telephone.put(key, value);
            }
            for (Map.Entry<String, String> entry : telephone.entrySet()) {
                if (entry.getValue().length() != 10 || entry.getValue().contains(" "))
                    throw new InputMismatchException();
            }
        }

        return this;
    }

    @Override
    public ContactCard getInstance(String data) {
        return getInstance(new Scanner(data));
    }

    @Override
    public String getFullName() {
        return name;
    }

    @Override
    public String getOrganization() {
        return organization;
    }

    @Override
    public boolean isWoman() {
        return gender != null && !gender.equals("") && !gender.equals("M");
    }

    @Override
    public Calendar getBirthday() {
        if (birthday == null || birthday.equals(""))
            throw new NoSuchElementException();

        Calendar cal;

        try {
            cal = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            simpleDateFormat.setLenient(false);
            cal.setTime(simpleDateFormat.parse(birthday));
        } catch (Exception e) {
            InputMismatchException mismatchException = new InputMismatchException();
            mismatchException.initCause(e);
            throw mismatchException;
        }
        return cal;
    }

    @Override
    public Period getAge() {
        if (birthday.equals(""))
            throw new NoSuchElementException();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate bday = LocalDate.parse(birthday, dtf);
        return Period.between(bday, LocalDate.now());
    }

    @Override
    public int getAgeYears() {
        if (birthday.equals(""))
            throw new NoSuchElementException();
        return getAge().getYears();
    }

    @Override
    public String getPhone(String type) {
        StringBuilder sb;
        if (!telephone.containsKey(type))
            throw new NoSuchElementException();
        else {
            sb = new StringBuilder(telephone.get(type));
        }
        sb.insert(0, "(");
        sb.insert(4, ")");
        sb.insert(5, " ");
        sb.insert(9, "-");
        return sb.toString();
    }
}