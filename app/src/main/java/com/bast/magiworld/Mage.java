package com.bast.magiworld;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class Mage extends Personnage{
    int degats = intelligence;

    Mage(String name, String nomPerso, int niveau, int vie, int force, int agilite, int intelligence, String nomAttBase, String nomAttSpe) {
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

}
