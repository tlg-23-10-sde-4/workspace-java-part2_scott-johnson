package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp()  {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void numberInGenre_shouldReturnCorrectResult() {
        int result = catalog.numberInGenre(MusicCategory.POP);
        assertEquals(4, result);

    }

    @Test
    public void findSelfTitled_shouldReturnCollection_whenArtistSameAsTitle() {
        Collection<MusicItem> items = catalog.findSelfTitled();
        assertEquals(2, items.size());

        for (MusicItem item : items) {
            assertTrue(item.getArtist().equals(item.getTitle())); //same as below
            assertEquals(item.getArtist(), item.getTitle());

        }
    }

    @Test
    public void findByCategory_shouldReturnCollection_whenCategoryFound() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        assertEquals(4, items.size());

        for (MusicItem item : items) {
            assertTrue(MusicCategory.POP == item.getMusicCategory()); // ok to use == ffor enum
            assertSame(MusicCategory.POP, item.getMusicCategory());
            assertEquals(MusicCategory.POP, item.getMusicCategory()); // used equals() method all of these are the same
        }
    }

    @Test
    public void findByCategory_shouldReturnEmptyCollection_whenCategoryNotFound() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.JAZZ);
        assertEquals(0, items.size());
    }

    @Test
    public void findById_shouldReturnMusicItem_whenFound() {
        MusicItem item = catalog.findById(1L);
        assertEquals(1L, item.getId().longValue());
    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(19L);
        assertNull(item);
        assertTrue(item == null); // same thing
    }
}