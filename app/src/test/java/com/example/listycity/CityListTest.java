package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains unit tests for the {@link CityList} class.
 * Each test method verifies the correctness of one or more
 * functionalities implemented in CityList.
 */
public class CityListTest {
    /**
     * Creates a mock CityList containing one default city ("Edmonton, Alberta").
     * @return a CityList object with one City added
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }


    /**
     * Creates a mock City object for testing purposes.
     * @return a City object representing "Edmonton, Alberta"
     */
    private City mockCity() {

        return new City("Edmonton", "Alberta");
    }

    /**
     * Tests that adding a city to the list correctly increases the list size
     * and that the city is properly stored.
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Tests that adding a duplicate city throws an IllegalArgumentException.
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    /**
     * Tests that {@link CityList#getCities()} returns a sorted list of cities
     * and verifies their order after multiple insertions.
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
         // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
         // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
       // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    /**
     * Tests whether {@link CityList#hasCity(City)} correctly detects
     * the presence or absence of a city in the list.
     */

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(city)); // should be true
        City missingCity = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(missingCity)); // should be false
    }


    /**
     * Tests that {@link CityList#delete(City)} properly removes an existing city.
     */
    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city)); // should be removed
    }
    /**
     * Tests that {@link CityList#delete(City)} throws an IllegalArgumentException
     * when attempting to remove a city not present in the list.
     */
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * Tests that {@link CityList#countCities()} returns the correct number of cities
     * after additions to the list.
     */
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Vancouver", "British Columbia"));
        assertEquals(2, cityList.countCities());
    }

}
