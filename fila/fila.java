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

    public void Entra(Object e) {
        nodo<Object> x = new nodo<Object>(e);
        quantidade++;

        if (comeco == null && fim == null) {
            comeco = x;
            fim = x;
        }

        fim.setproximo(x);
        fim = x;
    }

    public Object Sai() {
        if(Vazio()) throw new EDLVazioExcecao("Fila vazia");
        else {
            Object ans = comeco.getobj();
            comeco = comeco.getprox();
            return ans;
        }
    }

    public void PrintFila() {
        if (quantidade != 0) {
            nodo<Object> x = comeco;
            while (x != null) {
                System.out.print(x.getobj() + " -> ");
                x = x.getprox();
            }
        }
        System.out.println("Acabô");
    }

    public void Limpar() {
        comeco = null;
        fim = null;
        quantidade = 0;
    }

    public Object Inicio() {
        if(Vazio()) throw new EDLVazioExcecao("Fila vazia");
        return comeco.getobj();
    }

    public Object Final(){
        if(Vazio()) throw new EDLVazioExcecao("Fila vazia");
        return fim.getobj();
    }

    public int Tamanho() {
        return quantidade;
    }

    public boolean Vazio() {
        return quantidade == 0;
    }

    public nodo<Object> Comeco() {
        if(Vazio()) throw new EDLVazioExcecao("Fila vazia");
        return this.comeco;
    }

    public nodo<Object> Fim() {
        if(Vazio()) throw new EDLVazioExcecao("Fila vazia");
        return this.fim;
    }

}
