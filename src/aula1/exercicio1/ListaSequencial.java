package aula1.exercicio1;

import java.util.Random;

/**
 * Created by rodrigo on 09/03/17.
 */

public class ListaSequencial {

    private static final int TAMANHO = 5;
    private int[] lista = new int[TAMANHO];
    private int cursor = 0;


    //mostra os elementos da lista
    public String mostraLista() {
        String mostrar = "";
        if (listaVazia()) {
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

    //adiciona um elemento no inicio da lista
    public void adicionaInicio(int valor) {
        if (listaCheia()) {
            throw new IllegalArgumentException("A lista esta cheia");
        }

        for (int i = cursor; i > 0; i--) {
            lista[i] = lista[i - 1];
        }

        lista[0] = valor;
        cursor++;
    }

    //adiciona um elemento no final da lista
    public void adicionaFinal(int valor) {
        if (listaCheia()) {
            throw new IllegalArgumentException("A lista esta cheia");
        }

        lista[cursor] = valor;
        cursor++;
    }

    //adiciona um elemento em uma posicao expecifica da lista
    public void adicionaPosicao(int posicao, int valor) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posicao invalida");
        }

        for (int i = cursor; i >= posicao; i--) {
            lista[i] = lista[i - 1];
        }

        lista[posicao] = valor;
        cursor++;
    }

    //remove um elemento no inicio da lista
    public void removeInicio() {
        if (listaVazia()) {
            throw new IllegalArgumentException("posicao invalida");
        }

        for (int i = 0; i < cursor - 1; i++) {
            lista[i] = lista[i + 1];
        }

        cursor--;
    }

    //remove no final da lista
    public void removeFinal() {
        if (listaVazia()) {
            throw new IllegalArgumentException("posicao invalida");
        }

        //simulando o null de um objeto
        lista[cursor - 1] = 0;
        cursor--;
    }

    //recebe uma posicao e remove um elemento da lista
    public void removePosicao(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posiçao invalida");
        }

        for (int i = posicao; i < cursor - 1; i++) {
            lista[i] = lista[i + 1];
        }

        cursor--;
    }

    //recebe um valor e descobre se este valor está ou não na lista
    public int contem(int valor) {
        for (int i = 0; i < cursor; i++) {
            if (lista[i] == valor) {
                return i;
            }
        }

        return -1;
    }

    //recebe uma posição e devolve um elemento da lista
    public int pega(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posiçao invalida");
        }

        return lista[posicao];
    }

    //Sorteia uma posicao da lista
    public int sorteiaPosicao() {
        if (listaVazia()) {
            throw new IllegalArgumentException("A lista esta vazia");
        }

        Random randonico = new Random();
        int sorteado = randonico.nextInt(cursor - 1);

        return sorteado;
    }

    //verifica se a lista esta vazia
    private boolean listaVazia() {
        return cursor <= 0;
    }

    //verifica se a lista esta cheia
    private boolean listaCheia() {
        return cursor >= TAMANHO;
    }

    //recebe uma posicao e verifica se a mesma e valida
    private boolean posicaoValida(int posicao) {
        return (posicao >= 0) && (posicao < TAMANHO);
    }

    //verifica se possui elementos na lista
    private boolean posicaoOcupada() {
        return (cursor > 0) && (cursor < TAMANHO);
    }

    //recebe uma posicao e verifica se a mesma esta ocupada
    private boolean posicaoOcupada(int posicao) {
        return (posicao >= 0) && (posicao < cursor);
    }
}
