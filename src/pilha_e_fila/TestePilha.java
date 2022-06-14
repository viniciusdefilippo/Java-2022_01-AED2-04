package pilha_e_fila;

public class TestePilha {

    public static void main(String[] args) {

        Stack aux = new Stack();
        Stack p = new Stack();

        p.push(1);
        p.push(2);
        p.push(3);

        System.out.println("Pilha inicial:");
        System.out.println("size: " + p.size());
        p.print();
        while (!p.isEmpty()) {
            aux.push(p.pop());
        }
        System.out.println("Impressão:");
        while (!aux.isEmpty()) {
            int temp = aux.pop();
            System.out.println(temp);
            p.push(temp);
        }
        System.out.println("Pilha Final");
        p.print();
    }
}

