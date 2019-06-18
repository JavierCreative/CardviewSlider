package com.creative.carviewslider;

import android.support.v7.widget.CardView;

public interface CardAdapter {
    int MAX_ELEVATION_FACTOR = 8;
    float BASE_ELEVATION = 4;
    CardView getCardViewAt(int position);
    int getCount();
}