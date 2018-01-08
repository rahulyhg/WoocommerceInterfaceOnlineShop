package com.tehran.amir.aria.woocommerceinterfaceonlineshop.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by amir on 1/6/2018.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceLeft;
    private int spaceRight;
    private int spaceTop;
    private int spaceButton;


    public SpacesItemDecoration(int spaceLeft ,int  spaceRight ,int spaceTop ,int spaceButton) {
        this.spaceLeft = spaceLeft;
        this.spaceRight = spaceRight;
        this.spaceTop = spaceTop;
        this.spaceButton = spaceButton;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = spaceLeft;
        outRect.right = spaceRight;
        outRect.bottom = spaceButton;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) == 0 ||
                parent.getChildLayoutPosition(view) == 1) {
            outRect.top = spaceTop;
        } else {
            outRect.top = 0;
        }
    }
}
