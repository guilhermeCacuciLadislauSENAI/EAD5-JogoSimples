public class LutadorMedio extends Lutador {
    public LutadorMedio(String nome) {
        super(nome, 120, 100, 20);
    }

    @Override
    public void atacar(Lutador oponente) {
        if (oponente.tentarDesviar()) return;

        int dano = forca + 10;
        oponente.vida -= dano;
        System.out.println(nome + " atacou causando " + dano + " de dano!");
        energia -= 7;
    }

    @Override
    public void ataqueEspecial(Lutador oponente) {
        int gasto = 15;
        energia -= gasto;
        oponente.vida -= (forca + gasto);
        System.out.println(nome + " usou ataque especial!");
        System.out.println(oponente.nome + " perdeu " + (forca + gasto) + " de vida!");
    }
}
