package org.example;
import java.sql.*;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();
        int count=0;
        if (StringUtils.isBlank(input)) {
            count= 0;
        }else {
            String[] words = input.trim().split("\\s+");
            count= words.length;
        }

        System.out.println("Word count: " + count);
    }

}