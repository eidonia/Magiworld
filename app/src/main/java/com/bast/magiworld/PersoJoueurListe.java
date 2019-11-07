package com.bast.magiworld;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class PersoJoueurListe extends ArrayList<Personnage> implements Parcelable {

    public PersoJoueurListe(){

    }


    protected PersoJoueurListe(Parcel in) {
        this.getFromParcel(in);
    }



    public static final Creator<PersoJoueurListe> CREATOR = new Creator<PersoJoueurListe>() {
        @Override
        public PersoJoueurListe createFromParcel(Parcel in) {
            return new PersoJoueurListe(in);
        }

        @Override
        public PersoJoueurListe[] newArray(int size) {
            return new PersoJoueurListe[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        int size = this.size();
        dest.writeInt(size);
        for (int i=0; i<size; i++){
            Personnage personnage = this.get(i);
            dest.writeString(personnage.name);
            dest.writeInt(personnage.niveau);
            dest.writeInt(personnage.vie);
            dest.writeInt(personnage.force);
            dest.writeInt(personnage.agilite);
            dest.writeInt(personnage.intelligence);
        }

    }

    private void getFromParcel(Parcel in) {
        this.clear();

        int size = in.readInt();

        for(int i = 0; i<size; i++){
            Personnage personnage = new Personnage(in);
            personnage.setName(in.readString());
            personnage.setNiveau(in.readInt());
            personnage.setVie(in.readInt());
            personnage.setForce(in.readInt());
            personnage.setAgilite(in.readInt());
            personnage.setIntelligence(in.readInt());
            this.add(personnage);

        }




    }


}
