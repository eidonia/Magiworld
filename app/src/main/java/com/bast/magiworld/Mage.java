package com.bast.magiworld;

public class Mage extends Personnage implements Attaque{
    int degats = intelligence;

    Mage(String name, String nomPerso, int niveau, int vie, int force, int agilite, int intelligence, String nomAttBase, String nomAttSpe) {
        super(name, nomPerso, niveau, vie, force, agilite, intelligence, nomAttBase, nomAttSpe);
    }

    public void soin(){
    }

    @Override //Boule de feu
    public void attaqueDeBase(Personnage defenseur) {
        defenseur.vie -= degats;
    }

    @Override //Soin
    public void attaqueSpeciale(Personnage attaquant, Personnage defenseur) {
        this.vie = vie + (2*intelligence);

        if(vie > (5*niveau)) vie = 5 * niveau;
    }
}
