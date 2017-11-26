/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import core.vector.Vector;

/**
 *
 * @author Ashifur
 */
public class TestMain {

    public static void main(String[] args) {

        Vector vector1 = new Vector();
        vector1.vector[0] = -3;
        vector1.vector[1] = 5;
        vector1.vector[2] = 7;

        Vector vector2 = new Vector();
        vector2.vector[0] = 3;
        vector2.vector[1] = 1;
        vector2.vector[2] = 8;

        /**
         * ***********************************************************
         * Test of vector normalization
         *
         * ***********************************************************
         */
        /*
        vector1 = VectorUtil.normalize(vector1);
        System.out.println(vector1.vector[0] + " " + vector1.vector[1] + " " + vector1.vector[2]);

        vector2 = VectorUtil.normalize(vector2);
        System.out.println(vector2.vector[0] + " " + vector2.vector[1] + " " + vector2.vector[2]);
         */
        /**
         * ***********************************************************
         * dot product tested
         *
         * ***********************************************************
         */
        /*
        System.out.println(VectorUtil.dotProduct(vector1, vector2));
         */
        /**
         * ***********************************************************
         * Cross product test
         *
         * ***********************************************************
         */
        /*
        vector1 = VectorUtil.crossProduct(vector1, vector2);
        System.out.println(vector1.vector[0] + " " + vector1.vector[1] + " " + vector1.vector[2]);
         */
        /**
         * ***********************************************************
         * Identity Matrix testing
         *
         *************************************************************
         */
        /*
        TrMatrix trMatrix = MatrixMaker.identityMatrix();

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                System.out.print(trMatrix.matrix[i][j] + " ");
            }
            System.out.println("");
        }
         */
        /**
         * ***********************************************************
         * Translation Matrix testing
         *
         * ***********************************************************
         */
        /*
        TrMatrix trMatrix = MatrixMaker.translationMatrix(2, 8, 10);

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                System.out.print(trMatrix.matrix[i][j] + " ");
            }
            System.out.println("");
        }
         */
        /**
         * ***********************************************************
         * Scaling Matrix testing
         *
         * ***********************************************************
         */
        /*
        TrMatrix trMatrix = MatrixMaker.scaleMatrix(6, 4, 3);

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                System.out.print(trMatrix.matrix[i][j] + " ");
            }
            System.out.println("");
        }
         */
        /**
         * ***********************************************************
         * Matrix multiplication testing
         *
         * ***********************************************************
         */
        /*
        TrMatrix trMatrix1 = new TrMatrix();
        TrMatrix trMatrix2 = new TrMatrix();

        Random random = new Random();
        int dimension = 4;

        //genetaring matrix 1
        for (int i = 0; i < dimension; i++) {

            for (int j = 0; j < dimension; j++) {

                trMatrix1.matrix[i][j] = random.nextDouble();
            }
        }

        //generatng matrix 2
        for (int i = 0; i < dimension; i++) {

            for (int j = 0; j < dimension; j++) {

                trMatrix2.matrix[i][j] = random.nextDouble();
            }
        }

        //Prnting first (1st) generated matrix
        System.out.println("Matrix 1: \n____________________________________________");

        for (int i = 0; i < dimension; i++) {

            for (int j = 0; j < dimension; j++) {

                System.out.format("%15.10f", trMatrix1.matrix[i][j]);
            }

            System.out.println();
        }

        //printing second (2nd) generated matrix
        System.out.println("\nMatrix 2: \n__________________________________________");

        for (int i = 0; i < dimension; i++) {

            for (int j = 0; j < dimension; j++) {

                System.out.format("%15.10f", trMatrix2.matrix[i][j]);
            }

            System.out.println();
        }

        //multiplying two matrix
        TrMatrix mulMatrix = null;
        mulMatrix = MatrixMaker.matrixProduct(trMatrix1, trMatrix2);

        System.out.println("\n Multiplied Matrix: \n__________________________________________");
        if (mulMatrix != null) {

            for (int i = 0; i < dimension; i++) {

                for (int j = 0; j < dimension; j++) {

                    System.out.format("%15.10f", mulMatrix.matrix[i][j]);
                }

                System.out.println();
            }
        }
         */
    }

}
