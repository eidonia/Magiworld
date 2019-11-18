package com.bast.magiworld;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageSwitcher;
import android.widget.TextView;
import android.os.Handler;


public class Mage extends Personnage{
    int degats = intelligence;

    public Mage(String name, String nomPerso, int niveau, int vie, int force, int agilite, int intelligence, String nomAttBase, String nomAttSpe) {
        super(name, nomPerso, niveau, vie, force, agilite, intelligence, nomAttBase, nomAttSpe);
    }

    public void soin(){
    }

    @Override //Boule de feu
    public void attaqueDeBase(Personnage defenseur, TextView textView) {
        defenseur.vie -= degats;
        textView.setText("Vous attaquez " + defenseur.nomPerso + " avec votre attaque " + nomAttBase + " " + degats);
    }

    @Override //Soin
    public void attaqueSpeciale(Personnage defenseur, TextView textView) {
        this.vie = vie + (2*intelligence);

        if(vie > (5*niveau)) vie = 5 * niveau;
        textView.setText("Vous vous soignez, votre vie est maintenant de " + vie);
    }

    public static final Parcelable.Creator<Mage> CREATOR = new Creator<Mage>() {
        @Override
        public Mage createFromParcel(Parcel in) {
            return new Mage(in);
        }

        @Override
        public Mage[] newArray(int size) {
            return new Mage[size];
        }
    };


    protected Mage(Parcel in){
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
