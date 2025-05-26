import Services.AuthService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();

        while (true) {
            System.out.println("\n--- Validação de Usuário ---");
            System.out.print("Digite o número do cartão (ou 'cancelar'): ");
            String card = scanner.nextLine();

            if (card.equalsIgnoreCase("cancelar")) {
                authService.cancelOperation();
                continue;
            }

            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            String resultado = authService.authenticate(card, senha);
            System.out.println(resultado);

//            System.out.println(authService.showCards());
        }
    }
}
