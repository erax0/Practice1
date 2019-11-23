package ru.aydarov.converter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class ConversionArrayAdapter extends ArrayAdapter<Unit> {
    public ConversionArrayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
