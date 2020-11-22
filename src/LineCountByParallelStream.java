import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class LineCountByParallelStream{

	private static long count;

	public static long countLine(Path p) {
		try {
			return Files.readAllLines(p).stream()
					.filter(line -> !line.isEmpty()).count();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();


		try{
			count = Files.walk(Paths.get(args[0]))
					.filter(Files::isRegularFile)
					.filter(p -> p.toString().endsWith(".java"))
					.parallel()
					.mapToLong(LineCountByParallelStream::countLine)
					.sum();


		}catch(IOException ioe){
			ioe.printStackTrace();
		}


		long duration = System.currentTimeMillis() - startTime;

		System.out.println("Total number of non-empty lines: "+count);
		System.out.println("Execution time: "+duration);
	}

}

