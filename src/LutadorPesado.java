public class LutadorPesado extends Lutador{
    public LutadorPesado (String nome){
        super(nome, 150, 100, 30);
    }

    @Override
    public void atacar (Lutador oponente){
        if (oponente.tentarDesviar()) return;

        int dano = forca + 20;
        oponente.vida -= dano;
        System.out.println(nome + " atacou causando " + dano + " de dano!");
    }

    @Override
    public void ataqueEspecial (Lutador oponente){
        int gasto = 45;
        oponente.energia -= gasto;
        System.out.println(nome + " usou ataque especial removendo " + gasto + " de energia!");
    }
}