package com.entertainment;

import java.util.Objects;

/*
 * to be consistent with equals whatever fields we use for equals() and hashCode(),
 * we MUST use those same fields for natural order
 * That means well switch to a primary sort key 'brand' and when tied on brand,
 * we will break tie via secondary sort key 'volume'
 */
public class Television implements  Comparable<Television> {

   private String brand;
   private int volume;



   
   public Television() {
   }

   public Television(String brand, int volume) {
       setBrand(brand);
       setVolume(volume);
   }

   private Tuner tuner = new Tuner();

   public int getCurrentChannel() {
       return tuner.getChannel();

   }
   public void changeChannel(int channel){
       tuner.setChannel(channel);
   }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
/*

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Television that = (Television) obj;
        return this.getVolume() == that.getVolume() && Objects.equals(this.getBrand(), that.getBrand());
    }
 */

    @Override
    public int hashCode() {
       /*
        *This is a poorly written hash function, because it easily yields "hash collisions."
        * a hash collision is when "different" object have the same hash code (just by coincidence)
        */
       //return getBrand().length() + getVolume(); <===BAD
        // instead we rely on Objects.hash() to give us a "scientifically correct" hash function
        return Objects.hash(getBrand(), getVolume());
    }


    @Override
    public boolean equals(Object obj) {
       boolean result = false;
       // proceed only if 'obj' is really referencing a Television object
       if(obj != null && this.getClass() == obj.getClass()) {
           //safely downcast 'obj' to more specific reference type Television
           Television other = (Television) obj;

           // do the checks: business equality is defined by brand and volume being the same
           result =  Objects.equals(this.getBrand(), other.getBrand()) &&     // null-safe check
                   this.getVolume() == other.getVolume();

       }
       return result;
    }

    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {  // tied on brand
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "[brand= " + getBrand() + " volume= " +
                getVolume() + " currentChannel= " + getCurrentChannel() + "]";
    }
}