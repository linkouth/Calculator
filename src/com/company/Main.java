package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char flag = 'y';
        while (flag == 'y') {
            int num1 = getInt();
            int num2 = getInt();
            char operation = getOperation();
            int result = calc(num1, num2, operation);
            System.out.println("Результат операции: " + result);
            System.out.println("Продолжить?(y/n)");
            if (scanner.hasNext()) {
                flag = scanner.next().toLowerCase().charAt(0);
            } else {
                flag = 'n';
            }
        }
    }

    private static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    private static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    private static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }
}
