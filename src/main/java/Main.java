import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    // napisz swój program tutaj. Do wczytywania danych użyj przekazanego w parametrze scannera
    ArrayList<Integer> numbers = new ArrayList<>();

    public void run(Scanner scanner) {
        System.out.println("Podaj liczby");
        int userInput = scanner.nextInt();

        while (userInput > 0) {
            numbers.add(userInput);
            userInput = scanner.nextInt();
        }

        reverseAndPrintNumbers(numbers);
        System.out.println();
        sumAndPrintNumbers(numbers);
        System.out.println("Najmniejsza liczba w liście to " + findLowestNumber(numbers));
        System.out.println("Największa liczba w liście to " + findHighestNumber(numbers));
    }

    public void reverseAndPrintNumbers(ArrayList<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            sb.append(numbers.get(i));
            sb.append(",");
            System.out.print(sb);
            //Dlaczego zwraca jakaś dziwna kolejność?

//          sb.replace(sb.length() - 1, sb.length(), ",");
//          sb.append(numbers);
//          System.out.print(sb);
        }
    }

    public void sumAndPrintNumbers(ArrayList<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
            if (!numbers.isEmpty()) {
                int newSum = 0;
                for (Integer number : numbers) {
                    sb.append(number);
                    sb.append("+");
                    newSum += number;
                }
                sb.replace(sb.length() - 1, sb.length(), "=");
                sb.append(newSum);
                System.out.print(sb + "\n");
            } //Dlaczego drukuje sie tyle razy?
        }
    }

    private int findLowestNumber(ArrayList<Integer> numbers) {
        int lowestNumber = numbers.get(0);
        for (Integer number : numbers) {
            if (number < lowestNumber) {
                lowestNumber = number;
            }
        }
        return lowestNumber;
    }

    private int findHighestNumber(ArrayList<Integer> numbers) {
        int highestNumber = numbers.get(0);
        for (Integer number : numbers) {
            if (number > highestNumber) {
                highestNumber = number;
            }
        }
        return highestNumber;
    }
}
