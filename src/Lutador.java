public abstract class Lutador {
    String nome;
    int vida;
    int energia;
    int forca;

    public Lutador(String nome, int vida, int energia, int forca) {
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
        this.forca = forca;
    }

    public abstract void atacar(Lutador oponente);
    public abstract void ataqueEspecial(Lutador oponente);

    public void defender() {
        if (energia < 20) {
            energia += 20;
            System.out.println(nome + " recuperou 20 de energia.");
        } else {
            energia -= 5;

            int reducao = forca;
            System.out.println(nome + " defendeu! Redução de dano: " + reducao);
            System.out.println("Energia gasta: 5.");
        }
    }

    public void mostrarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Energia: " + energia);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void curar(int pontos) {
        this.vida += pontos;
        if (this.vida > 100) this.vida = 100;
        System.out.println(nome + " se curou " + pontos + " pontos.");
    }

    public boolean tentarDesviar() {
        double chance = Math.random();
        if (chance < 0.20) {
            System.out.println(nome + " desviou do ataque!");
            return true;
        }
        return false;
    }

    // NOVO METODO: Centraliza a lógica de recebimento de dano para garantir vida >= 0 (Requisito 1)
    private void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0; // Força a vida a ser zero, impedindo valores negativos.
            System.out.println(this.nome + " foi nocauteado!");
        }
    }
}