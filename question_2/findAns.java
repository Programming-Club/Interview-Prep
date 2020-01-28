import java.util.HashMap;
import java.util.Map;

public class findAns {
    /**
     * You are given a number N and a pattern. The pattern consists of lowercase latin letters and one operation "+" or "-". The challenge is to split the number and evaluate it according to this pattern e.g.
     *
     * 1232 ab+cd -> a:1, b:2, c:3, d:2 -> 12+32 -> 44
     *
     * Your program should read a String from standard input. Each String contains the number and the pattern separated by a single whitespace. The number will be in range [100, 1,000,000,000]
     *
     *
     * Ex:
     * findAns("1232 ab+cd")  		=> 44
     * findAns("1234 ab-cd")		=> -22
     * findAns("1203 ab+cd")		=> 15
     * findAns("34097 aa+bbcde")	=> 33,171
     * findAns("6785493 abc-ade") 	=> 19
     */

    public static long findAns(String patten) {
        // first split the pattern
        String[] splitPattern = patten.split( " ");
        String numbers = splitPattern[0];
        String equation = splitPattern[1];

        Map<Character, Long> map = new HashMap();

        // Add the values to the map
        addToMap(numbers, equation, map);

        //evaluate the pattern and return
        return evaluatePattern(map, equation);
    }

    public static long findAnsChallenge(String pattern){
        //TODO: Wii complete when my brain refreshes :-)

        long temp = 0;
        return temp;
    }


    // Adds the numbers to the map so that each letter is associated with a number
    private static void addToMap(String numbers, String equation, Map<Character,Long> map) {
        int numIndex = 0;

        for(int i = 0; i < equation.length(); i ++) {
            Character letter = equation.charAt(i);

            // Check if the letter is an operator
            if(!letter.equals('+') && !letter.equals('-')) {

                // If the map does not contain the key then add it and the value
             if (!map.containsKey(letter)) {
                    map.put(letter, Long.parseLong(Character.toString(numbers.charAt(numIndex))));
                    numIndex++;
                }
            }
        }
    }

    // Using the given map this function evaluates the pattern by associating each element in the pattern with a key
    //  in the map.
    private static long evaluatePattern(Map<Character, Long> map, String pattern) {
        boolean isAddition = pattern.contains("+");
        String[] eq = isAddition ? pattern.split("\\+") : pattern.split("-");

        String lhs = eq[0];
        String rhs = eq[1];
        StringBuilder leftAns = new StringBuilder();
        StringBuilder rightAns = new StringBuilder();

        // find the number for both sides
        for(int i = 0; i < lhs.length(); i++){
            Character letter = lhs.charAt(i);
            leftAns.append(map.get(letter));
        }

        for(int i = 0; i < rhs.length(); i++){
            Character letter = rhs.charAt(i);
            rightAns.append(map.get(letter));
        }

        if(isAddition){
            return Long.parseLong(leftAns.toString()) + Long.parseLong(rightAns.toString());
        }
        else {
            return Long.parseLong(leftAns.toString()) - Long.parseLong(rightAns.toString());
        }
    }


    public static void main(String[] args) {

        System.out.println(findAns("1232 ab+cd"));          // 44
        System.out.println(findAns("1234 ab-cd"));          // -22
        System.out.println(findAns("1203 ab+cd"));          // 15
        System.out.println(findAns("34097 aa+bbcde"));      // 44,130
        System.out.println(findAns("6785493 abc-ade"));     // 24

    }
}
