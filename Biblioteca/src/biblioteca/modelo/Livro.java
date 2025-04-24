package biblioteca.modelo;

import java.util.Random;

import biblioteca.interfaces.Emprestavel;

public class Livro extends ItemBiblioteca implements Emprestavel {
    private String autor;
    private boolean disponivel = true;
    private Usuario emprestadoPara;
    private int id;

    public Livro(String titulo, String autor) {
        super(titulo);
        this.autor = autor;
        this.id = gerarIdAleatorio();
    }
    
    private int gerarIdAleatorio() {
        Random rand = new Random();
        return 1000 + rand.nextInt(9000);
    }

    public String getAutor() {
        return autor;
    }
    
    public int getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Usuario getEmprestadoPara() {
        return emprestadoPara;
    }

    protected void marcarComoEmprestado(Usuario usuario) {
        this.emprestadoPara = usuario;
        this.disponivel = false;
    }

    protected void marcarComoDevolvido() {
        this.emprestadoPara = null;
        this.disponivel = true;
    }

    public void exibirStatus() {
        if (disponivel) {
            System.out.println("- \"" + titulo + "\" (Autor: " + autor + ") (ID: " + id + ") - Disponível");
        } else {
            System.out.println("- \"" + titulo + "\" (Autor: " + autor + ") (ID: " + id + ") - Emprestado para " + emprestadoPara.getNome());
        }
    }
    
    //Método apenas para teste no Main//
    public void setId(int id) {
    	this.id = id;
    }
    
}
