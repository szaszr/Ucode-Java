package org.ucode.homework5;
import java.util.*;

/*
Write a Java program to add 3 hours to the current time.
 */

public class Exercise37 {
    public static void main(String[] args) {
        Calendar cd = Calendar.getInstance();
        System.out.println("Current" + cd.getTime());
        cd.add(Calendar.HOUR, 3);
        System.out.println("New time" + cd.getTime());
        }
    }
