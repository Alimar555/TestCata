import java.util.Scanner;

public class Main {

    public static String textModifier() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Шаг A: Оставляем только один пробел между словами
        StringBuilder result = new StringBuilder();
        boolean isSpace = false;
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                if (!isSpace) {
                    result.append(c);
                }
                isSpace = true;
            } else {
                result.append(c);
                isSpace = false;
            }
        }

        // Шаг B: Меняем символы местами вокруг знака "-"
        for (int i = 0; i < result.length() - 1; i++) {
            if (result.charAt(i) == '-') {
                char leftChar = result.charAt(i - 1);
                char rightChar = result.charAt(i + 1);
                result.setCharAt(i - 1, rightChar);
                result.setCharAt(i + 1, leftChar);
                result.deleteCharAt(i); // Удаляем "-"
                i--; // Корректируем индекс после удаления
            }
        }

        // Шаг C: Заменяем "+" на "!"
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '+') {
                result.setCharAt(i, '!');
            }
        }

        // Шаг D: Удаляем цифры и считаем их сумму
        int sum = 0;
        for (int i = 0; i < result.length(); i++) {
            char currentChar = result.charAt(i);
            if (Character.isDigit(currentChar)) {
                sum += Character.getNumericValue(currentChar);
                result.deleteCharAt(i);
                i--; // Корректируем индекс после удаления
            }
        }

        // Если сумма больше 0, добавляем её в конец строки
        if (sum > 0) {
            result.append(" ").append(sum);
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(textModifier());
    }
}
