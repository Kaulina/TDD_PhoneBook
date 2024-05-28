package ru.kaulina;

public class PhoneBook {
    private static PhoneBook INSTANCE = null;

    private PhoneBook(){}

    public static PhoneBook getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new PhoneBook();
        }
        return INSTANCE;
    }

    public int add(String name, String namberPhone){
        return  0;
    }
}
