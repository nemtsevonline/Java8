package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;



class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "-1; 0",
                    "5; 5",
                    "9; 9",
                    "0; 0",
                    "12; 0"
            }
            , delimiter = ';'
    )
    void setCurrentStationTest(int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentStation(start);
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "-1; 0",
                    "5; 5",
                    "12; 0"
            }
            , delimiter = ';'
    )
    void setCurrentVolumeTest(int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentVolume(start);
        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "0; 1",
                    "8; 9",
                    "9; 0"
            }
            , delimiter = ';'
    )
    void pressNextStationTest(int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentStation(start);

        radio.pressNextStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "5; 4",
                    "1; 0",
                    "0; 9"
            }
            , delimiter = ';'
    )
    void pressPrevStationTest(int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentStation(start);

        radio.pressPrevStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "0; 1",
                    "9; 10",
                    "10; 10"
            }
            , delimiter = ';'
    )
    void pressPlusVolumeTest(int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentVolume(start);

        radio.pressPlusVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "5; 4",
                    "1; 0",
                    "0; 0"
            }
            , delimiter = ';'
    )
    void pressMinusVolumeTest(int start, int expected) {
        Radio radio=new Radio();
        radio.setCurrentVolume(start);

        radio.pressMinusVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
}