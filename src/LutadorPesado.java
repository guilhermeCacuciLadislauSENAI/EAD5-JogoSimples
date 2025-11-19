public class LutadorPesado extends Lutador {
    public LutadorPesado(String nome) {
        super(nome, 150, 100, 30);
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
        int gasto = 15;
        energia -= gasto;
        oponente.vida -= (forca + gasto);
        System.out.println(nome + " usou ataque especial!");
        System.out.println(oponente.nome + " perdeu " + (forca + gasto) + " de vida!");
    }
}
