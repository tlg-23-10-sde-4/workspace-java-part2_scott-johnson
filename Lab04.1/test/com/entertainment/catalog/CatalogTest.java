/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Before
    public void setUp()  {

    }

    @Test(expected=UnsupportedOperationException.class)
    public void getInventory_shouldReturnReadOnlyCollection() {
        Collection<Television> tvs = Catalog.getInventory();
        tvs.clear(); // should throw exception

    }

//    @Test
//    public void findByBrands_shouldReturnPopularedMap_brandsPassed_1() {
//       String[] brands = { "Sony", "Zenith"};
//       Map<String,Collection<Television>> tvMap = Catalog.findByBrands(brands);
//
//       assertEquals(brands.length, tvMap.size());
//
//       for (String brand : brands) {
//           verifyCollection(brand, tvMap.get(brand));
//
//        }
//
//
//    }

    @Test
    public void get() {
    }

    @Test
    public void findByBrands_shouldReturnPopulatedMap_whenBrandsArePassed() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "Zenith");
        assertEquals(2, tvMap.size());
        Collection<Television> sonyTvs = tvMap.get("Sony");
        for (Television tv : sonyTvs) {
            assertEquals("Sony", tv.getBrand());

        }
        Collection<Television> zenithTvs = tvMap.get("Zenith");
        for (Television tv : zenithTvs) {
            assertEquals("Zenith", tv.getBrand());
        }
    }


    @Test
    public void findByBrands_shouldReturnEmptyMap_whenNoBrandsPassed() {
        Map<String, Collection<Television>> tvMap = Catalog.findByBrands();
        assertTrue(tvMap.isEmpty());

    }

// hint brand is a string[] array in here and you can for each other it.
    @Test
    public void findByBrand_shouldReturnCollection_whenBrandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");
        assertEquals(7, tvs.size());

        for (Television tv : tvs ) {
            assertEquals("Sony", tv.getBrand());
        }
    }

    @Test
    public void findByBrand_shouldReturnEmptyCollection_whenBrandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(tvs);
        assertTrue(tvs.isEmpty());
    }
}