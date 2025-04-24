package biblioteca.modelo;

public abstract class ItemBiblioteca {
    protected String titulo;
    protected boolean disponivel = true;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
}