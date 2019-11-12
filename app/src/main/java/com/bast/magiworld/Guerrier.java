package com.bast.magiworld;

import android.os.Parcel;
import android.os.Parcelable;
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
}