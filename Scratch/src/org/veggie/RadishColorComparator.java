package org.veggie;

import java.util.Comparator;

// sort key is Color String
class RadishColorComparator implements Comparator<Radish> {
    @Override
    public int compare(Radish radish1, Radish radish2) {

        return radish1.getColor().compareTo(radish2.getColor());
    }
}