package tp.devops.triangle;

/** Usage: java -jar triangle.jar a b c */
public final class App {

    private App() {
    }

    public static void main(String[] args) {
        double[] sides = {3, 4, 5};
        if (args.length == 3) {
            for (int i = 0; i < 3; i++) {
                sides[i] = Double.parseDouble(args[i]);
            }
        }
        System.out.printf("Triangle (%s, %s, %s): %s%n", sides[0], sides[1], sides[2],
                Triangle.classify(sides[0], sides[1], sides[2]));
    }
}
