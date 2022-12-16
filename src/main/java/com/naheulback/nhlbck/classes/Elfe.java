package com.naheulback.nhlbck.classes;

public class Elfe extends Hero {

    private String saySomething;
    private int[] fleches;

    public Elfe(String slug, String name, int inputHealth, int inputMaxHealth, Boolean inputIsAlive){
        super(slug, name, inputHealth, inputMaxHealth, inputIsAlive, "elfe");
        saySomething = "J'aime pas les nains !";
        Carquois carquoisBase = new Carquois("carquois_base", "Carquois de flêches de base", 1);
        Carquois carquoisQualité = new Carquois("carquois_qualité", "Carquois de flêches de qualité", 1);
        Carquois carquoisSylvain = new Carquois("carquois_sylvain", "Carquois de flêches d'elfes sylvains", 1);
        super.addItem(carquoisBase);
        super.addItem(carquoisQualité);
        super.addItem(carquoisSylvain);
        fleches = new int[]{0, 0, 0};
    }

    public int getFleches(int type){
        return fleches[ type - 1 ];
    }

}
