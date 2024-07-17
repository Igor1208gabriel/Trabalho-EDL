import java.util.ArrayList;

import Excecoes.EDLVazioExcecao;
import Excecoes.ValorExisteExcecao;
import Excecoes.ValorNaoExisteExcecao;

public class arvore {
    private nodo raiz;
    private int tamanho;




    arvore(int i) {
        raiz = new nodo(i);
        tamanho = 1;
    }




    private nodo acharNodo(int i, nodo n) {
        if (n == null || (EExterno(n) && n.getValor() != i))
            return null;
        int x = n.getValor();
        if (x > i)
            return acharNodo(i, n.getFilhoe());
        if (x < i)
            return acharNodo(i, n.getFilhod());
        return n;
    }




    public int getAltura() {
        int max = 0;
        for (int i : EmOrdem()) {
            int x = Altura(i);
            if (x > max)
                max = x;
        }
        return max;
    }




    public int getTamanho() {
        return tamanho;
    }




    public Boolean Vazio() {
        return tamanho == 0;
    }




    public nodo getRaiz() {
        return raiz;
    }




    public nodo getPai(nodo n) {
        return n.getPai();
    }




    public Boolean EExterno(nodo n) {
        return n.getFilhoe() == null && n.getFilhod() == null;
    }




    public Boolean EInterno(nodo n) {
        return !EExterno(n);
    }




    public Boolean ERaiz(nodo n) {
        return raiz == n;
    }




    private int Altura(nodo n) {
        if (ERaiz(n))
            return 0;
        else
            return Altura(n.getPai()) + 1;
    }




    public int Altura(int n) {
        nodo x = acharNodo(n, raiz);
        if (x != null) {
            return Altura(x);
        }
        throw new ValorNaoExisteExcecao("Valor não existe");
    }




    public void Plantar(int i) {
        nodo x = acharNodo(i, raiz);
        if (x != null)
            throw new ValorExisteExcecao("Valor já existe no set");
        if (Vazio()) {
            raiz = new nodo(i);
        }




        PlantarRec(raiz, i);
        tamanho++;
        return;
    }




    private void PlantarRec(nodo n, int i) {
        if (EExterno(n)) {
            if (n.getValor() > i) {
                n.setFilhoe(new nodo(i, n));
            }
            if (n.getValor() < i) {
                n.setFilhod(new nodo(i, n));
            }
        } else {
            if (n.getValor() < i) {
                if (n.getFilhod() != null)
                    PlantarRec(n.getFilhod(), i);
                else
                    n.setFilhod(new nodo(i, n));
            }
            if (n.getValor() > i) {
                if (n.getFilhoe() != null)
                    PlantarRec(n.getFilhoe(), i);
                else
                    n.setFilhoe(new nodo(i, n));




            }
        }
    }




    public int Colher(int i) {
        nodo x = acharNodo(i, raiz);
        if (x == null)
            throw new ValorNaoExisteExcecao("Valor não achado");




        nodo pai = x.getPai();




        if (x.getFilhod() == null && x.getFilhoe() == null) { // sem filhos
            if (pai.getFilhod() == x) pai.setFilhod(null);
            else if (pai.getFilhoe() == x) pai.setFilhoe(null);
        }




        else if (x.getFilhod() != null && x.getFilhoe() == null) { // Apenas filho direita
            if (pai.getFilhod() == x) pai.setFilhod(x.getFilhod());
            else if (pai.getFilhoe() == x) pai.setFilhoe(x.getFilhod());
           
        }




        else if (x.getFilhod() == null && x.getFilhoe() != null) { // Apenas filho esquerda
            if (pai.getFilhod() == x) pai.setFilhod(x.getFilhoe());
            else if (pai.getFilhoe() == x) pai.setFilhoe(x.getFilhoe());
        }




        else if (x.getFilhod() != null && x.getFilhoe() != null) { // Ambos os filhos
            nodo pr = acharmaior(x.getValor());
            int v = pr.getValor();


            Colher(v);
            x.setValor(v);
            return v;
        }




        else {
            throw new ValorNaoExisteExcecao("Algum erro aconteceu");
        }




        x.setFilhod(null);
        x.setFilhoe(null);
        x.setPai(null);




        tamanho--;
        return x.getValor();
    }




    public int Replantar(nodo n, int i) {
        Colher(n.getValor());
        Plantar(i);
        return i;
    }




    public ArrayList<Integer> PreOrdem() {
        ArrayList<Integer> x = new ArrayList<Integer>();
        preordem(raiz, x);
        return x;
    }




    private void preordem(nodo n, ArrayList<Integer> s) {
        s.add(n.getValor());
        if (n.getFilhoe() != null)
            preordem(n.getFilhoe(), s);
        if (n.getFilhod() != null)
            preordem(n.getFilhod(), s);
    }




    public ArrayList<Integer> EmOrdem() {
        ArrayList<Integer> x = new ArrayList<Integer>();
        emordem(raiz, x);
        return x;
    }




    private void emordem(nodo n, ArrayList<Integer> s) {
        if (n.getFilhoe() != null)
            emordem(n.getFilhoe(), s);
        s.add(n.getValor());
        if (n.getFilhod() != null)
            emordem(n.getFilhod(), s);
    }




    public ArrayList<Integer> PosOrdem() {
        ArrayList<Integer> x = new ArrayList<Integer>();
        posordem(raiz, x);
        return x;
    }




    private void posordem(nodo n, ArrayList<Integer> s) {
        if (n.getFilhoe() != null)
            posordem(n.getFilhoe(), s);
        if (n.getFilhod() != null)
            posordem(n.getFilhod(), s);
        s.add(n.getValor());
    }




    public int Proximo(int i) {
        nodo x = acharmaior(i);
        if (x != null)
            return x.getValor();
        else
            throw new ValorNaoExisteExcecao("Nao existe");
    }




    public int Anterior(int i) {
        nodo x = acharmenor(i);
        if (x != null)
            return x.getValor();
        else
            throw new ValorNaoExisteExcecao("Nao existe");
    }




    private nodo acharmenor(int i) {
        ArrayList<Integer> s = EmOrdem();
        if (s.getFirst() > i)
            throw new ValorNaoExisteExcecao("Nao existe");
        int j = 0;
        for (int f = 0; f < tamanho - 1; f++) {
            if (s.get(f) < i)
                j = s.get(f);
        }
        return acharNodo(j, raiz);
    }




    private nodo acharmaior(int i) {
        ArrayList<Integer> s = EmOrdem();
        if (s.getLast() < i)
            throw new ValorNaoExisteExcecao("Nao existe");
        int j = 0;
        for (int f = 0; f < tamanho - 1; f++) {
            if (s.get(f) > i) {
                j = s.get(f);
                break;
            }
        }
        return acharNodo(j, raiz);
    }




}
