
package org.example;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for DataReader App.
 */
public class CitiesSearchTest
{
    CityReader cityReader = new CityReader();
    String jsonPath = "./data.json";
    String ExpectedDescriptionAmsterdam = "Amsterdam’s intriguing history spans seven centuries. From humble beginnings as a small village to a world power in the 17th century, Amsterdam today is a fascinating mix of history and commerce.";
    String expectedDescriptionTelAviv = "Tel Aviv, a city on Israel’s Mediterranean coast, is marked by stark 1930s Bauhaus buildings, thousands of which are clustered in the White City architectural area.";
    String expectedCityNameAmsterdam = "Amsterdam";
    String expectedCityNameTelAviv = "Tel Aviv";
    String keyWordPartOfDescription = "stark 1930s";

    @Test
    public void searchByFullDescription() throws IOException {
        List<CityData> citiesData = cityReader.searchByKeyWord(ExpectedDescriptionAmsterdam, jsonPath);

        assertEquals(citiesData.size(), 1);
        assertEquals(citiesData.get(0).getCityName(), expectedCityNameAmsterdam);
        assertEquals(citiesData.get(0).getCityDescription(), ExpectedDescriptionAmsterdam);
    }

    @Test
    public void searchByPartialDescription() throws IOException {
        List<CityData> citiesData = cityReader.searchByKeyWord(keyWordPartOfDescription, jsonPath);

        assertEquals(citiesData.size(), 1);
        assertEquals(citiesData.get(0).getCityName(), expectedCityNameTelAviv);
        assertEquals(citiesData.get(0).getCityDescription(), expectedDescriptionTelAviv);
    }

    @Test
    public void searchWithEmptyString() throws IOException {
        List<CityData> citiesData = cityReader.searchByKeyWord("", jsonPath);

        assertEquals(citiesData.size(), 7);
    }

    @Test
    public void searchForSeveralSearchResults() throws IOException {
        List<CityData> citiesData = cityReader.searchByKeyWord("cent", jsonPath);

        assertEquals(citiesData.size(), 3);
    }

    @Test
    public void searchWithNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> cityReader.searchByKeyWord(null, jsonPath));

        String expectedMessage = "Cannot invoke \"java.lang.CharSequence.toString()\" because \"s\" is null";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
