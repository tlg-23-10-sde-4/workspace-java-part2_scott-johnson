package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
   private Television tv1;
   private Television tv2;


    @Before
    public void setUp() {
        tv1 = new Television("Sony", 50, DisplayType.LCD);
        tv2 = new Television("Sony", 50, DisplayType.LCD);

    }

    @Test
    public void hashCode_equalObjectMustHaveEqualHashCodes() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_sameDisplayType() {
        tv2.setBrand("LG");
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_differentVolume_sameDisplayType() {
        tv2.setVolume(30);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_sameVolume_differentDisplayType() {
        tv2.setDisplay(DisplayType.LED);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(tv1, tv2);

    }

    @Test(expected=InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_upperBound() throws InvalidChannelException{
        tv1.changeChannel(1000);
    }

    @Test(expected=InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_whenInvalid_lowerBound() throws InvalidChannelException{
        tv1.changeChannel(-1);
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws InvalidChannelException {
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws InvalidChannelException{
        tv1.changeChannel(1);
        assertEquals(1, tv1.getCurrentChannel());
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_upperBound() {
        try {
            tv1.setVolume(101);
            fail("should have throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            String expected = "Invalid volume: 101. Allowed range: [0,100].";
            assertEquals(expected, e.getMessage());
        }

    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalid_lowerBound() {
        tv1.setVolume(-1);


    }

    @Test
    public void setVolume_shouldStoreValue_when_Vaild_upperBound() {
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());

    }

    @Test
    public void setVolume_shouldStoreValue_whenValid_lowerBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());


    }
}