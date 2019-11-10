package com.bast.magiworld;

import android.os.Parcel;
import android.os.Parcelable;
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
}
