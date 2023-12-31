import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidParametersException extends Exception {
    public InvalidParametersException(String message) {
        super(message);
    }
}

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        int parametroUm = getInputNumber("Digite o primeiro parâmetro:", terminal);
        int parametroDois = getInputNumber("Digite o segundo parâmetro:", terminal);

        try {
            count(parametroUm, parametroDois);
        } catch (InvalidParametersException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static int getInputNumber(String message, Scanner scanner) {
        int number;
        while (true) {
            try {
                System.out.println(message);
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); 
            }
        }
        return number;
    }

    static void count(int parametroUm, int parametroDois) throws InvalidParametersException {
        if (parametroUm > parametroDois) {
            throw new InvalidParametersException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int count = parametroDois - parametroUm;
        for (int i = 1; i < count + 1; i++) {
            System.out.println("Imprimindo o número " + i);
        }

        System.out.println("Total de iterações entre " + parametroUm + " e " + parametroDois + " foi de: " + count);
    }
}