import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Demo3 {

    private static long count;

    public static long countLine(Path p) {
        try {
            return Files.readAllLines(p).stream()
                    .filter(line -> !line.isEmpty()).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void LineCountByParallelStream(String pathName){
        try {
            long c = Files.walk(Paths.get(pathName))
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java"))
                    .parallel()
                   .mapToLong(Demo3::countLine)
//                    .filter(line ->!line.isEmpty()).count()
                    .sum();
            System.out.println(c);
        } catch (IOException ioe) {
            ioe.printStackTrace();

    }


    }


        public static void main (String args[]){
        Demo3 a1 = new Demo3();
            a1.LineCountByParallelStream("jdksrc2");
        }
    }


