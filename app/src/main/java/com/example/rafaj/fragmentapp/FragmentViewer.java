package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    TextView txt_name, txt_mass, txt_gravity;
    ImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        txt_name = view.findViewById(R.id.txt_name);
        txt_mass = view.findViewById(R.id.txt_mass);
        txt_gravity = view.findViewById(R.id.txt_gravity);
        image = view.findViewById(R.id.img_planet);

        Bundle bundle = this.getArguments();


        if(bundle != null){

            Planet planet = (Planet)(bundle.getSerializable(Planet.KEY_PLANET));
            //Toast.makeText(getActivity(), "Planet: " + planet.getName(), Toast.LENGTH_SHORT).show();


            txt_name.setText(planet.getName());
            txt_mass.setText(planet.getMass() + "\n" + getResources().getString(R.string.mass_units));
            txt_gravity.setText(planet.getTemp() + "\n" + getResources().getString(R.string.gravity_units));
            image.setImageResource(planet.getPicture());

        }

        return view;
    }


}
