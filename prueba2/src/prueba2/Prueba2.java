/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author HP
 */
public class Prueba2 {

    /**
     * @param matrix
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] matrix = {{1, 5, 3}, {4, 5, 3}, {7, 8, 9}, {1, 2, 3}};
        System.out.println(matrix);
        for (int j = 0; j < matrix[0].length; j++) {
            Set<Integer> set = new HashSet<Integer>();
            System.out.println(set);
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(i);
                if (!set.add(matrix[i][j])) {
                    System.out.println("Columna " + j + " contiene elemento duplicado: " + matrix[i][j]);
                }
            }
        }

    }
}
