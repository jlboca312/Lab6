package edu.temple.lab6;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class CanvasFragment extends Fragment {

    RelativeLayout rl;
    static final String[] colorArr = {"lightGray", "Red", "Yellow", "Green", "Cyan"};

    public CanvasFragment(){
        //required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        //get the id for the layout
        rl = (RelativeLayout) v.findViewById(R.id.MyFragmentLayoutCanvas);

        return v;

    }

    public void setColor(String color){
        int position = Integer.parseInt(color);
        rl.setBackgroundColor(Color.parseColor(colorArr[position]));
    }
}
