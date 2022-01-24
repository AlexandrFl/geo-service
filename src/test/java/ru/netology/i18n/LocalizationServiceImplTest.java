package ru.netology.i18n;

import org.junit.jupiter.api.*;
import ru.netology.entity.Country;


public class LocalizationServiceImplTest {

    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @BeforeAll
    public static void start() {
        System.out.println("Тестирование началось");
    }

    @BeforeEach
    public void startEach() {
        System.out.println("Тест запущен");
    }

    @AfterEach
    public void finishEach() {
        System.out.println("Тест завершен успешно");
    }

    @AfterAll
    public static void finish() {
        System.out.println("Тестирование завершено");
    }

    @Test
    void byIpRussiaTest() {

        Country country = Country.RUSSIA;
        String expectation = "Добро пожаловать";
        String result = localizationService.locale(country);

        Assertions.assertEquals(result, expectation);
    }

    @Test
    void byIpBrazilTest() {

        Country country = Country.BRAZIL;
        String expectation = "Welcome";
        String result = localizationService.locale(country);

        Assertions.assertEquals(result, expectation);
    }

    @Test
    void byIpGermanyTest() {

        Country country = Country.GERMANY;
        String expectation = "Welcome";
        String result = localizationService.locale(country);

        Assertions.assertEquals(result, expectation);
    }

    @Test
    void byIpUsaTest() {

        Country country = Country.USA;
        String expectation = "Welcome";
        String result = localizationService.locale(country);

        Assertions.assertEquals(result, expectation);
    }
}
