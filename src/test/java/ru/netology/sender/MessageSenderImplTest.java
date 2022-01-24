package ru.netology.sender;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


import ru.netology.geo.GeoServiceImpl;


import ru.netology.i18n.LocalizationServiceImpl;


import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

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
        System.out.println("\nТест завершен успешно");
    }

    @AfterAll
    public static void finish() {
        System.out.println("Тестирование завершено");
    }

    @Test
    void sendNYTest() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(GeoServiceImpl.NEW_YORK_IP))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        String result = messageSender.send(headers);

        String expectation = "Welcome";
        Assertions.assertEquals(result,expectation);
    }

    @Test
    void sendMoscowTest() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(GeoServiceImpl.MOSCOW_IP))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        String result = messageSender.send(headers);

        String expectation = "Добро пожаловать";
        Assertions.assertEquals(result,expectation);
    }

    @Test
    void sendLocalHostTest() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(GeoServiceImpl.LOCALHOST))
                .thenReturn(new Location(null, null, null, 0));

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(null))
                .thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.LOCALHOST);
        String result = messageSender.send(headers);

        String expectation = "Welcome";
        Assertions.assertEquals(result,expectation);
    }

    @Test
    void sendRuTest() {
        String ip = "127.4.4.4";
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(ip))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        String result = messageSender.send(headers);

        String expectation = "Добро пожаловать";
        Assertions.assertEquals(result,expectation);
    }

    @Test
    void sendUsaTest() {
        String ip = "96.4.4.4";
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(ip))
                .thenReturn(new Location("New York", Country.USA, null,  0));

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        String result = messageSender.send(headers);

        String expectation = "Welcome";
        Assertions.assertEquals(result,expectation);
    }
}