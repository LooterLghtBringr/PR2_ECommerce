package org.campus02.ecom;

import java.util.ArrayList;

public class BasketDataDemo {

    public static void main(String[] args) {
        try {
            ArrayList<BasketData> a = BasketDataLoader.load("D:\\IdeaProjects\\StarterKitUE05052021\\data\\buyings.json", new BasketComparator());

            for (BasketData bd : a) {
                System.out.println(bd.toString());
            }

            BasketAnalyzer basketAnalyzer = new BasketAnalyzer(a);
            basketAnalyzer.groupByProductCategory();

        } catch (DataFileException e) {
            e.printStackTrace();
        }
    }

}
