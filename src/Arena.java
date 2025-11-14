import java.util.Scanner;

public class Arena {
    Scanner entrada = new Scanner(System.in);

    public void lutar(Lutador[] lutadores) {
        System.out.println("=== INÍCIO DA LUTA ===");

        // Mostrar status inicial
        for (Lutador l : lutadores) {
            l.mostrarStatus();
        }

        int vivos;
        int turno = 0;

        // Enquanto mais de 1 estiver vivo
        do {
            System.out.println("\n--- TURNO " + (turno++) + " ---");

            for (int i = 0; i < lutadores.length; i++) {
                Lutador atacante = lutadores[i];

                if (!atacante.estaVivo()) continue; // morto não joga

                // escolher alvo vivo
                Lutador alvo = escolherAlvo(lutadores, i);
                if (alvo == null) break;

                System.out.println("\nTurno de: " + atacante.nome);
                executarTurno(atacante, alvo);
            }

            vivos = contarVivos(lutadores);

        } while (vivos > 1);

        // Mostrar vencedor
        for (Lutador l : lutadores) {
            if (l.estaVivo()) {
                System.out.println("\n--- FIM DA LUTA ---");
                System.out.println("Vencedor: " + l.nome);
                break;
            }
        }
    }

    private Lutador escolherAlvo(Lutador[] lutadores, int atacanteIndex) {
        for (int i = 0; i < lutadores.length; i++) {
            if (i != atacanteIndex && lutadores[i].estaVivo()) {
                return lutadores[i];
            }
        }
        return null;
    }

    private int contarVivos(Lutador[] lutadores) {
        int vivos = 0;
        for (Lutador l : lutadores) {
            if (l.estaVivo()) vivos++;
        }
        return vivos;
    }

    private void executarTurno(Lutador ativo, Lutador alvo) {
        System.out.println("Escolha a ação:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Ataque Especial");
        System.out.println("3 - Defender");

        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                ativo.atacar(alvo);
                break;

            case 2:
                ativo.ataqueEspecial(alvo);
                break;

            case 3:
                ativo.defender();
                break;

            default:
                System.out.println("Opção inválida! Perdeu o turno!");
        }

        System.out.println("\nStatus atualizado:");
        ativo.mostrarStatus();
        alvo.mostrarStatus();
    }
}
