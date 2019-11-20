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
    public void running(final ImageSwitcher imageSwitcher) {
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
                if(isFighting) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }

    @Override
    public void runningReverse(final ImageSwitcher imageSwitcher) {
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
                if(isFighting) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }

    @Override
    public void death(final ImageSwitcher imageSwitcher) {
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++){
                    case 1 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath6);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath7);
                        break;
                    case 8 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath8);
                        break;
                    case 9 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath9);
                        break;
                    case 10 :
                        imageSwitcher.setImageResource(R.mipmap.roguedeath10);
                        isDead = true;
                        break;
                }
                animationCounter %= 11;
                if(animationCounter == 0) animationCounter = 1;
                if(!isDead) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }

    @Override
    public void win(final ImageSwitcher imageSwitcher) {
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++){
                    case 1 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin2);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin4);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin5);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin6);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin7);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin8);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin9);
                        break;
                    case 8 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin10);
                        break;
                    case 9 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin12);
                        break;
                    case 10 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin13);
                        break;
                    case 11 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin14);
                        break;
                    case 12 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin15);
                        break;
                    case 13 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin16);
                        break;
                    case 14 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin17);
                        break;
                    case 15 :
                        imageSwitcher.setImageResource(R.mipmap.roguewin18);
                        break;
                }
                animationCounter %= 16;
                if(animationCounter == 0) animationCounter = 1;
                if(!isDead) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }

    @Override
    public void attBase(final ImageSwitcher imageSwitcher) {
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++){
                    case 1 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack6);
                        isHitting = true;
                        break;
                }
                animationCounter %= 7;
                if(animationCounter == 0) animationCounter = 1;
                if(!isFighting) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }

    @Override
    public void attBaseReverse(final ImageSwitcher imageSwitcher) {
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++){
                    case 1 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack1reverse);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack2reverse);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack3reverse);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack4reverse);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack5reverse);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.roguewalk_attack6reverse);
                        isHitting = true;
                        break;
                }
                animationCounter %= 7;
                if(animationCounter == 0) animationCounter = 1;
                if(!isFighting) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }

    @Override
    public void attSpe(final ImageSwitcher imageSwitcher) {
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++){
                    case 1 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe6);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe7);
                        break;
                    case 8 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe8);
                        break;
                    case 9 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe9);
                        break;
                    case 10 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe10);
                        break;
                    case 11 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe11);
                        isHitting = true;
                        break;
                }
                animationCounter %= 12;
                if(animationCounter == 0) animationCounter = 1;
                if(!isDead) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }

    @Override
    public void attSpeReverse(final ImageSwitcher imageSwitcher) {
        imgSwitchHandler = new Handler(Looper.getMainLooper());
        imgSwitchHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++){
                    case 1 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe1reverse);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe2reverse);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe3reverse);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe4reverse);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe5reverse);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe6reverse);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe7reverse);
                        break;
                    case 8 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe8reverse);
                        break;
                    case 9 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe9reverse);
                        break;
                    case 10 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe10reverse);
                        break;
                    case 11 :
                        imageSwitcher.setImageResource(R.mipmap.rogueattackspe11reverse);
                        isHitting = true;
                        break;
                }
                animationCounter %= 12;
                if(animationCounter == 0) animationCounter = 1;
                if(!isDead) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }
}
