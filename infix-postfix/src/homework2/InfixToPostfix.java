/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.Stack;

/**
 *  Question 5
 * @author aelinadas
 */
public class InfixToPostfix {
    
    private String infixExp;
    private String postfixExp;
    private Stack<Character> stack = null;
    
    public InfixToPostfix(String infixExp){
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
                }else if(infixExp.charAt(i) == ' '){
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
    
    public static void main(String[] args){   
        InfixToPostfix newExp = new InfixToPostfix("A*B/C+(D+E-(F*(G/H)))");
        System.out.println("Postfix Expression: " + newExp.finalExp());
        
    }
}
