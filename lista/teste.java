/*
 * Métodos a testar:
 * PrimeiroNo()*
 * PrimeiroObj()*
 * UltimoNo()*
 * UltimoObj()*
 * EPrimeiro(nodo p)*
 * EUltimo(nodo p)*
 * Tamanho()*
 * Vazio()*
 *
 * BotarDepois(nodo p, Object o)*
 * BotarAntes(nodo p, Object o)*
 * Remover(nodo p)*
 * TrocaElemento(nodo p, Object o)*
 * TrocaElementos(nodo p, nodo q)*
 * BotarPrimeiro(Object o)*
 * BotarUltimo(Object o)*
 */

package lista;

import nodo.nodo;

public class teste {
    public static void main(String[] args) {
        listall<Object> teste = new listall<Object>();
        // testes para Lista Vazia funcionando
        // teste.printlista();
        // System.out.println(teste.PrimeiroNo());
        // System.out.println(teste.PrimeiroObj());
        // System.out.println(teste.UltimoNo());
        // System.out.println(teste.UltimoObj());

        teste.BotarPrimeiro(3);
        teste.printlista();
        nodo<Object> x = teste.BotarUltimo(5);
        teste.printlista();
        x = teste.BotarDepois(x, 4);
        teste.printlista();
        x = teste.BotarAntes(x, 2);
        teste.printlista();
        teste.TrocaElementos(x, teste.PrimeiroNo());
        teste.printlista();
        x = teste.BotarUltimo(1);
        teste.printlista();
        teste.Remover(x);
        teste.printlista();
        System.out.println(teste.PrimeiroObj());
        // teste.BotarAntes(x, 1); -> Erro: x não está mais na lista;
        // teste.printlista();
        x = teste.BotarAntes(teste.PrimeiroNo(), 1);
        teste.printlista();
        teste.TrocaElemento(x, 0);
        teste.printlista();
        x = x.getprox();
        teste.TrocaElemento(x, 1);
        teste.printlista();
        x = x.getprox();
        x = x.getprox();
        teste.TrocaElementos(x.getanterior(), x.getprox());
        teste.printlista();
        teste.TrocaElementos(x, x.getanterior());
        teste.printlista();
        System.out.println(teste.EPrimeiro(teste.PrimeiroNo()));
        System.out.println(teste.EPrimeiro(x));
        x = teste.BotarPrimeiro(7);
        teste.printlista();
        System.out.println(teste.EPrimeiro(x));
    }
}
