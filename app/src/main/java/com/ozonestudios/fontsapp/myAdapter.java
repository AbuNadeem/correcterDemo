/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ozonestudios.fontsapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class myAdapter extends ArrayAdapter<myFonts>  {


    public myAdapter(Context context, ArrayList<myFonts> fonts) {
        super(context, 0, fonts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item0, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
      myFonts currentfont = getItem(position);
        TextView idTextView = (TextView) listItemView.findViewById(R.id.id_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        idTextView.setText(currentfont.getID());
        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        nameTextView.setText(currentfont.getName());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView ageTextView = (TextView) listItemView.findViewById(R.id.age_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
      ageTextView.setText(currentfont.getAge());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}