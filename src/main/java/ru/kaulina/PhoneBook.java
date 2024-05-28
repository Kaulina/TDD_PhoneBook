package ru.kaulina;

import java.util.ArrayList;
import java.util.List;
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
        if (name == null) {
            throw new NullPointerException("Значение в имени - Null не допустимо ");
        }
        if (!book.containsKey(name)) {
            book.put(name, namberPhone);
        }
        return book.size();
    }

    public String findByNumber(String namberPhone) {
        return book.entrySet().stream()
                .filter(b -> b.getValue().equals(namberPhone))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public String findByName(String name) {
        return book.get(name);
    }

    public List<String> printAllNames() {
        return new ArrayList<>(book.keySet());
    }
}