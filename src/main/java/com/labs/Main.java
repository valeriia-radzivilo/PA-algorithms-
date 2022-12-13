package com.labs;

import com.labs.ArrWork.*;

import java.util.Objects;
import java.util.Scanner;


public class Main {
       public static void main(String args[]){
           int n =8;

           int [] initial_placement = ArrWork.make_rand_int_arr(n);
           System.out.println("Initial task: ");
           ArrWork.create_matr(initial_placement,n);

           Scanner myObj = new Scanner(System.in);
           System.out.println("Write nuber of type BFS(0)/RBFS(1): ");
           int method = myObj.nextInt();
           while (method!=0 && method!=1){
               System.out.println("YOU MUST WRITE 0 OR 1, NOTHING ELSE!");
               System.out.println("Write nuber of type BFS(0)/RBFS(1): ");
               method = myObj.nextInt();
           }
           if(method == 0) {
               int[] result = make_n_queens.make_n_queens(n, false, initial_placement, method);

               System.out.println("Result BFS: ");
               ArrWork.create_matr(result, n);
               System.out.println("F2 for BFS: " + F2.F2(result, 8));
           }
           else  if (method==1){
               int[] result = make_n_queens.make_n_queens(n, false, initial_placement, 1);

               System.out.println("Result RBFS: ");
               ArrWork.create_matr(result, n);
               System.out.println("F2 for RBFS: " + F2.F2(result, 8));
           }

           System.out.println("Do you want to see 2 solution?('yes'/'no'): ");
           myObj =new Scanner(System.in);
           String answer = myObj.nextLine();
           if(Objects.equals(answer, "yes"))
           {
               method = Math.abs(method -1);
               System.out.println(method);
               if(method == 0) {
                   int[] result = make_n_queens.make_n_queens(n, false, initial_placement, method);

                   System.out.println("Result BFS: ");
                   ArrWork.create_matr(result, n);
                   System.out.println("F2 for BFS: " + F2.F2(result, 8));
               }
               else  if (method==1){
                   int[] result = make_n_queens.make_n_queens(n, false, initial_placement, 1);

                   System.out.println("Result RBFS: ");
                   ArrWork.create_matr(result, n);
                   System.out.println("F2 for RBFS: " + F2.F2(result, 8));
               }
           }

       }



}
