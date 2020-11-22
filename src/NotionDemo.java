import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class NotionDemo {

    static boolean isSquareNumber(int n) {
        int i;
        for (i = 1; i * i < n; i++) {
        }
        return i * i == n;
    }


    public static void main(String args[]) {

        // iterate from 10, increase 1 each time
        // generate 20 numbers
        // for each item: process by println
        IntStream.iterate(10, i -> i+1).limit(20).forEach(System.out::println);
        System.out.println();

        // should be 20 too
        long c = IntStream.iterate(10, i -> i+1).limit(20).count();
        System.out.println(c);
        System.out.println();

        // use take while to set the upper bound of value generated (not number)
        // generated numbers are put to array
        int a[] = IntStream.iterate(10, i -> i+1).takeWhile(i -> i<26).toArray();

        // print using for loop
        for(int i=0; i<a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();

        // print using Arrays
        System.out.println(Arrays.toString(a));
        System.out.println();

        // print the square number below 1000
        IntStream.iterate(1, i -> i+1).takeWhile(i -> i<1000)
                .filter( i-> isSquareNumber(i) ).forEach(System.out::println);
        System.out.println();



        // get the even number between 20 (inclusive) and 40 (exclusive)
        IntStream.iterate(20, i -> i+1).takeWhile(i -> i<40)
                .filter(i -> i%2==0)
                .forEach(System.out::println);
        System.out.println();

        // how to group the numbers above
        // the output will be a Map<K, List<K>>
        // however K must be complex type
        // therefore, we need to convert the element above to Integer
        IntFunction<Integer> f = i -> Integer.valueOf(i);

        Stream<Integer> si;
        si = IntStream.iterate(20, i -> i+1).takeWhile(i -> i<40)
                .filter(i -> i%2==0)
                .mapToObj(f);
        si.forEach(System.out::println);	// output is similar, but it is now Integer objects
        System.out.println();

        // a easier version
        si = IntStream.iterate(20, i -> i+1).takeWhile(i -> i<40)
                .filter(i -> i%2==0)
                .boxed();
        si.forEach(System.out::println);
        System.out.println();


        // group by last digit
        Map<Integer, List<Integer>> m;
        m = IntStream.iterate(20, i -> i+1).takeWhile(i -> i<40)
                .filter(i -> i%2==0)
                .boxed()													// Stream<Integer>
                .collect(Collectors.groupingBy(i -> i.intValue()%10));		// Collect the Stream<Integer>
        System.out.println(m);

        // group by last digit and count
        Map<Integer, Long> mc;
        mc = IntStream.iterate(20, i -> i+1).takeWhile(i -> i<40)
                .filter(i -> i%2==0)
                .boxed()
                .collect(Collectors.groupingBy(i -> i.intValue()%10, Collectors.counting()));
        System.out.println(mc);                                      //  |<------counting----->|
    }
}