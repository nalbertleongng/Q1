import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.math.*;
import java.util.stream.*;
import java.util.function.*;

public class NumbersEx {

    static int[] first10Numbers() {
        return IntStream.iterate(1, i -> i + 1).limit(10).toArray();
    }

    static int[] first10SquareNumbers() {
        return IntStream.iterate(1,i -> i+1).limit(10).map(x->x*x).toArray();
    }


    static boolean isSquareNumber(int n) {
        int i;
        for (i = 1; i * i < n; i++);
        return i * i == n;
    }

    static long countSquareNumbersBelowOrEqual1000000() {
        long c = IntStream.iterate(1,i -> i+1).limit(1000000).filter(i->isSquareNumber(i)).count();
        return c;
    }

    static  Map<Integer, Long> countSquareNumberBelowOrEqual1000000ByLastDigit(){
        Map<Integer, Long> mc;
        mc = IntStream.iterate(20,i ->i+1).takeWhile(i -> i< 40)
                .filter(i -> i%2==0)
                .boxed()
                .collect(Collectors.groupingBy( i -> i.intValue()%10, Collectors.counting()));
        return mc;
    }


    static int sevenDigitSquareNumberWithMostDistinctDigits() {
        return 1;
    }





    public static void main(String[] args) {
        System.out.println("First 10 numbers: "
                + Arrays.toString(first10Numbers()));

        System.out.println("First 10 square numbers: "
                + Arrays.toString(first10SquareNumbers()));

        System.out.println("Count square numbers below or equal to "
                + "1,000,000: "
                + countSquareNumbersBelowOrEqual1000000());

        System.out.println("Count square numbers below or equal to "
                + "1,000,000 grouped by last digit: "
                + countSquareNumberBelowOrEqual1000000ByLastDigit());

        System.out.println("Seven-digit square numbers "
                + "with most distinct digits:" +" "+ sevenDigitSquareNumberWithMostDistinctDigits());
    }
}