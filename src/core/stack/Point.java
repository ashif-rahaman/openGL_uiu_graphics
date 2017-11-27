/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.stack;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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

    public static Point getPoint(String p) {
        double x, y, z;
        x = Double.parseDouble(p.split(" ")[0]);
        y = Double.parseDouble(p.split(" ")[1]);
        z = Double.parseDouble(p.split(" ")[2]);
        Point point = new Point(x, y, z);

        return point;
    }

    @Override
    public String toString() {

        NumberFormat formatter = new DecimalFormat("#0.0000000");

        return "" + formatter.format(point[0]) + " " + formatter.format(point[1]) + " " + formatter.format(point[2]);
    }
}
