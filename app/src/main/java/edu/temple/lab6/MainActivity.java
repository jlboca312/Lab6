package edu.temple.lab6;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity implements PaletteFragment.SenderInterface{

    //global variables
    CanvasFragment canvas;
    int isTwoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //determine if two panes, if returned 1 then PORTRAIT, if 2, then LANDSCAPE
        isTwoPanes = getResources().getConfiguration().orientation;

        canvas = new CanvasFragment();
        PaletteFragment palette = new PaletteFragment();

        //if in two potrait, load the cavnas frag on top
        if(isTwoPanes == 1) {
            //load the color listview by default
            getFragmentManager().beginTransaction().add(R.id.paletteFrag, palette).commit();

            //load the canvas
            getFragmentManager().beginTransaction().add(R.id.canvasFrag, canvas).addToBackStack(null).commit();
        }else{ //else in landscape, load the fragment next to the color listview

            //set the layout to landscape
            setContentView(R.layout.activity_main_landscape);

            //load the new color listview
            getFragmentManager().beginTransaction().add(R.id.paletteFragLandscape, palette).commit();

            //load the canvas next to listview
            getFragmentManager().beginTransaction().add(R.id.canvasFragLandscape, canvas).commit();

        }
    }

    @Override
    public void acceptColor(String color){
        canvas.setColor(color);
    }

}
