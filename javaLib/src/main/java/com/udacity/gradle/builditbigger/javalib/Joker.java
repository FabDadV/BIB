package com.udacity.gradle.builditbigger.javalib;

import java.util.ArrayList;
import java.util.Random;

public final class Joker {
    private ArrayList<String> jokes = new ArrayList<>();

    Random rnd = new Random();
    {
        jokes.add(" Wenn ist das Nunstruck git und Slotermeyer?\n"
                + " Ja! ... Beiherhund das Oder die Flipperwaldt gersput!");
        jokes.add(" When do you go at red and stop at green? \n"
                + " When you are eating a watermelon.");
        jokes.add(" Why should not you fall in love with a pastry chef?\n"
                + " He will dessert you.");
        jokes.add(" Son: What is the difference between love and marriage?\n"
                + " Father: Love is blind. Marriage is an eye opener.");
        jokes.add(" If I have to choose between a husband and shoes, I choose shoes.\n"
                + " They tend to last longer and are easier to replace.");
        jokes.add(" Man: I have not spoken to my wife in 18 months.\n"
                + " Friend: Why not?\n Man: I do not like to interrupt her.");
        jokes.add(" Wife: Do you want dinner?\n"
                + " Husband: Sure, what are my choices?\n"
                + " Wife: Yes or no.");
        jokes.add(" Son: Dad, I have heard that in some parts of the world"
                + " a man does not know his wife until he marries her.\n"
                + " Father: Son, that is true everywhere.");
        jokes.add(" What do you call two birds in love?\n"
                + " Tweet-hearts!");
        jokes.add(" What did the little boat say to the yacht?\n"
                + " Can I interest you in a little row-mance?");
        jokes.add(" If a man opens the car door for his wife,"
                + " you can be sure of one thing   either the car is new or the wife is.");
        jokes.add(" I can not stand Russian nesting dolls.\n"
                + " They are so full of themselves.");
        jokes.add(" What is the biggest lie in the entire universe?\n"
                + " I have read and agree to the Terms & Conditions.");
        jokes.add(" How does a computer get drunk?\n"
                + " It takes screenshots.");
        jokes.add(" I just got fired from my job at the keyboard factory."
                + " They told me I was not putting in enough shifts.");
        jokes.add("When do you go at red and stop at green?\n"
                + " When you are eating a watermelon.");
    }

    public String getJoke(){
        int i = rnd.nextInt(15);
        return jokes.get(i);
    }
}