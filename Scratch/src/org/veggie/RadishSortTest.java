package org.veggie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        // color, size, tailLength, sprouts
        radishes.add(new Radish("red", 2.1, 1.0, 0));
        radishes.add(new Radish("black", 1.0, 0.0, 3));
        radishes.add(new Radish("red", 2.5, 4.2, 0));
        radishes.add(new Radish("pink", 0.7, 3.2, 2));

        System.out.println("Orginial Order");
        dump(radishes);
        System.out.println();

        System.out.println("Natural Order");
        radishes.sort(null);
        dump(radishes);
        System.out.println();

        System.out.println("Color Order, via anonymous class ");
        //radishes.sort(new RadishColorComparator());
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return r1.getColor().compareTo(r2.getColor());
            }
        });
        dump(radishes);
        System.out.println();

        System.out.println("Sprouts Order, via anonymous class");
        //radishes.sort(new RadishSproutsComparator());
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return Integer.compare(r1.getSprouts(), r2.getSprouts());
            }
        });
        dump(radishes);
        System.out.println();

        System.out.println("sort by tail length via anonymous class");
       radishes.sort(new Comparator<Radish>() {

           @Override
           public int compare(Radish r1, Radish r2) {
               return Double.compare(r1.getTailLength(), r2.getTailLength());
           }
       });
       dump(radishes);
        System.out.println();



    }

    private static void dump(List<Radish> radishes) {
        for (Radish radish : radishes) {
            System.out.println(radish);  // toString() auto called

        }
    }
}