/* 
 * Métodos a testar:
 * Entra()*
 * Sai()*
 * PrintFila()*
 * Limpar()*
 * Inicio()*
 * Final()*
 * Tamanho()*
 * Vazio()*
 * Comeco()*
 * fim()*
 */

package fila;

public class teste {
    public static void main(String[] args) {
        fila<Object> x = new fila<Object>();
        
        System.out.println("VAZIO:");
        x.PrintFila();
        //System.out.println("Começo: " + x.Comeco());//-> Não é possível pois está vazio!
        //System.out.println("Valor do começo: " + x.Inicio()); //-> Não é possível pois está vazio!
        //System.out.println("Fim: " + x.Fim());//-> Não é possível pois está vazio!
        //System.out.println("Valor do fim: " + x.Final());//-> Não é possível pois está vazio!
        System.out.println("Vazio: " + x.Vazio());
        System.out.println("Tamanho: " + x.Tamanho());
        System.out.println("\n\n\n");
        
        
        x.Entra(1);
        x.Entra(2);
        x.Entra(3);
        x.Entra(4);
        x.Entra(5);
        x.Entra(6);
        x.Entra(7);
        x.Entra(8);
        x.Entra(9);
        x.Entra(10);


        System.out.println("POPULADO:");
        x.PrintFila();
        System.out.println("Começo: " + x.Comeco());
        System.out.println("Valor do começo: " + x.Inicio());
        System.out.println("Fim: " + x.Fim());
        System.out.println("Valor do fim: " + x.Final());
        System.out.println("Vazio: " + x.Vazio());
        System.out.println("Tamanho: " + x.Tamanho());
        System.out.println("\n\n\n");


        x.Sai();
        x.Sai();
        x.Sai();
        x.Sai();
        x.Sai();
        x.Sai();


        System.out.println("ALGUMAS REMOÇÕES:");
        x.PrintFila();
        System.out.println("Começo: " + x.Comeco());
        System.out.println("Valor do começo: " + x.Inicio());
        System.out.println("Fim: " + x.Fim());
        System.out.println("Valor do fim: " + x.Final());
        System.out.println("Vazio: " + x.Vazio());
        System.out.println("Tamanho: " + x.Tamanho());
        System.out.println("\n\n\n");



        x.Limpar();


        System.out.println("VAZIO DE NOVO:");
        x.PrintFila();
        //System.out.println("Começo: " + x.Comeco());
        //System.out.println("Valor do começo: " + x.Inicio());
        //System.out.println("Fim: " + x.Fim());
        //System.out.println("Valor do fim: " + x.Final());
        System.out.println("Vazio: " + x.Vazio());
        System.out.println("Tamanho: " + x.Tamanho());

    
    }
}
