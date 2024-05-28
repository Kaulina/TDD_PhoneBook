package ru.kaulina;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static Map<String, String> book;

    public static void main(String[] args) {
        PhoneBook phoneBook = PhoneBook.getINSTANCE();
        book = new TreeMap<>();
        book.put("Pop", "79990000002");
        book.put("Bob", "79990000003");
        book.put("Djop", "79990000004");

        String s =
                rrrr("79990000002");
        System.out.println(s);
    }

    public static String rrrr(String n) {
        return book.entrySet().stream()
                .filter(b -> b.getValue().equals(n))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}