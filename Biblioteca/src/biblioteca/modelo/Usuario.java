package biblioteca.modelo;

import java.util.*;

public class Usuario {
    private String nome;
    private int id;
    private List<Livro> livrosEmprestados = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
        this.id = gerarIdAleatorio();
    }

    private int gerarIdAleatorio() {
        Random rand = new Random();
        return 1000 + rand.nextInt(9000);
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
    
    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }


    protected void adicionarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }

    protected void removerLivroEmprestado(Livro livro) {
        livrosEmprestados.remove(livro);
    }

    public void exibirLivrosEmprestados() {
        System.out.println("\nLivros emprestados para " + nome + ":");
        if (livrosEmprestados.isEmpty()) {
            System.out.println("Nenhum livro emprestado.");
        } else {
            for (Livro livro : livrosEmprestados) {
                System.out.println(" - " + livro.getTitulo());
            }
        }
    }
    
    //Método apenas para teste no Main//
    public void setId(int id) {
    	this.id = id;
    }
}

