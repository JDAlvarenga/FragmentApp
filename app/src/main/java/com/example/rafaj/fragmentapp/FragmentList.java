package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener{

    ArrayList<Planet> planets;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        planets = new ArrayList<Planet>();


        String[] names = getResources().getStringArray(R.array.planet_names);
        String[] masses = getResources().getStringArray(R.array.planets_mass);
        String[] gravities = getResources().getStringArray(R.array.planets_gravity);

        TypedArray imgs = getResources().obtainTypedArray(R.array.planet_images);


        if(names.length == masses.length && masses.length == gravities.length && gravities.length == imgs.length()) {
            for (int i = 0; i < names.length; i++) {
                planets.add(new Planet(names[i], masses[i], gravities[i], imgs.getResourceId(i, -1)));
            }
        }



        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.planet_names, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();



        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            newIntent.setAction(Intent.ACTION_SEND);
            //newIntent.setType("text/plain");
            newIntent.putExtra(Planet.KEY_PLANET, planets.get(i));
            startActivity(newIntent);
        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Toast.makeText(getActivity(), "Item: " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            Bundle bundlePlanet = new Bundle();
            bundlePlanet.putSerializable(Planet.KEY_PLANET, planets.get(i));

            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundlePlanet);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }



    }
}
