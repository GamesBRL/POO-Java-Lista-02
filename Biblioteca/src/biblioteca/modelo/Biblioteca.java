package biblioteca.modelo;

import java.util.*;

import biblioteca.exception.*;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public void excluirUsuario(int idUsuario) throws UsuarioNaoEncontradoException {
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Usuário com ID " + idUsuario + " não encontrado.");
        }
        if (!usuario.getLivrosEmprestados().isEmpty()) {
            System.out.println("Não é possível excluir. O usuário possui livros emprestados.");
            return;
        }
        usuarios.remove(usuario);
        System.out.println("Usuário removido com sucesso: " + usuario.getNome());
    }
    
    public void excluirLivro(int titulo) throws LivroNaoEncontradoException {
        Livro livro = buscarLivro(titulo);
        if (livro == null) {
            throw new LivroNaoEncontradoException("Livro \"" + titulo + "\" não encontrado.");
        }
        if (!livro.isDisponivel()) {
            System.out.println("Não é possível excluir. O livro está emprestado.");
            return;
        }
        livros.remove(livro);
        System.out.println("Livro removido com sucesso: " + titulo);
    }

    public void emprestarLivro(int idLivro, int idUsuario)
            throws LivroIndisponivelException, UsuarioNaoEncontradoException, LivroNaoEncontradoException {

        Usuario usuario = buscarUsuario(idUsuario);
        Livro livro = buscarLivro(idLivro);

        if (livro == null) throw new LivroNaoEncontradoException("Livro \"" + idLivro + "\" não encontrado.");
        if (usuario == null) throw new UsuarioNaoEncontradoException("Usuário com ID " + idUsuario + " não encontrado.");
        if (!livro.isDisponivel()) throw new LivroIndisponivelException("Livro com ID \"" + idLivro + "\" está indisponível.");

        livro.marcarComoEmprestado(usuario);
        usuario.adicionarLivroEmprestado(livro);
        System.out.println("\nLivro \"" + livro.getTitulo() + "\" emprestado para " + usuario.getNome());
    }

    public void devolverLivro(int idLivro) throws LivroNaoEncontradoException {
        Livro livro = buscarLivro(idLivro);
        if (livro == null) throw new LivroNaoEncontradoException("Livro com ID \"" + idLivro + "\" não encontrado.");

        if (!livro.isDisponivel()) {
            Usuario usuario = livro.getEmprestadoPara();
            livro.marcarComoDevolvido();
            usuario.removerLivroEmprestado(livro);
            System.out.println("Livro com ID \"" + idLivro + "\" devolvido.");
        } else {
            System.out.println("Livro com ID \"" + idLivro + "\" já estava disponível.");
        }
    }

    public void exibirLivros() {
        System.out.println("\nLista de livros:");
        for (Livro livro : livros) {
            livro.exibirStatus();
        }
    }

    public void exibirListaUsuarios() {
        System.out.println("\nLista de usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println("- " + usuario.getNome() + " (ID: " + usuario.getId() + ")");
        }
    }
    
    public void exibirUsuario(int idUsuario) throws UsuarioNaoEncontradoException {
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Usuário com ID " + idUsuario + " não encontrado.");
        }
        usuario.exibirLivrosEmprestados();
    }

    private Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) return usuario;
        }
        return null;
    }

    private Livro buscarLivro(int idLivro) {
        for (Livro livro : livros) {
            if (livro.getId() == idLivro) return livro;
        }
        return null;
    }
}