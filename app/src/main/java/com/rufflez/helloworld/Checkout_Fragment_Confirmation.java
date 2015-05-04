package com.rufflez.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Mohammed on 03-05-2015.
 */
public class Checkout_Fragment_Confirmation extends Fragment implements View.OnClickListener{
    ArrayList<Product> products=new ArrayList<Product>();
    Button order;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_checkout_confirmation, container, false);
        order=(Button)v.findViewById(R.id.order);
        order.setOnClickListener(this);
        getproducts();
        CustomGrid adapter = new CustomGrid(getActivity(), products);
        GridView grid=(GridView)v.findViewById(R.id.gridView);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });

        return v;
    }

    private void getproducts() {

        Product pr=new Product("1", "Superior Birds Nest with Rock Sugar","Canned Food", 45.00, "New Moon superio......", getResources().getDrawable(R.drawable.download));
        Product pr2=new Product("2", "Superior Birds Nest with Rock salt","Canned Food", 50.00, "New Moon superio......", getResources().getDrawable(R.drawable.download));
        products.add(pr);
        products.add(pr2);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = new Checkout_fragment_payment();

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }
}


