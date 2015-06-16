package com.example.divya.addition.models;

import android.content.Context;

import extremus.Model;

/**
 * Created by Divya on 11-06-2015.
 */
public class Sensor extends Model {
    public int id;
    public String  name;
    public boolean status;
    public int controller_id;
    public Sensor(Context context){
        super(context, "sensor");
    }
}
