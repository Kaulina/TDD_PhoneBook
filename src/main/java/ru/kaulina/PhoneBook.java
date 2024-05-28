package ru.kaulina;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private static PhoneBook INSTANCE = null;
    private Map<String, String> book = new TreeMap<>();

    private PhoneBook() {
    }

    public static PhoneBook getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PhoneBook();
        }
        return INSTANCE;
    }

    public int add(String name, String namberPhone) {
        return 0;
        if (name == null) {
            throw new NullPointerException("Значение в имени - Null не допустимо ");
        }
        if (!book.containsKey(name)) {
            book.put(name, namberPhone);
        }
        return book.size();
    }
}
