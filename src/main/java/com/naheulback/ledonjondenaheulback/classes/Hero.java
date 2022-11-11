package com.naheulback.ledonjondenaheulback.classes;

public abstract class Hero {

    private int level;
    private int experience;
    private int health;
    private int armor;
    private int attack;
    private int magic;
    private int mana;
    private int speed;
    private String testSpeak;

    public Hero(){

        level = 1;
        experience = 0;
        health = 100;
        armor = 100;
        attack = 100;
        magic = 100;
        mana = 100;
        speed = 100;
    }

    public abstract void speak();

    public void printTest(){

        System.out.println("test");

    }

    private int getHealth(){

        return health;

    }

}
