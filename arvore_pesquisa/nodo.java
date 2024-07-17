public class nodo {
    private int valor;
    private nodo pai;
    private nodo filhoe;
    private nodo filhod;
 
 
    nodo(int i){
        valor = i;
        pai = null;
        filhoe = null;
        filhod = null;
    }
 
 
    nodo(int i, nodo n){
        valor = i;
        pai = n;
 
 
    }
 
 
    public nodo getFilhod() {
        return filhod;
    }
    public nodo getFilhoe() {
        return filhoe;
    }
    public nodo getPai() {
        return pai;
    }
    public int getValor() {
        return valor;
    }
 
 
 
 
    public void setFilhod(nodo filhod) {
        this.filhod = filhod;
    }
    public void setFilhoe(nodo filhoe) {
        this.filhoe = filhoe;
    }
    public void setPai(nodo pai) {
        this.pai = pai;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
 
 
 
 
 }
 