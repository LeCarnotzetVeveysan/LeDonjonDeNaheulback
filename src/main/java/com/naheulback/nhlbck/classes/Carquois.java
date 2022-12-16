package com.naheulback.nhlbck.classes;

public class Carquois extends Item {

    private Weapon fleche;
    private int nombreFleches;
    public Carquois(String inputSlug, String inputName, int inputLevel){
        super(inputSlug, inputName, inputLevel);
        nombreFleches = 5;
        switch (inputLevel){
            case 1 -> fleche = new Weapon("fleche_base", "Flèche de base", 1, 1, 5);
            case 2 -> fleche = new Weapon("fleche_quali", "Flèch de qualité", 2, 1, 10);
            case 3 -> fleche = new Weapon("fleche_sylvaine", "Flèche sylvaine", 3, 1, 30);
        }
    }

    public int getFleches() { return nombreFleches; }

    public void setFleches(int amount){ nombreFleches += amount; }

    public Weapon getArrow(){ return fleche; }

}
