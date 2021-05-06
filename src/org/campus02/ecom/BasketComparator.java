package org.campus02.ecom;

import java.util.Comparator;

public class BasketComparator implements Comparator<BasketData> {

    @Override
    public int compare(BasketData o1, BasketData o2) {
        return o1.getBuyingLocation().compareTo(o2.getBuyingLocation());
    }
}
