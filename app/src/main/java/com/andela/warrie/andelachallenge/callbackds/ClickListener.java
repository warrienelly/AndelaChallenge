package com.andela.warrie.andelachallenge.callbackds;

import android.view.View;

/**
 * Created by Bless on 11/2/2017.
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
