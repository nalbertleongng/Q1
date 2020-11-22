import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;



public class NotionDemo2 {

    static boolean isSquareNumber(int n) {
        int i;
        for (i = 1; i * i < n; i++) {
        }
        return i * i == n;
    }


    public static void main(String args[]) {

        IntStream iStream = DoubleStream.generate(Math::random)
                .mapToInt(d -> (int)(d*1000)+1 )
                .limit(0);
        // iStream.forEach(System.out::println);

        Optional<Integer> oi = iStream.boxed()
                .peek(System.out::println)
                .max( (a,b) -> {return a-b;} );
        System.out.println();
        System.out.println( oi.orElse(-1) );



        Integer x1 = Integer.valueOf(12344321);
        Integer x2 = Integer.valueOf(12345678);

        x2.toString().chars().forEach(System.out::println);
        System.out.println();

        x2.toString().chars().forEach(i->System.out.println((char)i));
        System.out.println();

        x2.toString().chars().distinct().forEach(i->System.out.println((char)i));
        System.out.println();

        long c1 = x2.toString().chars().distinct().count();
        System.out.println(c1);
        System.out.println();

    }
}