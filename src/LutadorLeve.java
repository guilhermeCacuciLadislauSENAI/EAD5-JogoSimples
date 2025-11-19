public class LutadorLeve extends Lutador {
    public LutadorLeve(String nome) {
        super(nome, 100, 100, 10);
    }

    @Override
    public void atacar(Lutador oponente) {
        if (oponente.tentarDesviar()) return;

        int dano = forca + 5;
        oponente.vida -= dano;
        System.out.println(nome + " atacou causando " + dano + " de dano!");
        energia -= 5;
    }

    @Override
    public void ataqueEspecial(Lutador oponente) {
        int gasto = 15;

        // Verificação de Energia Adicionada
        if (energia < gasto) {
            System.out.println(nome + " não tem energia suficiente (" + gasto + ") para o ataque especial!");
            return;
        }

        energia -= gasto;
        oponente.vida -= (forca + gasto);
        System.out.println(nome + " usou ataque especial!");
        System.out.println(oponente.nome + " perdeu " + (forca + gasto) + " de vida!");
    }
}