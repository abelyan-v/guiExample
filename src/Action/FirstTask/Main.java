package Action.FirstTask;

import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Hero hero = new Hero();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) { // Бесконечный цикл, пока пользователь не выберет выход
//            System.out.println("Выберите способ передвижения: ");
//            System.out.println("1. Пешком (Walk)");
//            System.out.println("2. На лошади (Horse)");
//            System.out.println("3. На самолете (Fly)");
//            System.out.println("4. Прыжком (Jump)");
//            System.out.println("5. На велосипеде (Bike)");
//            System.out.println("6. Бегом (Run)");
//            System.out.println("0. Выход");
//            System.out.print("Введите номер выбранного способа: ");
//
//            int choice = 0;
//
//            try {
//                choice = scanner.nextInt();
//
//                if (choice == 0) {
//                    break; // Выход из цикла, если пользователь выбрал 0
//                }
//
//                switch (choice) {
//                    case 1:
//                        hero.move(new Walk());
//                        break;
//                    case 2:
//                        hero.move(new Horse());
//                        break;
//                    case 3:
//                        hero.move(new Fly());
//                        break;
//                    case 4:
//                        hero.move(new Jump());
//                        break;
//                    case 5:
//                        hero.move(new Bike());
//                        break;
//                    case 6:
//                        hero.move(new Run());
//                        break;
//                    default:
//                        System.out.println("Неверный выбор. Используется пешком.");
//                        hero.move(new Walk());
//                }
//            } catch (java.util.InputMismatchException e) {
//                System.out.println("Ошибка: Введите число от 0 до 6.");
//                scanner.next(); // Очистка ввода
//            }
//        }
//
//        scanner.close();
//    }
}
