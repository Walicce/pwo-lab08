/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.utils;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Klasa narzędziowa służąca do obsługi obiektów<br>
 * implementujących interfejs {@link SequenceGenerator}
 *
 * @author nadyasimakovich
 * @version 1.0.0
 */
public class SequenceTools {

    private static String getTerms(SequenceGenerator sg,
            int from, int to, String sep) {

        int i = from, stop = to, step = from > to ? -1 : 1;
        String terms = "";

        while (true) {
            terms += sg.getTerm(i) + sep;
            if (i == stop) {
                return terms.trim();
            }
            i += step;
        }
    }

    /**
     * Zamienia wyrazy ciągu na tekst.<br>
     * Wyrazy ciągu tworzą kolumnę.
     *
     * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
     * @param from Początkowy wyraz ciągu
     * @param to Końcowy wyraz ciągu
     * @return Wyrazy ciągu w postaci tekstu tworzącego kolumnę
     * @see #getTermsAsLine(pwo.utils.SequenceGenerator, int, int)
     */
    public static String getTermsAsColumn(SequenceGenerator sg,
            int from, int to) {
        return getTerms(sg, from, to, "\n");
    }

    /**
     * Zamiania wyrazy ciągu na tekst.<br>
     * Wyrazy ciągu tworzą wiersz.
     *
     * @param sg Dowolny obiekt implementujący {@link SequenceGenerator}
     * @param from Początkowy wyraz ciągu
     * @param to Końcowy wyraz ciągu
     * @return Wyrazy ciągu w postaci tekstu tworzącego wiersz
     * @see #getTermsAsColumn(pwo.utils.SequenceGenerator, int, int)
     */
    public static String getTermsAsLine(SequenceGenerator sg,
            int from, int to) {
        return getTerms(sg, from, to, " ");
    }

    /**
     * Zapisuje wyrazy ciągu do pliku w postaci kolumny.
     *
     *
     * @param sg Dowolny obiekt implementujący {@link    SequenceGenerator}
     * @param from Początkowy wyraz ciągu
     * @param to Końcowy wyraz ciągu
     * @param fileName Nazwa pliku
     * @return true jeżeli udało się zapisać plik, false w przeciwnym wypadku
     */
    public static boolean writeToFile(SequenceGenerator sg,
            int from, int to, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {
            writer.write(getTermsAsColumn(sg, from, to));
        } catch (IOException ex) {
            return false;
        }

        return true;
    }
}
