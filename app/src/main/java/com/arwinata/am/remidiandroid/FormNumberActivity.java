package com.arwinata.am.remidiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormNumberActivity extends AppCompatActivity {

    EditText tanggal, ruang;
    Button create;
    Calendar myCalendar;
    DatePickerDialog dpc;

    private void updateLabel() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        tanggal.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_number);

        tanggal = findViewById(R.id.edTanggal);
        ruang = findViewById(R.id.edRuang);
        create = findViewById(R.id.btnCreate);

        myCalendar = Calendar.getInstance();


        tanggal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel();
                    }

                };

                // TODO Auto-generated method stub
                new DatePickerDialog(FormNumberActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String namaRuang = "";
                namaRuang = ruang.getText().toString();

                if(namaRuang.isEmpty())
                {
                    Toast.makeText(FormNumberActivity.this, "Harus isi nama ruang!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FormNumberActivity.this, "Data Ruang "+namaRuang+" Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
