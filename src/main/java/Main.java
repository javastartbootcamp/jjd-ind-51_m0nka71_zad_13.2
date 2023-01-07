import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        List<Integer> numbers = createList(scanner);

        reverseAndPrintNumbers(numbers);
        System.out.println();
        sumAndPrintNumbers(numbers);
        System.out.println("Najmniejsza liczba w liście to " + findLowestNumber(numbers));
        System.out.println("Największa liczba w liście to " + findHighestNumber(numbers));
    }

    private List createList(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Podaj liczby");
        int userInput = scanner.nextInt();

        try {
            if (userInput <= 0) {
                throw new IncorrectNumberException();
            }
        } catch (IncorrectNumberException e) {
            System.err.println(e.getMessage());
        }

        while (userInput > 0) {
            numbers.add(userInput);
            userInput = scanner.nextInt();
        }

        return numbers;
    }

    public void reverseAndPrintNumbers(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            sb.append(numbers.get(i));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public void sumAndPrintNumbers(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
            sb.append(numbers.get(i));
            if (numbers.size() > 0) {
                sb.append("+");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "=");
        sb.append(sum);
        System.out.print(sb + "\n");
    }

    private int findLowestNumber(List<Integer> numbers) {
        int lowestNumber = numbers.get(0);
        for (Integer number : numbers) {
            if (number < lowestNumber) {
                lowestNumber = number;
            }
        }
        return lowestNumber;
    }

    private int findHighestNumber(List<Integer> numbers) {
        int highestNumber = numbers.get(0);
        for (Integer number : numbers) {
            if (number > highestNumber) {
                highestNumber = number;
            }
        }
        return highestNumber;
    }
}
