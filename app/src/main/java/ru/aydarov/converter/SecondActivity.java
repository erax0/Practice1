package ru.aydarov.converter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String CONV_EXTRA = "Conversion";
    private Spinner mSpinnerOne;
    private Spinner mSpinnerTwo;
    private Conversion mConversion;
    private EditText mEditTextOne;
    private EditText mEditTextTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_second);
        mEditTextTwo = findViewById(R.id.et_one);
        mEditTextOne = findViewById(R.id.et_two);
        mSpinnerTwo = findViewById(R.id.spinner_one);
        mSpinnerOne = findViewById(R.id.spinner_two);
        mConversion = (Conversion) getIntent().getSerializableExtra(CONV_EXTRA);
        spinnersConfig();
        editTextConfig();
        super.onCreate(savedInstanceState);
    }

    private void editTextConfig() {
        TextWatcher textWatcher = getTextWatcher();
        TextWatcher textWatcherReverse = getTextWatcher(true);
        mEditTextOne.addTextChangedListener(textWatcher);
        mEditTextTwo.addTextChangedListener(textWatcherReverse);
    }

    private void spinnersConfig() {
        List<String> spinnerList = new ArrayList<>();
        for (Unit unit : mConversion.mUnits) {
            spinnerList.add(this.getString(unit.mLabel));
        }
        mSpinnerTwo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerList));
        mSpinnerOne.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerList));
        AdapterView.OnItemSelectedListener onItemSelectedListener = getOnItemSelectedListener();
        mSpinnerTwo.setOnItemSelectedListener(onItemSelectedListener);
        mSpinnerOne.setOnItemSelectedListener(onItemSelectedListener);
    }

    private TextWatcher getTextWatcher(boolean reverse) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mEditTextTwo.isFocused())
                    converting(reverse);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    private TextWatcher getTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mEditTextOne.isFocused())
                    converting();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    private AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                converting();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }

    private void converting() {
        if (!TextUtils.isEmpty(mEditTextOne.getText().toString())) {
            double res = Double.valueOf(mEditTextOne.getText().toString()) * mConversion.mUnits.get(mSpinnerTwo.getSelectedItemPosition()).mValue / mConversion.mUnits.get(mSpinnerOne.getSelectedItemPosition()).mValue;
            mEditTextTwo.setText(String.valueOf(res));
        }
    }

    private void converting(boolean inverse) {
        if (!TextUtils.isEmpty(mEditTextTwo.getText().toString())) {
            double res = Double.valueOf(mEditTextTwo.getText().toString()) * mConversion.mUnits.get(mSpinnerOne.getSelectedItemPosition()).mValue / mConversion.mUnits.get(mSpinnerTwo.getSelectedItemPosition()).mValue;
            mEditTextOne.setText(String.valueOf(res));
        }
    }
}

