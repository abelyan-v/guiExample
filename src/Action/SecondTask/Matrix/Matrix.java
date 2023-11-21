package Action.SecondTask.Matrix;

import Action.SecondTask.Except.DivZero;
import Action.SecondTask.Except.InvalidSize;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Matrix {
    private int size = 1;
    private int[][] matrix;

    public Matrix(int s) throws InvalidSize {
        if (s > 1_000_000) {
            throw new InvalidSize();
        } else if (s <= 0) {
            throw new InvalidSize();
        }
        this.size = s;

        Random random = new Random();
        int maxValue = this.size ;
        int minValue = - this.size ;

        this.matrix = new int[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.matrix[i][j] = random.nextInt(maxValue - minValue) + minValue;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getElement(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return matrix[row][col];
        }
        return 0; // Возвращаем 0 в случае некорректных индексов
    }

    public void printMatrix(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {

            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    writer.write(this.matrix[i][j] + " ");
                }
                writer.write("\n");
            }
            writer.write("-------------------------------------\n");
        }
    }

    public void rotateAndDivideMatrix() throws DivZero {
        this.rotateMatrix();
        this.divideMatrix();
    }

    private void rotateMatrix() {
        int[][] temp = new int[this.size][this.size];

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                temp[j][i] = this.matrix[i][this.size - j - 1];
            }
        }
        for (int i = 0; i < this.size; i++) {
            System.arraycopy(temp[i], 0, this.matrix[i], 0, this.size);
        }

    }

    public void divideMatrix() throws DivZero {
        int[][] temp = new int[this.size][this.size];
        int sum;

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                sum = 0;

                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k != i || l != j) {
                            if (k >= 0 && k < this.size && l >= 0 && l < this.size) {
                                sum += this.matrix[k][l];
                            }
                        }
                    }
                }

                if (sum == 0) {
                    throw new DivZero();
                }
                temp[i][j] = this.matrix[i][j] / sum;
            }
        }

        for (int i = 0; i < this.size; i++) {
            System.arraycopy(temp[i], 0, this.matrix[i], 0, this.size);
        }
    }
}