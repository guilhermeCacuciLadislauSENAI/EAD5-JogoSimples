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
        energia -= gasto;
        oponente.vida -= (forca + gasto);
        System.out.println(nome + " usou ataque especial!");
        System.out.println(oponente.nome + " perdeu " + (forca + gasto) + " de vida!");
    }
}
