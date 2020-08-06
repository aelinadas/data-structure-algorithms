/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.Stack;

/**
 *
 * @author aelinadas
 */
public class Calculator {
    
    private String infixExp;
    private String postfixExp;
    private Stack<Character> stack = null;
    
    public Calculator(String infixExp){
        this.infixExp= infixExp;
    }
    
    public int precedenceChk(char operator){     
        switch(operator){
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;
                
            case '^':
                return 3;
        }
       return -1; 
    }
    
    public void popFromStack(char ch){
        if(ch == '('){
            stack.push(ch);
        }else if(ch == ')'){
            while(!stack.empty() && stack.peek() != '('){
                postfixExp = postfixExp + stack.pop();
            }
            if(stack.peek() == '('){
                stack.pop();
            }       
        }else{
            while(!stack.isEmpty() && precedenceChk(ch) <= precedenceChk(stack.peek())){
                postfixExp = postfixExp + stack.pop();
            }
            stack.push(ch);
        }   
    }
    
    public String finalExp(){
        postfixExp = "";
        stack = new Stack<>();
        if(infixExp != null){
            for(int i = 0; i < infixExp.length(); i++){
                char charChk = infixExp.charAt(i);
                if(Character.isLetterOrDigit(charChk)){
                    postfixExp = postfixExp + charChk;
                }else if(infixExp.charAt(i) ==' '){
                    continue;
                }else{
                    popFromStack(charChk);
                }
            }
        }while(!stack.isEmpty()){
            postfixExp = postfixExp + stack.pop();
        }
        return postfixExp;
    }
    
    public int evaluatePostFix(String postfixExp){
        Stack<Integer> stack = new Stack<>(); 
        for(int i=0;i<postfixExp.length();i++){
            char c=postfixExp.charAt(i);
            if(Character.isDigit(c)){
            stack.push(c - '0');
            }else if(postfixExp.charAt(i) ==' '){
                continue;
            }
            else{ 
                int val1 = stack.pop(); 
                int val2 = stack.pop();     
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break;
                } 
            } 
        } 
        return stack.pop();       
    } 
    
    public static void main(String[] args){ 
        Calculator newExp = new Calculator("A*B/C+(D+E-(F*(G/H)))");
        System.out.println("Postfix Expression: " + newExp.finalExp());
        Calculator newExp1 = new Calculator("(4 + 8) * (6 - 5)/((3 - 2) * (2 + 2))");
        String res = newExp1.finalExp();
        System.out.println("Result:" + res);
        System.out.println("Result:" + newExp1.evaluatePostFix(res));
    }
}
