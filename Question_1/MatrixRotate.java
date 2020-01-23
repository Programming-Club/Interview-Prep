import java.util.Arrays;

public class MatrixRotate {
    // Written By Josh

    /**
     * This is my original solution where I rotate each row
     */
    public static int[][] rotateMatrix( int[][] matrix) {
        int[][] newArray = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {

            // rotate the row into the new array
            newArray = rotateRow(matrix[i], i, newArray);
        }

        return newArray;
    }

    // rotates a given row and places it in a new array
    public static int[][] rotateRow(int[] row, int index, int[][] newArray){

        int arrayLength = row.length -1;
        for(int i = 0; i < row.length; i++){
            // Get each element and set it to the side
            int newX = arrayLength - index;
            newArray[i][newX] = row[i];
        }


        return newArray;
    }


    /**
     * This is my efficient solution where only the matrix is mutated. No copies
     *   of the array are made.
     */
    public static int[][] rotateMatrixEfficient(int[][] array){

        for(int i = 0; i < array.length / 2 ; i++) {
            for(int j = i; j < (array.length -1) - i; j++){
                rotate4(i, j, array);
            }
        }
        return array;
    }

    // rotates the 4 elements in the array to be at the proper position
    public static void rotate4(int rowIndex, int colIndex, int[][] array){
        int length = array.length-1;
       int temp = array[rowIndex][colIndex]; // We need to save one value so it is not over written
       array[rowIndex][colIndex] = array[length - colIndex][rowIndex];
       array[length-colIndex][rowIndex] = array[length-rowIndex][length-colIndex];
       array[length-rowIndex][length-colIndex] = array[colIndex][length-rowIndex];
       array[colIndex][length-rowIndex] = temp;
    }


    public static void main(String[] args) {
        int[][] array = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        System.out.println(Arrays.deepToString(rotateMatrix(array)));
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(Arrays.deepToString(rotateMatrixEfficient(array)));
    }
}
