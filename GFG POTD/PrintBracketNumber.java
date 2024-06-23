import java.util.ArrayList;
import java.util.Stack;

class PrintBracketNumber {
    ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int counter = 1;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(counter);
                result.add(counter);
                counter++;
            } else if (ch == ')') {
                result.add(stack.pop());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str1 = "(aa(bdc))p(dee)";
        String str2 = "(((()(";

        System.out.println(sol.bracketNumbers(str1)); 
        System.out.println(sol.bracketNumbers(str2)); 
    }
}

