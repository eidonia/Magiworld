package com.bast.magiworld;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends Activity{

    public final static String VAL_RETOUR = "com.bast.magiworld.VALRETOUR";

    TextView textBienvenue, textNomPerso, textClassJ1, textNivJ1, textForceJ1, textAgiJ1, textIntJ1, textResCreaJ1, textNomPerso2, textClassJ2, textNivJ2, textForceJ2, textAgiJ2, textIntJ2, textResCreaJ2;
    EditText editNomPerso, editNivJ1, editForceJ1, editAgiJ1, editIntJ1, editNomPerso2, editNivJ2, editForceJ2, editAgiJ2, editIntJ2;
    Button buttonCreateJ1, buttonCreateJ2, buttonCombat, buttonRAZ;
    RadioGroup rGroupJ1, rGroupJ2;
    RadioButton rButtonWarJ1, rButtonRogueJ1, rButtonMageJ1, rButtonWarJ2, rButtonRogueJ2, rButtonMageJ2;
    ArrayList<Personnage> arrayPerso = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/MedievalSharp-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()))
                .build());
        setContentView(R.layout.activity_main);
        createView();

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
                resetJeu();
            }
        });

    }

    //CREATION DE LA VUE

    public void createView(){
        textBienvenue = findViewById(R.id.textBienvenue);

        textNomPerso = findViewById(R.id.textNomPerso);
        editNomPerso = findViewById(R.id.editNomPerso);
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

        textBienvenue.setText("Magiworld");

        textNomPerso.setText("Donne un nom à ton personnage");
        editNomPerso.getHint();
        editNomPerso.setInputType(InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE);
        editNomPerso.setMaxLines(1);

        textNivJ1.setText("Entre le niveau de ton personnage");
        editNivJ1.getHint();
        editNivJ1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editNivJ1.setMaxLines(1);

        textForceJ1.setText("Entre sa force");
        editForceJ1.getHint();
        editForceJ1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editForceJ1.setMaxLines(1);

        textAgiJ1.setText("Entre son agilité");
        editAgiJ1.getHint();
        editAgiJ1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editAgiJ1.setMaxLines(1);

        textIntJ1.setText("Entre son intelligence");
        editIntJ1.getHint();
        editIntJ1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editIntJ1.setMaxLines(1);

        buttonCreateJ1.setText("Création du personnage");

        textNomPerso2.setText("Donne un nom à ton personnage");
        editNomPerso2.getHint();
        editNomPerso2.setInputType(InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE);
        editNomPerso2.setMaxLines(1);

        textNivJ2.setText("Entre le niveau de ton personnage");
        editNivJ2.getHint();
        editNivJ2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editNivJ2.setMaxLines(1);

        textForceJ2.setText("Entre sa force");
        editForceJ2.getHint();
        editForceJ2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editForceJ2.setMaxLines(1);

        textAgiJ2.setText("Entre son agilité");
        editAgiJ2.getHint();
        editAgiJ2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editAgiJ2.setMaxLines(1);

        textIntJ2.setText("Entre son intelligence");
        editIntJ2.getHint();
        editIntJ2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editIntJ2.setMaxLines(1);

        buttonCreateJ2.setText("Création du personnage");

        buttonCombat.setText("Let's Fight !");
        buttonRAZ.setText("RAZ du jeu");

        buttonCreateJ1.setOnClickListener(createListener);
        buttonCreateJ2.setOnClickListener(createListener);

        rGroupJ1 = (RadioGroup)findViewById(R.id.rGroupJ1);
        rGroupJ2 = (RadioGroup)findViewById(R.id.rGroupJ2);
        rButtonMageJ1 = (RadioButton)findViewById(R.id.rButtonMageJ1);
        rButtonMageJ2 = (RadioButton)findViewById(R.id.rButtonMageJ2);
        rButtonRogueJ1 = (RadioButton)findViewById(R.id.rButtonRogueJ1);
        rButtonRogueJ2 = (RadioButton)findViewById(R.id.rButtonRogueJ2);
        rButtonWarJ1 = (RadioButton)findViewById(R.id.rButtonWarJ1);
        rButtonWarJ2 = (RadioButton)findViewById(R.id.rButtonWarJ2);

        rButtonMageJ1.setOnClickListener(backChanged);
        rButtonWarJ1.setOnClickListener(backChanged);
        rButtonRogueJ1.setOnClickListener(backChanged);
        rButtonMageJ2.setOnClickListener(backChanged);
        rButtonRogueJ2.setOnClickListener(backChanged);
        rButtonWarJ2.setOnClickListener(backChanged);
    }


    // CREATION DES PERSONNAGES

    public View.OnClickListener createListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.buttonCreateJ1 :
                    String nomJ1 = "";
                    if (rGroupJ1.getCheckedRadioButtonId() == R.id.rButtonWarJ1){
                        nomJ1 = "Guerrier";
                    }else if (rGroupJ1.getCheckedRadioButtonId() == R.id.rButtonRogueJ1){
                        nomJ1 = "Rôdeur";
                    }else if (rGroupJ1.getCheckedRadioButtonId() == R.id.rButtonMageJ1){
                        nomJ1 = "Mage";
                    }

                    createCharac(editNomPerso, editNivJ1, editForceJ1, editIntJ1, editAgiJ1, textResCreaJ1, nomJ1);
                    break;

                case R.id.buttonCreateJ2 :
                    String nomJ2 = "";
                    if (rGroupJ2.getCheckedRadioButtonId() == R.id.rButtonWarJ2){
                        nomJ2 = "Guerrier";
                    }else if (rGroupJ2.getCheckedRadioButtonId() == R.id.rButtonRogueJ2){
                        nomJ2 = "Rôdeur";
                    }else if (rGroupJ2.getCheckedRadioButtonId() == R.id.rButtonMageJ2){
                        nomJ2 = "Mage";
                    }
                    createCharac(editNomPerso2, editNivJ2, editForceJ2, editIntJ2, editAgiJ2, textResCreaJ2, nomJ2);
                    break;
            }
        }
    };

    public void createCharac(EditText editNom, EditText editNiv, EditText editForce, EditText editInt, EditText editAgi, TextView textView, String nomClasse){
        if(editNom.getText().toString().equals("") || editNiv.getText().toString().equals("") || editForce.getText().toString().equals("") || editInt.getText().toString().equals("") || editAgi.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Remplis les cases", Toast.LENGTH_LONG).show();
        }else{

            createStats(editNom, editNiv, editForce, editAgi, editInt, textView, nomClasse);
        }

    }

    public void createStats(EditText editNom, EditText editNiv, EditText editForce, EditText editAgi, EditText editIntel, TextView textView, String nomClasse){

        String nomPerso = editNom.getText().toString();

        String niv = editNiv.getText().toString();
        int nivInt = Integer.parseInt(niv);

        int vie = 5*nivInt;

        String force = editForce.getText().toString();
        int forceInt = Integer.parseInt(force);

        String agi = editAgi.getText().toString();
        int agiInt = Integer.parseInt(agi);

        String intel = editIntel.getText().toString();
        int intelInt = Integer.parseInt(intel);

        testCarac(nomPerso, nivInt, vie, forceInt, agiInt, intelInt, textView, nomClasse);

    }

    public void testCarac(String nomPerso, int niv, int vie, int force, int agi, int intel, TextView textview, String nomClasse){
        if ((force+agi+intel) > niv){
            Toast.makeText(this, "Vous ne pouvez pas avoir plus de caractéristiques que de niveau!", Toast.LENGTH_LONG).show();
        }else{
            chooseClass(nomClasse, nomPerso, niv, vie, force, agi, intel, textview);

        }


    }

    public void chooseClass(String nameClass, String nomPerso, int niv, int vie, int force, int agi, int intel, TextView textview){
        if(nameClass.equals("Mage")){
            Mage mage = new Mage("Mage", nomPerso, niv, vie, force, agi, intel, "Boule de Feu", "Soin");
            textview.setText("Je m'appelle " + mage.nomPerso +" et je suis un " + mage.name + " niveau " + mage.niveau + " j'ai "  + mage.vie + " pv et j'ai "+ mage.intelligence + " en intelligence, " + mage.agilite + " en agilité et " + mage.force + " en force");
            arrayPerso.add(mage);

        }else if(nameClass.equals("Guerrier")){
            Guerrier guerrier = new Guerrier("Guerrier", nomPerso, niv, vie, force, agi, intel, "Coup d'épée", "Coup de Rage");
            textview.setText("Je m'appelle " + guerrier.nomPerso + " et je suis un " + guerrier.name + " niveau " + guerrier.niveau + " j'ai "  + guerrier.vie + " pv et j'ai "+ guerrier.force + " en force, " + guerrier.agilite + " en agilité et " + guerrier.intelligence + " en intelligence");
            arrayPerso.add(guerrier);

        }else{
            Rodeur rodeur = new Rodeur("Rôdeur", nomPerso, niv, vie, force, agi, intel, "Coup de Surin", "Concentration");
            textview.setText("Je m'appelle " + rodeur.nomPerso + " et je suis un " + rodeur.name + " niveau " + rodeur.niveau + " j'ai "  + rodeur.vie + " pv et j'ai "+ rodeur.agilite + " en agilité, " + rodeur.force + " en force et " + rodeur.intelligence + " en intelligence");
            arrayPerso.add(rodeur);

        }
    }


    //RESET DU JEU

    public void resetJeu(){
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
        textResCreaJ1.setText("");
        textResCreaJ2.setText("");
        rButtonWarJ1.setBackground(getDrawable(R.mipmap.warwait));
        rButtonRogueJ1.setBackground(getDrawable(R.mipmap.roguewait));
        rButtonMageJ1.setBackground(getDrawable(R.mipmap.magewait));
        rButtonWarJ2.setBackground(getDrawable(R.mipmap.warwait));
        rButtonRogueJ2.setBackground(getDrawable(R.mipmap.roguewait));
        rButtonMageJ2.setBackground(getDrawable(R.mipmap.magewait));
    }



    //GESTION DES RADIOGROUP / RADIOBUTTON

    public View.OnClickListener backChanged = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.rButtonWarJ1 :
                    changedBackRButt(rButtonWarJ1, rButtonRogueJ1, rButtonMageJ1, 0);
                    break;
                case R.id.rButtonRogueJ1 :
                    changedBackRButt(rButtonWarJ1, rButtonRogueJ1, rButtonMageJ1, 1);
                    break;
                case R.id.rButtonMageJ1 :
                    changedBackRButt(rButtonWarJ1, rButtonRogueJ1, rButtonMageJ1, 2);
                    break;
                case R.id.rButtonWarJ2 :
                    changedBackRButt(rButtonWarJ2, rButtonRogueJ2, rButtonMageJ2, 0);
                    break;
                case R.id.rButtonRogueJ2 :
                    changedBackRButt(rButtonWarJ2, rButtonRogueJ2, rButtonMageJ2, 1);
                    break;
                case R.id.rButtonMageJ2 :
                    changedBackRButt(rButtonWarJ2, rButtonRogueJ2, rButtonMageJ2, 2);
                    break;
            }
        }
    };



    public void changedBackRButt(RadioButton rButtonWar, RadioButton rButtonRogue, RadioButton rButtonMage, int i){
        if( i == 0) {
            rButtonWar.setBackground(getDrawable(R.mipmap.warchoose));
            rButtonRogue.setBackground(getDrawable(R.mipmap.roguewait));
            rButtonMage.setBackground(getDrawable(R.mipmap.magewait));
        }else if ( i == 1 ){
            rButtonWar.setBackground(getDrawable(R.mipmap.warwait));
            rButtonRogue.setBackground(getDrawable(R.mipmap.roguechoose));
            rButtonMage.setBackground(getDrawable(R.mipmap.magewait));
        }else if ( i == 2 ){
            rButtonWar.setBackground(getDrawable(R.mipmap.warwait));
            rButtonRogue.setBackground(getDrawable(R.mipmap.roguewait));
            rButtonMage.setBackground(getDrawable(R.mipmap.magechoose));
        }

    }




    // RETOUR DE L'INTENT

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            String s = data.getStringExtra(VAL_RETOUR);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
        }
    }






    // CALLIGRAPHY

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }








}



