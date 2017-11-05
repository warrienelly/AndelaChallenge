package com.andela.warrie.andelachallenge.utils;

import android.util.Log;

import com.andela.warrie.andelachallenge.R;
import com.andela.warrie.andelachallenge.model.Currency;
import com.andela.warrie.andelachallenge.model.CurrencyPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bless on 11/3/2017.
 */

public class Utils {

    static final String[] currencyNames = {
            "Argentine Peso",
            "Brazillian Real",
            "Canadian Dollar",
            "Swiss Franc",
            "Czech Koruna",
            "Euro",
            "British Pound",
            "Hong Kong Dollar",
            "Indonesian Rupiah",
            "IsraelI New Shekel",
            "Indian Rupee",
            "Japanese Yen",
            "Korean Won",
            "Mexican Peso",
            "Malaysian Ringgit",
            "Naira",
            "Belarusian Ruble",
            "Danish Krone",
            "US Dollar",
            "South African Rand"

    };

     static final String[] currencyCountries = {
            "Argentina",
            "Brazil",
            "Canada",
            "France",
            "Czech Republic",
            "Europe",
            "Britian",
            "Hong Kong",
            "Indonesia",
            "Israel",
            "India",
            "Japan",
            "Korea",
            "Mexico",
            "Malaysia",
            "Nigeria",
            "Belugaria",
            "Danish Republic",
            "United States",
            "South Africa",
    };

    public static final int[] curencyDrawables = {
            R.drawable.argentine,
            R.drawable.brazillian_real,
            R.drawable.canadian,
            R.drawable.swiss,
            R.drawable.czech,
            R.drawable.euro,
            R.drawable.british_pound,
            R.drawable.hong_kong,
            R.drawable.indonesia,
            R.drawable.isreal,
            R.drawable.indian_rupee,
            R.drawable.japan_yen,
            R.drawable.korean_won,
            R.drawable.mexican,
            R.drawable.malaysia,
            R.drawable.naira,
            R.drawable.bitcoin_icon,
            R.drawable.danish,
            R.drawable.dollar,
            R.drawable.south_africa
    };


    public static List<Currency> getCurrencyList(CurrencyPojo currencyPojo){

        Log.e("TAG", "entered get currecy list");
        List<Currency> currencyList = new ArrayList<>();

        for(int i=0; i<19;i++){
            Currency currency = new Currency();
            switch (i){
                case 0:
                    Log.e("TAG", "case 0");
                    currency.setPrice(Double.valueOf((currencyPojo.getARS()) != null ? currencyPojo.getARS() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 1:
                    currency.setPrice(Double.valueOf(currencyPojo.getBRL()!= null ? currencyPojo.getBRL() : "100.00"  ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 2:
                    currency.setPrice(Double.valueOf(currencyPojo.getCAD() != null ? currencyPojo.getCAD() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 3:
                    currency.setPrice(Double.valueOf(currencyPojo.getCHF() != null ? currencyPojo.getCHF() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 4:
                    currency.setPrice(Double.valueOf(currencyPojo.getCZK() != null ? currencyPojo.getCZK() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 5:
                    Log.e("TAG", "case 5 eur " + currencyPojo.getEUR());
                    currency.setPrice(Double.valueOf(currencyPojo.getEUR() != null ? currencyPojo.getEUR() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 6:
                    currency.setPrice(Double.valueOf(currencyPojo.getGBP() != null ? currencyPojo.getGBP() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 7:
                    currency.setPrice(Double.valueOf(currencyPojo.getHKD() != null ? currencyPojo.getHKD() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 8:
                    currency.setPrice(Double.valueOf(currencyPojo.getIDR() != null ? currencyPojo.getIDR() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 9:
                    currency.setPrice(Double.valueOf(currencyPojo.getILS() != null ? currencyPojo.getILS() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 10:
                    currency.setPrice(Double.valueOf(currencyPojo.getINR() != null ? currencyPojo.getINR() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 11:
                    currency.setPrice(Double.valueOf(currencyPojo.getJPY() != null ? currencyPojo.getJPY() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 12:
                    currency.setPrice(Double.valueOf(currencyPojo.getKRW() != null ? currencyPojo.getKRW() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 13:
                    currency.setPrice(Double.valueOf(currencyPojo.getMXN() != null ? currencyPojo.getMXN() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 14:
                    currency.setPrice(Double.valueOf(currencyPojo.getMYR() != null ? currencyPojo.getMYR() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 15:
                    currency.setPrice(Double.valueOf(currencyPojo.getNGN() != null ? currencyPojo.getNGN() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 16:
                    currency.setPrice(Double.valueOf(currencyPojo.getRUB() != null ? currencyPojo.getRUB() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 17:
                    currency.setPrice(Double.valueOf(currencyPojo.getSHP() != null ? currencyPojo.getSHP() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 18:
                    currency.setPrice(Double.valueOf(currencyPojo.getUSD() != null ? currencyPojo.getUSD() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
                case 19:
                    currency.setPrice(Double.valueOf(currencyPojo.getZAR() != null ? currencyPojo.getZAR() : "100.00" ));
                    currency.setCurrencyName(currencyNames[i]);
                    currency.setCountry(currencyCountries[i]);
                    currencyList.add(currency);
                    break;
            }

        }
        return currencyList;
    }
}
