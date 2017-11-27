/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import core.stack.MatrixMaker;
import core.stack.Point;
import core.stack.Stack;
import core.stack.TrMatrix;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ashif
 */
public class Main {

    public static void main(String[] args) {

        // The name of the file to open.
        String path = "C:\\Users\\Ashifur\\Desktop\\Graphics\\Assignment_2\\Assignment_2\\test cases\\1";

        String scene = path + "scene.txt";
        String stage1 = path + "stage1.txt";

        String[] first4lines = new String[4];
        Point inputPoints = new Point(0, 0, 0);
        Point outputPoints = new Point(0, 0, 0);
        Stack stack = new Stack();

        FileReader sceneFileReader = null;
        FileWriter stage1FileWriter = null;

        BufferedReader sceneBufferedReader = null;
        BufferedWriter stage1BufferedWriter = null;

        stack.push(MatrixMaker.identityMatrix());

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            sceneFileReader = new FileReader(scene);
            stage1FileWriter = new FileWriter(stage1);

            // Always wrap FileReader in BufferedReader.
            sceneBufferedReader = new BufferedReader(sceneFileReader);
            stage1BufferedWriter = new BufferedWriter(stage1FileWriter);

            first4lines[0] = sceneBufferedReader.readLine();
            first4lines[1] = sceneBufferedReader.readLine();
            first4lines[2] = sceneBufferedReader.readLine();
            first4lines[3] = sceneBufferedReader.readLine();

            boolean stop = false;
            double angle;
            TrMatrix stackTop, trMatrix;
            while ((line = sceneBufferedReader.readLine()) != null && !stop) {

                switch (line) {

                    case "triangle":

                        line = sceneBufferedReader.readLine();
                        inputPoints.point[0] = Double.parseDouble(line.split(" ")[0]);
                        inputPoints.point[1] = Double.parseDouble(line.split(" ")[1]);
                        inputPoints.point[2] = Double.parseDouble(line.split(" ")[2]);

                        outputPoints = MatrixMaker.pointMatrixProduct(stack.top(), inputPoints);
                        outputPoints.scale();

                        stage1BufferedWriter.write(outputPoints.toString());
                        stage1BufferedWriter.newLine();

                        line = sceneBufferedReader.readLine();
                        inputPoints.point[0] = Double.parseDouble(line.split(" ")[0]);
                        inputPoints.point[1] = Double.parseDouble(line.split(" ")[1]);
                        inputPoints.point[2] = Double.parseDouble(line.split(" ")[2]);

                        outputPoints = MatrixMaker.pointMatrixProduct(stack.top(), inputPoints);
                        outputPoints.scale();

                        stage1BufferedWriter.write(outputPoints.toString());
                        stage1BufferedWriter.newLine();

                        line = sceneBufferedReader.readLine();
                        inputPoints.point[0] = Double.parseDouble(line.split(" ")[0]);
                        inputPoints.point[1] = Double.parseDouble(line.split(" ")[1]);
                        inputPoints.point[2] = Double.parseDouble(line.split(" ")[2]);

                        outputPoints = MatrixMaker.pointMatrixProduct(stack.top(), inputPoints);
                        outputPoints.scale();

                        stage1BufferedWriter.write(outputPoints.toString());
                        stage1BufferedWriter.newLine();

                        stage1BufferedWriter.newLine();

                        break;

                    case "translate":

                        line = sceneBufferedReader.readLine();
                        inputPoints.point[0] = Double.parseDouble(line.split(" ")[0]);
                        inputPoints.point[1] = Double.parseDouble(line.split(" ")[1]);
                        inputPoints.point[2] = Double.parseDouble(line.split(" ")[2]);

                        trMatrix = MatrixMaker.translationMatrix(
                                inputPoints.point[0],
                                inputPoints.point[1],
                                inputPoints.point[2]);

                        trMatrix = MatrixMaker.matrixProduct(stack.top(), trMatrix);
                        stack.push(trMatrix);
                        break;

                    case "scale":

                        line = sceneBufferedReader.readLine();
                        inputPoints.point[0] = Double.parseDouble(line.split(" ")[0]);
                        inputPoints.point[1] = Double.parseDouble(line.split(" ")[1]);
                        inputPoints.point[2] = Double.parseDouble(line.split(" ")[2]);

                        trMatrix = MatrixMaker.scaleMatrix(
                                inputPoints.point[0],
                                inputPoints.point[1],
                                inputPoints.point[2]);

                        trMatrix = MatrixMaker.matrixProduct(stack.top(), trMatrix);
                        stack.push(trMatrix);
                        break;

                    case "rotate":

                        line = sceneBufferedReader.readLine();
                        angle = Double.parseDouble(line.split(" ")[0]);
                        inputPoints.point[0] = Double.parseDouble(line.split(" ")[1]);
                        inputPoints.point[1] = Double.parseDouble(line.split(" ")[2]);
                        inputPoints.point[2] = Double.parseDouble(line.split(" ")[3]);

                        trMatrix = MatrixMaker.rotationMatrix(
                                angle,
                                inputPoints.point[0],
                                inputPoints.point[1],
                                inputPoints.point[2]);

                        trMatrix = MatrixMaker.matrixProduct(stack.top(), trMatrix);
                        stack.push(trMatrix);
                        break;

                    case "push":
                        stack.pushPointer();
                        break;

                    case "pop":
                        stack.popPointer();
                        break;

                    case "end":
                        stop = true;
                        break;
                }
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {

            try {

                if (sceneFileReader != null) {

                    sceneFileReader.close();
                }
                if (sceneBufferedReader != null) {

                    sceneBufferedReader.close();
                }

                if (stage1FileWriter != null) {

                    stage1FileWriter.close();
                }
                if (stage1BufferedWriter != null) {

                    stage1BufferedWriter.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
