public class LutadorMedio extends Lutador{
public LutadorMedio (String nome){
        super(nome, 120, 100, 20);
    }

    @Override
    public void atacar(Lutador oponente){
        if (oponente.tentarDesviar()) return;

        int dano = forca + 10;
        oponente.vida -= dano;
        System.out.println(nome + " atacou causando " + dano + " de dano!");
    }

    @Override
    public void ataqueEspecial (Lutador oponente){
        int gasto = 30;
        oponente.energia -= gasto;
        System.out.println(nome + " usou ataque especial removendo " + gasto + " de energia!");
    }
}