package pwo.seq;

import java.math.BigDecimal;

/**
 *
 * @author nadyasimakovich
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor klasy FibonacciGenerator. Inicjalizuje current, f_1 i f_2
     * odpowiednimi wartościami.
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Przeładowana metoda resetująca generator, wywołująca także reset klasy
     * nadrzędnej.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Przeładowana metoda generująca kolejny term w ciągu Fibonacciego.
     *
     * @return Następny term w ciągu.
     */
    @Override
    public BigDecimal nextTerm() {

        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
