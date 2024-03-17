package runner;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1 или 2: ");
        byte x= scanner.nextByte();
        while (x!=1&&x!=2){
            System.out.print("Введено неверное число\nВведите 1 или 2: ");
            x= scanner.nextByte();
        }
        useMyFuncInterface(x);

    }
    private static void useMyFuncInterface(int x) {
        Scanner scanner = new Scanner(System.in);
        if (x == 1) {
            IMyInterface<String> iMyInterface = str -> {
                StringBuilder newString = new StringBuilder();
                for (int i = str.length() - 1; i >= 0; i--) {
                    newString.append(str.charAt(i));
                }
                return newString.toString();
            };
            System.out.print("введите строку: ");
            System.out.println(iMyInterface.funcInterfaceMethod(scanner.nextLine()));
        } else {
            IMyInterface<Integer> iMyInterface = integer -> {
                if (integer == 0) {
                    return 1;
                } else {
                    int result = 1;
                    for (int i = 1; i <= integer; i++) {
                        result *= i;
                    }
                    return result;
                }
            };
            int f = -1;
            do {
                System.out.println("введите положительное число: ");
                String temp = scanner.next();
                try {
                    f = Integer.parseInt(temp);
                    if (f < 0) {
                        System.out.println("некорректный ввод");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("некорректный ввод");
                }
            } while (f < 0);
            System.out.println(iMyInterface.funcInterfaceMethod(f));
        }

    }
}
