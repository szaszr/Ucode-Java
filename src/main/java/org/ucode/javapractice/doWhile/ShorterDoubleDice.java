package org.ucode.javapractice.doWhile;

import java.util.*;

/*
http://www.programmingbydoing.com/a/shorter-double-dice.html
 */

public class ShorterDoubleDice {
    public static void main(String[] args) {
        Random r = new Random();

        System.out.println("HERE COMES THE DICE!");
        System.out.println();

        int roll1, roll2;

        do {
            roll1 = (1+r.nextInt(6));
            roll2 = (1+r.nextInt(6));
            int total = roll1+roll2;

            System.out.println("Roll #1: " + roll1);
            System.out.println("Roll #2: " + roll2);
            System.out.println("The total is " + total);
            System.out.println();
        } while (roll1!=roll2);
    }
}
