import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        ParallelCalculations calculations = new ParallelCalculations();

        calculations.setNumberOfThreads(2);
        calculations.setPointGenerator(new PointGenerator());
        calculations.createThreads();

        System.out.println("Current sum value: " + calculations.getSum());

        calculations.start();

        try {
            Thread.sleep(2_100);
            calculations.suspend();

            System.out.println("Sum: " + calculations.getSum());

            Thread.sleep(500);
            System.out.println("Suspended");
            Thread[] threads = calculations.getThreads();
            Stream.of(threads).forEach(t -> System.out.println(t.getName() + " : " + t.getState()));

            Thread.sleep(3_000);
            calculations.resume();
            System.out.println("Running");

            Thread.sleep(500);
            threads = calculations.getThreads();
            Stream.of(threads).forEach(t -> System.out.println(t.getName() + " : " + t.getState()));

            Thread.sleep(4_100);
            calculations.terminate();
            Thread.sleep(1200);

            threads = calculations.getThreads();
            Stream.of(threads).forEach(t -> System.out.println(t.getName() + " : " + t.getState()));

            System.out.println("After calc sum value: " + calculations.getSum());
        } catch (InterruptedException ignored) {

        }
    }
}
