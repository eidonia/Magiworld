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
    public void running(final ImageSwitcher imageSwitcher) {
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
                if(isFighting) imgSwitchHandler.postDelayed(this,300);
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
                if(isFighting) imgSwitchHandler.postDelayed(this,300);
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
                        imageSwitcher.setImageResource(R.mipmap.wardeath1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath6);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath7);
                        break;
                    case 8 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath8);
                        break;
                    case 9 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath9);
                        break;
                    case 10 :
                        imageSwitcher.setImageResource(R.mipmap.wardeath10);
                        isDead = true;
                        break;
                }
                animationCounter %= 11;
                if(animationCounter == 0) animationCounter = 1;
                if(!isDead) imgSwitchHandler.postDelayed(this,300);
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
                        imageSwitcher.setImageResource(R.mipmap.warwin2);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.warwin3);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.warwin5);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.warwin6);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.warwin7);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.warwin8);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.warwin9);
                        break;
                    case 8 :
                        imageSwitcher.setImageResource(R.mipmap.warwin10);
                        break;
                    case 9 :
                        imageSwitcher.setImageResource(R.mipmap.warwin11);
                        break;
                    case 10 :
                        imageSwitcher.setImageResource(R.mipmap.warwin12);
                        break;
                }
                animationCounter %= 11;
                if(animationCounter == 0) animationCounter = 1;
                if(!isDead) imgSwitchHandler.postDelayed(this,300);
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
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack6);
                        isHitting = true;
                        break;
                }
                animationCounter %= 7;
                if(animationCounter == 0) animationCounter = 1;
                if(!isFighting) imgSwitchHandler.postDelayed(this,300);
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
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack1reverse);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack2reverse);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack3reverse);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack4reverse);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack5reverse);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.warwalk_attack6reverse);
                        isHitting = true;
                        break;
                }
                animationCounter %= 7;
                if(animationCounter == 0) animationCounter = 1;
                if(!isFighting) imgSwitchHandler.postDelayed(this,300);
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
                        imageSwitcher.setImageResource(R.mipmap.warattackspe1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe6);
                        isHitting = true;
                        break;
                }
                animationCounter %= 7;
                if(animationCounter == 0) animationCounter = 1;
                if(!isFighting) imgSwitchHandler.postDelayed(this,300);
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
                        imageSwitcher.setImageResource(R.mipmap.warattackspe1reverse);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe2reverse);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe3reverse);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe4reverse);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe5reverse);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.warattackspe6reverse);
                        isHitting = true;
                        break;
                }
                animationCounter %= 7;
                if(animationCounter == 0) animationCounter = 1;
                if(!isFighting) imgSwitchHandler.postDelayed(this,300);
            }
        });
    }
}