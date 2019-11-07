package com.bast.magiworld;

import android.widget.TextView;

public class Guerrier extends Personnage implements Attaque{
    int degats = force;

    Guerrier(String name, String nomPerso, int niveau, int vie, int force, int agilite, int intelligence, String nomAttBase, String nomAttSpe) {
        super(name, nomPerso, niveau, vie, force, agilite, intelligence, nomAttBase, nomAttSpe);
    }

    @Override // Coup d'épée
    public void attaqueDeBase(Personnage defenseur) {
        defenseur.vie = defenseur.vie - degats;
    }

    @Override //Coup de Rage
    public void attaqueSpeciale(Personnage attaquant, Personnage defenseur) {

        degats = 2*force;
        defenseur.vie -= degats;
        this.vie = this.vie - (force/2);

    }
}