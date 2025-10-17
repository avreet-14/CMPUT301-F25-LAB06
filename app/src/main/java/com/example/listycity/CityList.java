package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *This is a class that keeps a list of city objects
 */

public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list if it does not already exist.
     * @param city the city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list");
        }
        cities.add(city);
    }

    /**
     * Returns a sorted list of cities by name.
     * @return a sorted list of City objects
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a city exists in the list.
     * @param city the city to check
     * @return true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list.
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not found
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list");
        }
        cities.remove(city);
    }

    /**
     * Returns the total number of cities in the list.
     * @return the number of cities
     */
    public int countCities() {
        return cities.size();
    }
}