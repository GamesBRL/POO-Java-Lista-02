package biblioteca.exception;

public class LivroIndisponivelException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LivroIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
