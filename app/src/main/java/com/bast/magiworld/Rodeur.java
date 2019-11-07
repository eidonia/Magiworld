package com.bast.magiworld;

public class Rodeur extends Personnage implements Attaque{
    int degats = agilite;

    Rodeur(String name, String nomPerso, int niveau, int vie, int force, int agilite, int intelligence, String nomAttBase, String nomAttSpe) {
        super(name, nomPerso, niveau, vie, force, agilite, intelligence, nomAttBase, nomAttSpe);
    }

    @Override //Tir à l'Arc
    public void attaqueDeBase(Personnage defenseur) {
        defenseur.vie -= degats;
    }

    @Override //Concentration
    public void attaqueSpeciale(Personnage attaquant, Personnage defenseur) {
        degats = degats + (niveau/2);
    }
}
