package pilha_e_fila;

public class Stack {

    public int num, totalElementos;
    public Stack prox;
    Stack topo = null;
    Stack fim = null;
    Stack aux;

    boolean isEmpty() {
        return topo == null;
    }

    int size() {
        return this.totalElementos;
    }

    void push(int value) {

        Stack novo = new Stack();
        novo.num = value;

        if (isEmpty()) {
            // A pilha está vazia o elemento inserido será o primeiro e o último
            topo = novo;
            fim = novo;
            novo.prox = null;
        } else {
            // A pilha já contém elementos, neste caso, o novo
            // elemento será inserido no topo da Pilha
            novo.prox = topo;
            topo = novo;
        }
        totalElementos++;
    }

    void print() {

        if (isEmpty()) System.out.println("A pilha está vazia!");
        else {
            System.out.println("Consultando toda a Pilha:");
            aux = topo;
            while (aux != null) {
                System.out.print(aux.num + ", ");
                aux = aux.prox;
            }
            System.out.println();
        }
    }

    int pop() {
        if (isEmpty()) System.out.println("A pilha está vazia!");
        else {
            aux = topo;
            topo = aux.prox;
            totalElementos--;
            return aux.num;
        }
        return -1;
    }

    void limpar() {
        if (topo == null) System.out.println("A pilha está vazia!");
        else {
            topo = null;
            System.out.println("=> MENSAGEM: A pilha foi esvaziada!");
        }
    }
}

