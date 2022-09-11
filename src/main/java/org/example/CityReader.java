package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class CityReader
{
    public CityReader() {
    }

    public List<CityData> searchByKeyWord(String searchKey, String jsonPath) throws IOException {
        List<CityData> cities = getCitiesFromJson(jsonPath);
        List<CityData> searchResults = cities.stream().filter(c -> c.getCityDescription().contains(searchKey)).collect(Collectors.toList());
        System.out.println(searchResults);
        return searchResults;
    }

    private List<CityData> getCitiesFromJson(String jsonPath) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(jsonPath));
        return new Gson().fromJson(reader, new TypeToken<List<CityData>>() {}.getType());
    }
}
