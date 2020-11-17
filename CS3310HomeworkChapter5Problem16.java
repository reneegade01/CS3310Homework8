/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3310homeworkchapter5problem16;

/*
    S. Renee Eller
    CS 3310
    Homework 8 
    Chapter 5 Problem 16
 */
public class CS3310HomeworkChapter5Problem16
{
    public static boolean[] include = {false, false, false, false, false};

    public static void main(String[] args)
    {
        int n = 5;
        int W = 21;
        int weight[]={5,6,10,11,16};
        getSubSetSum(n,weight,W);
        for(int i = 0; i < 5; i++)
        {
            if(include[i])
                System.out.println(i+1 + " the weight: " + weight[i] + " will be included"); 
        }
    }
        
    public static boolean getSubSetSum(int n, int weight[], int W)
    {
        if(n <= 0)
            return false;
        if(W == 0)
            return true; 
        if(weight[n-1] > W)
        {
            include[n-1] = false;
            return getSubSetSum(n-1, weight, W);
        }
  
        boolean r1 = getSubSetSum(n-1, weight, W-weight[n-1]);
        if(r1)
        {
            include[n-1] = true;
            return true;
        }
        
        boolean r2 = getSubSetSum(n-1, weight, W);
        if(r2)
        {
            include[n-1]=false;
            return true;
        }
        return false;
    }    
    
}
