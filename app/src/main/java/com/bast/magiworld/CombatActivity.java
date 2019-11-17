package com.bast.magiworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class CombatActivity extends Activity {

    TextView testArray, testArray2, textRound, separateur, separateur2, separateur3, textJoueur1, textInfoJ1, textJoueur2, textInfoJ2, textResult;
    Button buttonAttBaseJ1, buttonAttSpeJ1, buttonPVJ1, buttonAttBaseJ2, buttonAttSpeJ2, buttonPVJ2, buttonFinRound, buttonReturn;
    ImageSwitcher imgSwitchJ1, imgSwitchJ2, imgSwitchFirework;
    int i = 1;
    int countAtt = 0;
    int animationCounterJ1 = 1;
    Handler imgSwitchHandler;

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

        createView();


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


    //CREATION DE LA VUE

    public void createView(){
        textRound = findViewById(R.id.textRound);
        separateur = findViewById(R.id.separateur);
        separateur.setText("\n --------------- \n");
        separateur2 = findViewById(R.id.separateur2);
        separateur.setText("\n --------------- \n");
        separateur3 = findViewById(R.id.separateur3);
        separateur3.setText("\n --------------- \n");
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

        imgSwitchJ1 = (ImageSwitcher)findViewById(R.id.imageJoueur1);
        imgSwitchJ2 = (ImageSwitcher)findViewById(R.id.imageJ2);
        imgSwitchFirework = (ImageSwitcher)findViewById(R.id.imgSwitchFirework);

        imgSwitchJ1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                return myView;
            }
        });

        imgSwitchJ2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                return myView;

            }
        });

        imgSwitchFirework.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                return myView;

            }
        });



    }

    //CREATION  DU JEU

    public void touJeu(ArrayList<Personnage> list){
        textRound.setText("\n\n\nRound 1");

        Personnage joueur1 = create(list, 0);
        Personnage joueur2 = create(list, 1);
        animPerso(joueur1, imgSwitchJ1);
        animPersoRev(joueur2, imgSwitchJ2);
        textJoueur1.setText(joueur1.nomPerso);
        textJoueur2.setText(joueur2.nomPerso);
        nomButton(buttonAttBaseJ1, buttonAttSpeJ1, buttonAttBaseJ2, buttonAttSpeJ2, joueur1, joueur2);
        testArray2.setText("Nos 2 combattants sont : \n - " + joueur1.nomPerso + " un " + joueur1.name + " de niveau " + joueur1.niveau + "\n - " + joueur2.nomPerso + " un " + joueur2.name + " de niveau " + joueur2.niveau);
        tourAttaque(joueur1, joueur2);

    }

    public Personnage create(ArrayList<Personnage> array, int i){
        if(array.get(i).name.equals("Mage")) {
            return new Mage(array.get(i).name, array.get(i).nomPerso, array.get(i).niveau, array.get(i).vie, array.get(i).force, array.get(i).agilite, array.get(i).intelligence, "Boule de Feu", "Soin");
        }else if (array.get(i).name.equals("Guerrier")) {
            return new Guerrier(array.get(i).name, array.get(i).nomPerso, array.get(i).niveau, array.get(i).vie, array.get(i).force, array.get(i).agilite, array.get(i).intelligence, "Coup d'épée", "Coup de Rage");
        }
        return new Rodeur(array.get(i).name, array.get(i).nomPerso, array.get(i).niveau, array.get(i).vie, array.get(i).force, array.get(i).agilite, array.get(i).intelligence, "Coup de Surin", "Concentration");
    }

    public void tourAttaque(final Personnage persoJ1, final Personnage persoJ2){
        buttonFinRound.setEnabled(false);
        buttonAtt(buttonAttBaseJ1, buttonAttSpeJ1, textInfoJ1, persoJ1, persoJ2, imgSwitchJ1);
        buttonAtt(buttonAttBaseJ2, buttonAttSpeJ2, textInfoJ2, persoJ2, persoJ1, imgSwitchJ2);

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


    //ANIMATIONS

    public void animPerso(Personnage perso, final ImageSwitcher imageSwitcher){

        if(perso.name.equals("Mage")){
            imgSwitchHandler = new Handler(Looper.getMainLooper());
            imgSwitchHandler.post(new Runnable() {
                @Override
                public void run() {
                    switch (animationCounterJ1++){
                        case 1 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk1);
                            break;
                        case 2 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk2);
                            break;
                        case 3 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk3);
                            break;
                        case 4 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk4);
                            break;
                        case 5 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk5);
                            break;
                        case 6 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk6);
                            break;
                    }
                    animationCounterJ1 %= 7;
                    if(animationCounterJ1 == 0) animationCounterJ1 = 1;
                    imgSwitchHandler.postDelayed(this, 600);


                }
            });

        }else if(perso.name.equals("Guerrier")){
            imgSwitchHandler = new Handler(Looper.getMainLooper());
            imgSwitchHandler.post(new Runnable() {
                @Override
                public void run() {
                    switch (animationCounterJ1++){
                        case 1 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk1);
                            break;
                        case 2 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk2);
                            break;
                        case 3 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk3);
                            break;
                        case 4 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk4);
                            break;
                        case 5 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk5);
                            break;
                        case 6 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk6);
                            break;
                    }
                    animationCounterJ1 %= 7;
                    if(animationCounterJ1 == 0) animationCounterJ1 = 1;
                    imgSwitchHandler.postDelayed(this, 600);

                }
            });

        }else if(perso.name.equals("Rôdeur")){
            imgSwitchHandler = new Handler(Looper.getMainLooper());
            imgSwitchHandler.post(new Runnable() {
                @Override
                public void run() {
                    switch (animationCounterJ1++){
                        case 1 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk1);
                            break;
                        case 2 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk2);
                            break;
                        case 3 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk3);
                            break;
                        case 4 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk4);
                            break;
                        case 5 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk5);
                            break;
                        case 6 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk6);
                            break;
                    }
                    animationCounterJ1 %= 7;
                    if(animationCounterJ1 == 0) animationCounterJ1 = 1;
                    imgSwitchHandler.postDelayed(this, 600);

                }
            });

        }
    }

    public void animPersoRev(Personnage perso, final ImageSwitcher imageSwitcher){

        if(perso.name.equals("Mage")){
            imgSwitchHandler = new Handler(Looper.getMainLooper());
            imgSwitchHandler.post(new Runnable() {
                @Override
                public void run() {
                    switch (animationCounterJ1++){
                        case 1 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk1reverse);
                            break;
                        case 2 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk2reverse);
                            break;
                        case 3 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk3reverse);
                            break;
                        case 4 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk4reverse);
                            break;
                        case 5 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk5reverse);
                            break;
                        case 6 :
                            imageSwitcher.setImageResource(R.mipmap.magewalk6reverse);
                            break;
                    }
                    animationCounterJ1 %= 7;
                    if(animationCounterJ1 == 0) animationCounterJ1 = 1;
                    imgSwitchHandler.postDelayed(this, 600);


                }
            });

        }else if(perso.name.equals("Guerrier")){
            imgSwitchHandler = new Handler(Looper.getMainLooper());
            imgSwitchHandler.post(new Runnable() {
                @Override
                public void run() {
                    switch (animationCounterJ1++){
                        case 1 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk1reverse);
                            break;
                        case 2 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk2reverse);
                            break;
                        case 3 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk3reverse);
                            break;
                        case 4 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk4reverse);
                            break;
                        case 5 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk5reverse);
                            break;
                        case 6 :
                            imageSwitcher.setImageResource(R.mipmap.warwalk6reverse);
                            break;
                    }
                    animationCounterJ1 %= 7;
                    if(animationCounterJ1 == 0) animationCounterJ1 = 1;
                    imgSwitchHandler.postDelayed(this, 600);

                }
            });

        }else if(perso.name.equals("Rôdeur")){
            imgSwitchHandler = new Handler(Looper.getMainLooper());
            imgSwitchHandler.post(new Runnable() {
                @Override
                public void run() {
                    switch (animationCounterJ1++){
                        case 1 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk1reverse);
                            break;
                        case 2 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk2reverse);
                            break;
                        case 3 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk3reverse);
                            break;
                        case 4 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk4reverse);
                            break;
                        case 5 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk5reverse);
                            break;
                        case 6 :
                            imageSwitcher.setImageResource(R.mipmap.roguewalk6reverse);
                            break;
                    }
                    animationCounterJ1 %= 7;
                    if(animationCounterJ1 == 0) animationCounterJ1 = 1;
                    imgSwitchHandler.postDelayed(this, 600);

                }
            });

        }
    }

    public void animFirework(){
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounterJ1++){
                    case 1 :
                        imgSwitchFirework.setImageResource(R.mipmap.firework_red0);
                        break;
                    case 2 :
                        imgSwitchFirework.setImageResource(R.mipmap.firework_red1);
                        break;
                    case 3 :
                        imgSwitchFirework.setImageResource(R.mipmap.firework_red2);
                        break;
                    case 4 :
                        imgSwitchFirework.setImageResource(R.mipmap.firework_red3);
                        break;
                    case 5 :
                        imgSwitchFirework.setImageResource(R.mipmap.firework_red4);
                        break;
                    case 6 :
                        imgSwitchFirework.setImageResource(R.mipmap.firework_red5);
                        break;
                    case 7 :
                        imgSwitchFirework.setImageResource(R.mipmap.firework_red6);
                        break;
                    case 8 :
                        imgSwitchFirework.setImageResource(R.mipmap.firework_red7);
                        break;
                }
                animationCounterJ1 %= 9;
                if ( animationCounterJ1 == 0 ) animationCounterJ1 = 1;
                imgSwitchHandler.postDelayed(this, 300);

            }
        });
    }

    // GESTION DES BUTTONS

    public void buttonAtt(final Button buttonAttaque, final Button buttAttSpe, final TextView textInfo, final Personnage persoAtt, final Personnage persoDef, final ImageSwitcher imageSwitcher){
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


    // CALCUL DES POINTS DE VIE A CHAQUE ATTAQUE

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
            animFirework();
        }else if (persoAtt.vie <=0){
            text.setText("\n\nFélicitation !! " + persoAtt.nomPerso + " s'est tué avec son attaque ! " + persoVie.nomPerso + " gagne le combat !!");
            buttonFinRound.setEnabled(false);
            buttonAttSpeJ1.setEnabled(false);
            buttonAttSpeJ2.setEnabled(false);
            buttonAttBaseJ1.setEnabled(false);
            buttonAttBaseJ2.setEnabled(false);
            buttonPVJ1.setEnabled(false);
            buttonPVJ2.setEnabled(false);
            animFirework();
        }
    }


    // NOM DES BUTTONS SUIVANT LES CLASSES

    public void nomButton (Button buttonJ1Base, Button buttonJ1Spe, Button buttonJ2Base, Button buttonJ2Spe, Personnage pJ1, Personnage pJ2){
        buttonJ1Base.setText(pJ1.nomAttBase);
        buttonJ1Spe.setText(pJ1.nomAttSpe);
        buttonJ2Base.setText(pJ2.nomAttBase);
        buttonJ2Spe.setText(pJ2.nomAttSpe);
    }




    // CALLIGRAPHY

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
