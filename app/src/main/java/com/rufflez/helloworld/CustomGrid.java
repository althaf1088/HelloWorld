package com.rufflez.helloworld;

/**
 * Created by hemanth on 2/5/2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomGrid extends BaseAdapter{
    private Context mContext;
   private ArrayList<Product>products;

    public CustomGrid(Context c,ArrayList<Product>products ) {
        mContext = c;
        this.products=products;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.gridviewadapter, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            TextView price = (TextView) grid.findViewById(R.id.grid_price);

            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(products.get(position).name);
            price.setText(""+products.get(position).price);
            imageView.setImageDrawable(products.get(position).getImage());
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
