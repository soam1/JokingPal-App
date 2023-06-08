package com.akashsoam.jokesapp.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.akashsoam.jokesapp.R;

public class CardsDataAdapter extends ArrayAdapter<String> {

    public CardsDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, final View contentView, ViewGroup parent){
        //supply the layout for your card
        TextView v = (contentView.findViewById(R.id.content));
        v.setText(getItem(position));
        return contentView;
    }

}
