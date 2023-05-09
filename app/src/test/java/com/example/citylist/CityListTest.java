package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testDelete()
    {
        CityList cityList=new CityList();
        City city=new City("Natore","Rajshahi");
        City city1=new City("Pabna","Rajshahi");
        cityList.add(city);
        cityList.add(city1);

       // cityList.delete(city);
        assertTrue(!cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * This tests if a city exists or not
     */
    @Test
    public void testDeleteException()
    {
        CityList cityList=new CityList();
        City city=new City("Natore","Rajshahi");
        City city1=new City("Pabna","Rajshahi");
        cityList.add(city);
        cityList.add(city1);
        //assertEquals(2,cityList.count());

        //cityList.delete(city);
        //assertEquals(1,cityList.count());
        assertThrows(IllegalArgumentException.class, () -> {
           // cityList.delete(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testGetCitiesSorted() {
        CityList cityList = new CityList();
        City city1= new City("Jessore", "ABC");
        cityList.add(city1);

        assertEquals(0, city1.compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities().get(1)));
    }
}
