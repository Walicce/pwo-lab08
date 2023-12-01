package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

/**
 * Klasa abstrakcyjna Generator implementuje interfejs SequenceGenerator i
 * dostarcza podstawową funkcjonalność dla generatorów sekwencji. Implementacje
 * konkretnych generatorów powinny dziedziczyć z tej klasy.
 *
 * @author nadyasimakovich
 */
abstract class Generator implements SequenceGenerator {

    // Pole przechowujące ostatni indeks generowanego elementu sekwencji.
    protected int lastIndex = 0;

    // Pola przechowujące aktualny element sekwencji oraz trzy poprzednie elementy.
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;

    /**
     * Resetuje generator do początkowego stanu, ustawiając lastIndex na 0.
     */
    @Override
    public void reset() {
        lastIndex = 0;
    }

    /**
     * Zwraca i-ty element sekwencji. W razie potrzeby generuje elementy do
     * indeksu i.
     *
     * @param i Indeks elementu sekwencji
     * @return Element sekwencji o podanym indeksie
     * @throws IllegalArgumentException jeśli i jest mniejsze od 0
     */
    @Override
    public final BigDecimal getTerm(int i) {
        // Sprawdza, czy indeks i jest nieujemny.
        if (i < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        // Jeśli indeks i jest mniejszy niż lastIndex, resetuje generator.
        if (i < lastIndex) {
            reset();
        }
        // Generuje elementy sekwencji do indeksu i.
        while (lastIndex <= i) {
            nextTerm();
        }
        // Zwraca wygenerowany element sekwencji.
        return current;
    }
}
