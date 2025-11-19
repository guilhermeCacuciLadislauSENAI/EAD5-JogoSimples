public class LutadorLeve extends Lutador {
    public LutadorLeve(String nome) {
        super(nome, 100, 100, 10);
    }

    @Override
    public void atacar(Lutador oponente) {
        // REQUISITO 3: Consistência de Combate
        if (!this.estaVivo() || !oponente.estaVivo()) {
            System.out.println("Ataque não realizado. Lutador(es) nocauteado(s).");
            return;
        }

        if (oponente.tentarDesviar()) return;

        int dano = forca + 5;
        // oponente.vida -= dano; // Substituído pela chamada ao novo método
        oponente.receberDano(dano); // Agora usa a lógica centralizada de dano

        System.out.println(nome + " atacou causando " + dano + " de dano!");
        energia -= 5;
    }

    @Override
    public void ataqueEspecial(Lutador oponente) {
        // REQUISITO 3: Consistência de Combate
        if (!this.estaVivo() || !oponente.estaVivo()) {
            System.out.println("Ataque Especial não realizado. Lutador(es) nocauteado(s).");
            return;
        }

        int gasto = 15;
        // REQUISITO 2: Validação de Energia (já resolvido)
        if (energia < gasto) {
            System.out.println(nome + ": Energia insuficiente (" + gasto + ") para o ataque especial!");
            return;
        }

        energia -= gasto;
        int dano = forca + gasto;
        oponente.receberDano(dano); // Agora usa a lógica centralizada de dano

        System.out.println(nome + " usou ataque especial!");
        System.out.println(oponente.nome + " perdeu " + dano + " de vida!");
    }
}