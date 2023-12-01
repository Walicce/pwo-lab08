package pwo.seq;

import java.math.BigDecimal;

/**
 *
 * @author nadyasimakovich
 */
public class LucasGenerator extends FibonacciGenerator {

    /**
     * Konstruktor klasy LucasGenerator. Inicjalizuje current i f_2 wartościami
     * 2.
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Przeładowana metoda resetująca generator, wywołująca także reset klasy
     * nadrzędnej.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Przeładowana metoda generująca kolejny term w ciągu Lucasa.
     *
     * @return Następny term w ciągu.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }
}
