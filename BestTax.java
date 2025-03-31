import java.util.Scanner;

public class BestTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Приветствую предпрениматель!");

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println();
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Для выхода введите: end");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }


            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println();
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Введите сумму расхода:");
                    String moneyStr2 = scanner.nextLine();
                    int money2 = Integer.parseInt(moneyStr2);
                    spendings += money2;
                    break;
                case 3:
                    System.out.println();
                    if (taxEarnings(earnings) > taxEarningsMinusSpendings(earnings, spendings)) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings(earnings, spendings) + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarnings(earnings) + " рублей");
                        System.out.println("Экономия: " + (taxEarnings(earnings) - taxEarningsMinusSpendings(earnings, spendings)) + " рублей");
                    } else if (taxEarnings(earnings) < taxEarningsMinusSpendings(earnings, spendings)) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxEarnings(earnings) + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings(earnings, spendings) + " рублей");
                        System.out.println("Экономия: " + (taxEarningsMinusSpendings(earnings, spendings) - taxEarnings(earnings)) + " рублей");
                    }else if (taxEarnings(earnings) == taxEarningsMinusSpendings(earnings, spendings)) {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }

        }
        System.out.println();
        System.out.println("Программа завершена!");
    }
    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        return tax;
    }
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

}
