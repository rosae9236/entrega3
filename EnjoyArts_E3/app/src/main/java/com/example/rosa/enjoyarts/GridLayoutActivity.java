package com.example.rosa.enjoyarts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class GridLayoutActivity  extends BaseAdapter {

    private Context mContext;

    // Keep all Images in array
    public Integer[] picturesIds = {
            R.drawable.ic_vangoght_background, R.drawable.ic_seuratt_background,
            R.drawable.ic_rothko_background, R.drawable.ic_munchg_background,

    };

    // Constructor
    public GridLayoutActivity(Context c){
        mContext = c;
    }
    @Override
    public int getCount() {

        return picturesIds.length;
    }

    @Override
    public Object getItem(int position) {

        return picturesIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(picturesIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }
}
