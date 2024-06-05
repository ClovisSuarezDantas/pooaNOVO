package App;
import org.example.interfaces.PaymentMethord;
import org.example.interfaces.impls.BoletoPayment;
import org.example.interfaces.impls.CardPayment;
import org.example.interfaces.impls.PixPayment;

import java.time.LocalDate;

import java.util.Scanner;

public class app {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            PaymentMethord paymentMethord = null;

            System.out.println("Escolha o método de pagamento:");
            System.out.println("1. Boleto");
            System.out.println("2. PIX");
            System.out.println("3. Cartão de Crédito");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Digite o número do boleto: ");
                    String boletoNumber = scanner.nextLine();
                    System.out.print("Digite a data de vencimento do boleto (yyyy-MM-dd): ");
                    String dueDateStr = scanner.nextLine();
                    LocalDate dueDate = LocalDate.parse(dueDateStr);
                    paymentMethord = new BoletoPayment(boletoNumber, dueDate);
                    break;
                case 2:
                    System.out.print("Digite a chave PIX (email, CPF ou telefone): ");
                    String pixKey = scanner.nextLine();
                    paymentMethord = new PixPayment(pixKey);
                    break;
                case 3:
                    System.out.print("Digite o número do cartão de crédito: ");
                    String cardNumber = scanner.nextLine();
                    System.out.print("Digite a data de validade do cartão (MM/yy): ");
                    String expiryDate = scanner.nextLine();
                    paymentMethord = new CardPayment(cardNumber, expiryDate);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    System.exit(1);
            }

            paymentMethord.processPayment();
        }

}
