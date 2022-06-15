package arvore.arvorebinaria;

public class ArvoreBinaria {

    private static class Arvore {
        public int num;
        public Arvore dir, esq;
    }

    Arvore raiz = null;
    Arvore aux;

    public void inserir(int num) {
        raiz = inserir(raiz, num);
    }

    private Arvore inserir(Arvore aux, int num) {

        if (aux == null) {
            aux = new Arvore();
            aux.num = num;
            aux.esq = null;
            aux.dir = null;
        } else if (num < aux.num)
            aux.esq = inserir(aux.esq, num);
        else
            aux.dir = inserir(aux.dir, num);

        return aux;
    }

    public int consultar(int num) {
        return consultar(raiz, num, 0);
    }

    private int consultar(Arvore aux, int num, int achou) {
        if (aux != null && achou == 0) {
            if (aux.num == num) {
                achou = 1;
            } else if (num < aux.num)
                achou = consultar(aux.esq, num, achou);
            else
                achou = consultar(aux.dir, num, achou);
        }
        return achou;
    }

    public void mostrarEmOrdem() {
        mostrarEmOrdem(raiz);
    }

    private void mostrarEmOrdem(Arvore aux) {
        if (aux != null) {
            mostrarEmOrdem(aux.esq);
            System.out.print(aux.num + ", ");
            mostrarEmOrdem(aux.dir);
        }
    }

    public void mostrarPreOrdem() {
        mostrarPreOrdem(raiz);
    }

    private void mostrarPreOrdem(Arvore aux) {
        if (aux != null) {
            System.out.print(aux.num + ", ");
            mostrarPreOrdem(aux.esq);
            mostrarPreOrdem(aux.dir);
        }
    }

    public void mostrarPosOrdem() {
        mostrarPosOrdem(raiz);
    }

    public void mostrarPosOrdem(Arvore aux) {
        if (aux != null) {
            mostrarPosOrdem(aux.esq);
            mostrarPosOrdem(aux.dir);
            System.out.print(aux.num + ", ");
        }
    }

    public void remover(int numero) {
        if (consultar(numero) == 1)
            raiz = remover(raiz, numero);
        else
            System.out.println("Número não encontrado!");
    }

    private Arvore remover(Arvore aux, int num) {
        Arvore p, p2;
        if (aux.num == num) {
            if (aux.esq == aux.dir) {
                // o elemento a ser removido
                // não tem filhos
                return null;
            } else if (aux.esq == null) {
                // o elemento a ser removido
                // não tem filho para esquerda
                return aux.dir;
            } else if (aux.dir == null) {
                // o elemento a ser removido
                // não tem filho para direita
                return aux.esq;
            } else {
                // o elemento a ser removido
                // tem filho para ambos os lados
                p2 = aux.dir;
                p = aux.dir;
                while (p.esq != null) {
                    p = p.esq;
                }
                p.esq = aux.esq;
                return p2;
            }
        } else if (aux.num < num)
            aux.dir = remover(aux.dir, num);
        else
            aux.esq = remover(aux.esq, num);
        return aux;
    }

    public void limparArvore() {
        if (isEmpty()) {
            System.out.println("Árvore vazia!");
        } else {
            raiz = null;
            System.out.println("Arvore esvaziada!");
        }
    }

    private boolean isEmpty() {
        return raiz == null;
    }

}




