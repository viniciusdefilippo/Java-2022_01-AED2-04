package listas.lse_nao_ordenada;

/*
 * LSENaoOrdenada
 * Lista Simplesmente Encadeada Não Ordenada
 * Fonte: Estrutura de Dados - Algoritimos e Análise de Complexidade
 * Ana Fernanda Ascencio e Graziela Santos Araújo
 */

import java.util.Scanner;

public class LSENaoOrdenada {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Inicialmente a lista está vazia, logo, o  objeto  início  tem
        // o valor null, o objeto início conterá o endereço do primeiro
        // elemento da LISTA.
        Lista inicio = null;

        // O objeto fim conterá o endereço do último elemento da LISTA
        Lista fim = null;

        // O objeto aux é um objeto auxiliar
        Lista aux;

        // O objeto anterior é um objeto auxiliar
        Lista anterior;

        // Apresentando o menu de opções
        int op, numero = 0, achou;
        do {
            System.out.println("\nMENU DE OPÇOES");
            System.out.println("1 - Inserir no ínicio da lista");
            System.out.println("2 - Inserir no fim lista");
            System.out.println("3 - Consultar toda a lista");
            System.out.println("4 - Remover da lista");
            System.out.println("5 - Esvaziar a lista");
            System.out.println("6 - Sair");
            System.out.print("Digite a sua opção: ");
            op = entrada.nextInt();
            if (op < 1 || op > 6) {
                System.out.println("Opção inválida!");
            }

            // Inserir no ínicio da Lista *******************************************************
            if (op == 1) {
                System.out.println("Digite o número a ser inserido no início da lista: ");
                Lista novo = new Lista();
                novo.num = entrada.nextInt();
                if (inicio == null) {
                    // A lista está vazia o elemento inserido será o primeiro e o último
                    inicio = novo;
                    fim = novo;
                    novo.prox = null;
                } // fim se inicio == null
                else {
                    // A Lista já contém elementos, neste caso, o novo
                    // elemento será inserido no início da Lista
                    novo.prox = inicio;
                    inicio = novo;
                }
                System.out.println("=> MENSAGEM: O número: " + novo.num + ", foi inserido no início da lista.");
            } // fim inserir no início da lista ************************

            // Inserir no fim lista ************************************
            if (op == 2) {
                System.out.println("Digite o número a ser inserido no fim da lista: ");
                Lista novo = new Lista();
                novo.num = entrada.nextInt();
                if (inicio == null) {
                    // A lista está vazia o elemento inserido será
                    //o primeiro e o último
                    inicio = novo;
                    fim = novo;
                    novo.prox = null;
                } // fim se inicio == null
                else {
                    // A Lista já contém elementos, neste caso, o novo
                    // elemento será inserido no fim da Lista
                    fim.prox = novo;
                    fim = novo;
                    fim.prox = null;
                }
                System.out.println("=> MENSAGEM: O número: " + novo.num + ", foi inserido no fim da lista.");

            } // fim inserir no fim da lista **************************

            // Consultar toda a lista **********************************
            if (op == 3) {
                if (inicio == null) {
                    // A lista está vazia
                    System.out.println("A lista está vazia!");
                } else {
                    // A lista contém elementos e estes serão mostrados
                    // do início ao fim
                    System.out.println("\nConsultando toda a lista\n");
                    aux = inicio;
                    while (aux != null) {
                        System.out.println(aux.num + " ");
                        aux = aux.prox;
                        // aux = fim.prox;      // => resultaria em 30 (o endereço do último valor inserido)
                        // aux = inicio.prox;   // => resultaria em 90 impresso em um loop infinito
                        //    (porque aux nuca seria null, mas sim apontaria sempre para o primeiro valor).
                    }
                }

            } // fim consultar toda a lista *************************************

            // Remover da lista *************************************************
            if (op == 4) {
                if (inicio == null) {
                    // A lista está vazia
                    System.out.println("A lista está vazia!");
                } // fim se inicio == null
                else {
                    // A lista contém elementos e o elemento a ser removido deve
                    // ser digitado
                    System.out.println("\nDigite o elemento a ser removido: ");
                    numero = entrada.nextInt();
                } // fim else do inicio == fim

                // Todas as ocorrencias da lista correspondentes ao número
                // digitado serão removidas
                aux = inicio;
                anterior = null;
                achou = 0;
                // Enquanto não for final de arquivo. O null determina final
                // de arquivo
                while (aux != null) {
                    if (aux.num == numero) {
                        // O número digitado foi encontrado na lista e
                        // será removido
                        achou = achou + 1;
                        if (aux == inicio) {
                            // o número a ser removido é o primeiro da lista
                            inicio = aux.prox;
                            aux = inicio;
                        } // fim if aux == inicio
                        else if (aux == fim) {
                            // o número a ser removido é o último da lista
                            anterior.prox = null;
                            fim = anterior;
                            aux = null;
                        } // fim else if (aux == fim)
                        else {
                            // o número a ser removido está no meio da lista
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
                    System.out.println("=> MENSAGEM: Número removido " + achou + ", vezes!");
                }

            } // fim remover da lista ****************************************

            // Esvaziar a lista ***********************************************
            if (op == 5) {
                if (inicio == null) {
                    // a lista está vazia
                    System.out.println("A lista está vazia!");
                } else {
                    // a lista será esvaziada
                    inicio = null;
                    System.out.println("=> MENSAGEM: A lista foi esvaziada!");
                }
            } // fim Esvaziar lista *****************************************

        } // fim do do/while
        while (op != 6);
        System.out.println("\n**** PROGRAMA ENCERRADO ****\n");
    } // fim do método main
} // Fim da classe LSENaoOrdenada

