public class LutadorPesado extends Lutador {
    public LutadorPesado(String nome) {
        super(nome, 150, 80, 30);
    }

    @Override
    public void atacar(Lutador oponente) {
        if (oponente.tentarDesviar()) return;

        int dano = forca + 20;
        oponente.vida -= dano;
        System.out.println(nome + " atacou causando " + dano + " de dano!");
        energia -= 10;
    }

    @Override
    public void ataqueEspecial(Lutador oponente) {
        int gasto = 25; // Aumentei o custo para refletir o alto dano base (força=30)

        // Verificação de Energia Adicionada
        if (energia < gasto) {
            System.out.println(nome + " não tem energia suficiente (" + gasto + ") para o ataque especial!");
            return;
        }

        energia -= gasto;
        int dano = forca + gasto + 10; // Dano ligeiramente maior para o Pesado
        oponente.vida -= dano;

        System.out.println(nome + " usou ataque especial poderoso!");
        System.out.println(oponente.nome + " perdeu " + dano + " de vida!");
    }
}