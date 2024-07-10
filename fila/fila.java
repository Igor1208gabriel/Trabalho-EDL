//IMPLEMENTE EM JAVA/C# o TAD Fila utilizando uma Lista Simplesmente Encadeada.

package fila;

import EDLVazioExcecao.EDLVazioExcecao;
import nodo.nodo;

public class fila<E> {

    private nodo<Object> comeco;
    private nodo<Object> fim;
    private int quantidade;

    public fila() {
        comeco = null;
        fim = null;
        quantidade = 0;
    }

    public void entra(Object e) {
        nodo<Object> x = new nodo<Object>(e);
        quantidade++;

        if (comeco == null && fim == null) {
            comeco = x;
            fim = x;
        }

        fim.setproximo(x);
        fim = x;
    }

    public Object sai() {
        if (quantidade == 0 || comeco == null)
            throw new EDLVazioExcecao("Fila Vazia");
        else {
            Object ans = comeco.getobj();
            comeco = comeco.getprox();
            return ans;
        }
    }

    public void printfila() {
        if (quantidade != 0) {
            nodo<Object> x = comeco;
            while (x != null) {
                System.out.print(x.getobj() + " -> ");
                x = x.getprox();
            }
        }
        System.out.println("Acabô");
    }

    public void limpar() {
        comeco = null;
        fim = null;
    }

    public Object inicio() {
        return comeco.getobj();
    }

    public int tamanho() {
        return quantidade;
    }

    public boolean vazio() {
        return quantidade == 0;
    }

    public nodo<Object> comeco() {
        return this.comeco;
    }

    public nodo<Object> fim() {
        return this.fim;
    }

}
