package aula4.exercicio1;

import aula3.exercicio1.ListaSequencialOrdenada;

/**
 * Created by rodrigo on 28/03/17.
 */
public class ListaBusca extends ListaSequencialOrdenada {

    //recebe um valor e retorna o indice se esta na lista ou -1 se nao estiver
    public int sequentialSearch(int value) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }

        for (int i = 0; i < cursor; i++) {
            if (lista[i] == value) {
                return i;
            }
        }

        return -1;
    }

    //recebe um valor e retorna o indice se esta na lista ou -1 se nao estiver
    public int binarySearch(int value, int first, int last) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }

        if (first > last) {
            return -1;
        } else {
            int mid = (first + last) / 2;

            if (lista[mid] == value) {
                return mid;
            }

            if (lista[mid] < value) {
                return binarySearch(value, mid + 1, last);
            } else {
                return binarySearch(value, first, mid - 1);
            }
        }
    }

    // devolve o tamanho da lista
    public int size() {
        return cursor;
    }
}
