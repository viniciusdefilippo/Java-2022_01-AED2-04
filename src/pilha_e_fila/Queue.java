package pilha_e_fila;

public class Queue {

    public int num, totalElementos;
    public Queue prox;
    Queue inicio = null;
    Queue fim = null;
    Queue aux;

    boolean isEmpty() {
        return inicio == null;
    }

    int size() {
        return this.totalElementos;
    }

    void enqueue(int value) {

        Queue novo = new Queue();
        novo.num = value;
        if (isEmpty()) {
            // A fila está vazia o elemento inserido será
            // o primeiro e o último
            inicio = novo;
            fim = novo;
            novo.prox = null;
        } else {
            // A Fila já contém elementos, neste caso, o novo
            // elemento será inserido no fim da Fila
            fim.prox = novo;
            fim = novo;
            fim.prox = null;
        }
        totalElementos++;
    }

    void print() {

        if (isEmpty()) System.out.println("A fila está vazia!");
        else {
            System.out.println("Consultando toda a Fila:");
            aux = inicio;
            while (aux != null) {
                System.out.print(aux.num + ", ");
                aux = aux.prox;
            }
            System.out.println();
        }
    }

    int dequeue() {

        if (isEmpty()) System.out.println("A fila está vazia!");
        else {
            aux = inicio;
            inicio = aux.prox;
            totalElementos--;
            return aux.num;
        }
        return -1;
    }
}

