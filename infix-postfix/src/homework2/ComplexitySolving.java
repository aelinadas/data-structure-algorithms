/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 *
 * @author aelinadas
 */
public class ComplexitySolving {
    
    public void constantComplexity(){
        System.out.println("O(1) Complexity");
    }
    public void logNComplexity(){
        for(int i = 1; i < 16; i = i * 2){
            System.out.println("Log N complexity");
        }
    }
    
    public void nComplexity(){
        for(int i = 0; i < 5; i++){
            System.out.println("Log N complexity"); 
        }
    }
    
    public void nLogNComplexity(){
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 5; j = j + i){
                System.out.println("NlogN Complexity");
            } 
        }
    }
    
    public void nSquareComplexity(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.println("N^2 Complexity");
            } 
        }
    }
    
    public void nCubeComplexity(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                for(int k= 0; k < 5; k++){
                    System.out.println("N^3 Complexity");
                }
            } 
        }
    }
    
    public void twoPowerNComplexity() {
        for(int i = 1; i <= Math.pow(2, 4); i++){
            System.out.println("2^N Complexity");
        }
    }
    
    public static void main(String [] args){
        ComplexitySolving cmp = new ComplexitySolving();
        cmp.constantComplexity();
        cmp.logNComplexity();
        cmp.nComplexity();
        cmp.nLogNComplexity();
        cmp.nSquareComplexity();
        cmp.nCubeComplexity();
        cmp.twoPowerNComplexity();
    }
    
}
