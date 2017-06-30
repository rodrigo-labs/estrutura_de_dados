package aula2.exercicio3;

/**
 * Created by rodrigo on 15/03/17.
 */
public class Fila {
    private static final int TAMANHO = 5;
    private int[] fila = new int[TAMANHO];
    private int cursor = 0;


    // adiciona um elemento no final da fila
    public void add(int value) {
        if (isFull()) {
            throw new IllegalArgumentException("A fila está cheia");
        }

        fila[cursor] = value;
        cursor++;
    }

    // remove um elemento no inicio da fila
    public void poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("A fila está vazia");
        }

        for (int i = 0; i < cursor - 1; i++) {
            fila[i] = fila[i + 1];
        }

        cursor--;
    }

    // devolve o elemento do inicio da fila ou -1 se estiver vazia
    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("A fila está vazia");
        }

        return fila[0];
    }

    // devolve o tamanho da fila
    public int size() {
        return cursor;
    }

    // devolve todos os elementos da fila
    @Override
    public String toString() {
        String show = "";

        if (isEmpty()) {
            show = "[]";
        } else {
            for (int i = 0; i < cursor; i++) {
                if (i < cursor - 1) {
                    show += "[" + fila[i] + "] - ";
                } else {
                    show += "[" + fila[i] + "]";
                }
            }
        }

        return show;
    }

    // verifica se a fila esta vazia
    private boolean isEmpty() {
        return cursor <= 0;
    }

    // verifica se a fila esta cheia
    private boolean isFull() {
        return cursor >= TAMANHO;
    }
}
