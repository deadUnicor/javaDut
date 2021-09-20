/*
*Створити двовимірний масив, заповнити його випадковими значеннями від 0 до 9 (Random). 
    Вивести його на екран окремим методом (private void printArray(int[][] arr)). 
    Вивести на екран всі парні числа побічної діагоналі.
*Створити метод (private int[] fillArray(int begin, int end, int step)). 
    Який заповнює масив від begin до end, з кроком в step.
        Приклад : fillArray(0, 10, 2) -> [0, 2, 4, 6, 8, 10] end – begin 
*/

import java.util.Random;

public class Program{ 

    private static final int rows = 5, columns = 5, min = 0, max = 9;
    private static final int begin = 0, end = 10, step = 2;

    public static void main(String[] args){
        int [][] matrix = randomlyFillMatrix();
        System.out.println("Random Matrix:");
        printArray(matrix);

        System.out.println("Even values in anti-diagonal:");
        printAntiDiagonalEven(matrix);
        
        int[] array = fillArray(begin, end, step);
        System.out.println("Filled array with step:");
        printArray(array);
    }

    // #Task 1

    private static int[][] randomlyFillMatrix(){
        Random rnd = new Random();
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = rnd.nextInt(max + 1) + min;
            }
        }
        return matrix;
    }

    private static void printArray(int[][]arr){
        if(arr == null){
            return;
        }
        for (int[] row : arr) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    private static void printAntiDiagonalEven(int[][]arr){
        for(int i = 0; i < arr.length; ++i){
            int diagElement = arr[i][(arr[i].length - 1) - i ];
            if(diagElement % 2 == 0){
                System.out.print(diagElement + " ");
            }
        }
        System.out.println();
    }

    // #Task 2

    private static int[] fillArray(int begin, int end, int step){
        if(begin > end){
            return null;
        }

        if(step == 0){
            return null;
        }

        int totalSteps = ((end - begin) / step) + 1;
        int[] resultingArr = new int[totalSteps];
        
        for(int i = 0 ; i < totalSteps; ++i){
            resultingArr[i] = begin + (i*step);
        }

        return resultingArr;
    }

    private static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0 ; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }


}