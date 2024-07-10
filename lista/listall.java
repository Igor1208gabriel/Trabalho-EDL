package lista;

import nodo.nodo;
import EDLVazioExcecao.EDLVazioExcecao;

public class listall<T> {

    public class noespecial { // nó que não guarda valor, usado somente para primeiro e ultimo
        private nodo<Object> ref;

        public void setRef(nodo<Object> ref) {
            this.ref = ref;
        }

        public nodo<Object> getRef() {
            return ref;

        }

        noespecial() {
            this.ref = null;
        }
    }

    noespecial primeiro;
    noespecial ultimo;
    int tamanho;

    listall() {
        primeiro = new noespecial();
        ultimo = new noespecial();
        tamanho = 0;
    }

    private void ligar(nodo<Object> primeiro, nodo<Object> segundo) {
        primeiro.setproximo(segundo);
        segundo.setanterior(primeiro);
    }

    private void ligar(nodo<Object> primeiro, nodo<Object> segundo, nodo<Object> terceiro) {
        ligar(primeiro, segundo);
        ligar(segundo, terceiro);
    }

    public void printlista() {
        if (Vazio())
            throw new EDLVazioExcecao("Lista vazia");
        System.out.print("[");
        nodo<Object> listar = this.primeiro.getRef();

        for (int i = 0; i < tamanho; i++) {
            System.out.print(listar.getobj() + ", ");
            listar = listar.getprox();
        }
        System.out.println("]");
    }

    public nodo<Object> PrimeiroNo() {
        if (Vazio())
            throw new EDLVazioExcecao("Lista vazia");
        return primeiro.getRef();
    }

    public Object PrimeiroObj() {
        if (Vazio())
            throw new EDLVazioExcecao("Lista vazia");
        return primeiro.getRef().getobj();
    }

    public nodo<Object> UltimoNo() {
        if (Vazio())
            throw new EDLVazioExcecao("Lista vazia");
        return ultimo.getRef();
    }

    public Object UltimoObj() {
        if (Vazio())
            throw new EDLVazioExcecao("Lista vazia");
        return ultimo.getRef().getobj();
    }

    public boolean EPrimeiro(nodo<Object> n) {
        return n == primeiro.getRef();
    }

    public boolean EUltimo(nodo<Object> n) {
        return n == ultimo.getRef();
    }

    public int Tamanho() {
        return tamanho;
    }

    public boolean Vazio() {
        return tamanho == 0;
    }

    public nodo<Object> BotarDepois(nodo<Object> p, Object o) {
        // if(p.getanterior() == null) throw new EDLVazioExcecao(p + " não possui
        // próximo");
        if (p.getprox() == null) {
            BotarUltimo(o);
            return ultimo.getRef();
        }
        nodo<Object> bota = new nodo<Object>(o);
        ligar(p, bota, p.getprox());
        this.tamanho++;
        return bota;
    }

    public nodo<Object> BotarAntes(nodo<Object> p, Object o) {
        // if(p.getanterior() == null) throw new EDLVazioExcecao(p + " não possui
        // anterior");
        if (p.getanterior() == null) {
            BotarPrimeiro(o);
            return primeiro.getRef();
        }
        nodo<Object> bota = new nodo<Object>(o);
        ligar(p.getanterior(), bota, p);
        this.tamanho++;
        return bota;
    }

    public Object Remover(nodo<Object> p) {
        if (Vazio())
            throw new EDLVazioExcecao("Lista está vazia");

        if (tamanho == 1) {
            primeiro.setRef(null);
            ultimo.setRef(null);
        }

        if (!EPrimeiro(p) && !EUltimo(p) && tamanho > 2)
            ligar(p.getanterior(), p.getprox());

        if (EPrimeiro(p) && tamanho > 1)
            primeiro.setRef(p.getprox());
        if (EUltimo(p) && tamanho > 1)
            ultimo.setRef(p.getanterior());

        p.setproximo(null);
        p.setanterior(null);

        this.tamanho--;
        return p.getobj();
    }

    public void TrocaElemento(nodo<Object> p, Object o) {
        p.setobj(o);
    }

    public void TrocaElementos(nodo<Object> p, nodo<Object> q) {
        Object a = p.getobj();
        p.setobj(q.getobj());
        q.setobj(a);
    }

    public nodo<Object> BotarPrimeiro(Object o) {
        nodo<Object> p = new nodo<Object>(o);
        if (!Vazio())
            ligar(p, primeiro.getRef());
        else {
            ultimo.setRef(p);
        }
        primeiro.setRef(p);
        tamanho++;
        return p;
    }

    public nodo<Object> BotarUltimo(Object o) {
        nodo<Object> p = new nodo<Object>(o);
        ligar(ultimo.getRef(), p);
        ultimo.setRef(p);
        tamanho++;
        return p;
    }

}
