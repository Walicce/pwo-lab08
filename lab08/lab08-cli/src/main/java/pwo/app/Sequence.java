/*
 * Klasa Sequence reprezentuje aplikację wiersza poleceń do generowania sekwencji i obsługuje wybór między wyświetlaniem w terminalu i zapisywaniem do pliku.
 */
package pwo.app;

/**
 * Klasa Sequence jest aplikacją wiersza poleceń do generowania sekwencji i
 * obsługuje wybór między wyświetlaniem w terminalu i zapisywaniem do pliku.
 */
public class Sequence {

    /**
     * Metoda główna main() uruchamia aplikację wiersza poleceń w zależności od
     * liczby przekazanych argumentów.
     *
     * @param args Argumenty wiersza poleceń
     */
    public static void main(String[] args) {
        // Sprawdza liczbę przekazanych argumentów i wybiera odpowiednią aplikację do uruchomienia.
        switch (args.length) {
            case 3:
                // Jeśli przekazano trzy argumenty, uruchamia aplikację SeqToOutApp do wyświetlania sekwencji w terminalu.
                (new SeqToOutApp()).run(args);
                break;
            case 4:
                // Jeśli przekazano cztery argumenty, uruchamia aplikację SeqToFileApp do zapisywania sekwencji do pliku.
                (new SeqToFileApp()).run(args);
                break;
            default:
                // Wyświetla komunikat o błędzie, gdy liczba argumentów jest nieprawidłowa.
                System.out.println("!Illegal arguments\n"
                        + "Legal usage: seqName from to [fileName]");
        }
    }
}
