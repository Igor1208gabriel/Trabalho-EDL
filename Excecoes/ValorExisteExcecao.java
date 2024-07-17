package Excecoes;

public class ValorExisteExcecao extends RuntimeException{
    public ValorExisteExcecao(String err) {
        super(err);
    }
}
