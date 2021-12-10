package library;

import java.io.*;

public class Functions {
    public static double distance(double[] p1, double[]p2){
        double result = 0;
        for (int i = 0; i < p1.length; i++){
            result += (p1[i] - p2[i])*(p1[i] - p2[i]);
        }
        result = Math.sqrt(result);
        return result;
    }

    public static <T> int matrixType(T[][] M){
        if (M.length <= 1){
            return -1;
        }
        for (int i = 0; i < M.length - 1; i++){
            if (M[i].length != M[i+1].length){
                return 0;
            }
        }
        if (M.length == M[0].length){
            return 2;
        }
        return 1;
    }

    public static <T> T[][] transpose(T[][] M){
        if (matrixType(M) != 1 && matrixType(M) != 2){
            return null;
        }
        T[][] m = (T[][]) new Object[M[0].length][M.length];
        for (int i = 0; i < M.length; i++){
            for (int j = 0; j < M[i].length; j++){
                m[j][i] = M[i][j];
            }
        }
        return m;
    }

    public static Integer[][] spiral(int N){
        Integer[][] s = new Integer[N][N];
        int value = N*N; int minCol = 0; int maxCol = N-1; int minRow = 0; int maxRow = N-1;
        while(value > 0){
            for (int i = minRow; i <= maxRow; i++){
                s[i][minCol] = value;
                value--;
            }
            for (int i = minCol+1; i <= maxCol; i++){
                s[maxRow][i] = value;
                value--;
            }
            for (int i = maxRow-1; i >= minRow; i--){
                s[i][maxCol] = value;
                value--;
            }
            for (int i = maxCol-1; i >= minCol+1; i--){
                s[minRow][i] = value;
                value--;
            }
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
        return s;
    }

    public static <T> void serialize(T[][] M){
        try {
            FileOutputStream fos = new FileOutputStream("matrix.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(M);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T[][] deserialize(){
        try {
            FileInputStream fis = new FileInputStream("matrix.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (T[][]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
