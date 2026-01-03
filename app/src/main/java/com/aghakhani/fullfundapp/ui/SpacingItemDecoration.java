package com.aghakhani.fullfundapp.ui;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adds consistent spacing between RecyclerView items for a cleaner layout.
 */
public class SpacingItemDecoration extends RecyclerView.ItemDecoration {

    private final int spacePx;

    public SpacingItemDecoration(int spacePx) {
        this.spacePx = spacePx;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect,
                               @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        outRect.left = spacePx;
        outRect.right = spacePx;
        outRect.bottom = spacePx;

        int pos = parent.getChildAdapterPosition(view);
        if (pos == 0) outRect.top = spacePx;
    }
}
