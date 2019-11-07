package com.bast.magiworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class CombatActivity extends AppCompatActivity {

    TextView testArray;
    TextView testArray2;
    TextView textRound;
    TextView separateur;
    TextView separateur2;
    TextView separateur3;
    TextView textJoueur1;
    Button buttonAttBaseJ1;
    Button buttonAttSpeJ1;
    Button buttonPVJ1;
    TextView textInfoJ1;
    TextView textJoueur2;
    Button buttonAttBaseJ2;
    Button buttonAttSpeJ2;
    Button buttonPVJ2;
    TextView textInfoJ2;
    Button buttonFinRound;
    TextView textResult;
    Button buttonReturn;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        textRound = findViewById(R.id.textRound);
        separateur = findViewById(R.id.separateur);
        separateur.setText("\n ----------------------------------------------------------------- \n");
        separateur2 = findViewById(R.id.separateur2);
        separateur.setText("\n ----------------------------------------------------------------- \n");
        separateur3 = findViewById(R.id.separateur3);
        separateur3.setText("\n ----------------------------------------------------------------- \n");
        textJoueur1 = findViewById(R.id.textJoueur1CA);

        textJoueur2 = findViewById(R.id.textJoueur2CA);

        buttonPVJ1 = findViewById(R.id.buttonPV);
        buttonPVJ1.setText("PV");
        buttonPVJ2 = findViewById(R.id.buttonPVJ2);
        buttonPVJ2.setText("PV");
        buttonFinRound = findViewById(R.id.buttonFinRound);
        buttonFinRound.setText("Fin du round");
        textResult = findViewById(R.id.textResult);
        buttonAttBaseJ2 = findViewById(R.id.buttonAttBaseJ2);
        buttonAttBaseJ1 = findViewById(R.id.buttonAttBase);
        buttonAttSpeJ1 = findViewById(R.id.buttonAttSpe);
        buttonAttSpeJ2 = findViewById(R.id.buttonAttSpeJ2);
        textInfoJ1 = findViewById(R.id.textinfoJ1);
        textInfoJ2 = findViewById(R.id.textinfoJ2);
        buttonReturn = findViewById(R.id.buttonRturn);

        ArrayList<Personnage> listPerso = (ArrayList)this.getIntent().getParcelableArrayListExtra("listPerso");

        testArray = findViewById(R.id.testarray);
        testArray.setText("A présent, passons au combat !");

        testArray2 = findViewById(R.id.testarray2);

        textRound.setText("\n\n\nRound 1");


        if(listPerso.get(0).name.equals("Mage") && listPerso.get(1).name.equals("Mage")){
            Mage joueur1 = new Mage(listPerso.get(0).name,  listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Boule de Feu", "Soin");
            Mage joueur2 = new Mage(listPerso.get(1).name, listPerso.get(1).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Boule de Feu", "Soin");

            joueur1.name = "Mage Joueur 1";
            joueur2.name = "Mage Joueur 2";
            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        } else if(listPerso.get(0).name.equals("Mage") && listPerso.get(1).name.equals("Guerrier")) {
            Mage joueur1 = new Mage(listPerso.get(0).name, listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Boule de Feu", "Soin");
            Guerrier joueur2 = new Guerrier(listPerso.get(1).name, listPerso.get(0).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Coup d'épée", "Coup de Rage");

            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        }else if(listPerso.get(0).name.equals("Mage") && listPerso.get(1).name.equals("Rodeur")) {
            Mage joueur1 = new Mage(listPerso.get(0).name, listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Boule de Feu", "Soin");
            Rodeur joueur2 = new Rodeur(listPerso.get(1).name, listPerso.get(1).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Tir à l'Arc", "Concentration");

            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        }else if(listPerso.get(0).name.equals("Guerrier") && listPerso.get(1).name.equals("Mage")) {
            Guerrier joueur1 = new Guerrier(listPerso.get(0).name, listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Coup d'épée", "Coup de Rage");
            Mage joueur2 = new Mage(listPerso.get(1).name, listPerso.get(1).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Boule de Feu", "Soin");

            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        }else if(listPerso.get(0).name.equals("Guerrier") && listPerso.get(1).name.equals("Guerrier")) {
            Guerrier joueur1 = new Guerrier(listPerso.get(0).name, listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Coup d'épée", "Coup de Rage");
            Guerrier joueur2 = new Guerrier(listPerso.get(1).name, listPerso.get(1).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Coup d'épée", "Coup de Rage");

            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        }else if(listPerso.get(0).name.equals("Guerrier") && listPerso.get(1).name.equals("Rôdeur")) {
            Guerrier joueur1 = new Guerrier(listPerso.get(0).name, listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Coup d'épée", "Coup de Rage");
            Rodeur joueur2 = new Rodeur(listPerso.get(1).name, listPerso.get(1).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Tir à l'Arc", "Concentration");

            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        }else if(listPerso.get(0).name.equals("Rôdeur") && listPerso.get(1).name.equals("Mage")) {
            Rodeur joueur1 = new Rodeur(listPerso.get(0).name, listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Tir à l'Arc", "Concentration");
            Mage joueur2 = new Mage(listPerso.get(1).name, listPerso.get(1).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Boule de Feu", "Soin");

            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        }else if(listPerso.get(0).name.equals("Rôdeur") && listPerso.get(1).name.equals("Guerrier")) {
            Rodeur joueur1 = new Rodeur(listPerso.get(0).name, listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Tir à l'Arc", "Concentration");
            Guerrier joueur2 = new Guerrier(listPerso.get(1).name, listPerso.get(1).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Coup d'épée", "Coup de Rage");

            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        }else {
            Rodeur joueur1 = new Rodeur(listPerso.get(0).name, listPerso.get(0).nomPerso, listPerso.get(0).niveau, listPerso.get(0).vie, listPerso.get(0).force, listPerso.get(0).agilite, listPerso.get(0).intelligence, "Tir à l'Arc", "Concentration");
            Rodeur joueur2 = new Rodeur(listPerso.get(1).name, listPerso.get(1).nomPerso, listPerso.get(1).niveau, listPerso.get(1).vie, listPerso.get(1).force, listPerso.get(1).agilite, listPerso.get(1).intelligence, "Tir à l'Arc", "Concentration");

            textJoueur1.setText(joueur1.nomPerso + "\n");
            textJoueur2.setText(joueur2.nomPerso +"\n");

            nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);

            testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
            tourAttaque(joueur1, joueur2);

        }

        buttonReturn.setText("Recommencer");
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.VAL_RETOUR, "Recommence le jeu");
                CombatActivity.this.setResult(1, intent);
                CombatActivity.this.finish();
            }
        });

    }

    public void tourAttaque(final Personnage persoJ1, final Personnage persoJ2){
        buttonAtt(buttonAttBaseJ1, textInfoJ1, persoJ1, persoJ2);
        buttonAtt(buttonAttBaseJ2, textInfoJ2, persoJ2, persoJ1);

        buttonPV(buttonPVJ1, textInfoJ1, persoJ1);
        buttonPV(buttonPVJ2, textInfoJ2, persoJ2);

        buttonAttSpe(buttonAttSpeJ1, textInfoJ1, persoJ1, persoJ2);
        buttonAttSpe(buttonAttSpeJ2, textInfoJ2, persoJ2, persoJ1);

        buttonFinRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAttBaseJ2.setEnabled(true);
                buttonAttBaseJ1.setEnabled(true);
                buttonAttSpeJ1.setEnabled(true);
                buttonAttSpeJ2.setEnabled(true);
                i++;
                textRound.setText("\n\nRound " + i);
            }
        });
    }


    public void buttonAtt(final Button buttonAttaque, final TextView textInfo, final Personnage persoAtt, final Personnage persoDef){
        buttonAttaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persoAtt.attaqueDeBase(persoDef);
                buttonAttaque.setEnabled(false);

                textInfo.setText("Vous attaquez " + persoDef.nomPerso + " avec votre attaque " + persoAtt.nomAttBase);
                testPointDeVie(persoAtt, persoDef, textResult);
            }
        });

    }

    public void buttonPV(Button buttonPV, final TextView textInfoSoin, final Personnage persoPV){
        buttonPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInfoSoin.setText("Vous avez " + persoPV.vie + " points de vie");
            }
        });
    }

    public void buttonAttSpe(final Button buttonAttSpe, final TextView textInfo, final Personnage persoAttSpe, final Personnage persoDefSpe){
        buttonAttSpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persoAttSpe.attaqueSpeciale(persoAttSpe, persoDefSpe);
                buttonAttSpe.setEnabled(false);

                if(persoAttSpe.name.equals("Rôdeur")){
                    textInfo.setText("Vous augmentez votre concentration");
                }else if(persoAttSpe.name.equals("Mage")) {
                    textInfo.setText("Vous vous soignez, votre vie est maintenant de " + persoAttSpe.nomAttSpe);
                }else {
                    textInfo.setText("Vous attaquez " + persoDefSpe.nomPerso + " avec votre attaque " + persoAttSpe.nomAttSpe);
                    testPointDeVie(persoAttSpe, persoDefSpe, textResult);
                }
            }
        });
    }

    public void testPointDeVie( Personnage persoAtt, Personnage persoVie, TextView text){
        if(persoVie.vie <=0){
            text.setText("\n\nFélicitation !! " + persoAtt.nomPerso + " a gagné le combat !!");
            buttonFinRound.setEnabled(false);
            buttonAttSpeJ1.setEnabled(false);
            buttonAttSpeJ2.setEnabled(false);
            buttonAttBaseJ1.setEnabled(false);
            buttonAttBaseJ2.setEnabled(false);
            buttonPVJ1.setEnabled(false);
            buttonPVJ2.setEnabled(false);
        }
    }

    public void nomButton (Button buttonJ1Base, Button buttonJ1Spe, Button buttonJ2Base, Button buttonJ2Spe, Personnage pJ1, Personnage pJ2){
        buttonJ1Base.setText(pJ1.nomAttBase);
        buttonJ1Spe.setText(pJ1.nomAttSpe);
        buttonJ2Base.setText(pJ2.nomAttBase);
        buttonJ2Spe.setText(pJ2.nomAttSpe);
    }
}
