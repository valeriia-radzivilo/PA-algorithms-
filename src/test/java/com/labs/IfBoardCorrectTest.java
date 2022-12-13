package com.labs;

import com.labs.ArrWork.ArrWork;
import com.labs.ArrWork.make_n_queens;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class IfBoardCorrectTest {
    @Test
    public void ifBoardCorrect(){
        int n=8;
        int []expected = {2,5,7,0,3,6,4,1};

        int[] result_bfs = make_n_queens.make_n_queens(n,false, new int[]{2,5,7,0,3,6,4,1},0);
        int[] result_rbfs = make_n_queens.make_n_queens(n,false, new int[]{2,5,7,0,3,6,4,1},1);

        assertArrayEquals(expected,result_bfs ,"Test Check for BFS");
        System.out.println("Expected: ");
        ArrWork.create_matr(expected,n);
        System.out.println("Result: ");
        ArrWork.create_matr(result_bfs,n);

        assertArrayEquals(expected,result_rbfs ,"Test Check for RBFS");
        System.out.println("Expected: ");
        ArrWork.create_matr(expected,n);
        System.out.println("Result: ");
        ArrWork.create_matr(result_rbfs,n);
    }


}
