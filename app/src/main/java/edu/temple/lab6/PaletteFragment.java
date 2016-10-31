package edu.temple.lab6;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class PaletteFragment extends Fragment {

    //global variables
    SenderInterface activity;

    public PaletteFragment(){
        //required empty public constructor
    }

    @Override public void onAttach(Activity c){
        super.onAttach(c);
        activity = (SenderInterface) c;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        //put listview into variable
        ListView lv = (ListView) v.findViewById(R.id.listView);

        //get colors from the resources rolder
        Resources res = this.getResources();
        String[] colorLabels = res.getStringArray(R.array.colors_array);

        //create a custom adapter for the spinner to have the color array
        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, colorLabels);

        //set the adapter
        lv.setAdapter(colorAdapter);

        //deal with the list view listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the string of the color that you picked from the spinner
                //String color = parent.getItemAtPosition(position).toString(); //old way just gets the actual string not position
                String color = Integer.valueOf(position).toString();

                //send the color using the interface
                activity.acceptColor(color);

            }
        });

        return v;

    }

    //interface to send string to other fragment
    public interface SenderInterface {
        public void acceptColor(String message);
    }
}
