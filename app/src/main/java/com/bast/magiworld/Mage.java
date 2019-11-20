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
    public void running(final ImageSwitcher imageSwitcher) {
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
                        imageSwitcher.setImageResource(R.mipmap.magedeath1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath6);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath7);
                        break;
                    case 8 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath8);
                        break;
                    case 9 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath9);
                        break;
                    case 10 :
                        imageSwitcher.setImageResource(R.mipmap.magedeath10);
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
                        imageSwitcher.setImageResource(R.mipmap.magewin2);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.magewin4);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.magewin5);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.magewin6);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.magewin7);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.magewin8);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.magewin9);
                        break;
                    case 8 :
                        imageSwitcher.setImageResource(R.mipmap.magewin10);
                        break;
                    case 9 :
                        imageSwitcher.setImageResource(R.mipmap.magewin11);
                        break;
                    case 10 :
                        imageSwitcher.setImageResource(R.mipmap.magewin12);
                        break;
                    case 11 :
                        imageSwitcher.setImageResource(R.mipmap.magewin13);
                        break;
                    case 12 :
                        imageSwitcher.setImageResource(R.mipmap.magewin14);
                        break;
                }
                animationCounter %= 13;
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
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack6);
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
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack1reverse);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack2reverse);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack3reverse);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack4reverse);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack5reverse);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.magewalk_attack6reverse);
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
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe1);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe2);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe3);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe4);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe5);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe6);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe7);
                        isHitting = true;
                        break;
                }
                animationCounter %= 8;
                if(animationCounter == 0) animationCounter = 1;
                if(!isFighting) imgSwitchHandler.postDelayed(this, 300);
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
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe1reverse);
                        break;
                    case 2 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe2reverse);
                        break;
                    case 3 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe3reverse);
                        break;
                    case 4 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe4reverse);
                        break;
                    case 5 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe5reverse);
                        break;
                    case 6 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe6reverse);
                        break;
                    case 7 :
                        imageSwitcher.setImageResource(R.mipmap.mageattackspe7reverse);
                        isHitting = true;
                        break;
                }
                animationCounter %= 8;
                if(animationCounter == 0) animationCounter = 1;
                if(!isFighting) imgSwitchHandler.postDelayed(this, 300);
            }
        });
    }
}
