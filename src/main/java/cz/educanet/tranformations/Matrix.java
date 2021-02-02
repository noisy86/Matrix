package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        double[][] finalMatrix = new double[matrix.getRows() - rawArray.length + 1][rawArray[0].length - matrix.getColumns() + 1];


        for(int i = 0; i < finalMatrix.length; i++){
            for(int j = 0; j < rawArray.length; j++){
                for (int k = 0; k < rawArray[i].length; k++){
                    finalMatrix[i][j] += rawArray[i][k] * matrix.get(k,j);
                }
            }
        }
        return MatrixFactory.create(finalMatrix);
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] result = new double[rawArray.length][rawArray[0].length];

        for(int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                result[i][j] += rawArray[i][j] * (double) scalar;
            }
        }
        return MatrixFactory.create((result));
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] result = new double[matrix.getColumns()][matrix.getRows()];

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < 0; j++){
                result[i][j] = matrix.get(i,j) + rawArray[i][j];
            }
        }
        return MatrixFactory.create((result));
    }

    @Override
    public double get(int n, int m) {
        return rawArray[n][m];
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }
    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(rawArray, matrix.rawArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
