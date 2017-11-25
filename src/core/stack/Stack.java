/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.stack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ashif
 */
public class Stack {

    private List<TrMatrix> matrixes = new ArrayList<>();
    private List<Integer> pushArray = new ArrayList<>();

    private int pp = 0;
    private int sp = 0;

    public Stack() {
    }

    //pop 4x4 matrix from stack
    public TrMatrix pop() {

        if (sp == 1) {

            return matrixes.get(sp - 1);
        }

        if (sp > 0) {

            sp--;
            return matrixes.remove(sp);
        }

        return null;
    }

    //push 4x4 matrix to stack
    public void push(TrMatrix matrix) {
        matrixes.add(matrix);
        sp++;
    }

    public TrMatrix top() {

        if (sp > 0) {

            return matrixes.get(sp - 1);
        }

        return null;
    }

    public void pushPointer() {

        pushArray.add(sp);
        pp++;
    }

    public void popPointer() {

        if (pp > 0) {

            pp--;
            int n = pushArray.remove(pp);

            for (sp--; sp > n; sp--) {

                matrixes.remove(sp);
            }
        }
    }

    public void printMatrix(TrMatrix m) {

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                System.out.print(m.matrix[i][j] + " ");
            }

            System.out.println();
            System.out.println();
        }
    }
}
