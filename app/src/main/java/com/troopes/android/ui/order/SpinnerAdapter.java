package com.troopes.android.ui.order;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.troopes.android.R;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter {

    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull Object[] objects, String hint) {
        super(context, resource, objects);
    }

    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List objects, String hint) {
        super(context, resource, objects);
        // TODO: how to add data to list
        // instead of here try to add before passing the list into constructor
    }

    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0) {
            // Disable the first item from Spinner
            // First item will be use for hint
            return false;
        } else {
            return true;
        }
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                @NonNull ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView tv = (TextView) view;
        if (position == 0) {
            tv.setTextColor(ContextCompat.getColor(parent.getContext(), R.color.grey50Text));
        } else {
            tv.setTextColor(Color.BLACK);
        }
        return view;
    }
}
