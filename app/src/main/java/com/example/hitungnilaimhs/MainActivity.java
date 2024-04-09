package com.example.hitungnilaimhs;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2, num3,num4;
    Button hasil;
    TextView result,huruff;

    Double number1, number2, number3, number4,getResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.edtText1);
        num2 = findViewById(R.id.edtText2);
        num3 = findViewById(R.id.edtText3);
        num4 = findViewById(R.id.edtText4);
        hasil = findViewById(R.id.btnHitung);
        result = findViewById(R.id.txtAngka);
        huruff = findViewById(R.id.txtHuruf);

        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validasi apakah nilai yang dimasukkan pengguna lebih dari 100
                if (isInputValid()) {
                    number1 = Double.valueOf(num1.getText().toString().trim());
                    number2 = Double.valueOf(num2.getText().toString().trim());
                    number3 = Double.valueOf(num3.getText().toString().trim());
                    number4 = Double.valueOf(num4.getText().toString().trim());

                    getResult = (number1 + number2 + number3 + number4) / 4;
                    result.setText("Nilai Angka: " + getResult);

                    if (getResult > 85) {
                        huruff.setText("Nilai Huruf: A");
                    } else if (getResult >= 74.99100) {
                        huruff.setText("Nilai Huruf: B");
                    } else if (getResult > 64.99) {
                        huruff.setText("Nilai Huruf: C");
                    } else {
                        huruff.setText("Tidak Lulus");
                    }
                } else {
//                    Toast.makeText(MainActivity.this, "Nilai tidak boleh lebih dari 100", Toast.LENGTH_SHORT).show();
                    // Menampilkan Snackbar di atas
                    Snackbar.make(v, "Nilai tidak boleh lebih dari 100", Snackbar.LENGTH_SHORT)
                            .setAnchorView(num1)
                            .show();
                }
            }
        });
    }

    // Fungsi untuk memeriksa apakah nilai yang dimasukkan pengguna lebih dari 100
    private boolean isInputValid() {
        double n1 = Double.parseDouble(num1.getText().toString().trim());
        double n2 = Double.parseDouble(num2.getText().toString().trim());
        double n3 = Double.parseDouble(num3.getText().toString().trim());
        double n4 = Double.parseDouble(num4.getText().toString().trim());

        return (n1 <= 100 && n2 <= 100 && n3 <= 100 && n4 <= 100);
    }
}