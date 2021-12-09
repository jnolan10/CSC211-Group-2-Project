package com.mycompany.playingcards24_fxml;

import java.util.Stack;

public class EvalMethod {
    
    /**
     * This method will take a mathematical expression consisting of numbers, operators and parenthesis in the form of a string,
     * and will output the mathematical answer to the expression, while following correct order of operations rule, and parenthesis grouping
     * For my design, i decided to go with implementation of stacks
     * @param s1 the mathematical expression in string form to be evaluated
     * @return will return the double that is evaluated from given string input expression
     */
    public static double evaluateString(String s1) {
        //the stack that represents numbers from expression    
        Stack<Double> numbers = new Stack<Double>();

        //the stack that represents operators from expression
        Stack<Character> operators = new Stack<Character>();

        //stores input as char array, we will go through it character by character
        char[] expression = s1.toCharArray();
        
        //this will loop through char array, and eventually check every character from input
        for(int i = 0; i < expression.length; i++) {
        //if current character from array is a spcae/empty, skip it    
        if(expression[i] == ' ') {
        continue;
        }
        //if current character from array is an open parenthesis, push it to operators stack
        else if(expression[i] == '(') {
        operators.push(expression[i]);
        }
        //if current character from array is closing parenthesis, solve expression within parenthesis, that has been stored in numbers stack and operator stack
        //stops once closing parenthesis has been encountered, and pushes answer form inside parenthesis to number stack
        else if(expression[i] == ')') {
            while(operators.peek() != '(') {
                numbers.push(solveSimpleOperation(numbers.pop(), numbers.pop(), operators.pop()));
            }
            //pop off stack because excess open parenthesis is left over
            operators.pop();
        }
        //if current character from array is a number (1-9), use string builder to add it to numbers stack
        else if(expression[i] >= '0' && expression[i] <= '9') {
            StringBuilder str = new StringBuilder();
            //if a number is made up of multiple digits, append to str, then push to numbers stack
            while(i < expression.length && expression[i] >= '0' && expression[i] <= '9') {
            str = str.append(expression[i++]);
            }
            numbers.push(Double.parseDouble(str.toString()));
            //decrement i because it was incremented during for loop
            //otherwise, i would be pointing to the incorrect character, so in order to not skip any characters from expression, decrement i
            i--;
        }
        //if current character from array is an operator, we push it onto the operators stack
        else if(expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/') {
            //if top of operator stack has greater or same precedence as current character (operator), apply the top of operator stack to the top two
            //memebers of the numbers stack, and push answer to numbers stack
            while(!operators.empty() && precedenceCheck(expression[i], operators.peek()) == 1) {
                numbers.push(solveSimpleOperation(numbers.pop(), numbers.pop(), operators.pop()));
            }
            operators.push(expression[i]);
        }
        }
        //at this point, the entire stirng expression has been read, and divided into stacks
        //if there remains an operator on the stack, apply top operator to top two numbers from numbers stack, push answer back to numbers stack
        while(!operators.empty()) {
            numbers.push(solveSimpleOperation(numbers.pop(), numbers.pop(), operators.pop()));
        }
        //will return the final answer calculated from stirng expression, since all thats left in top of numbers stack is answer
        return numbers.pop();
    }
    
    /**
     * this method will take two doubles and an operator, and then return the result of combination of the two doubles via the operator
     * num2 is listed before num1 in parameters due to nature of LIFO structure of stacks
     * note: you cannot divide by 0 (num1 cannot = 0) this will result in an error
     * @param num2 represents operand 1
     * @param num1 represents operand 2
     * @param op operator two numbers will be combined with
     * @return result of combining the two operators via the operand
     */
    public static double solveSimpleOperation(double num2, double num1, char op) {
        switch(op) {
            case '+': {
            return num1 + num2;
            }
            case '-': {
            return num1 - num2;
            }
            case '*': {
            return num1 * num2;
            }
            case '/': {
                if(num1 == 0) {
                throw new UnsupportedOperationException("Error: Don't divide by 0");
                }
            return num1 / num2;
            }
        }
        return 0;
    }
    
    /**
     * this method will decide the precedence/order of two inputted operators
     * this method will check if the second operator(operator2) happens before first operator(operator1) following correct order of operations
     * @param operator1 represents first operator
     * @param operator2 represents second operator
     * @return will return 1 if operator2 has higher precedence than operator1 from order of operations, or has the same precedence
     *         will return 0 if operator1 has higher precedence than operator2 from order of operations
     */
    public static int precedenceCheck(char operator1, char operator2) {
        if(operator2 == '(' || operator2 == ')') {
        return 0;
        }
        else if(operator1 == '*' || operator1 == '/' && operator2 == '+' || operator2 == '-') {
        return 0;
        }
        else {
        return 1;
        }
    }
    
    /*just some test cases
    public static void main(String[] args) {
        System.out.println(EvalMethod.evaluateString("(6+6)*12/6"));
        System.out.println(EvalMethod.evaluateString("(1+2)/2"));
        System.out.println(EvalMethod.evaluateString("12*2+13"));
        System.out.println(EvalMethod.evaluateString("1 + 3 - 2 / 2"));
        System.out.println(EvalMethod.evaluateString("1+9 / (4+1)"));
        System.out.println(EvalMethod.evaluateString("1+(9 / (4+1))"));
        System.out.println(EvalMethod.evaluateString("(1+9) / (4+1)"));
        System.out.println(EvalMethod.precedenceCheck('/', '+'));
        System.out.println(EvalMethod.precedenceCheck('-', '*'));
        System.out.println(EvalMethod.solveSimpleOperation(2, 12, '*'));
    }*/

}
