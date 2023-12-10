package com.example.smartconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class temperature extends AppCompatActivity {
    private EditText val;
    private  TextView ResultatView;
    private  TextView TitreView;
    private OptionItem selectedOption;
    private OptionItem selectedOption2;
    Button btn_close;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        // Récupérer le Spinner à partir de la mise en page
        Spinner spinner = findViewById(R.id.spinner_from);
        Spinner spinner2 = findViewById(R.id.spinner_from2);

        // Créez une liste d'objets OptionItem
        List<OptionItem> optionList = new ArrayList<>();
        optionList.add(new OptionItem("unité ?", 0));
        optionList.add(new OptionItem("Kelvin", 1));
        optionList.add(new OptionItem("°Celsius", 2));
        optionList.add(new OptionItem("°Fahrenheit", 3.5));



        // Créez un adaptateur pour les données de la liste déroulante
        ArrayAdapter<OptionItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Appliquez l'adaptateur au Spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);


        // Dans la méthode onCreate() ou toute autre méthode où vous définissez l'écouteur de sélection
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Récupérez l'objet OptionItem sélectionné
                selectedOption = (OptionItem) parentView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Code à exécuter si rien n'est sélectionné
                Toast.makeText(getApplicationContext(), "Aucune unité de départ n'est sélectionnée", Toast.LENGTH_SHORT).show();
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Récupérez l'objet OptionItem sélectionné
                selectedOption2 = (OptionItem) parentView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Code à exécuter si rien n'est sélectionné
                Toast.makeText(getApplicationContext(), "Aucune unité de d'arrivé n'est sélectionnée", Toast.LENGTH_SHORT).show();
            }
        });


        ResultatView = findViewById(R.id.Resultat);
        TitreView = findViewById(R.id.textView5);
        TitreView.setText("Conversion de température");
        val = findViewById(R.id.valeur);

        Button Convert=findViewById(R.id.Convertir);
        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = val.getText().toString();
                String dep = selectedOption.getLabel();
                String arv = selectedOption2.getLabel();

                double ValDep =selectedOption.getValue();
                double ValArv =selectedOption2.getValue();

                if (userInput.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Saisissez une valeur à convertir svp.", Toast.LENGTH_SHORT).show();
                }
                else if (ValDep==0){
                    Toast.makeText(getApplicationContext(), "Sélectionnez une unité de départ svp.", Toast.LENGTH_SHORT).show();
                } else if (ValArv==0) {
                    Toast.makeText(getApplicationContext(), "Sélectionnez une unité de d'arrivé svp.", Toast.LENGTH_SHORT).show();
                } else {
                    double entre = Double.parseDouble(val.getText().toString());
                    double res=0;
                    double conv =  (ValDep-ValArv);
                    // K=1; C=2; F=3.5

                    if(conv == - 2.5){//De K à F
                       res = 9.0/5.0 * (entre - 273.15) + 32;

                    } else if (conv == 2.5) {//De F à K
                       res = 5.0/9.0 * (entre - 32) + 273.15;


                    }else if (conv == -1) {//De K à C
                        res = entre - 273.15;
                    }else if (conv == 1) {//De C à K
                        res = entre + 273.15;

                    }else if (conv == -1.5) {//De C à F
                        res = 9.0/5.0 * entre + 32;
                    }else if (conv == 1.5) {//De F à C
                        res = 5.0/9.0 * (entre - 32);
                    }
                    else if (conv == 0) {//De A à A
                        res = entre ;
                    }

                    ResultatView.setText(entre+" " + dep +" = "+" "+ res +" "+ arv);
                }

            }
        });





        btn_close = (Button)findViewById(R.id.button_retour);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}