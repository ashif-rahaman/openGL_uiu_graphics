/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.stack;

import core.vector.Vector;
import core.vector.VectorUtil;
import java.util.Arrays;

/**
 * @author ashif
 */
public class MatrixMaker {

    //identity matrix
    //Tested
    public static TrMatrix identityMatrix() {

        TrMatrix trMatrix = new TrMatrix();

        for (int i = 0; i < 4; i++) {

            Arrays.fill(trMatrix.matrix[i], 0.0);
        }

        for (int i = 0; i < 4; i++) {

            trMatrix.matrix[i][i] = 1;
        }

        return trMatrix;
    }

    //translation matrix
    //Tested
    public static TrMatrix translationMatrix(double tx, double ty, double tz) {

        TrMatrix trMatrix = new TrMatrix();

        for (int i = 0; i < 4; i++) {

            Arrays.fill(trMatrix.matrix[i], 0.0);
        }

        for (int i = 0; i < 4; i++) {

            trMatrix.matrix[i][i] = 1;
        }

        trMatrix.matrix[0][3] = tx;
        trMatrix.matrix[1][3] = ty;
        trMatrix.matrix[2][3] = tz;

        return trMatrix;
    }

    //scalling matrix
    //tested
    public static TrMatrix scaleMatrix(double sx, double sy, double sz) {

        TrMatrix trMatrix = new TrMatrix();

        for (int i = 0; i < 4; i++) {

            Arrays.fill(trMatrix.matrix[i], 0.0);
        }

        trMatrix.matrix[0][0] = sx;
        trMatrix.matrix[1][1] = sy;
        trMatrix.matrix[2][2] = sz;
        trMatrix.matrix[3][3] = 1.0;

        return trMatrix;
    }

    //Rotation matrix
    public static TrMatrix rotationMatrix(double angle, double x, double y, double z) {
        TrMatrix trMatrix = new TrMatrix();

        Vector v = new Vector();
        Vector unitVector = new Vector();

        unitVector.vector[0] = 0;
        unitVector.vector[1] = 0;
        unitVector.vector[2] = 0;

        v.vector[0] = x;
        v.vector[1] = y;
        v.vector[2] = z;

        Vector c1, c2, c3;

        v = VectorUtil.normalize(v);

        unitVector.vector[0] = 1;
        c1 = VectorUtil.getRodrigues(unitVector, v, angle);
        unitVector.vector[0] = 0;

        unitVector.vector[1] = 1;
        c2 = VectorUtil.getRodrigues(unitVector, v, angle);
        unitVector.vector[1] = 0;

        unitVector.vector[2] = 1;
        c3 = VectorUtil.getRodrigues(unitVector, v, angle);
        unitVector.vector[2] = 0;

        for (int i = 0; i < 4; i++) {

            Arrays.fill(trMatrix.matrix[i], 0.0);
        }
        trMatrix.matrix[3][3] = 1;

        trMatrix.matrix[0][0] = c1.vector[0];
        trMatrix.matrix[0][1] = c2.vector[0];
        trMatrix.matrix[0][2] = c3.vector[0];

        trMatrix.matrix[1][0] = c1.vector[1];
        trMatrix.matrix[1][1] = c2.vector[1];
        trMatrix.matrix[1][2] = c3.vector[1];

        trMatrix.matrix[2][0] = c1.vector[2];
        trMatrix.matrix[2][1] = c2.vector[2];
        trMatrix.matrix[2][2] = c3.vector[2];

        return trMatrix;
    }

    //Tested
    public static TrMatrix matrixProduct(TrMatrix m1, TrMatrix m2) {
        TrMatrix product = null;

        if (m1.matrix[0].length == m2.matrix.length) {

            product = new TrMatrix();
            double sum;
            for (int i = 0; i < m1.matrix.length; i++) {

                for (int j = 0; j < m2.matrix.length; j++) {

                    sum = 0;
                    for (int k = 0; k < m1.matrix[i].length; k++) {

                        sum += m1.matrix[i][k] * m2.matrix[k][j];
                    }

                    product.matrix[i][j] = sum;
                }
            }
        }

        return product;
    }

    public static Point pointMatrixProduct(TrMatrix m, Point p) {

        Point product = new Point(0, 0, 0);

        for (double[] matrix : m.matrix) {

            for (int j = 0; j < p.point.length; j++) {

            }
        }

        product.point[0]
                = m.matrix[0][0] * p.point[0]
                + m.matrix[0][1] * p.point[1]
                + m.matrix[0][2] * p.point[2]
                + m.matrix[0][3] * p.point[3];

        product.point[1]
                = m.matrix[1][0] * p.point[0]
                + m.matrix[1][1] * p.point[1]
                + m.matrix[1][2] * p.point[2]
                + m.matrix[1][3] * p.point[3];

        product.point[2]
                = m.matrix[2][0] * p.point[0]
                + m.matrix[2][1] * p.point[1]
                + m.matrix[2][2] * p.point[2]
                + m.matrix[2][3] * p.point[3];

        product.point[3]
                = m.matrix[3][0] * p.point[0]
                + m.matrix[3][1] * p.point[1]
                + m.matrix[3][2] * p.point[2]
                + m.matrix[3][3] * p.point[3];
        return product;
    }

}
