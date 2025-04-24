package biblioteca.app;

import biblioteca.exception.LivroIndisponivelException;
import biblioteca.exception.LivroNaoEncontradoException;
import biblioteca.exception.UsuarioNaoEncontradoException;
import biblioteca.modelo.Biblioteca;
import biblioteca.modelo.Livro;
import biblioteca.modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro l1 = new Livro("Dom Casmurro", "Machado de Assis");
        Livro l2 = new Livro("1984", "George Orwell");
        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);

        Usuario ana = new Usuario("Ana");
        Usuario joao = new Usuario("João");
        biblioteca.registrarUsuario(ana);
        biblioteca.registrarUsuario(joao);

        //Definindo ID fixo para testes//
        l1.setId(1);
        l2.setId(2);
        ana.setId(1);
        joao.setId(2);
        //-----------------------------//
        
        biblioteca.exibirLivros();
        biblioteca.exibirUsuarios();
        
        try {
       
			biblioteca.emprestarLivro(1, 2);
			biblioteca.exibirUsuario(1);
			biblioteca.exibirUsuario(2);
			
			
		} catch (LivroIndisponivelException | UsuarioNaoEncontradoException | LivroNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        biblioteca.exibirLivros();
    }
}
