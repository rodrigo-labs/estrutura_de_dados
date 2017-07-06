package aula15.exercicio1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rodrigo on 19/06/17.
 */
public class TabelaHash {
    private static final int LIMITE = 25;
    private List tabela[] = new List[LIMITE];


    public TabelaHash() {
        for (int i = 0; i < LIMITE; i++) {
            LinkedList lista = new LinkedList();
            tabela[i] = lista;
        }
    }


    public void inserir(int valor) {
        int chave = funcaoDeEspalhamento(valor);

        tabela[chave].add(valor);
    }

    public void remover(Integer valor) {
        int chave = funcaoDeEspalhamento(valor);

        tabela[chave].remove(valor);
    }

    public void localizar(int valor) {
        int chave = funcaoDeEspalhamento(valor);

        if (tabela[chave].contains(valor)) {
            System.out.println("valor encontrado na chave " + chave);
        } else {
            System.out.println("valor nao encontrado");
        }
    }

    private int funcaoDeEspalhamento(int valor) {
        return valor % LIMITE;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < LIMITE; i++) {
            if (!(tabela[i].isEmpty())) {
                resultado += tabela[i];
            }
        }

        return resultado;
    }
}
