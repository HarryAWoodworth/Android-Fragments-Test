package com.blueshroom.harry.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRssItemSelected(String text)
    {
        ExampleFragment fragment = (ExampleFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
        fragment.setText(text);
    }

}
