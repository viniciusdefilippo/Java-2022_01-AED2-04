package pilha_e_fila;

public class TesteFila {

    public static void main(String[] args) {

        Queue aux = new Queue();
        Queue q = new Queue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Fila inicial:");
        q.print();
        while (!q.isEmpty()) {
            aux.enqueue(q.dequeue());
        }
        System.out.println("Impressão:");
        while (!aux.isEmpty()) {
            int temp = aux.dequeue();
            System.out.println(temp);
            q.enqueue(temp);
        }
        System.out.println("Fila Final");
        q.print();
    }
}