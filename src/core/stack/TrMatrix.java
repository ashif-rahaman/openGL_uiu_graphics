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
public class TrMatrix {

    public double[][] matrix = new double[4][4];

    public TrMatrix() {

    }

    @Override
    public String toString() {
        return "Matrix is: \n" + matrix[0][0] + ",  " + matrix[0][1] + ",  " + matrix[0][2] + ",  " + matrix[0][3] + "\n"
                + matrix[1][0] + ",  " + matrix[1][1] + ",  " + matrix[1][2] + ",  " + matrix[1][3] + "\n"
                + matrix[2][0] + ",  " + matrix[2][1] + ",  " + matrix[2][2] + ",  " + matrix[2][3] + "\n"
                + matrix[3][0] + ",  " + matrix[3][1] + ",  " + matrix[3][2] + ",  " + matrix[3][3] + "\n";
    }
}
