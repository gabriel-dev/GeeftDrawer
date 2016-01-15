package com.gabrieldev.geeftdrawer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oldboy on 08/01/16.
 */
public class GeeftManager {
    private static String[] geeftArray = {"Old Chair", "Tennis Balls", "FreeHand Yo-yo", "Rollerblade", "DVD reader", "Book"};
    private static String[] geefterArray = {"Fabiola Amaya", "Ugo Okeadu", "Gabriele Vecchia", "Daniele Bracciani", "Joseph Aguilar", "Mickey Mouse"};
    private static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut " +
            "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " +
            "commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    private static GeeftManager mInstance;
    private List<Geeft> countries;

    public static GeeftManager getInstance() {
        if (mInstance == null) {
            mInstance = new GeeftManager();
        }

        return mInstance;
    }

    public List<Geeft> getCountries() {
        if (countries == null) {
            countries = new ArrayList<Geeft>();

            //in that area we associate the parameter to the layout we see
            String geeftName, geefterName;
            for (int i = 0; i < geeftArray.length; i++) {
                geefterName = geefterArray[i];
                geeftName = geeftArray[i];
                Geeft geeft = new Geeft();
                geeft.setGeefter(geefterName);
                geeft.setName(geeftName);
                geeft.setDescription(loremIpsum);
                geeft.setImageName(geeftName.replaceAll("\\s+","").toLowerCase());
                countries.add(geeft);
            }
        }

        return  countries;
    }

}
