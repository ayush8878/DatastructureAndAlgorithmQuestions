package StackAndQueue;

import util.Stack;

public class RedundantParenthesis {
    public static void main(String[] args) {
        String exp = "(a+b)";
        boolean isRedundant = checkRedundantParenthesis(exp);
        System.out.println(isRedundant);

    }

    private static boolean checkRedundantParenthesis(String exp) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            // when ) found
            if(exp.charAt(i) == ')')
            {
                boolean hasOperand = false;
                while (!stack.isEmpty() && stack.peek()!='(')
                {
                    char ch = stack.pop();
                    switch(ch)
                    {
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                        {
                            hasOperand = true;
                            break;
                        }
                    }
                }
                // if in-case there is no operand between ( and ) then it doesn't make sense keeping parenthesis
                if(!hasOperand)
                {
                    return true;
                }
                // make sure to pop out the ( from stack
                stack.pop();
            }
            // when ( found
            else
            {
                stack.push(exp.charAt(i));
            }
            // for operators and operand
        }
        return stack.isEmpty()?false:true;
    }
}
