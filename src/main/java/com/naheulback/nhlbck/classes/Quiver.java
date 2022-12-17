package com.naheulback.nhlbck.classes;

public class Quiver extends Item {

    private Weapon arrow;
    private int countArrows;
    public Quiver(String inputSlug, String inputName, int inputLevel){
        super(inputSlug, inputName, inputLevel);
        countArrows = 5;
        switch (inputLevel){
            case 1 -> arrow = new Weapon("arrow_base", "Flèche de base", 1, 1, 5);
            case 2 -> arrow = new Weapon("arrow_quality", "Flèche de qualité", 2, 1, 10);
            case 3 -> arrow = new Weapon("arrow_elvene", "Flèche elvene", 3, 1, 30);
        }
    }

    public int getArrows() { return countArrows; }

    public void setArrows(int amount){ countArrows += amount; }

    public Weapon getArrow(){ return arrow; }

}
