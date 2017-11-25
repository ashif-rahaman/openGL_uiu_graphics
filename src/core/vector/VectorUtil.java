/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.vector;

import java.text.DecimalFormat;

/**
 *
 * @author ashif
 */
public class VectorUtil {

    public static double dotProduct(Vector v1, Vector v2) {

        double dot = v1.vector[0] * v2.vector[0] + v1.vector[1] * v2.vector[1] + v1.vector[2] * v2.vector[2];

        return dot;
    }

    public static Vector crossProduct(Vector v1, Vector v2) {
        Vector cross = new Vector();

        cross.vector[0] = v1.vector[1] * v2.vector[2] - v1.vector[2] * v2.vector[1];
        cross.vector[1] = v1.vector[2] * v2.vector[0] - v1.vector[0] * v2.vector[2];
        cross.vector[2] = v1.vector[0] * v2.vector[1] - v1.vector[1] * v2.vector[0];

        return cross;
    }

    public static Vector normalize(Vector v) {

        Vector norm = new Vector();
        double dNom = Math.sqrt(v.vector[0] * v.vector[0] + v.vector[1] * v.vector[1] + v.vector[2] * v.vector[2]);

        norm.vector[0] = v.vector[0] / dNom;
        norm.vector[1] = v.vector[1] / dNom;
        norm.vector[2] = v.vector[2] / dNom;

        return norm;
    }

    public static Vector scaleVector(Vector v, double s) {

        Vector resVector = new Vector();

        resVector.vector[0] = v.vector[0] * s;
        resVector.vector[1] = v.vector[1] * s;
        resVector.vector[2] = v.vector[2] * s;

        return resVector;
    }

    public static Vector getRodrigues(Vector x, Vector a, double angle) {

        Vector rodVector;

        Vector v1, v2, v3;

        Vector cross = crossProduct(a, x);
        double dot = dotProduct(a, x);

        DecimalFormat df = new DecimalFormat("#.####");

        double cosTheta = Double.parseDouble(df.format(Math.cos(angle)));
        double sinTheta = Double.parseDouble(df.format(Math.sin(angle)));;

        v1 = scaleVector(x, cosTheta);
        v2 = scaleVector(a, (1 - cosTheta) * dot);
        v3 = scaleVector(cross, sinTheta);

        rodVector = addVector(v1, addVector(v2, v3));

        return rodVector;
    }

    public static Vector addVector(Vector v1, Vector v2) {
        Vector v = new Vector();

        v.vector[0] = v1.vector[0] + v2.vector[0];
        v.vector[1] = v1.vector[1] + v2.vector[1];
        v.vector[2] = v1.vector[2] + v2.vector[2];

        return v;
    }

    public VectorUtil() {
    }
}
