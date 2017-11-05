package com.andela.warrie.andelachallenge.model;

/**
 * Created by Bless on 11/2/2017.
 */

public class Currency {
    private String currencyName;
    private double price;
    private String country;

    public Currency() {
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyName='" + currencyName + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                '}';
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}
