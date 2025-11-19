public class LutadorMedio extends Lutador {
    public LutadorMedio(String nome) {
        super(nome, 120, 100, 20);
    }

    @Override
    public void atacar(Lutador oponente) {
        // REQUISITO 3: Consistência de Combate
        if (!this.estaVivo() || !oponente.estaVivo()) {
            System.out.println("Ataque não realizado. Lutador(es) nocauteado(s).");
            return;
        }

        if (oponente.tentarDesviar()) return;

        int dano = forca + 10;
        oponente.receberDano(dano);

        System.out.println(nome + " atacou causando " + dano + " de dano!");
        energia -= 7;
    }

    @Override
    public void ataqueEspecial(Lutador oponente) {
        // REQUISITO 3: Consistência de Combate
        if (!this.estaVivo() || !oponente.estaVivo()) {
            System.out.println("Ataque Especial não realizado. Lutador(es) nocauteado(s).");
            return;
        }

        int gasto = 15;
        // REQUISITO 2: Validação de Energia
        if (energia < gasto) {
            System.out.println(nome + ": Energia insuficiente (" + gasto + ") para o ataque especial!");
            return;
        }

        energia -= gasto;
        int dano = forca + gasto;
        oponente.receberDano(dano);

        System.out.println(nome + " usou ataque especial!");
        System.out.println(oponente.nome + " perdeu " + dano + " de vida!");
    }
}