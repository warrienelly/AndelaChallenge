package com.andela.warrie.andelachallenge.callbackds;

import com.andela.warrie.andelachallenge.model.CurrencyPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bless on 11/3/2017.
 */

public interface ApiInterface {

    @GET("data/price")
    Call<CurrencyPojo> getCurrencies(@Query("fsym") String currencyType, @Query("tsyms") String currencies);


}
