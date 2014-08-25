package com.example.login.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.login.R;

/**
 * Created by Common Sense on 8/25/2014.
 */
public class dataRetriever extends ArrayAdapter<String>
{
    private Activity activity;
    private String[] lastnames;
    private String[] cell;
    private int[] buttons;


    public dataRetriever(Activity activity, String[] lastnames, String[] cell , int[] buttons)
    {
        super(activity, R.layout.list , cell );
        this.activity = activity;
        this.buttons= buttons;
        this.cell = cell;
        this.lastnames = lastnames;

    }

    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list , null , true);

        TextView last = (TextView) rowView.findViewById(R.id.lastname);
        TextView cellno = (TextView) rowView.findViewById(R.id.cellno);
        Button buttonDetails = (Button) rowView.findViewById(R.id.btndt);

        last.setText(lastnames[position]);
        cellno.setText(cell[position]);
        buttonDetails.setText("Details" + position);
        buttonDetails.setClickable(true);
        buttonDetails.setId( position);
       //buttonDetails.setOnClickListener();

        return rowView;
    }
}
