public class LutadorLeve extends Lutador{
public LutadorLeve(String nome) {
        super(nome, 100, 100, 10);
    }

    @Override
    public void atacar(Lutador oponente){
        if (oponente.tentarDesviar()) return;

        int dano = forca + 5;
        oponente.vida -= dano;
        System.out.println(nome + " atacou causando " + dano + " de dano!");
    }

    @Override
    public void ataqueEspecial (Lutador oponente){
        int gasto = 15;
        this.energia -= gasto;
        oponente.vida -= gasto;
        System.out.println(nome + " usou ataque especial removendo " + gasto + " de sua energia!");
        System.out.println(oponente.nome + " perdeu " + gasto + " de vida!");
    }
}