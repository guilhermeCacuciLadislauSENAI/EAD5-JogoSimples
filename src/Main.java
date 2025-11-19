import java.util.*;

public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Quantos lutadores deseja criar? ");
        int quantidade = entrada.nextInt();
        entrada.nextLine();

        Lutador[] lutadores = new Lutador[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nCriando lutador " + (i + 1));

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.println("Tipo:");
            System.out.println("1 - Leve");
            System.out.println("2 - Médio");
            System.out.println("3 - Pesado");
            System.out.print("Escolha: ");
            int tipo = entrada.nextInt();
            entrada.nextLine();

            switch (tipo) {
                case 1:
                    lutadores[i] = new LutadorLeve(nome);
                    break;
                case 2:
                    lutadores[i] = new LutadorMedio(nome);
                    break;
                case 3:
                    lutadores[i] = new LutadorPesado(nome);
                    break;
                default:
                    System.out.println("Tipo inválido! Criando lutador leve por padrão.");
                    lutadores[i] = new LutadorLeve(nome);
            }
        }

        System.out.println("\n=== Lutadores cadastrados ===");
        for (Lutador l : lutadores) {
            l.mostrarStatus();
            System.out.println("-----------------------------");
        }

        int turno = 1;
        int vivos;

        do {
            System.out.println("\n === TURNO " + (turno++) + " ===");

            for (int i = 0; i < lutadores.length; i++) {

                Lutador atacante = lutadores[i];

                if (!atacante.estaVivo()) continue;

                Lutador alvo = escolherAlvo(lutadores, i);
                if (alvo == null) break;

                System.out.println("\nTurno de: " + atacante.nome);
                executarTurno(atacante, alvo);
            }

            vivos = contarVivos(lutadores);

        } while (vivos > 1);

        for (Lutador l : lutadores) {
            if (l.estaVivo()) {
                System.out.println("\n===== FIM DA LUTA =====");
                System.out.println("Vencedor: " + l.nome);
                break;
            }
        }
    }

    // Escolhe alvo aleatório vivo
    private static Lutador escolherAlvo(Lutador[] lutadores, int atacanteIndice) {

        List<Lutador> possiveis = new ArrayList<>();

        for (int i = 0; i < lutadores.length; i++) {
            if (i != atacanteIndice && lutadores[i].estaVivo()) {
                possiveis.add(lutadores[i]);
            }
        }

        if (possiveis.isEmpty()) return null;

        return possiveis.get(new Random().nextInt(possiveis.size()));
    }

    private static int contarVivos(Lutador[] lutadores) {
        int vivos = 0;
        for (Lutador l : lutadores) {
            if (l.estaVivo()) vivos++;
        }
        return vivos;
    }

    private static void executarTurno(Lutador atacante, Lutador alvo) {

        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Ataque");
        System.out.println("2 - Ataque especial");
        System.out.println("3 - Defender");
        int opcao = entrada.nextInt();

        switch (opcao) {

            case 1:
                atacante.atacar(alvo);
                break;
            case 2:
                atacante.ataqueEspecial(alvo);
                break;
            case 3:
                atacante.defender();
                break;
            default:
                System.out.println("Opção inválida!");
        }

        System.out.println("\nStatus atualizado: ");
        atacante.mostrarStatus();
        alvo.mostrarStatus();
    }
}
