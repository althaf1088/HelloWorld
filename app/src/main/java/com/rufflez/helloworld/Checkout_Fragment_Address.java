package com.rufflez.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Mohammed on 03-05-2015.
 */
public class Checkout_Fragment_Address extends Fragment {

    private ArrayList<Address> addressList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_checkout, container, false);
        getAddresses();
        CustomGrid_Address adapter = new CustomGrid_Address (getActivity(), addressList);
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

    private ArrayList<Address> getAddresses(){

        Address address1=new Address("Venus wong","Hougan Ave 7 Blk 344","s503444","95207188");
        addressList.add(address1);
        Address address2=new Address("Venus wong","Hougan Ave 7 Blk 344","s503444","95207188");
        addressList.add(address2);
        return addressList;


    }
}
