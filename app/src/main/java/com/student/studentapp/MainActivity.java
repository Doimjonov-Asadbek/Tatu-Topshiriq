package com.student.studentapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("The Point of Sale Application");
        setContentView(R.layout.activity_main);

        Button btnaddproduct = findViewById(R.id.btnaddproduct);
        Button btndatapicer = findViewById(R.id.btndatapicer);
        Button btngallarey = findViewById(R.id.btngallarey);
        DatePicker datePicker = findViewById(R.id.datePicker);
        TextView textview = findViewById(R.id.textview);
        TextView textview1 = findViewById(R.id.textView);
        ImageView image = findViewById(R.id.imageView2);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);


        btngallarey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });

        constraintLayout.setOnClickListener(v -> {
            datePicker.setVisibility(View.GONE);
            btngallarey.setVisibility(View.VISIBLE);
            btnaddproduct.setVisibility(View.VISIBLE);
            btndatapicer.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
            textview.setVisibility(View.VISIBLE);
        });
        textview.setOnClickListener(v -> {
            textview.setVisibility(View.VISIBLE);
            datePicker.setVisibility(View.GONE);
            btngallarey.setVisibility(View.VISIBLE);
            btnaddproduct.setVisibility(View.VISIBLE);
            btndatapicer.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
        });
        btndatapicer.setOnClickListener(v -> {
            datePicker.setVisibility(View.VISIBLE);
            btnaddproduct.setVisibility(View.GONE);
            btngallarey.setVisibility(View.GONE);
            btndatapicer.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
            textview.setVisibility(View.GONE);
        });
        datePicker.setOnClickListener(v -> {
            textview1.setText(datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear());
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
                textview1.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            });
        }

        btnaddproduct.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AddProduct.class)));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            ImageView imageView = findViewById(R.id.imageView2);
            imageView.setImageURI(uri);
        }
    }
}