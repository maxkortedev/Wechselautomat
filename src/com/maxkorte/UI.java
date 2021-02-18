package com.maxkorte;

import java.util.Scanner;

public class UI {

    public static void main(String[] args){
        Double[] muenzen = {2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
        Wechsel w = new Wechsel(muenzen);

        System.out.println("Gib den gewünschten Betrag ein (€): ");
        Scanner sc = new Scanner(System.in);
        w.processMuenzen(sc.nextDouble());

        for(double key : w.getRueckgabe().keySet()){
            System.out.println(w.getRueckgabe().get(key) + "x " + key + "€");
        }
    }
}
