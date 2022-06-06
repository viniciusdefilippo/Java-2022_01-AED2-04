package listas.excercicio;

import java.util.Scanner;

// 2 – Implementar a classe LSENaoOrdenada
public class LSENaoOrdenada {

    private static Scanner entrada;

    public static void main(String args[]) {

        // 3 – criar o objeto “entrada” de dados
        Scanner entrada = new Scanner(System.in);

        Lista inicio = null;
        Lista fim = null;
        Lista aux;
        Lista anterior;
        int op, numero = 0, achou;
        do {
            // 4 – criar o menu de acordo como layout
            System.out.println("\nMENU OPÇOES");
            System.out.println("1 - Inserir no início da lista");
            System.out.println("2 - Inserir no fim da lista");
            System.out.println("3 - Consultar toda a lista");
            System.out.println("4 - Remover da lista");
            System.out.println("5 - Esvaziar a lista");
            System.out.println("6 - Sair");

            // 5 – Usar a variável “op” para escolha da opção pelo usuário
            op = entrada.nextInt();

            // 6 – Verificar se a opção é menor que 1 ou maior que 6,
            // caso verdade emitir a mensagem: “Opção inválida”.”
            if (op < 1 || op > 6) System.out.println("Opção inválida!");

            // 7 – Implementar o código para inserir um número no início da Lista – Opção 1
            // Inserir no início da Lista
            if (op == 1) {
                System.out.println("Digite o número a ser inserido no início da lista: ");
                Lista novo = new Lista();
                novo.num = entrada.nextInt();
                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    novo.prox = null;
                } // fim se inicio == null
                else {
                    novo.prox = inicio;
                    inicio = novo;
                }
                // 8 – Mostrar mensagem no console: O número XXX foi inserido na LISTA
                System.out.println("O número " + novo.num + " foi inserido na LISTA");
            } // fim do (op == 1) inserir no início da lista

            // 13 – Implementar o código para inserir um número no FIM da LISTA – Opção 2
            if (op == 2) {
                System.out.println("Digite o número a ser inserido no final da lista: ");
                Lista novo = new Lista();
                novo.num = entrada.nextInt();
                if (inicio == null) {
                    inicio = novo;
                    fim = novo;
                    novo.prox = null;
                } // fim se inicio == null
                else {
                    fim.prox = novo;
                    fim = novo;
                    novo.prox = null;
                }
                // 8 – Mostrar mensagem no console: O número XXX foi inserido na LISTA
                System.out.println("O número " + novo.num + " foi inserido na LISTA");
            } // fim do (op == 1) inserir no início da lista

            // 9 – Implementar o código para consultar toda a Lista – Opção 3
            // Consultar toda a lista
            if (op == 3) {
                if (inicio == null) {
                    System.out.println("A lista está vazia!");
                } else {
                    System.out.println("\nConsultando toda a lista\n");
                    aux = inicio;
                    while (aux != null) {
                        System.out.print(aux.num + ", ");
                        // 10 – Mostrar no console cada número presente na lista
                        aux = aux.prox;
                    }
                    System.out.println();
                }
            } // fim da (op == 3) consultar toda a lista

            // 11 – Implementar o código para remover um número da LISTA – Opção 4
            // (Remover todas as ocorrências de um mesmo número na Lista)
            // Remover da lista
            if (op == 4) {
                if (inicio == null) {
                    System.out.println("A lista está vazia!");
                } // fim se inicio == null
                else {
                    System.out.println("\nDigite o elemento a ser removido: ");
                    numero = entrada.nextInt();
                } // fim else do inicio == fim
                aux = inicio;
                anterior = null;
                achou = 0;
                while (aux != null) {
                    if (aux.num == numero) {
                        achou = achou + 1;
                        if (aux == inicio) {
                            inicio = aux.prox;
                            aux = inicio;
                        } // fim if aux == inicio
                        else if (aux == fim) {
                            anterior.prox = null;
                            fim = anterior;
                            aux = null;
                        } // fim else if (aux == fim)
                        else {
                            anterior.prox = aux.prox;
                            aux = aux.prox;
                        }
                    } // fim if (aux.num == numero)
                    else {
                        anterior = aux;
                        aux = aux.prox;
                    } // fim se aux.num == numero
                } // fim enquanto aux != null
                if (achou == 0) {
                    System.out.println("Número não encontrado!");
                } // fim se achou == 0
                else if (achou == 1) {
                    System.out.println("=> MENSAGEM: Número removido uma vez!");
                } // fim else do se achou == 0
                else {
                    // 12 – Imprimir no console a mensagem “Número removido XXX vezes”
                    System.out.println("Número removido " + achou + " vezes ");
                }
            } // fim da (op == 4) remover da lista

            // 14 – Implementar o código para esvaziar a LISTA – Opção 5
            if (op == 5) {
                inicio = null;
                fim = null;
                System.out.println("A lista está vazia!");
            }

        } // fim do do/while
        while (op != 6);

        System.out.println("\n**** PROGRAMA ENCERRADO ****\n");
    } // fim do método main
} // Fim da classe LSENaoOrdenada