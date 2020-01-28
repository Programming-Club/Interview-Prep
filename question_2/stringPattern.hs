{-
You are given a number N and a pattern. The pattern consists of lowercase latin letters and one operation "+" or "-". 
    The challenge is to split the number and evaluate it according to this pattern e.g.

1232 ab+cd -> a:1, b:2, c:3, d:2 -> 12+32 -> 44

Your program should read a String from standard input. Each String contains the number and the pattern separated by
     a single whitespace. The number will be in range [100, 1000000000]


Ex:
findAns("1232 ab+cd)  		=> 44
findAns("1234 ab-cd")		=> -22
findAns("1203 ab+cd")		=> 15
findAns("34097 ee+aacdb")	=> 33,171
findAns("6785493 abc-adf") 	=> 19
-}
import qualified Data.Map as M

findAns :: [Char] -> Int
findAns aString =
    let (x,y) = splitBySpace aString
        m = M.fromList (createMapList (removeDuplicates y) x)
        rhsExp = evaluateExpression (getRHS y) m
        lhsExp = evaluateExpression (getLHS y) m
    in returnAnswer lhsExp rhsExp ('+' `elem` aString)


-- Splits a string by its space. Only 1 space can be in the
--   string for this to work
splitBySpace :: [Char] -> ([Char], [Char])
splitBySpace aString = 
    let lhs = takeWhile (/= ' ') aString
        (x:rhs) = dropWhile (/= ' ') aString
    in (lhs, rhs)


-- removes duplicate elements from a given list
removeDuplicates :: (Eq a) => [a] -> [a]
removeDuplicates list = removeHelper [] list
    where removeHelper seen [] = seen
          removeHelper seen (x:xs)
            | x `elem` seen = removeHelper seen xs
            | otherwise = removeHelper (seen ++ [x]) xs


-- creates a list to be mapped on 
createMapList :: [Char] -> [Char] -> [(Char, Char)]
createMapList [] _ = []
createMapList (x:xs) (y:ys)
    | x == '+'  = createMapList xs (y:ys)
    | x == '-'  = createMapList xs (y:ys)
    | otherwise = (x,y):(createMapList xs ys)

-- Evaluates the expression using the map and returns the proper expression
evaluateExpression :: [Char] -> M.Map Char Char -> [Char]
evaluateExpression [] _ = []
evaluateExpression (x:xs) m = 
    let val = getVal (M.lookup x m)
    in val:evaluateExpression xs m

-- converts a Maybe to a value of type a
getVal :: Maybe a -> a
getVal x = case x of
            Just x -> x
            Nothing -> error "No valid map element"


-- Gets the left hand side of the expression
getLHS :: [Char] -> [Char]
getLHS list
    | '+' `elem` list = takeWhile (/= '+') list
    | otherwise = takeWhile (/= '-') list


-- Gets the right hand side of the expression
getRHS :: [Char] -> [Char]
getRHS list
    |  '+' `elem` list = tail (dropWhile (/= '+') list)
    | otherwise = tail (dropWhile (/= '-') list)

-- converts the lhs and rhs of the equation to an int and then returns number value
--  if true then + else -
returnAnswer :: [Char] -> [Char] -> Bool -> Int
returnAnswer x y b
    | b = left + right
    | otherwise = left - right
    where left = read x :: Int
          right = read y :: Int