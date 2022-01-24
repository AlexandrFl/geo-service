package ru.netology.geo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import ru.netology.entity.Country;
import ru.netology.entity.Location;


public class GeoServiceImplTest {

    GeoServiceImpl geoService = new GeoServiceImpl();

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
    void byIpLocalhostTest() {
        String ip = GeoServiceImpl.LOCALHOST;
        Country act = geoService.byIp(ip).getCountry();

        Location expectation = new Location(null, null, null, 0);
        Country exp = expectation.getCountry();

        Assertions.assertEquals(act, exp);
    }

    @Test
    void byIpMoscowTest() {
        String ip = GeoServiceImpl.MOSCOW_IP;
        Country act = geoService.byIp(ip).getCountry();

        Location expectation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Country exp = expectation.getCountry();

        Assertions.assertEquals(act, exp);
    }

    @Test
    void byIpNyTest() {
        String ip = GeoServiceImpl.NEW_YORK_IP;
        Country act = geoService.byIp(ip).getCountry();

        Location expectation = new Location("New York", Country.USA, " 10th Avenue", 32);
        Country exp = expectation.getCountry();

        Assertions.assertEquals(act, exp);
    }

    @Test
    void byIpRuTest() {
        String ip = "172.3.4.5";
        Country act = geoService.byIp(ip).getCountry();

        Location expectation = new Location("Moscow", Country.RUSSIA, null, 0);
        Country exp = expectation.getCountry();

        Assertions.assertEquals(act, exp);
    }

    @Test
    void byIpUsaTest() {
        String ip = "96.3.4.5";
        Country act = geoService.byIp(ip).getCountry();

        Location expectation = new Location("New York", Country.USA, null,  0);
        Country exp = expectation.getCountry();

        Assertions.assertEquals(act, exp);
    }

    @Test
    void byCoordinatesTest()  {
        Assertions.assertThrows(RuntimeException.class, () -> {
            double latitude = 2.3;
            double longitude = 4.5;
            geoService.byCoordinates(latitude, longitude);
        });
    }
}
