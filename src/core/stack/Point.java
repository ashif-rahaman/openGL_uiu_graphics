/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.stack;

/**
 *
 * @author ashif
 */
public class Point {

    public double[] point = new double[4];

    public Point(double x, double y, double z) {

        point[0] = x;
        point[1] = y;
        point[2] = z;
        point[3] = 1;
    }

    public void scale() {

        point[0] /= point[3];
        point[1] /= point[3];
        point[2] /= point[3];
        point[3] /= point[3];
    }

    @Override
    public String toString() {
        return "" + point[0] + " " + point[1] + " " + point[2];
    }
}
