public class LutadorPesado extends Lutador {
    public LutadorPesado(String nome) {
        super(nome, 150, 80, 30);
    }

    @Override
    public void atacar(Lutador oponente) {
        // REQUISITO 3: Consistência de Combate
        if (!this.estaVivo() || !oponente.estaVivo()) {
            System.out.println("Ataque não realizado. Lutador(es) nocauteado(s).");
            return;
        }

        if (oponente.tentarDesviar()) return;

        int dano = forca + 20;
        oponente.receberDano(dano);

        System.out.println(nome + " atacou causando " + dano + " de dano!");
        energia -= 10;
    }

    @Override
    public void ataqueEspecial(Lutador oponente) {
        // REQUISITO 3: Consistência de Combate
        if (!this.estaVivo() || !oponente.estaVivo()) {
            System.out.println("Ataque Especial não realizado. Lutador(es) nocauteado(s).");
            return;
        }

        int gasto = 25;
        // REQUISITO 2: Validação de Energia
        if (energia < gasto) {
            System.out.println(nome + ": Energia insuficiente (" + gasto + ") para o ataque especial!");
            return;
        }

        energia -= gasto;
        int dano = forca + gasto + 10;
        oponente.receberDano(dano);

        System.out.println(nome + " usou ataque especial poderoso!");
        System.out.println(oponente.nome + " perdeu " + dano + " de vida!");
    }
}