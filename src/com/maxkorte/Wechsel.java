package com.maxkorte;

import java.util.HashMap;

public class Wechsel {

    private final HashMap<Double, Integer> rueckgabe;
    private final Double[] muenzen;

    public Wechsel(Double[] muenzen){
        this.muenzen = muenzen;
        rueckgabe = initializeRueckgabe();
    }

    private HashMap<Double, Integer> initializeRueckgabe(){
        HashMap<Double, Integer> rueckgabe = new HashMap<>();

        for (Double muenze : muenzen){      // für jefe Münze wird ein "Eintrag" in rueckgabe mit key=muenze, value=0 erstellt
            rueckgabe.put(muenze, 0);
        }

        return rueckgabe;
    }

    public void processMuenzen(double betrag) {
        for(double muenze : muenzen){
            if(betrag >= muenze){
                betrag = processMuenze(betrag, muenze);     // für die größtmögliche, im Betrag unterzubringende Münze wird processMuenze aufgerufen
            }
        }

        shrinkRueckgabe();
    }

    private double processMuenze(double betrag, double muenze) {
        double rest = betrag % muenze;
        double anzahlMuenze = (betrag - rest) / muenze;
        rueckgabe.replace(muenze, (int) (rueckgabe.get(muenze) + anzahlMuenze));        // Anzahl der Münze wird als value (für key=muenze) in rückgabe aktualisiert
        betrag = Math.round(rest * 100);
        betrag /= 100;      // es muss gerundet werden, da bei einigen modulo-Operationen (bz. auf rest) nicht immer "ganzzahlige" Ergebnisse herauskommen
        return betrag;
    }

    private void shrinkRueckgabe() {        // Muenzen, deren value=0 ist, werdern aus rueckgabe entfernt
        for(double muenze : muenzen){
            if(rueckgabe.get(muenze) == 0){
                rueckgabe.remove(muenze);
            }
        }
    }

    public HashMap<Double, Integer> getRueckgabe(){
        return rueckgabe;
    }
}