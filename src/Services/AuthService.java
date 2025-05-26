package Services;

import entities.Card;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, Card> cards = new HashMap<>();
    private int failedAttempts = 0;
    private long blockedUntil = 0;

    public AuthService() {
        cards.put("0124", new Card("0124", "ma171"));
    }

    public boolean isBlocked(){
        return System.currentTimeMillis() < blockedUntil;
    }

    public String authenticate(String cardNumber, String password) {
        if (isBlocked()) {
            long tempoRestante = (blockedUntil - System.currentTimeMillis()) / 1000; // em segundos

            long minutos = tempoRestante / 60;
            long segundos = tempoRestante % 60;

            return String.format("Cartão bloqueado. Tente novamente em %d minuto(s) e %d segundo(s).", minutos, segundos);
        }

        Card card = cards.get(cardNumber);
        if (card == null) {
            return "Cartão inválido.";
        }

        if (card.validatePassword(password)) {
            failedAttempts = 0;
            return "Acesso permitido. Seja bem vindo!";
        } else {
            failedAttempts++;
            if (failedAttempts >= 3) {
                blockedUntil = System.currentTimeMillis() + 2 * 60 * 1000; // 2 minutos
                return "Senha incorreta 3 vezes. Cartão bloqueado por 2 minutos.";
            }
            return "Senha incorreta. Tentativas restantes: " + (3 - failedAttempts);
        }
    }

    public void cancelOperation() {
        failedAttempts = 0;
        System.out.println("Operação cancelada.");
    }

    public String showCards() {
        StringBuilder sb = new StringBuilder();
        System.out.println("\n--- Cartões Registrados---");
        for (Card card : cards.values()) {
            sb.append("Cartão: ").append(card.getCardNumber()).append("\n");
        }
        return sb.toString();
    }

}
