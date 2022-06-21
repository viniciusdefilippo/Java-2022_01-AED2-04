package hash.tabelahash;

public class TabelaHash {

    public static class Hash {
        private int chave;
        private Hash prox;
    }

    private final int tam; // tamanho da função hash
    private final Hash[] tabela;

    public TabelaHash(int tam) {
        this.tam = tam;
        tabela = new Hash[tam];
    }

    public void inserir(int n) {

        int pos = funcaoHashing(n);

        Hash novo = new Hash();
        novo.chave = n;
        novo.prox = tabela[pos];
        tabela[pos] = novo;
    }

    private int funcaoHashing(int num) {
        return num % tam;
    }

    public void mostrarHash() {

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

    public void consultar(int num) {

        Hash aux;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            while (aux != null) {
                if (aux.chave == num) {
                    System.out.println("Chave " + aux.chave + " encontrada!");
                    return;
                } else {
                    aux = aux.prox;
                }
            }
        }
        System.out.println("Chave " + num + " não encontrada!");
    }

    public void excluirHash(int num) {

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
}
