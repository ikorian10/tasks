import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try (Scanner ellipse = new Scanner(new File(args[0]));
             Scanner points = new Scanner(new File(args[1]))) {
            pointsEllipse(ellipse, points);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pointsEllipse(Scanner ellipse, Scanner points) {
        StringBuilder result = new StringBuilder();
        BigDecimal x0 = new BigDecimal(ellipse.next());
        BigDecimal y0 = new BigDecimal(ellipse.next());
        BigDecimal a = new BigDecimal(ellipse.next());
        BigDecimal b = new BigDecimal(ellipse.next());
        BigDecimal aq = a.multiply(a);
        BigDecimal bq = b.multiply(b);
        while (points.hasNext()) {
            BigDecimal x = new BigDecimal(points.next());
            BigDecimal y = new BigDecimal(points.next());
            BigDecimal dx = x.subtract(x0);
            BigDecimal dy = y.subtract(y0);
            BigDecimal l = dx.multiply(dx).multiply(bq).add(dy.multiply(dy).multiply(aq));
            BigDecimal r = aq.multiply(bq);
            int compare = l.compareTo(r);
            if (compare == 0) {
                result.append("0\n");
            } else if (compare > 0) {
                result.append("2\n");
            } else {
                result.append("1\n");
            }
        }
        System.out.print(result);
    }
}
