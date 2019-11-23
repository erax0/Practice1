package ru.aydarov.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import androidx.annotation.StringRes;

public enum Conversion {
    DATA(R.string.data, Collections.<Unit>emptyList()),
    ENERGY(R.string.energy, Collections.<Unit>emptyList()),
    LENGTH(R.string.length, Arrays.asList(Unit.KILOMETRE, Unit.MILI, Unit.METRE)),
    WEIGHT(R.string.weight, Collections.<Unit>emptyList());

    @StringRes
    int label;
    public List<Unit> mUnits;

    Conversion(int label, List<Unit> units) {
        this.label = label;
        mUnits = units;
    }
}
