package ru.skillbench.tasks.text.regex;

/**
 * @author Anton Popkov
 */
public class MainCV {
    public static void main(String[] args) {
        String phone = "(916)125-4171";
        String fullName = "Anton Popkov Retoc";

        CurriculumVitaeImpl curriculumVitae = new CurriculumVitaeImpl();
        curriculumVitae.setText(phone);

        curriculumVitae.getPhones();

        CurriculumVitaeImpl cvName = new CurriculumVitaeImpl();
        cvName.setText(fullName);

        cvName.getFirstName();
    }
}