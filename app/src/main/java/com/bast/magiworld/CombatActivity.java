package com.bast.magiworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class CombatActivity extends Activity {

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
    int countAtt = 0;

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
        setContentView(R.layout.activity_combat);

        textRound = findViewById(R.id.textRound);
        separateur = findViewById(R.id.separateur);
        separateur.setText("\n ---------------------------------------------------- \n");
        separateur2 = findViewById(R.id.separateur2);
        separateur.setText("\n ---------------------------------------------------- \n");
        separateur3 = findViewById(R.id.separateur3);
        separateur3.setText("\n --------------------------------------------------- \n");
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


        touJeu(listPerso);


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
        buttonFinRound.setEnabled(false);
        buttonAtt(buttonAttBaseJ1, buttonAttSpeJ1, textInfoJ1, persoJ1, persoJ2);
        buttonAtt(buttonAttBaseJ2, buttonAttSpeJ2, textInfoJ2, persoJ2, persoJ1);

        buttonPV(buttonPVJ1, textInfoJ1, persoJ1);
        buttonPV(buttonPVJ2, textInfoJ2, persoJ2);

        buttonAttSpe(buttonAttSpeJ1, textInfoJ1, persoJ1, persoJ2, buttonAttBaseJ1);
        buttonAttSpe(buttonAttSpeJ2, textInfoJ2, persoJ2, persoJ1, buttonAttBaseJ2);

                buttonFinRound.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonAttBaseJ2.setEnabled(true);
                        buttonAttBaseJ1.setEnabled(true);
                        buttonAttSpeJ1.setEnabled(true);
                        buttonAttSpeJ2.setEnabled(true);
                        buttonFinRound.setEnabled(false);
                        i++;
                        textRound.setText("\n\nRound " + i);
                        countAtt = 0;

                        if (persoJ1.name.equals("Rôdeur"))
                            persoJ1.degats = persoJ1.agilite;
                        if (persoJ2.name.equals("Rôdeur"))
                            persoJ2.degats = persoJ2.agilite;
                    }
                });
    }


    public void buttonAtt(final Button buttonAttaque, final Button buttAttSpe, final TextView textInfo, final Personnage persoAtt, final Personnage persoDef){
        buttonAttaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persoAtt.attaqueDeBase(persoDef, textInfo);
                buttonAttaque.setEnabled(false);
                testPointDeVie(persoAtt, persoDef, textResult);

                buttAttSpe.setEnabled(false);
                countAtt++;
                if(countAtt == 2 && persoDef.vie > 0)
                    buttonFinRound.setEnabled(true);

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

    public void buttonAttSpe(final Button buttonAttSpe, final TextView textInfo, final Personnage persoAttSpe, final Personnage persoDefSpe, final Button buttonAttBase){
        buttonAttSpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persoAttSpe.attaqueSpeciale(persoDefSpe, textInfo);
                buttonAttSpe.setEnabled(false);
                testPointDeVie(persoAttSpe, persoDefSpe, textResult);

                if(persoAttSpe.name.equals("Guerrier") || persoAttSpe.name.equals("Mage")) {
                    buttonAttBase.setEnabled(false);
                    countAtt++;
                    if(countAtt == 2 && persoDefSpe.vie > 0)
                        buttonFinRound.setEnabled(true);
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
        }else if (persoAtt.vie <=0){
            text.setText("\n\nFélicitation !! " + persoAtt.nomPerso + " s'est tué avec son attaque ! " + persoVie.nomPerso + " gagne le combat !!");
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

    public Personnage create(ArrayList<Personnage> array, int i){
        if(array.get(i).name.equals("Mage")) {
            return new Mage(array.get(i).name, array.get(i).nomPerso, array.get(i).niveau, array.get(i).vie, array.get(i).force, array.get(i).agilite, array.get(i).intelligence, "Boule de Feu", "Soin");
        }else if (array.get(i).name.equals("Guerrier")) {
            return new Guerrier(array.get(i).name, array.get(i).nomPerso, array.get(i).niveau, array.get(i).vie, array.get(i).force, array.get(i).agilite, array.get(i).intelligence, "Coup d'épée", "Coup de Rage");
        }
        return new Rodeur(array.get(i).name, array.get(i).nomPerso, array.get(i).niveau, array.get(i).vie, array.get(i).force, array.get(i).agilite, array.get(i).intelligence, "Tir à l'Arc", "Concentration");
    }

    public void touJeu(ArrayList<Personnage> list){
        textRound.setText("\n\n\nRound 1");

        Personnage joueur1 = create(list, 0);
        Personnage joueur2 = create(list, 1);
        textJoueur1.setText(joueur1.nomPerso);
        textJoueur2.setText(joueur2.nomPerso);
        nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);
        testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
        tourAttaque(joueur1, joueur2);

    }

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
