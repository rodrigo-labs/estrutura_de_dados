package aula4.exercicio1;

/**
 * Created by rodrigo on 21/03/17.
 */
public class ListaSequencialOrdenada {

    private static final int TAMANHO = 10;
    private int[] lista = new int[TAMANHO];
    private int posicaoAtual = 0;


    //adiciona um elemento em uma posicao expecifica da lista
    public void add(int posicao, int valor) {
        if (isFull()) {
            throw new IllegalArgumentException("Lista cheia");
        }

        for (int i = posicaoAtual - 1; i >= posicao; i--) {
            lista[i + 1] = lista[i];
        }

        lista[posicao] = valor;
        posicaoAtual++;
    }

    //recebe uma posicao e remove um elemento da lista
    public void remove(int posicao) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }

        for (int i = posicao; i < posicaoAtual; i++) {
            lista[i] = lista[i + 1];
        }

        posicaoAtual--;
    }

    //recebe um valor e retorna o indice se esta na lista ou -1 se nao estiver
    public int contains(int valor) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }

        for (int i = 0; i < posicaoAtual; i++) {
            if (lista[i] == valor) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        String mostrar = "";

        if (isEmpty()) {
            mostrar = "[]";
        } else {
            for (int i = 0; i < posicaoAtual; i++) {
                if (i < posicaoAtual - 1) {
                    mostrar += "[" + lista[i] + "] - ";
                } else {
                    mostrar += "[" + lista[i] + "]";
                }
            }
        }

        return mostrar;
    }

    //verifica se a lista esta vazia
    private boolean isEmpty() {
        return posicaoAtual <= 0;
    }

    //verifica se a lista esta cheia
    private boolean isFull() {
        return posicaoAtual >= TAMANHO;
    }
}
