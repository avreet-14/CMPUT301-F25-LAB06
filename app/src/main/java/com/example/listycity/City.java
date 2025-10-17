package com.example.listycity;

/**
 *This class represents a City with a name and a province.
 * It implements the Comparable interface to allow sorting by city name.
 */
public class City implements Comparable<City> {

    private String city;
    private String province;

    /**
     * Constructs a City object with the specified city name and province.
     * @param city the name of the city
     * @param province the province the city belongs to
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of the city.
     * @return the city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Gets the name of the province.
     * @return the province name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this city to another city lexicographically by city name.
     * @param other the other City to compare to
     * @return a negative integer, zero, or a positive integer
     *         if this city name is less than, equal to, or greater than the other
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Checks if this city is equal to another object.
     * Two cities are equal if both their names and provinces match.
     * @param obj the object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return this.city.equals(city.getCityName()) &&
                this.province.equals(city.getProvinceName());
    }

    /**
     * Returns a hash code for this City object.
     * @return the hash code based on city and province
     */
    @Override
    public int hashCode() {
        return (city + province).hashCode();
    }

    /**
     * Returns a string representation of the city.
     * @return the city and province formatted as "City, Province"
     */
    @Override
    public String toString() {
        return city + ", " + province;
    }
}