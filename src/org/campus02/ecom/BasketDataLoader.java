package org.campus02.ecom;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BasketDataLoader {

    public static ArrayList<BasketData> load(String path) throws DataFileException {
        ArrayList<BasketData> basketData = null;
        try
        {
            basketData = new ArrayList<>();
            File f = new File(path);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while((line = br.readLine()) != null)
            {
                BasketData bd = new Gson().fromJson(line, BasketData.class);
                basketData.add(bd);
            }
        }
        catch (Exception e)
        {
            throw new DataFileException("Error", e);
        }

        return basketData;
    }

    public static ArrayList<BasketData> load(String path, Comparator<BasketData> comparator) throws DataFileException {
        ArrayList<BasketData> basketData = null;
        try
        {
            basketData = new ArrayList<>();
            File f = new File(path);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while((line = br.readLine()) != null)
            {
                BasketData bd = new Gson().fromJson(line, BasketData.class);
                basketData.add(bd);
            }

            Collections.sort(basketData, comparator);
        }
        catch (Exception e)
        {
            throw new DataFileException("Error", e);
        }

        return basketData;
    }
}
