import java.util.Scanner;

class Calculadora {
    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) throw new ArithmeticException("Divisão por zero.");
        return a / b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner sc = new Scanner(System.in);
        String continuar = "";

        while (true) {
            try {
                System.out.print("Primeiro número: ");
                double num1 = Double.parseDouble(sc.nextLine());

                System.out.print("Segundo número: ");
                double num2 = Double.parseDouble(sc.nextLine());

                System.out.print("Operação (+, -, *, /): ");
                String op = sc.nextLine();

                double resultado = 0;
                switch (op) {
                    case "+":
                        resultado = calc.somar(num1, num2);
                        break;
                    case "-":
                        resultado = calc.subtrair(num1, num2);
                        break;
                    case "*":
                        resultado = calc.multiplicar(num1, num2);
                        break;
                    case "/":
                        resultado = calc.dividir(num1, num2);
                        break;
                    default:
                        System.out.println("Operação inválida!");
                        continue;
                }
                System.out.println("Resultado: " + resultado);
            } catch (NumberFormatException ex) {
                System.out.println("Digite apenas números válidos.");
            } catch (ArithmeticException ex) {
                System.out.println("Erro: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Erro inesperado: " + ex.getMessage());
            }

            while (true) {
                System.out.print("Deseja continuar? (s/n): ");
                continuar = sc.nextLine().toLowerCase().trim();
                if (continuar.equals("n") || continuar.equals("não") || continuar.equals("nao")) {
                    return; // Sai do programa
                } else if (continuar.equals("s") || continuar.equals("sim")) {
                    break; // Sai do loop e continua o programa
                } else {
                    System.out.println("Valor inválido! Digite 's', 'sim', 'n', 'não' ou 'nao'.");
                }
            }
        }
    }
}
