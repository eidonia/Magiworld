package com.bast.magiworld;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageSwitcher;
import android.widget.TextView;

public class Guerrier extends Personnage{
    int degats = force;

    Guerrier(String name, String nomPerso, int niveau, int vie, int force, int agilite, int intelligence, String nomAttBase, String nomAttSpe) {
        super(name, nomPerso, niveau, vie, force, agilite, intelligence, nomAttBase, nomAttSpe);
    }

    @Override // Coup d'épée
    public void attaqueDeBase(Personnage defenseur, TextView textView) {
        defenseur.vie = defenseur.vie - degats;
        textView.setText("Vous attaquez " + defenseur.nomPerso + " avec votre attaque " + nomAttBase);
    }

    @Override //Coup de Rage
    public void attaqueSpeciale(Personnage defenseur, TextView textView) {
        degats = 2*force;
        defenseur.vie -= degats;
        this.vie = this.vie - (force/2);
        textView.setText("Vous attaquez " + defenseur.nomPerso + " avec votre attaque " + nomAttSpe + " mais vous subissez vous aussi des dégats, votre vie est de " + vie);
    }

    public static final Parcelable.Creator<Guerrier> CREATOR = new Creator<Guerrier>() {
        @Override
        public Guerrier createFromParcel(Parcel in) {
            return new Guerrier(in);
        }

        @Override
        public Guerrier[] newArray(int size) {
            return new Guerrier[size];
        }
    };


    protected Guerrier(Parcel in){
        super(in);
    }
    @Override
    public void running(final ImageSwitcher imageSwitcher, final boolean isFighting) {
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++){
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
                animationCounter %= 7;
                if(animationCounter == 0) animationCounter = 1;
                if(isFighting) imgSwitchHandler.postDelayed(this, 600);
            }
        });
    }

    @Override
    public void runningReverse(final ImageSwitcher imageSwitcher, final boolean isFighting) {
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++){
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
                animationCounter %= 7;
                if(animationCounter == 0) animationCounter = 1;
                if(isFighting) imgSwitchHandler.postDelayed(this, 600);
            }
        });
    }

    @Override
    public void death() {

    }

    @Override
    public void win() {

    }

    @Override
    public void attBase() {

    }

    @Override
    public void attSpe() {

    }
}