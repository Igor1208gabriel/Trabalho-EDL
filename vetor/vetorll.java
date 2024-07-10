package vetor;

import nodo.nodo;
import EDLVazioExcecao.EDLVazioExcecao;

public class vetorll<T> {
    private nodo<Object> primeiro;
    private nodo<Object> ultimo;
    private int tamanho;

    vetorll() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void PrintVetor() {
        if (Vazio())
            throw new EDLVazioExcecao("Vetor vazio");
        nodo<Object> viagem = this.primeiro;
        System.out.println();
        for (int i = 0; i < tamanho; i++) {
            System.out.print(viagem.getobj() + " ");
            viagem = viagem.getprox();
        }
        System.out.println();
    }

    private nodo<Object> achar(int rank) {
        nodo<Object> viagem = this.primeiro;
        for (int i = 0; i < rank; i++) {
            viagem = viagem.getprox();
        }
        return viagem;
    }

    private void ligar(nodo<Object> primeiro, nodo<Object> segundo) {
        primeiro.setproximo(segundo);
        segundo.setanterior(primeiro);
    }

    public Object ElementoEm(int rank) {
        if (rank >= tamanho)
            throw new EDLVazioExcecao("Índice maior que o tamanho da lista");
        return achar(rank).getobj();
    }

    public Object TrocarEm(int rank, Object o) {
        if (rank >= tamanho)
            throw new EDLVazioExcecao("Índice maior que o tamanho da lista");
        nodo<Object> no = achar(rank);
        Object ans = no.getobj();
        no.setobj(o);
        return ans;
    }

    public void InserirEm(int rank, Object o) {
        if (rank > tamanho)
            throw new EDLVazioExcecao("Índice maior que o tamanho da lista");
        nodo<Object> novonodo = new nodo<Object>(o);

        if (Vazio()) {
            primeiro = novonodo;
            ultimo = novonodo;
        }

        else if (rank == tamanho && !Vazio()) {
            ligar(ultimo, novonodo);
            this.ultimo = novonodo;
        }

        else if (rank == 0) {
            ligar(novonodo, primeiro);
            this.primeiro = novonodo;
        }

        else {
            ligar(achar(rank).getanterior(), novonodo);
            ligar(novonodo, achar(rank));
        }
        tamanho++;

    }

    public Object RemoverEm(int rank) {
        nodo<Object> ans;

        if (rank > tamanho)
            throw new EDLVazioExcecao("Índice maior que o tamanho da lista");

        else if (rank == 0) {
            ans = primeiro;
            primeiro = primeiro.getprox();
            primeiro.setanterior(null);
        }

        else if (rank == tamanho) {
            ans = ultimo;
            ultimo = ultimo.getanterior();
            ultimo.setproximo(null);
        } else {

            ans = achar(rank);
            ligar(achar(rank).getanterior(), achar(rank).getprox());
        }
        tamanho--;
        return ans.getobj();
    }

    public int Tamanho() {
        return tamanho;
    }

    public Boolean Vazio() {
        return tamanho == 0;
    }

    public Boolean Cheio() {
        return true;
    }
}
