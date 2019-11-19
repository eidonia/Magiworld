package com.bast.magiworld;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class Personnage  implements Parcelable, Attaque, Animation {
    String name;
    String nomPerso;
    protected int niveau;
    protected int vie;
    protected int force;
    protected int agilite;
    protected int intelligence;
    String nomAttBase;
    String nomAttSpe;
    int degats;
    int animationCounter = 1;
    Handler imgSwitchHandler;
    boolean isFighting = true;
    boolean isDead = false;
    boolean isHitting = false;

    //Personnage(){}

    Personnage(String name, String nomPerso, int niveau, int vie, int force, int agilite, int intelligence, String nomAttBase, String nomAttSpe){
        this.name = name;
        this.nomPerso = nomPerso;
        this.niveau = niveau;
        this.vie = vie;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        this.nomAttBase = nomAttBase;
        this.nomAttSpe = nomAttSpe;

    }

    //Accesseurs

    public String getName(){ return name; }

    public int getNiveau() {
        return niveau;
    }

    public int getVie() {
        return vie;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    //Mutateurs

    public void setName(String name){this.name = name;}

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    //Parcelable

    protected Personnage(Parcel in) {
        name = in.readString();
        nomPerso = in.readString();
        niveau = in.readInt();
        vie = in.readInt();
        force = in.readInt();
        agilite = in.readInt();
        intelligence = in.readInt();
        nomAttBase = in.readString();
        nomAttSpe = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(nomPerso);
        dest.writeInt(niveau);
        dest.writeInt(vie);
        dest.writeInt(force);
        dest.writeInt(agilite);
        dest.writeInt(intelligence);
        dest.writeString(nomAttBase);
        dest.writeString(nomAttSpe);
    }
}

