package cs3310homeworkchapter5problem11;            

import java.util.Random;

/*
    S. Renee Eller
    CS 3310 Section 2 
    Homework #8 Problem 11

 */
public class CS3310HomeworkChapter5Problem11
{
    public static int N = 8;
    public static int[] col = new int[N + 1];
    public static Random rd = new Random(); 
    
    public static void main(String[] args) 
    {
        int ret = 0, total = 0; 
        for(int i = 0; i < 20; i++)
        {
            ret = estimate_n_queens(N);
            total += ret;
            System.out.printf("seq[%d]: Number of Nodes = %d\n", i, ret);
        }
        System.out.printf("total = %d\taverage = %d\n", total, total/20);  
    }
    
    public static int estimate_n_queens (int n)
    {    
        int j, m = 1, mProd = 1, numNodes = 1;
        int random; 
        int i = 0; 
        
        while (m != 0 && i != n)
        {
            mProd = mProd * m; 
            numNodes = numNodes + mProd * n; 
            i++;
            m = 0; 
            int promChildren[] = new int[N + 1]; 
            for (j = 1; j <= n; j++)
            {
                col[i] = j; 
                if (promising(i))
                {
                    m++;
                    promChildren[j] = 1;
                }
            }
            if (m != 0)
            {
                while(true)
                {
                    random = (Math.abs(rd.nextInt())% N)+ 1;
                    if (promChildren[random] == 1)
                    {
                        j = random;
                        break;
                    }        
                }                            
                col[i] = j; 
            }
        }
        return numNodes;
    }
    
    public static boolean promising (int i)
    {
        boolean swit = true;
        int k = 1; 
        while (k < i && swit)
        {
            if (col[i] == col[k] || Math.abs(col[i] - col[k]) == i - k)
            {
                swit = false; 
            }
            k++;
        }
        return swit;
    }
    
}
