/*
 * Klasa reprezentuje aplikację wiersza poleceń do generowania sekwencji i wyświetlania ich w terminalu.
 */
package pwo.app;

import pwo.utils.SequenceTools;

/**
 * Klasa SeqToOutApp rozszerza funkcjonalność klasy SeqToFileApp i obsługuje
 * generowanie sekwencji oraz wyświetlanie ich w terminalu.
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     * Przesłonięta metoda getArgs() dodatkowo sprawdza poprawność argumentów i
     * zwraca true, jeśli są one poprawne.
     *
     * @param args Argumenty wiersza poleceń
     * @return True, jeśli argumenty są poprawne, w przeciwnym razie false
     */
    @Override
    protected boolean getArgs(String[] args) {
        // Wywołuje getArgs() z klasy nadrzędnej i zwraca true, jeśli wynik jest true oraz typ sekwencji, początek i koniec są prawidłowe.
        if (super.getArgs(args)) {
            return true;
        }
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Przesłonięta metoda writeSeq() generuje sekwencję i wyświetla jej terminy
     * w formie kolumny w terminalu.
     *
     * @return Zawsze zwraca true, ponieważ wyświetlanie w terminalu jest zawsze
     * uważane za udane.
     */
    protected boolean writeSeq() {
        // Wyświetla terminy sekwencji w terminalu za pomocą SequenceTools.
        System.out.println(SequenceTools.getTermsAsColumn(seqType.getGenerator(), from, to));
        return true;
    }

    /**
     * Przesłonięta metoda run() wykonuje aplikację wiersza poleceń do
     * generowania sekwencji i wyświetlania jej terminów w terminalu.
     *
     * @param args Argumenty wiersza poleceń
     */
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");
        // Sprawdza poprawność argumentów i wyświetla komunikat o błędzie, jeśli są nieprawidłowe.
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n" + "Legal usage: seqName from to");
            return;
        }
        // Wywołuje writeSeq() do wygenerowania sekwencji i wyświetlenia jej terminów w terminalu.
        writeSeq();
    }
}
