package com.example.myapplication;

public class Algorithm {

    private static int a;

    // создание пустого конструктора
    public Algorithm() {
    }

    // метод определения счастливого билета по Питерской системе
    public static boolean isHappyStPetersburg(int x) {
        int s1 =0, s2 = 0;
        for(int i = 0; i < 3; i++) {
            s1 += x % 10;
            x = x / 10;
            s2 += x % 10;
            x = x / 10;
        }
        if (s1 == s2)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        System.out.println("Введите номер билета.");
        if (isHappyStPetersburg(a))
            System.out.println("Питерский счастливый билет.");
        if (!isHappyStPetersburg(a))
            System.out.println("Обычный билет.");
    }

    // метод определения следующего счастливого билета (чуть менее быстрый)
    public int nextHappyTicketV1(String input) {
        int inputInt = Integer.parseInt(input); // конвертирование данных из String в int

        if(!isHappyStPetersburg(Integer.parseInt(Integer.toString(inputInt)))) { // если билет не счастливый
            while (!isHappyStPetersburg(Integer.parseInt(Integer.toString(inputInt)))) { // то выполняется цикл
                inputInt = inputInt + 1; // шаговой проверки следующих билетов до наступления счастливого билета
            }
            return inputInt; // возвращается найденный счастливый билет
        } else { // иначе (в случае изначально счастливого билета)
            return inputInt; // возвращается счастливый билет
        }
    }

    // метод определения следующего счастливого билета (быстрее)
    public int nextHappyTicketV2(String input) {
        int inputInt = Integer.parseInt(input); // конвертирование данных из String в int
        int count = 0; // задание счётчика

        for (int i = inputInt; i < 1_000_000; i++) { // цикл проверки и поиски счастливого билета
            int s1 = i%10 + (i/10)%10 + (i/100)%10; // подсчёт суммы последних трёх чисел
            int j = i / 1000;
            int s2 = j%10 + (j/10)%10 + (j/100)%10; // подсчёт суммы первых трёх чисел
            if (s1 == s2) { // проверка счастливого билета
                break; // выброс из цикла
            } else { // иначе
                count++; // увеличение счётчика на единицу
            }
        }

        return inputInt + count; // вывод счастливого билета
    }
}


