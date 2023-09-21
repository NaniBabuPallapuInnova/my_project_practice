package com.welcome.programs_practice.strings_programs;

import java.util.Scanner;

public class DivideStringNEqualParts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== ENTER STRING ========");
        String data = scanner.next();
        System.out.println("====== ENTER 'N' EQUAL PARTS ======");
        int numOfParts = scanner.nextInt();
        String[] strings = new String[numOfParts];

        int temp = 0;

        int chars = data.length() / numOfParts;
        if (data.length() % numOfParts != 0) {
            System.out.println("It cannot be divided into N equal parts ");
        } else {
            for (int i = 0; i < data.length(); i = i + chars) {
                String part = data.substring(i, i + chars);
                strings[temp] = part;
                temp++;
            }
        }
        int partNum = 1;
        for (String str : strings) {
            System.out.println(partNum + "." + str);
            partNum++;
        }

    }
}
