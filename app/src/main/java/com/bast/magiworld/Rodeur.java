package com.bast.magiworld;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageSwitcher;
import android.widget.TextView;

public class Rodeur extends Personnage{
    int degats = agilite;

    Rodeur(String name, String nomPerso, int niveau, int vie, int force, int agilite, int intelligence, String nomAttBase, String nomAttSpe) {
        super(name, nomPerso, niveau, vie, force, agilite, intelligence, nomAttBase, nomAttSpe);
    }

    @Override //Tir à l'Arc
    public void attaqueDeBase(Personnage defenseur, TextView textView) {
        defenseur.vie -= degats;
        textView.setText("Vous attaquez " + defenseur.nomPerso + " avec votre attaque " + nomAttBase);
    }

    @Override //Concentration
    public void attaqueSpeciale(Personnage defenseur, TextView textView) {
        degats = agilite + (niveau/2);
        textView.setText("Vous augmentez votre concentration");

    }

    public static final Parcelable.Creator<Rodeur> CREATOR = new Creator<Rodeur>() {
        @Override
        public Rodeur createFromParcel(Parcel in) {
            return new Rodeur(in);
        }

        @Override
        public Rodeur[] newArray(int size) {
            return new Rodeur[size];
        }
    };


    protected Rodeur(Parcel in){
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
