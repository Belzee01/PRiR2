import java.util.Random;

public class PointGenerator implements PointGeneratorInterface {

    private static int xTotal = 0;
    private static int yTotal = 0;

    @Override
    public Point2D getPoint() {
        try {
            Thread.sleep(201);
        } catch (InterruptedException ignored) {
        }
        Random rand = new Random();
        int x = rand.nextInt(MAX_POSITION);
        xTotal += x;
        int y = rand.nextInt(MAX_POSITION);
        yTotal += y;


        System.out.println("Sum points: " + x);
//        System.out.println("Sum points: " + y);
//        System.out.println("Sum points: " + xTotal);
//        System.out.println("Sum points: " + yTotal);

        return new Point2D(x, y);
    }
}
