package com.andela.warrie.andelachallenge.adapters;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.warrie.andelachallenge.R;
import com.andela.warrie.andelachallenge.model.Currency;
import com.andela.warrie.andelachallenge.ui.MainActivity;
import com.andela.warrie.andelachallenge.utils.Utils;

import java.util.List;

import okhttp3.internal.Util;

/**
 * Created by Bless on 11/2/2017.
 */

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MyViewHolder> {

    List<Currency> currencyList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView currencyName, country, amount;
        public ImageView currencyImage;
        public MyViewHolder(View view) {
            super(view);
            currencyImage = view.findViewById(R.id.coin_image);
            currencyName =  view.findViewById(R.id.currency_name);
            country =  view.findViewById(R.id.currency_country);
            amount=  view.findViewById(R.id.currency_amount);
        }
    }


    public MainPageAdapter(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Currency currency = currencyList.get(position);
        holder.currencyName.setText(currency.getCurrencyName());
        holder.country.setText(currency.getCountry());
        holder.amount.setText( ""+ currency.getPrice());
        holder.currencyImage.
                setImageDrawable(MainActivity.context.getResources().getDrawable(Utils.curencyDrawables[position]));
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }

    public void setData(List<Currency> currencyList){
        Log.e("TAG", "set data entered " );
        this.currencyList = currencyList;
        notifyDataSetChanged();
    }
}

