package nodo;

public class nodo<T> {
    private Object obj;
    private nodo<Object> prox;
    private nodo<Object> ant;

    public void setobj(Object e) {
        obj = e;
    }

    public void setproximo(nodo<Object> proximo) {
        prox = proximo;
    }

    public void setanterior(nodo<Object> anterior) {
        ant = anterior;
    }

    public nodo(Object objeto) {
        obj = objeto;
        prox = null;
        ant = null;
    }

    public nodo() {
        obj = null;
        prox = null;
        ant = null;
    }

    public Object getobj() {
        return obj;
    }

    public nodo<Object> getprox() {
        return prox;
    }

    public nodo<Object> getanterior() {
        return ant;
    }

}