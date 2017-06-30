package aula2.exercicio2;

/**
 * Created by rodrigo on 14/03/17.
 */
public class Pilha {
    private static final int TAMANHO = 10;
    private int[] pilha = new int[TAMANHO];
    private int cursor = 0;


    // adiciona um elemento no final da pilha
    public void push(int value) {
        if (isFull()) {
            throw new IllegalArgumentException("A pilha está cheia");
        }

        pilha[cursor] = value;
        cursor++;
    }

    // remove um elemento do final da pilha
    public void pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("A pilha está vazia");
        }

        // simulacao de null para objeto
        pilha[cursor - 1] = 0;
        cursor--;
    }

    // devolve o elemento do topo da pilha ou -1 se estiver vazia
    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("A pilha está vazia");
        }

        return pilha[cursor - 1];
    }

    // devolve o tamanho da pilha
    public int size() {
        return cursor;
    }

    // devolve todos os elementos da pilha
    @Override
    public String toString() {
        String show = "";

        if (isEmpty()) {
            show = "[]";
        } else {
            for (int i = cursor - 1; i >= 0; i--) {
                show += "[" + pilha[i] + "]\n";
            }
        }

        return show;
    }

    // verifica se a pilha esta vazia
    private boolean isEmpty() {
        return cursor <= 0;
    }

    // verifica se a pilha esta cheia
    private boolean isFull() {
        return cursor >= TAMANHO;
    }
}
