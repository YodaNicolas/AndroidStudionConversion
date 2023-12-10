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


public class devise extends AppCompatActivity {
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
        optionList.add(new OptionItem("Euro", 1));
        optionList.add(new OptionItem("Dollar", 2));
        optionList.add(new OptionItem("CFA", 3.5));


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
        TitreView.setText("Conversion de dévise");
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
                    Toast.makeText(getApplicationContext(), "Sélectionnez une dévise de départ svp.", Toast.LENGTH_SHORT).show();
                } else if (ValArv==0) {
                    Toast.makeText(getApplicationContext(), "Sélectionnez une dévise d'arrivé svp.", Toast.LENGTH_SHORT).show();
                } else {
                    double entre = Double.parseDouble(val.getText().toString());
                    double res=0;
                    double conv =  (ValDep-ValArv);
                    // Euro=1; Dollar=2; CFA=3.5

                    if(conv == - 2.5){//De Euro à CFA
                        res = 655.957 * entre;
                    } else if (conv == 2.5) {//De CFA à Euro
                        res = entre/655.957;

                    }else if (conv == -1) {//De Euro à Dollar
                        res = entre * 1.12;
                    }else if (conv == 1) {//De Dollar à Euro
                        res = entre / 1.12;

                    }else if (conv == 1.5) {//De CFA à Dollar
                        res = entre/600.0;
                    }else if (conv == -1.5) {//De Dollar à CFA
                        res = 600 * entre;
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