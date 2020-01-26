package programming_club;

public class RotateMatrix {

	public static int[][] rotateMatrix(int[][] matrix) {
		
		int n = matrix.length;
		
		for (int i = 0; i < n / 2; i++) {
			
			for (int j = i; j < n - i - 1; j++) {
				
				int top_left = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i]; // bottom left to top left
				matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1 - j]; // bottom right to bottom left
				matrix[n - i - 1][n - 1 - j] = matrix[j][n - i - 1]; // top right to bottom right
				matrix[j][n - i - 1] = top_left; // top left to top right
				
			}
		}
		
		return matrix;
		
	}
}