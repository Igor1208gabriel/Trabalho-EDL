package vetor;

import EDLVazioExcecao.EDLVazioExcecao;

public class vetorarray<T> {
    private Object[] dado;
    private int tamanho;
    public int capacidade;

    vetorarray() {
        dado = new Object[8];
        tamanho = 0;
        capacidade = 8;
    }

    public void PrintVetor() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(dado[i] + " ");
        }
        System.out.println(" ");
    }

    private void mudartamanho(int t) {
        Object[] novodado = new Object[t];

        for (int i = 0; i < t && i < this.tamanho; i++) {
            novodado[i] = dado[i];
        }

        this.dado = novodado;
        this.capacidade = t;

    }

    public Object ElementoEm(int i) {
        if (i >= tamanho)
            throw new EDLVazioExcecao("Índice não existe");
        return dado[i];
    }

    public Object TrocarEm(int i, Object o) {
        if (i >= tamanho)
            throw new EDLVazioExcecao("Índice não existe");
        Object ans = dado[i];
        dado[i] = o;
        return ans;
    }

    public void InserirEm(int i, Object o) {
        if (i > tamanho)
            throw new EDLVazioExcecao("Índice não existe");
        if (Cheio()) {
            mudartamanho(tamanho * 2);
        }
        for (int f = tamanho; f > i; f--) {
            dado[f] = dado[f - 1];
        }
        dado[i] = o;
        tamanho++;
    }

    public Object RemoverEm(int i) {
        if (i > tamanho || Vazio())
            throw new EDLVazioExcecao("Índice não existe");
        if (tamanho <= capacidade / 4) {
            mudartamanho(capacidade / 2);
        }
        Object ans = dado[i];
        for (int j = i; j < capacidade - 1; j++) {
            dado[j] = dado[j + 1];
        }
        tamanho--;
        return ans;
    }

    public int Tamanho() {
        return tamanho;
    }

    public Boolean Vazio() {
        return tamanho == 0;
    }

    public Boolean Cheio() {
        return tamanho == capacidade;
    }

}
