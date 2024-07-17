public class teste {
    public static void main(String[] args) {
        arvore x = new arvore(20);
        x.Plantar(15);
        x.Plantar(25);
        x.Plantar(21);
        x.Plantar(23);
        x.Plantar(16);
        x.Plantar(17);
        x.Plantar(18);
        x.Plantar(13);
        x.Plantar(14);
        x.Plantar(12);
        x.Plantar(8);
        x.Plantar(6);
        x.Plantar(10);


        x.Colher(8);
        x.Colher(17);
        x.Colher(21);
        x.Colher(23);
       
        System.out.println("\nPre Ordem:");
        for(int y : x.PreOrdem()){
            System.out.print(y + " ");
        }
        System.out.println("\nEm Ordem:");
        for(int y : x.EmOrdem()){
            System.out.print(y + " ");
        }
        System.out.println("\nPos Ordem:");
        for(int y : x.PosOrdem()){
            System.out.print(y + " ");
        }








    }
 }
