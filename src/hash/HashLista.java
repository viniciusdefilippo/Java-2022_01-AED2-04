package hash;

import java.util.Scanner;

public class HashLista {

    public static class Hash {
        int chave;
        Hash prox;
    }

    static int tam = 10; // tamanho da função hash
    static Hash[] tabela = new Hash[tam];
    static Scanner entrada = new Scanner(System.in);

    public static void inserir(int n) {

        int pos = funcaoHashing(n);

        Hash novo = new Hash();
        novo.chave = n;
        novo.prox = tabela[pos];
        tabela[pos] = novo;

    }

    static int funcaoHashing(int num) {
        return num % tam;
    }

    static void mostrarHash() {

        Hash aux;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            System.out.print("[" + i + "]: ");
            while (aux != null) {
                System.out.print(aux.chave + ", ");
                aux = aux.prox;
            }
            System.out.println();
        }
    }

    static void consultar(int num) {

        Hash aux;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            while (aux != null) {
                if (aux.chave == num) {
                    System.out.print("Chave " + aux.chave + " encontrada!");
                    return;
                } else {
                    aux = aux.prox;
                }
            }
        }
        System.out.print("Chave " + num + " não encontrada!");
    }

    static void excluirHash(int num) {

        int pos = funcaoHashing(num);
        Hash aux;

        if (tabela[pos] != null) {
            if (tabela[pos].chave == num) {
                tabela[pos] = tabela[pos].prox;
            } else {
                aux = tabela[pos].prox;
                Hash ant = tabela[pos];
                while (aux != null && aux.chave != num) {
                    ant = aux;
                    aux = aux.prox;
                }
                if (aux != null) {
                    ant.prox = aux.prox;
                } else {
                    System.out.println("Número não encontrado!");
                }
            }
        } else {
            System.out.println("Número não encontrado!");
        }
    }

    public static void main(String[] args) {

        int op, num;

        do {
            System.out.println("\nMENU DE OPÇÕES:\n");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Mostrar tabela hash");
            System.out.println("3 - Excuir elemento");
            System.out.println("4 - Consultar elemento");
            System.out.println("5 - Sair");
            System.out.print("Digite sua opção: ");

            op = entrada.nextInt();

            if (op < 1 || op > 5)
                System.out.println("Opção inválida!!");
            else {
                switch (op) {
                    case 1 -> {
                        System.out.println("Digite um número: ");
                        num = entrada.nextInt();
                        inserir(num);
                    }
                    case 2 -> mostrarHash();
                    case 3 -> {
                        System.out.println("Digite um número: ");
                        num = entrada.nextInt();
                        excluirHash(num);
                    }
                    case 4 -> {
                        System.out.println("Digite um número: ");
                        num = entrada.nextInt();
                        consultar(num);
                    }
                }
            }

        } while (op != 5);
    }
}
