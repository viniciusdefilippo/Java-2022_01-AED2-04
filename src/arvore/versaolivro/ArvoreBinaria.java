package arvore.versaolivro;

import java.util.Scanner;

public class ArvoreBinaria {

    // Definindo a classe que representará
    // cada elemento da árvore binária
    private static class Arvore {
        public int num;
        public Arvore dir, esq;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        // a árvore está vazia
        Arvore raiz = null;
        Arvore aux;

        int op, achou, numero;

        do {
            System.out.println("\nMENU DE OPÇÕES:\n");
            System.out.println("1 - Inserir na árvore");
            System.out.println("2 - Consultar um nó da árvore");
            System.out.println("3 - Consultar toda árvore em ordem");
            System.out.println("4 - Consultar toda árvore em pré-ordem");
            System.out.println("5 - Consultar toda árvore em pos-ordem");
            System.out.println("6 - Excluir um nó da árvore");
            System.out.println("7 - Esvasiar a árvore");
            System.out.println("8 - Sair");
            System.out.print("Digite sua opção: ");

            op = entrada.nextInt();

            if (op < 1 || op > 8)
                System.out.println("Opção inválida!!");
            if (op == 1) {
                System.out.println("Digite o número a ser inserido na árvore: ");
                numero = entrada.nextInt();
                raiz = inserir(raiz, numero);
                System.out.println("Número inserido na árvore!!!");
            }
            if (op == 2) {
                if (raiz == null) {
                    System.out.println("Árvore vazia!");
                } else {
                    System.out.println("Digite o número a ser consultado: ");
                    numero = entrada.nextInt();
                    achou = 0;
                    achou = consultar(raiz, numero, achou);
                    if (achou == 0) {
                        System.out.println("Número não encontrado na árvore!");
                    } else {
                        System.out.println("Número encontrado na árvore!");
                    }
                }
            }
            if (op == 3) {
                if (raiz == null) {
                    System.out.println("Árvore vazia!");
                } else {
                    System.out.println("Listando todos os elementos da árvore em ordem");
                    mostrarEmOrdem(raiz);
                }
            }

            if (op == 4) {
                if (raiz == null) {
                    System.out.println("Árvore vazia!");
                } else {
                    System.out.println("Listando todos os elementos da árvore em pré-ordem");
                    mostrarPreOrdem(raiz);
                }
            }

            if (op == 5) {
                if (raiz == null) {
                    System.out.println("Árvore vazia!");
                } else {
                    System.out.println("Listando todos os elementos da árvore em pós-ordem");
                    aux = raiz;
                    mostrarPosOrdem(aux);
                }
            }

            if (op == 6) {
                if (raiz == null) {
                    System.out.println("Árvore vazia!");
                } else {
                    System.out.println("Digite o número a ser excluído: ");
                    numero = entrada.nextInt();
                    achou = 0;
                    achou = consultar(raiz, numero, achou);
                    if (achou == 0) {
                        System.out.println("Número não encontrado na árvore!");
                    } else {
                        raiz = remover(raiz, numero);
                        System.out.println("Número excluído da árvore");
                    }
                }
            }
            if (op == 7) {
                if (raiz == null) {
                    System.out.println("Árvore vazia!");
                } else {
                    raiz = null;
                    System.out.println("Árvore esvaziada!");
                }
            }

        } while (op != 8);
    }

    public static Arvore inserir(Arvore aux, int num) {

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

    public static int consultar(Arvore aux, int num, int achou) {
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

    public static void mostrarEmOrdem(Arvore aux) {
        if (aux != null) {
            mostrarEmOrdem(aux.esq);
            System.out.println(aux.num + " ");
            mostrarEmOrdem(aux.dir);
        }
    }

    public static void mostrarPreOrdem(Arvore aux) {
        if (aux != null) {
            System.out.println(aux.num + " ");
            mostrarPreOrdem(aux.esq);
            mostrarPreOrdem(aux.dir);
        }
    }

    public static void mostrarPosOrdem(Arvore aux) {
        if (aux != null) {
            mostrarPosOrdem(aux.esq);
            mostrarPosOrdem(aux.dir);
            System.out.println(aux.num + " ");
        }
    }

    public static Arvore remover(Arvore aux, int num) {
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

}
