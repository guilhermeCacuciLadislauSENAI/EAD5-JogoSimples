import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Quantos lutadores deseja criar? ");
        int quantidade = entrada.nextInt();
        entrada.nextLine(); // limpar buffer

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
            entrada.nextLine(); // limpar buffer

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

        // Mostra todos os lutadores criados
        System.out.println("\n--- Lutadores cadastrados ---");
        for (Lutador l : lutadores) {
            l.mostrarStatus();
        }

        Arena arena = new Arena();
        arena.lutar(lutadores); // agora passa o array inteiro
    }
}
