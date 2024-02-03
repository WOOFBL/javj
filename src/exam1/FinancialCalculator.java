package exam1;


import java.math.BigDecimal;
import java.util.Scanner;

public class FinancialCalculator {
    private static final int MAX_DAYS = 30;
    private static final double DEFAULT_EXPENSE = -1;
    private double[] expenses;
    private double sum,sum3,sum2,sum1;

    public FinancialCalculator() {
        expenses = new double[MAX_DAYS];
        for (int i = 0; i < MAX_DAYS; i++) {
            expenses[i] = DEFAULT_EXPENSE;
        }
    }
    public void start() {
        int point = -1;
        Scanner z = new Scanner(System.in);
        while (point != 0) {
            printMenu();
            point = z.nextInt();
            switch (point) {
                case 0:
                    System.out.println("До свидания!");
                    System.exit(0);
                    break;
                case 1:
                    enterExpenses(z);
                    break;
                case 2:
                    printExpenses();
                    break;
                case 3:
                    printMaxExpense();
                    break;
                case 4:
                    printconversion();
                    break;
                default:
                    System.out.println("Недопустимый выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("Меню:");
        System.out.println("1 - Ввести расходы за определенный день");
        System.out.println("2 - Траты за месяц");
        System.out.println("3 - Самая большая сумма расхода за месяц");
        System.out.println("4 - Конвертация валют");
        System.out.println("0 - Выход");
        System.out.print("Выбор: ");
    }
    private void enterExpenses(Scanner z) {
        System.out.print("Введите день: ");
        int day;
        day= z.nextInt();


        if (day < 1 || day > MAX_DAYS) {
            System.out.println("Недопустимый день.");
            return;
        }
        day--;
        if (expenses[day] != DEFAULT_EXPENSE) {
            System.out.println("Расход за указанный день уже введен: " + expenses[day] + " руб.");
            System.out.print("Перезаписать сумму? (y/n): ");
            String overstoke = z.next();
            if (overstoke.equalsIgnoreCase("y")) {
                System.out.print("Введите сумму трат за текущий день: ");
                double expense = z.nextDouble();
                expenses[day] = expense;
                System.out.println("Расходы за " + (day + 1) + " день перезаписаны.");
            }
        } else {
            System.out.print("Введите сумму трат за текущий день: ");
            double expense = z.nextDouble();
            expenses[day] = expense;
            System.out.println("Расходы за " + (day + 1) + " день записаны.");
        }



        System.out.print("Ввести траты за другой день? (y/n): ");
        String contst = z.next();
        if (contst.equalsIgnoreCase("y")) {
            enterExpenses(z);
        }

    }
    private void printExpenses() {
        System.out.println("Траты за месяц:");
        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] != DEFAULT_EXPENSE) {
                System.out.println((i + 1) + " день - " + expenses[i] + " руб.");
                sum = expenses[i]+sum;
            }
        }
        System.out.println("Сумма трат за месяц: "+sum+ " руб.");
        System.out.println();

        Scanner z = new Scanner(System.in);
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        z.nextLine();
    }
    private void printMaxExpense() {
        double maxExpense = 0.0;
        int maxExpenseDay = -1;

        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] > maxExpense) {
                maxExpense = expenses[i];
                maxExpenseDay = i + 1;
            }
        }

        if (maxExpenseDay != -1) {
            System.out.println("Самая большая сумма расхода за месяц: " + maxExpense + " руб. (день " + maxExpenseDay + ")");
        } else {
            System.out.println("В месяце не было внесено расходов.");
        }

        Scanner z = new Scanner(System.in);
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        z.nextLine();
    }
    private void printconversion() {
        int point = -1;
        Scanner z = new Scanner(System.in);
        while (point != 0) {
            printMenuConvertsion();
            point = z.nextInt();
            switch (point) {
                case 0:
                    start();
                    break;
                case 1:
                    conversionDollars(sum3);
                    break;
                case 2:
                    conversionYuan(sum2);
                    break;
                case 3:
                    conversionEuro(sum1);
                    break;
                default:
                    System.out.println("Недопустимый выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }

    private void printMenuConvertsion() {
        System.out.println("Выбирите валюту для перевода:");
        System.out.println("1 - Доллары");
        System.out.println("2 - Юани");
        System.out.println("3 - Евро");
        System.out.println("0 - Выход в основное меню");
        System.out.print("Выбор: ");
    }

    private void conversionDollars(double sum3) {
        System.out.println("Траты за месяц:");
        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] != DEFAULT_EXPENSE) {
                BigDecimal dollars;
                dollars = BigDecimal.valueOf((expenses[i]/90.66));
                System.out.println((i + 1) + " день - " + dollars + " дол.");

            }
            sum3 =(expenses[i]/90.66)+ sum3;
        }
        System.out.println("Сумма трат за месяц: "+sum3+ " дол.");
        System.out.println();

        Scanner z = new Scanner(System.in);
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        z.nextLine();
    }
    private void conversionYuan(double sum2) {
        System.out.println("Траты за месяц:");
        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] != DEFAULT_EXPENSE) {
                BigDecimal yuan;
                yuan = BigDecimal.valueOf((expenses[i]/12.6));
                System.out.println((i + 1) + " день - " + yuan + " юан.");
            }
            sum2 =(expenses[i]/12.6)+ sum2;
        }
        System.out.println("Сумма трат за месяц: "+ sum2+ " юан.");
        System.out.println();

        Scanner z = new Scanner(System.in);
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        z.nextLine();
    }
    private void conversionEuro(double sum1) {
        System.out.println("Траты за месяц:");
        for (int i = 0; i < MAX_DAYS; i++) {
            if (expenses[i] != DEFAULT_EXPENSE) {
                BigDecimal euro;
                euro = BigDecimal.valueOf((expenses[i]/98.64));
                System.out.println((i + 1) + " день - " + euro + " евро");
            }
            sum1 =(expenses[i]/98.64)+ sum1;
        }
        System.out.println("Сумма трат за месяц: "+ sum1+ " евро");
        System.out.println();

        Scanner z = new Scanner(System.in);
        System.out.print("Нажмите Enter, чтобы вернуться в меню...");
        z.nextLine();
    }
    public static void main(String[] args) {
        FinancialCalculator financeTracker;
        financeTracker = new FinancialCalculator();
        financeTracker.start();
    }
}