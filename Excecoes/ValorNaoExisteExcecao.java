package Excecoes;

public class ValorNaoExisteExcecao extends RuntimeException{
    public ValorNaoExisteExcecao(String err) {
        super(err);
    }
}
