package com.blueshroom.harry.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyListFragment extends Fragment
{
     private OnItemSelectedListener listener;

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
     {
         View view = inflater.inflate(R.layout.fragment_example,container,false);
         Button button = (Button)view.findViewById(R.id.updateButton);
         button.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View v)
             {
                 updateDetail();
             }
         });
         return view;
     }

     public interface OnItemSelectedListener
     {
         void onRssItemSelected(String text);
     }

     // Pre-API 23
     public void onAttach(Activity activity)
     {
        super.onAttach(activity);
        if(activity instanceof OnItemSelectedListener)
            listener = (OnItemSelectedListener) activity;
        else
            throw new ClassCastException(activity.toString() + " must implement MyListFragment.OnItemSelectedListener");
     }

     public void onAttach(Context context)
     {
         super.onAttach(context);
         if(context instanceof OnItemSelectedListener)
             listener = (OnItemSelectedListener) context;
         else
             throw new ClassCastException(context.toString() + " must implement MyListFragment.OnItemSelectedListener");
     }

     public void updateDetail()
     {
         // Create data
         String newTime = String.valueOf(System.currentTimeMillis());
         // Send date to activity
         listener.onRssItemSelected(newTime);
     }
}
