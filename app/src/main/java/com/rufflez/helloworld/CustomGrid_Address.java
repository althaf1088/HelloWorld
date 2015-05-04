package com.rufflez.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mohammed on 03-05-2015.
 */
public class CustomGrid_Address extends BaseAdapter {

    private Context mContext;
    private ArrayList<Address> addressArrayList;

    public CustomGrid_Address(Context c,ArrayList<Address> addressArrayList ) {
        mContext = c;
        this.addressArrayList=addressArrayList;

    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return addressArrayList.size();
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
            grid = inflater.inflate(R.layout.addresslayout, null);
            TextView textView = (TextView) grid.findViewById(R.id.activeAddress);

            textView.setText(addressArrayList.get(position).getModifiedAdress());

        } else {
            grid = (View) convertView;
        }

        return grid;
    }

}
