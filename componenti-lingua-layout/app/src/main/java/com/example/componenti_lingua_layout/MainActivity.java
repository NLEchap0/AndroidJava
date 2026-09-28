package com.example.componenti_lingua_layout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroupOptions);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.radioWoman) {
                ImageView imageView = findViewById(R.id.avatar);
                imageView.setImageResource(R.drawable.donna);
            }else if(checkedId == R.id.radioMan) {
                ImageView imageView = findViewById(R.id.avatar);
                imageView.setImageResource(R.drawable.uomo);
            }else if(checkedId == R.id.radioChild) {
                ImageView imageView = findViewById(R.id.avatar);
                imageView.setImageResource(R.drawable.bambina);
            }
        });

        Button buttonSave = findViewById(R.id.buttonSave);
        EditText inputName = findViewById(R.id.inputName);
        EditText inputEmail = findViewById(R.id.inputEmail);

        buttonSave.setOnClickListener(v -> {
            if(radioGroup.getCheckedRadioButtonId() == -1 ||
            inputName.getText().toString().isEmpty() ||
            inputEmail.getText().toString().isEmpty()
            ) {
                Snackbar snackbar = Snackbar.make(v, "Campo mancante! Ricontrollare selezione dei campi obbligatori (*).", Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.parseColor("#FF0000"));
                snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                snackbar.show();
            }else {
                if (!inputEmail.getText().toString().contains("@")) {
                    Snackbar snackbar = Snackbar.make(v, "Campo email non valido!", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.parseColor("#FF0000"));
                    snackbar.setTextColor(Color.parseColor("#FFFFFF"));
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar.make(v, "Salvataggio completato! " +
                            "Dati: " + inputName.getText().toString() + " " +
                            inputEmail.getText().toString() + " " +
                            //TODO:FIX
                            radioGroup.getCheckedRadioButtonId().getText(), Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.parseColor("#00FF00"));
                    snackbar.setTextColor(Color.parseColor("#000000"));
                    snackbar.show();
                }
            }
        });
    }


}