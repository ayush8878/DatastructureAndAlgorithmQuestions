package StackAndQueue;

import util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String exp = "((a+b)*x-d))";
        boolean isBalanced = checkBalancedParenthesis(exp);
        System.out.println(isBalanced);

    }

    private static boolean checkBalancedParenthesis(String exp) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            if(exp.charAt(i) == ')')
            {
                if(!stack.isEmpty() && stack.peek() == '(')
                stack.pop();
                else
                    return false;
            }
            else if(exp.charAt(i) == '(')
            {
                stack.push('(');
            }
        }
        return stack.isEmpty()?true:false;
    }
}
