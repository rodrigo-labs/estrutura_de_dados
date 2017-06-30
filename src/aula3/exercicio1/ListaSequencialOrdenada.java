package aula3.exercicio1;

/**
 * Created by rodrigo on 21/03/17.
 */
public class ListaSequencialOrdenada {
    protected static final int TAMANHO = 10;
    protected int[] lista = new int[TAMANHO];
    protected int cursor = 0;


    //adiciona um elemento em uma posicao expecifica da lista
    public void add(int value) {
        if (isFull()) {
            throw new IllegalArgumentException("Lista cheia");
        }

        int posicao = getPosicao(value);

        for (int i = cursor; i > posicao; i--) {
            lista[i] = lista[i - 1];
        }


        lista[posicao] = value;
        cursor++;
    }

    //recebe uma posicao e remove um elemento da lista
    public void remove(int posicao) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (posicao >= TAMANHO) {
            throw new IllegalArgumentException("Posiçao invalida");
        }

        for (int i = posicao; i < cursor - 1; i++) {
            lista[i] = lista[i + 1];
        }

        cursor--;
    }

    private int getPosicao(int valor) {
        if (isEmpty()) {
            return 0;
        } else if (valor > lista[cursor - 1]) {
            return cursor;
        } else {
            for (int i = 0; i < cursor; i++) {
                if (valor == lista[i]) {
                    throw new IllegalArgumentException("Número já cadastrado");
                } else if (valor < lista[i]) {
                    return i;
                }
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        String mostrar = "";

        if (isEmpty()) {
            mostrar = "[]";
        } else {
            for (int i = 0; i < cursor; i++) {
                if (i < cursor - 1) {
                    mostrar += "[" + lista[i] + "] - ";
                } else {
                    mostrar += "[" + lista[i] + "]";
                }
            }
        }

        return mostrar;
    }

    //verifica se a lista esta vazia
    protected boolean isEmpty() {
        return cursor <= 0;
    }

    //verifica se a lista esta cheia
    protected boolean isFull() {
        return cursor >= TAMANHO;
    }
}
