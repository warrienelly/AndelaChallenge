package com.andela.warrie.andelachallenge.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.andela.warrie.andelachallenge.R;
import com.andela.warrie.andelachallenge.adapters.MainPageAdapter;
import com.andela.warrie.andelachallenge.callbackds.ApiInterface;
import com.andela.warrie.andelachallenge.callbackds.RecyclerTouchListener;
import com.andela.warrie.andelachallenge.model.Currency;
import com.andela.warrie.andelachallenge.model.CurrencyPojo;
import com.andela.warrie.andelachallenge.requestmanager.api.ApiClient;
import com.andela.warrie.andelachallenge.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Currency> currencyList = new ArrayList<>();
    private RecyclerView recyclerView;
    ProgressBar progressBar;
    private MainPageAdapter mAdapter;
    public final String currencies = "USD,EUR,NGN,DKK,BRL,JPY,GBP,INR,HKD,KRW,CAD,ARS,CZK,MXN,RUB,CHF,ZAR,IDR,ILS,MYR";
    String currencyType = "BTC";
    FloatingActionButton floatingActionButton;
    public static Context context;

    String[] SPINNERLIST = {"Etherum", "Bitcoin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context  = this;

//        Toolbar toolbar =  findViewById(android.R.id.toolbar);
//        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        floatingActionButton = findViewById(R.id.floatingActionButton2);
        progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        mAdapter = new MainPageAdapter(currencyList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popUpDialog();
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Currency currency = currencyList.get(position);
                Toast.makeText(getApplicationContext(), currency.getCountry() + " Hippie!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        makeRetrofitRequest(currencyType);
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }


    public void makeRetrofitRequest(String currencyType){

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<CurrencyPojo> call = apiService.getCurrencies(currencyType, currencies);
        Log.e("TAG", "URL " + call.request().url());
        call.enqueue(new Callback<CurrencyPojo>() {
            @Override
            public void onResponse(Call<CurrencyPojo>call, Response<CurrencyPojo> response) {

                Log.e("TAG", "entered on response " + response.body().toString());
                CurrencyPojo currencyPojo = response.body();
                currencyList = Utils.getCurrencyList(currencyPojo);
                mAdapter.setData(currencyList);
                Log.e("TAG", "Number of movies received: " + currencyList.toString());
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<CurrencyPojo>call, Throwable t) {
                // Log error here since request failed
                Log.e("TAG", t.toString());
            }
        });
    }

    public void popUpDialog(){

        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View mView = layoutInflaterAndroid.inflate(R.layout.pop_up_dialog, null);
        final AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(this);
        alertDialogBuilderUserInput.setView(mView);

        Spinner spinner =  mView.findViewById(R.id.spinner);
        final ImageView coinImage = mView.findViewById(R.id.coin_image_dialog);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        if(spinner == null){
            Log.e("TAG", "spinner is null" );
            return;
        }
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    currencyType = "BTC";
                    coinImage.setImageDrawable(getResources().getDrawable(R.drawable.bitcoin_icon));

                }else {
                    currencyType = "ETH";
                    coinImage.setImageDrawable(getResources().getDrawable(R.drawable.etherum_icon));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        makeRetrofitRequest(currencyType);
                        progressBar.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                    }
                })

                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
        alertDialogAndroid.show();
    }


}
