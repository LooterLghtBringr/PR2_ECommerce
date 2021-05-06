package org.campus02.ecom;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasketAnalyzer {
    List<BasketData> baskets = new ArrayList<>();

    public BasketAnalyzer(List<BasketData> baskets) {
        this.baskets = baskets;
    }

    public List<BasketData> getEveryNthBasket(int n){
        List<BasketData> nthData = new ArrayList<BasketData>();
        int j = 0;
        for (int i = 0; i < baskets.size(); i++){

            if (i == n || i == (j+n)) {
                j = i;
                nthData.add(baskets.get(i));
            }
        }
        return nthData;
    }

    public List <BasketData> filterBaskets(String paymentType, Double from, Double to){
        List<BasketData> filteredData = new ArrayList<>();
        for (BasketData bd : baskets) {
            if (bd.getPaymentType().equals(paymentType) && (bd.getOrderTotal() >= from && bd.getOrderTotal() <= to))
                filteredData.add(bd);
        }
        return filteredData;
    }

    private List <BasketData> filterProductCategory(String productCategory){
        List<BasketData> filteredData = new ArrayList<>();
        for (BasketData bd : baskets) {
            if (bd.getProductCategory().equals(productCategory))
                filteredData.add(bd);
        }
        return filteredData;
    }

    public HashMap<String, ArrayList<Double>> groupByProductCategory() {
        HashMap<String, ArrayList<Double>> grouped = new HashMap<>();
        ArrayList<Double> orderTotal = new ArrayList<>();
        for (BasketData bd : baskets) {
            grouped.put(bd.getProductCategory(), orderTotal);
        }

        for (String key : grouped.keySet()) {
            List<BasketData> productCategory = filterProductCategory(key);
            orderTotal = new ArrayList<>();
            for (BasketData basketDataForTotal : productCategory) {
                orderTotal.add(basketDataForTotal.getOrderTotal());
            }
            grouped.put(key, orderTotal);
        }
        return grouped;
    }
}
