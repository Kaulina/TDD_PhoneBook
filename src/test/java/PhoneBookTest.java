import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kaulina.PhoneBook;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты на проверку работы телефонной-книги: ")
class PhoneBookTest {
    private static PhoneBook phoneBook;

    @BeforeAll
    static void beforeAll() {
        phoneBook = PhoneBook.getINSTANCE();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Тест прошел: ");
        phoneBook.add("Any", "79990000009");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Конец теста\n");
    }

    public static Stream<Arguments> argumentsForAddTest() {
        return Stream.of(Arguments.of("Bob", "79990000001", 1),
                Arguments.of("Pop", "79990000002", 2),
                Arguments.of("Bob", "79990000003", 2),
                Arguments.of("Djop", "79990000004", 3));
    }


    @ParameterizedTest
    @MethodSource("argumentsForAddTest")
    @DisplayName("Тест на проверку на добавления имени и номера телефона")
    void addTest(String name, String namberPhone, int expected) {
        int countNamber = phoneBook.add(name, namberPhone);

        assertEquals(expected, countNamber);

    }

    public static Stream<Arguments> argumentsForAddTestOnNull() {
        return Stream.of(Arguments.of("Bob", "79990000001", 1),
                Arguments.of(null, "79990000005", 4));
    }


    @ParameterizedTest
    @MethodSource("argumentsForAddTestOnNull")
    @DisplayName("Тест на исключение при имени == null")
    void addTestOnNull(String expected, String namberPhone, int count) {

        Throwable exception = assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("error message");
        });
    }

    public static Stream<Arguments> argumentsForFindByNumberTest() {
        return Stream.of(Arguments.of(null, "79990000001"),
                Arguments.of("Pety", "79990000004"));
    }

    @ParameterizedTest
    @MethodSource("argumentsForFindByNumberTest")
    @DisplayName("Тест на поиск по номеру телефона")
    void findByNumberTest(String expected, String namberPhone) {
        String result = phoneBook.findByNumber(namberPhone);

        assertEquals(expected, result);
    }

    @DisplayName("Тест на поиск по имени")
    @Test
    void findByNameTest() {
        String expected = "79990000009";
        String result = phoneBook.findByName("Any");
        assertEquals(expected, result);
    }

    @Test
    void printAllNames() {
        phoneBook.add("Bob", "79990000006");
        phoneBook.add("Vova", "79990000008");

        List<String> expected = Arrays.asList("Any", "Bob", "Vova");
        List<String> result = phoneBook.printAllNames();

        assertEquals(expected, result);
    }

}
