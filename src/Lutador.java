abstract public class Lutador {
    String nome;
    int vida;
    int energia;
    int forca;

    public Lutador (String nome, int vida, int energia, int forca){
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
        this.forca = forca;
    }

    public abstract void atacar(Lutador oponente);
    public abstract void ataqueEspecial(Lutador oponente);

    public void defender (){
        if (energia < 20){
            energia += 20;
            System.out.println("Recuperando energia.");
        } else{
            int reducao = forca;
            System.out.println("Defendeu! Redução: " + reducao);
        }
    }

    public void mostrarStatus(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Energia: " + this.energia);
    }

    public boolean estaVivo(){
        if (this.vida > 0){
            System.out.println("Está vivo!");
            return true;
        } else{
            System.out.println("Está morto!");
            return false;
        }
    }

    public void curar() {
        this.vida += 20;
        if (this.vida > 100) this.vida = 100;  // limita vida
        System.out.println(nome + " se curou 20 pontos.");
    }

    public void curar(int pontos) {
        this.vida += pontos;
        if (this.vida > 100) this.vida = 100;
        System.out.println(nome + " se curou " + pontos + " pontos.");
    }

    public boolean tentarDesviar() {
        double chance = Math.random();

        if (chance < 0.20) { // 20% de chance
            System.out.println(nome + " desviou do ataque!");
            return true;
        }
        return false;
    }

}