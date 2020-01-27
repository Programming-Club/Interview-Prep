# Solution by Ajay Shah

def rotate90degrees(matrix):
    solution = []
    for x in range(0, len(matrix)):
        row = []
        for y in range(0, len(matrix[x])):
            row.append(matrix[y][x])
        solution.append(row[::-1])
    return solution

import unittest
class MatrixRotatations(unittest.TestCase):
    def testRotation(self):
        matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        self.assertEquals(rotate90degrees(matrix), [[7, 4, 1], [8, 5, 2], [9, 6, 3]])

def main():
    unittest.main()
main()