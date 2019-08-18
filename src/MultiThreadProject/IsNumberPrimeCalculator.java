package MultiThreadProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shailendra on 12/6/2016.
 */
public class IsNumberPrimeCalculator {
    //List<Integer> _primeNumbers = new ArrayList<Integer>();

    public void CheckIfNumbersArePrime(int numberToCheck,List<Integer> _primeNumbers) {

        synchronized (this) {
        if (IsNumberPrime(numberToCheck))
        {
            _primeNumbers.add(numberToCheck);

        }}

    }

    private boolean IsNumberPrime(long numberWeAreChecking)
    {
        if (numberWeAreChecking % 2 == 0)
            return false;
        return true;
    }
}
