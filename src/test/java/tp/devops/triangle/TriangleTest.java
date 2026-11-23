package tp.devops.triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TriangleTest {

    @Test
    void equilateral() {
        assertEquals(Triangle.Type.EQUILATERAL, Triangle.classify(2, 2, 2));
    }

    @Test
    void isosceles() {
        assertEquals(Triangle.Type.ISOSCELES, Triangle.classify(2, 2, 3));
    }

    @Test
    void scalene() {
        assertEquals(Triangle.Type.SCALENE, Triangle.classify(3, 4, 5));
    }

    @Test
    void invalidWhenASideIsZeroOrNegative() {
        assertEquals(Triangle.Type.INVALID, Triangle.classify(0, 4, 5));
        assertEquals(Triangle.Type.INVALID, Triangle.classify(-1, 4, 5));
    }

    @Test
    void invalidWhenTriangleInequalityFails() {
        assertEquals(Triangle.Type.INVALID, Triangle.classify(1, 2, 3));
    }
}
