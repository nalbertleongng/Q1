import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class LineCountByThreadPool {

	private static long count;

	public static long countLine(Path p) {
		try {
			return Files.readAllLines(p).stream()
					.filter(line -> !line.isEmpty()).count();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static synchronized void addCount(long c) {
		count += c;
	}

	public static void main(String args[]) {



		int n = Integer.parseInt(args[1]);
		ExecutorService executor = Executors.newFixedThreadPool(n);

		long startTime = System.currentTimeMillis();
		try {
			Files.walk(Paths.get(args[0]))
					.filter(Files::isRegularFile)
					.filter(p -> p.toString().endsWith(".java"))
					.forEach(p -> executor.execute(() -> addCount(countLine(p))));
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}

		executor.shutdown();

		try {
			executor.awaitTermination(300, TimeUnit.SECONDS);
		}
		catch (InterruptedException ex) {
		}
		long duration = System.currentTimeMillis() - startTime;

		System.out.println("Total number of non-empty lines: "+count);
		System.out.println("Execution time: "+duration);
	}

}