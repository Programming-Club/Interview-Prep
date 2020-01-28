def patternEval(string:str):
    characters = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    splitted = string.split(" ")
    numbers = splitted[0]
    pattern = splitted[1]
    cleanPattern = pattern.replace('+', "").replace('-', "")
    map = {}
    for i in range(0, len(numbers)):
        map[characters[i]] = numbers[i]
    equation = "".join([map.get(c, c) for c in pattern])
    if '+' in equation:
        equation = equation.split("+")
        answer = int(equation[0]) + int(equation[1])
    else:
        equation = equation.split("-")
        answer = int(equation[0]) - int(equation[1])
    return answer
import unittest
class StringPatterns(unittest.TestCase):
    def testPattern(self):
        self.assertEqual(patternEval("1232 ab+cd"), 44)
        self.assertEqual(patternEval("1234 ab-cd"), -22)
        self.assertEqual(patternEval("1203 ab+cd"), 15)
        self.assertEqual(patternEval("34097 aa+bbcde"), 44130)
        self.assertEqual(patternEval("6785493 abc-ade"), 24)
        self.assertEqual(patternEval("6785493 abc-adf"), 19)
        self.assertEqual(patternEval("34097 ee+aacdb"), 33171)
def main():
    unittest.main()
main()