package ru.aydarov.converter;

import androidx.annotation.StringRes;

public enum Unit {
    KILOMETRE(R.string.kilometr, 1000.0),
    MILI(R.string.mili, 1600.0),
    METRE(R.string.metr, 1.0);
    @StringRes
    int mLabel;
    double mValue;

    Unit(@StringRes int label, double value) {
        mLabel = label;
        mValue = value;
    }
}
