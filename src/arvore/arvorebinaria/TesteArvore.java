package arvore.arvorebinaria;

public class TesteArvore {

    public static void main(String[] args) {

        ArvoreBinaria ab = new ArvoreBinaria();

        ab.inserir(27);
        ab.inserir(13);
        ab.inserir(6);
        ab.inserir(17);
        ab.inserir(42);
        ab.inserir(33);
        ab.inserir(48);

        if (ab.consultar(100) == 0) {
            System.out.println("Número não encontrado na árvore!");
        }

        System.out.println("\nPré Ordem:");
        ab.mostrarPreOrdem();
        System.out.println();

        System.out.println("\nEm Ordem:");
        ab.mostrarEmOrdem();
        System.out.println();

        System.out.println("\nPós Ordem:");
        ab.mostrarPosOrdem();
        System.out.println();

        ab.remover(6);
        ab.remover(48);
        ab.remover(100);

        System.out.println("\nEm Ordem:");
        ab.mostrarEmOrdem();
        System.out.println();

        ab.limparArvore();

        System.out.println("\nEm Ordem:");
        ab.mostrarEmOrdem();
        System.out.println();

        ab.limparArvore();
    }
}
