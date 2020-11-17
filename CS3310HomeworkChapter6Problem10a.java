package cs3310homeworkchapter6problem10a;

import java.util.ArrayList;
/*
    S. Renee Eller
    CS 3310
    Assignment 8
    Chapter 6 Problem 10
 */
public class CS3310HomeworkChapter6Problem10a
{    
    static int V = 4;
    
    public static void main(String[] args)
    {
           int graph[][] = {{0, 24, 15, 10},
                           {11, 0, 35, 15},
                           {13, 35, 0, 23},
                           {45, 45, 30, 0}};
           int s = 0;
           System.out.println(travllingSalesmanProblem(graph, s));
    }  
    
    public static int travllingSalesmanProblem(int graph[][], int s)
    {
        ArrayList<Integer> vertex = new ArrayList<Integer>();
     
        for (int i = 0; i < V; i++)
        if (i != s)
            vertex.add(i);

        int min_path = Integer.MAX_VALUE;
        do
        {
            int current_pathweight = 0;
            int k = s;
     
            for (int i = 0;i < vertex.size(); i++) 
            {
                current_pathweight += graph[k][vertex.get(i)];
                k = vertex.get(i);
            }
            current_pathweight += graph[k][s];
            min_path = Math.min(min_path, current_pathweight);
        } while (findNextPermutation(vertex));
 
        return min_path;
    }

    public static ArrayList<Integer> swap(ArrayList<Integer> data, 
                                          int left, int right) 
    { 
        int temp = data.get(left); 
        data.set(left, data.get(right)); 
        data.set(right, temp); 
 
        return data; 
    } 
    
    public static ArrayList<Integer> reverse(ArrayList<Integer> data, 
                                            int left, int right) 
    { 
        while (left < right) 
        { 
            int temp = data.get(left); 
            data.set(left++, data.get(right)); 
            data.set(right--, temp); 
        } 
        
        return data; 
    } 
    
    public static boolean findNextPermutation(ArrayList<Integer> data) 
    {  
        if (data.size() <= 1) 
            return false; 
        int last = data.size() - 2; 
 
         while (last >= 0) 
        { 
            if (data.get(last) < data.get(last + 1)) 
            { 
                break; 
            } 
        last--; 
        } 

        if (last < 0) 
            return false; 
        int nextGreater = data.size() - 1; 
        
        for (int i = data.size() - 1; i > last; i--)
        { 
            if (data.get(i) > data.get(last)) 
            { 
                nextGreater = i; 
                break; 
            } 
        } 

        data = swap(data, nextGreater, last); 
        data = reverse(data, last + 1, data.size() - 1); 

        return true; 
    } 
}
