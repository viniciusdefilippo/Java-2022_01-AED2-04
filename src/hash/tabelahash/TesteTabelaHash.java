package hash.tabelahash;

public class TesteTabelaHash {

    public static void main(String[] args) {

        TabelaHash th = new TabelaHash(10);
        th.inserir(10);
        th.inserir(20);
        th.inserir(30);
        th.inserir(15);
        th.inserir(25);
        th.inserir(19);

        th.mostrarHash();

        th.consultar(100);
        th.consultar(10);

        th.excluirHash(10);
        th.inserir(10);
        th.mostrarHash();
    }
}
