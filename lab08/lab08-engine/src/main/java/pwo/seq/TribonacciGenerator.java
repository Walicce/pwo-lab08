package pwo.seq;

import java.math.BigDecimal;

/**
 *
 * @author nadyasimakovich
 */
public class TribonacciGenerator extends
        FibonacciGenerator {

    /**
     * Konstruktor klasy TribonacciGenerator. Inicjalizuje f_3 wartością 0.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Przeładowana metoda resetująca generator, wywołująca także reset klasy
     * nadrzędnej.
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }

    /**
     * Przeładowana metoda generująca kolejny term w ciągu Tribonacci.
     *
     * @return Następny term w ciągu.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
