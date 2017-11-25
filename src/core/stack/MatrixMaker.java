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

    public static TrMatrix matrixProduct(TrMatrix m1, TrMatrix m2) {
        TrMatrix product = new TrMatrix();

        //row 1
        product.matrix[0][0]
                = m1.matrix[0][0] * m2.matrix[0][0]
                + m1.matrix[0][1] * m2.matrix[1][0]
                + m1.matrix[0][2] * m2.matrix[2][0]
                + m1.matrix[0][3] * m2.matrix[3][0];

        product.matrix[0][1]
                = m1.matrix[0][0] * m2.matrix[0][1]
                + m1.matrix[0][1] * m2.matrix[1][1]
                + m1.matrix[0][2] * m2.matrix[2][1]
                + m1.matrix[0][3] * m2.matrix[3][1];

        product.matrix[0][2]
                = m1.matrix[0][0] * m2.matrix[0][2]
                + m1.matrix[0][1] * m2.matrix[1][2]
                + m1.matrix[0][2] * m2.matrix[2][2]
                + m1.matrix[0][3] * m2.matrix[3][2];

        product.matrix[0][3]
                = m1.matrix[0][0] * m2.matrix[0][3]
                + m1.matrix[0][1] * m2.matrix[1][3]
                + m1.matrix[0][2] * m2.matrix[2][3]
                + m1.matrix[0][3] * m2.matrix[3][3];

        //row 2
        product.matrix[1][0]
                = m1.matrix[1][0] * m2.matrix[0][0]
                + m1.matrix[1][1] * m2.matrix[1][0]
                + m1.matrix[1][2] * m2.matrix[2][0]
                + m1.matrix[1][3] * m2.matrix[3][0];

        product.matrix[1][1]
                = m1.matrix[1][0] * m2.matrix[0][1]
                + m1.matrix[1][1] * m2.matrix[1][1]
                + m1.matrix[1][2] * m2.matrix[2][1]
                + m1.matrix[1][3] * m2.matrix[3][1];

        product.matrix[1][2]
                = m1.matrix[1][0] * m2.matrix[0][2]
                + m1.matrix[1][1] * m2.matrix[1][2]
                + m1.matrix[1][2] * m2.matrix[2][2]
                + m1.matrix[1][3] * m2.matrix[3][2];

        product.matrix[1][3]
                = m1.matrix[1][0] * m2.matrix[0][3]
                + m1.matrix[1][1] * m2.matrix[1][3]
                + m1.matrix[1][2] * m2.matrix[2][3]
                + m1.matrix[1][3] * m2.matrix[3][3];

        //row 3
        product.matrix[2][0]
                = m1.matrix[2][0] * m2.matrix[0][0]
                + m1.matrix[2][1] * m2.matrix[1][0]
                + m1.matrix[2][2] * m2.matrix[2][0]
                + m1.matrix[2][3] * m2.matrix[3][0];

        product.matrix[2][1]
                = m1.matrix[2][0] * m2.matrix[0][1]
                + m1.matrix[2][1] * m2.matrix[1][1]
                + m1.matrix[2][2] * m2.matrix[2][1]
                + m1.matrix[2][3] * m2.matrix[3][1];

        product.matrix[2][2]
                = m1.matrix[2][0] * m2.matrix[0][2]
                + m1.matrix[2][1] * m2.matrix[1][2]
                + m1.matrix[2][2] * m2.matrix[2][2]
                + m1.matrix[2][3] * m2.matrix[3][2];

        product.matrix[2][3]
                = m1.matrix[2][0] * m2.matrix[0][3]
                + m1.matrix[2][1] * m2.matrix[1][3]
                + m1.matrix[2][2] * m2.matrix[2][3]
                + m1.matrix[2][3] * m2.matrix[3][3];

        //row 4
        product.matrix[3][0]
                = m1.matrix[3][0] * m2.matrix[0][0]
                + m1.matrix[3][1] * m2.matrix[1][0]
                + m1.matrix[3][2] * m2.matrix[2][0]
                + m1.matrix[3][3] * m2.matrix[3][0];

        product.matrix[3][1]
                = m1.matrix[3][0] * m2.matrix[0][1]
                + m1.matrix[3][1] * m2.matrix[1][1]
                + m1.matrix[3][2] * m2.matrix[2][1]
                + m1.matrix[3][3] * m2.matrix[3][1];

        product.matrix[3][2]
                = m1.matrix[3][0] * m2.matrix[0][2]
                + m1.matrix[3][1] * m2.matrix[1][2]
                + m1.matrix[3][2] * m2.matrix[2][2]
                + m1.matrix[3][3] * m2.matrix[3][2];

        product.matrix[3][3]
                = m1.matrix[3][0] * m2.matrix[0][3]
                + m1.matrix[3][1] * m2.matrix[1][3]
                + m1.matrix[3][2] * m2.matrix[2][3]
                + m1.matrix[3][3] * m2.matrix[3][3];

        return product;
    }

    public static Point pointMatrixProduct(TrMatrix m, Point p) {

        Point product = new Point(0, 0, 0);

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
