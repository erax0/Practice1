package ru.aydarov.converter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static ru.aydarov.converter.SecondActivity.CONV_EXTRA;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(new ConversionAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));

    }

    @Override
    public void navigateSecondActivity(Conversion conversion) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(CONV_EXTRA, conversion);
        startActivity(intent);

    }
}
