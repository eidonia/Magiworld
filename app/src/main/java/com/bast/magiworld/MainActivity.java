package com.bast.magiworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String VAL_RETOUR = "com.bast.magiworld.VALRETOUR";

    TextView textBienvenue;
    TextView textNomPerso;
    EditText editNomPerso;
    TextView textClassJ1;
    Spinner spinClassJ1;
    TextView textNivJ1;
    EditText editNivJ1;
    TextView textForceJ1;
    EditText editForceJ1;
    TextView textAgiJ1;
    EditText editAgiJ1;
    TextView textIntJ1;
    EditText editIntJ1;
    Button buttonCreateJ1;
    TextView textResCreaJ1;

    TextView textNomPerso2;
    EditText editNomPerso2;
    TextView textClassJ2;
    Spinner spinClassJ2;
    TextView textNivJ2;
    EditText editNivJ2;
    TextView textForceJ2;
    EditText editForceJ2;
    TextView textAgiJ2;
    EditText editAgiJ2;
    TextView textIntJ2;
    EditText editIntJ2;
    Button buttonCreateJ2;
    TextView textResCreaJ2;

    Button buttonCombat;
    Button buttonRAZ;

    ArrayList<Personnage> arrayPerso = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBienvenue = findViewById(R.id.textBienvenue);

        textNomPerso = findViewById(R.id.textNomPerso);
        editNomPerso = findViewById(R.id.editNomPerso);
        textClassJ1 = findViewById(R.id.textClasseJ1);
        spinClassJ1 = findViewById(R.id.spinClasseJ1);
        textNivJ1 = findViewById(R.id.textNivJ1);
        editNivJ1 = findViewById(R.id.editNivJ1);
        textForceJ1 = findViewById(R.id.textForceJ1);
        editForceJ1 = findViewById(R.id.editForceJ1);
        textAgiJ1 = findViewById(R.id.textAgiJ1);
        editAgiJ1 = findViewById(R.id.editAgiJ1);
        textIntJ1 = findViewById(R.id.textIntJ1);
        editIntJ1 = findViewById(R.id.editIntJ1);
        buttonCreateJ1 = findViewById(R.id.buttonCreateJ1);
        textResCreaJ1 = findViewById(R.id.textResCreaJ1);

        textNomPerso2 = findViewById(R.id.textNomPerso2);
        editNomPerso2 = findViewById(R.id.editNomPerso2);
        textClassJ2 = findViewById(R.id.textClasseJ2);
        spinClassJ2 = findViewById(R.id.spinClasseJ2);
        textNivJ2 = findViewById(R.id.textNivJ2);
        editNivJ2 = findViewById(R.id.editNivJ2);
        textForceJ2 = findViewById(R.id.textForceJ2);
        editForceJ2 = findViewById(R.id.editForceJ2);
        textAgiJ2 = findViewById(R.id.textAgiJ2);
        editAgiJ2 = findViewById(R.id.editAgiJ2);
        textIntJ2 = findViewById(R.id.textIntJ2);
        editIntJ2 = findViewById(R.id.editIntJ2);
        buttonCreateJ2 = findViewById(R.id.buttonCreateJ2);
        textResCreaJ2 = findViewById(R.id.textResCreaJ2);

        buttonCombat = findViewById(R.id.buttonCombat);
        buttonRAZ = findViewById(R.id.buttonRAZ);

        textBienvenue.setText("Bienvenue à MagiWorld ! Créez vos personnages.");

        textNomPerso.setText("Donne un nom à ton personnage");
        editNomPerso.getHint();
        editNomPerso.setInputType(InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE);
        editNomPerso.setMaxLines(1);

        textClassJ1.setText("Choisissez votre classe");

        textNivJ1.setText("Entrez le niveau de votre personnage");
        editNivJ1.getHint();
        editNivJ1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editNivJ1.setMaxLines(1);

        textForceJ1.setText("Entrez sa force");
        editForceJ1.getHint();
        editForceJ1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editForceJ1.setMaxLines(1);

        textAgiJ1.setText("Entrez son agilité");
        editAgiJ1.getHint();
        editAgiJ1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editAgiJ1.setMaxLines(1);

        textIntJ1.setText("Entrez son intelligence");
        editIntJ1.getHint();
        editIntJ1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editIntJ1.setMaxLines(1);

        buttonCreateJ1.setText("Création du personnage");

        textNomPerso2.setText("Donne un nom à ton personnage");
        editNomPerso2.getHint();
        editNomPerso2.setInputType(InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE);
        editNomPerso2.setMaxLines(1);

        textClassJ2.setText("Choisissez votre classe");

        textNivJ2.setText("Entrez le niveau de votre personnage");
        editNivJ2.getHint();
        editNivJ2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editNivJ2.setMaxLines(1);

        textForceJ2.setText("Entrez sa force");
        editForceJ2.getHint();
        editForceJ2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editForceJ2.setMaxLines(1);

        textAgiJ2.setText("Entrez son agilité");
        editAgiJ2.getHint();
        editAgiJ2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editAgiJ2.setMaxLines(1);

        textIntJ2.setText("Entrez son intelligence");
        editIntJ2.getHint();
        editIntJ2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editIntJ2.setMaxLines(1);

        buttonCreateJ2.setText("Création du personnage");

        buttonCombat.setText("Let's Fight !");
        buttonRAZ.setText("RAZ du jeu");


        List<String> classe = new ArrayList<String>();
        classe.add("Guerrier");
        classe.add("Mage");
        classe.add("Rôdeur");

        final ArrayAdapter<String> adaClasse = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, classe);

        adaClasse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinClassJ1.setAdapter(adaClasse);
        spinClassJ2.setAdapter(adaClasse);

        buttonCreateJ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editNomPerso.getText().toString().equals("") || editNivJ1.getText().toString().equals("") || editForceJ1.getText().toString().equals("") || editIntJ1.getText().toString().equals("") || editAgiJ1.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Remplis les cases", Toast.LENGTH_LONG).show();
                }else{
                    String nomPerso = editNomPerso.getText().toString();

                    String nivJ1 = editNivJ1.getText().toString();
                    final int nivJ1Int = Integer.parseInt(nivJ1);

                    int vieJ1 = 5*nivJ1Int;

                    String forceJ1 = editForceJ1.getText().toString();
                    final int forceJ1Int = Integer.parseInt(forceJ1);

                    String agiJ1 = editAgiJ1.getText().toString();
                    final int agiJ1Int = Integer.parseInt(agiJ1);

                    String intJ1 = editIntJ1.getText().toString();
                    final int intJ1Int = Integer.parseInt(intJ1);

                    testCarac(nomPerso, nivJ1Int, vieJ1, forceJ1Int, agiJ1Int, intJ1Int, textResCreaJ1, spinClassJ1);
                }

            }
        });

        buttonCreateJ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editNomPerso2.getText().toString().equals("") || editNivJ2.getText().toString().equals("") || editForceJ2.getText().toString().equals("") || editIntJ2.getText().toString().equals("") || editAgiJ2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Remplis les cases", Toast.LENGTH_LONG).show();
                }else{
                    String nomPerso2 = editNomPerso2.getText().toString();

                    String nivJ2 = editNivJ2.getText().toString();
                    int nivJ2Int = Integer.parseInt(nivJ2);

                    int vieJ2 = 5*nivJ2Int;

                    String forceJ2 = editForceJ2.getText().toString();
                    int forceJ2Int = Integer.parseInt(forceJ2);

                    String agiJ2 = editAgiJ2.getText().toString();
                    int agiJ2Int = Integer.parseInt(agiJ2);

                    String intJ2 = editIntJ2.getText().toString();
                    int intJ2Int = Integer.parseInt(intJ2);

                    testCarac(nomPerso2, nivJ2Int, vieJ2, forceJ2Int, agiJ2Int, intJ2Int, textResCreaJ2, spinClassJ2);


                }

            }
        });

        buttonCombat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(arrayPerso.isEmpty()){
                    Toast.makeText(MainActivity.this, "Créez vos personnages !", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, CombatActivity.class);
                    intent.putParcelableArrayListExtra("listPerso", (ArrayList)arrayPerso);
                    startActivityForResult(intent, 0);
                }
            }
        });

        buttonRAZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNomPerso.setText("");
                editNomPerso2.setText("");
                editNivJ1.setText("");
                editNivJ2.setText("");
                editForceJ1.setText("");
                editForceJ2.setText("");
                editAgiJ1.setText("");
                editAgiJ2.setText("");
                editIntJ1.setText("");
                editIntJ2.setText("");
                arrayPerso.clear();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            String s = data.getStringExtra(VAL_RETOUR);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
        }
    }

    public void testCarac(String nomPerso, int niv, int vie, int force, int agi, int intel, TextView textview, Spinner spin){
        if ((force+agi+intel) > niv){
            Toast.makeText(this, "Vous ne pouvez pas avoir plus de caractéristiques que de niveau!", Toast.LENGTH_LONG).show();
        }else{

            if(spin.getSelectedItem().toString().equals("Mage")){
                Mage mage = new Mage("Mage", nomPerso, niv, vie, force, agi, intel, "Boule de Feu", "Soin");
                textview.setText("Je m'appelle " + mage.nomPerso +" et je suis un " + mage.name + " niveau " + mage.niveau + " j'ai "  + mage.vie + " pv et j'ai "+ mage.intelligence + " en intelligence, " + mage.agilite + " en agilité et " + mage.force + " en force");
                arrayPerso.add(mage);

            }else if(spin.getSelectedItem().toString().equals("Guerrier")){
                Guerrier guerrier = new Guerrier("Guerrier", nomPerso, niv, vie, force, agi, intel, "Coup d'épée", "Coup de Rage");
                textview.setText("Je m'appelle " + guerrier.nomPerso + " et je suis un " + guerrier.name + " niveau " + guerrier.niveau + " j'ai "  + guerrier.vie + " pv et j'ai "+ guerrier.force + " en force, " + guerrier.agilite + " en agilité et " + guerrier.intelligence + " en intelligence");
                arrayPerso.add(guerrier);

            }else{
                Rodeur rodeur = new Rodeur("Rôdeur", nomPerso, niv, vie, force, agi, intel, "Tir à l'Arc", "Concentration");
                textview.setText("Je m'appelle " + rodeur.nomPerso + " et je suis un " + rodeur.name + " niveau " + rodeur.niveau + " j'ai "  + rodeur.vie + " pv et j'ai "+ rodeur.agilite + " en agilité, " + rodeur.force + " en force et " + rodeur.intelligence + " en intelligence");
                arrayPerso.add(rodeur);

            }

        }


    }
}



