import java.util.*;

public class Main {
    // Mantém o Scanner como estático para uso em toda a classe
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        // 1. Lendo a Quantidade de Lutadores (Com Try-Catch e Do-While)
        int quantidade = lerQuantidade("Quantos lutadores deseja criar? ");

        Lutador[] lutadores = new Lutador[quantidade];

        // Loop de Criação de Lutadores
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nCriando lutador " + (i + 1));

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.println("Tipo:");
            System.out.println("1 - Leve");
            System.out.println("2 - Médio");
            System.out.println("3 - Pesado");

            // 2. Lendo o Tipo de Lutador (Com Try-Catch e Do-While)
            int tipo = lerOpcaoMenu("Escolha: ");

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
                    System.out.println("Opção inválida! Criando lutador leve por padrão.");
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

        // Loop principal da luta
        do {
            System.out.println("\n === TURNO " + (turno++) + " ===");

            for (int i = 0; i < lutadores.length; i++) {

                Lutador atacante = lutadores[i];

                if (!atacante.estaVivo()) continue;

                Lutador alvo = escolherAlvo(lutadores, i);
                if (alvo == null) break;

                System.out.println("\nTurno de: " + atacante.nome);
                // 3. Execução do Turno (Com Try-Catch e Do-While)
                executarTurno(atacante, alvo);
            }

            vivos = contarVivos(lutadores);

        } while (vivos > 1);

        // Exibição do Vencedor
        for (Lutador l : lutadores) {
            if (l.estaVivo()) {
                System.out.println("\n===== FIM DA LUTA =====");
                System.out.println("Vencedor: " + l.nome);
                break;
            }
        }
    }

    // Método auxiliar para ler a quantidade de lutadores
    private static int lerQuantidade(String prompt) {
        int valor = 0;
        boolean sucesso = false;

        do {
            System.out.print(prompt);
            try {
                valor = entrada.nextInt();
                entrada.nextLine(); // Consome a quebra de linha
                sucesso = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite apenas números inteiros.");
                entrada.nextLine();
            }
        } while (!sucesso);

        return valor;
    }

    // Metodo auxiliar para ler as opções de Menu (Tipo de Lutador ou Ação)
    private static int lerOpcaoMenu(String prompt) {
        int valor = 0;
        boolean sucesso = false;

        do {
            System.out.print(prompt);
            try {
                valor = entrada.nextInt();
                entrada.nextLine(); // Consome a quebra de linha
                sucesso = true;
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, digite 1, 2 ou 3.");
                entrada.nextLine();
            }
        } while (!sucesso);

        return valor;
    }

    // Metodo auxiliar para escolher alvo (lógica original)
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

    // Metodo auxiliar para contar vivos (lógica original)
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

        // 3. Leitura da Opção do Turno
        int opcao = lerOpcaoMenu("Escolha: "); // Usa o metodo seguro

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
                System.out.println("Opção inválida! O lutador perdeu o turno.");
        }

        System.out.println("\nStatus atualizado: ");
        atacante.mostrarStatus();
        alvo.mostrarStatus();
    }
}