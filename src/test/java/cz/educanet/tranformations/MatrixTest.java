package cz.educanet.tranformations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private IMatrix a;
    private IMatrix b;
    private IMatrix c;
    private IMatrix d;
    private IMatrix empty;

    @Before
    public void setUp() throws Exception {
        double[][] rawA = {
                {1, 1, 1},
                {1, 1, 1},
        };
        a = MatrixFactory.create(rawA);

        double[][] rawB = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        b = MatrixFactory.create(rawB);
        double[][] rawC = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        c = MatrixFactory.create(rawC);

        double[][] rawEmpty = {};
        empty = MatrixFactory.create(rawEmpty);

        double[][] rawD = {
                {1, 1}
        };
        d = MatrixFactory.create(rawD);
    }

    @Test
    public void getRows() {
        assertEquals(2, a.getRows());
        assertEquals(3, b.getRows());
        assertEquals(3, c.getRows());
        assertEquals(0, empty.getRows());
    }

    @Test
    public void getColumns() {
        assertEquals(3, a.getColumns());
        assertEquals(3, b.getColumns());
        assertEquals(3, c.getColumns());
        assertEquals(0, empty.getColumns());
        assertEquals(2, d.getColumns());
    }

    @Test
    public void times() {
        double[][] test = {
                {22.0, 28.0},
                {49.0, 64.0},
        };

        IMatrix testMatrix = MatrixFactory.create(test);
        IMatrix finalMatrix = c.times(a);

        for (int i = 0; i < test.length; i++){
            for (int j = 0; j < test[i].length;j++){
                assertEquals(testMatrix.get(i,j), finalMatrix.get(i,j), 0.05);
            }
        }
    }

    @Test
    public void timesScalar() {
        double[][] test = {
                {5.0, 5.0, 5.0},
                {5.0, 5.0, 5.0},
        };
        IMatrix testMatrix = MatrixFactory.create(test);
        IMatrix finalMatrix = a.times(5.0);


        for (int i = 0; i < test.length; i++){
            for (int j = 0; j < test[i].length; j++){
                assertEquals(testMatrix.get(i, j), finalMatrix.get(i,j), 0.05);
            }
        }
    }

    @Test
    public void add() {
        double[][] testAdd = {
                {2, 1, 1},
                {1, 1, 1},
                {0, 0, 1},
        };

        assertEquals(testAdd, b.add(c));
    }

    @Test
    public void get() {
        assertEquals(1, a.get(1,0), 1);
    }

    @Test
    public void transpose() {
    }

    @Test
    public void determinant() {
    }
}
