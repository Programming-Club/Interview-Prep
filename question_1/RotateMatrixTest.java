package programming_club;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RotateMatrixTest {

	@Test
	void test() {

		int[][] list1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		assertArrayEquals(RotateMatrix.rotateMatrix(list1), new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
		
	}
}