package tp.devops.triangle;

/** Type of a triangle from the length of its three sides. */
public final class Triangle {

    public enum Type { EQUILATERAL, ISOSCELES, SCALENE, INVALID }

    private Triangle() {
    }

    public static Type classify(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            return Type.INVALID;
        }
        if (a == b && b == c) {
            return Type.EQUILATERAL;
        }
        if (a == b || b == c || a == c) {
            return Type.ISOSCELES;
        }
        return Type.SCALENE;
    }
}
