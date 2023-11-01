package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {

    public static void main(String[] args) {
        // show behavior of == versus equals()
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Samsung", 32);
        Television tvD = new Television("LG", 12);
        System.out.println();


        System.out.println("tvA ==tvB: " +  (tvA == tvB));
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));


        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);  // should be rejected as a dupilcate (no dupes in sets)
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The size of the set is: " + tvs.size());
        for (Television tv :tvs) {
            System.out.println(tv);
        }


    }
}