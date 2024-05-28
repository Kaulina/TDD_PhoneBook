import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.kaulina.PhoneBook;

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
    }

    @AfterEach
    void tearDown() {
        System.out.println("END Test !  Конец теста\n");
        System.out.println("Конец теста\n");
    }

    public static Stream<Arguments> argumentsForAddTest() {
        return Stream.of(Arguments.of("Bob", "79990000001", 1),
                Arguments.of("Pop", "79990000002", 2),
                Arguments.of("Bob", "79990000003", 2),
                Arguments.of("Djop", "79990000004", 3),
                Arguments.of(null, "79990000005", 4));
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
    @MethodSource("argumentsForAddTest")
    @DisplayName("Тест значение имени == null")
    @MethodSource("argumentsForAddTestOnNull")
    @DisplayName("Тест на исключение при имени == null")
    void addTestOnNull(String expected, String namberPhone, int count) {
        int countNamber = phoneBook.add(expected, namberPhone);

        assertNotNull(expected);

        Throwable exception = assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("error message");
        });
    }

    public static Stream<Arguments> argumentsForFindByNumberTest() {
        return Stream.of(Arguments.of( null, "79990000001"),
                Arguments.of( "Pety", "79990000004"));
    }

    @ParameterizedTest
    @MethodSource("argumentsForFindByNumberTest")
    @DisplayName("Тест на поиск имени по номеру телефона")
    void findByNumberTest(String expected, String namberPhone) {
        String result = phoneBook.findByNumber(namberPhone);

        assertEquals(expected, result);
    }
}
