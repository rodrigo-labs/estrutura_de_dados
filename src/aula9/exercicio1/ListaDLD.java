package aula9.exercicio1;

/**
 * Created by rodrigo on 22/05/17.
 */
public class ListaDLD<T> {
    private No<T> inicio;
    private No<T> fim;
    private int descritor = 0;


    public void adicionarNoInicio(T elemento) {
        No novoNo = new No(elemento, null, inicio);

        inicio = novoNo;

        if (listaVazia()) {
            fim = inicio;
        }

        descritor++;
    }

    public void adicionarNoFim(T elemento) {
        if (listaVazia()) {
            adicionarNoInicio(elemento);
        } else {
            No noNovo = new No(elemento, fim, null);

            fim.setProximo(noNovo);
            fim = noNovo;
            descritor++;
        }
    }

    public void adicionarNaPosicao(T elemento, int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        if (listaVazia() || posicao == 0) {
            adicionarNoInicio(elemento);
        } else if (posicao == tamanhoDaLista()) {
            adicionarNoFim(elemento);
        } else {
            No noAtual = inicio;
            No noAnterior = null;
            No noProximo = null;

            for (int i = 0; i < posicao; i++) {
                noAtual = noAtual.getProximo();
            }

            noAnterior = noAtual.getAnterior();
            noProximo = noAtual.getProximo();

            No novoNo = new No(elemento, noAnterior, noProximo);

            descritor++;
        }
    }

    public void removerNoInicio() {
        if (listaVazia()) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (tamanhoDaLista() == 1) {
            inicio = null;
            descritor--;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
            descritor--;
        }
    }

    public void removerNoFim() {
        if (listaVazia()) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (tamanhoDaLista() == 1) {
            inicio = null;
            descritor--;
        } else {
            No noAnterior = fim.getAnterior();

            fim.setAnterior(null);
            noAnterior.setProximo(null);
            fim = noAnterior;
            descritor--;
        }
    }

    public void removerNaPosicao(int posicao) {
        No noAtual = inicio;
        No noAnterior = null;
        No noProximo = null;

        if (listaVazia()) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição invalida");
        } else if (posicao == 0) {
            System.out.println("remove no inicio");
            removerNoInicio();
        } else if (posicao == tamanhoDaLista() - 1) {
            System.out.println("remove no fim");
            removerNoFim();
        } else {
            for (int i = 0; i < posicao; i++) {
                noAnterior = noAtual;
                noAtual = noAtual.getProximo();
            }

            noProximo = noAtual.getProximo();
            noAnterior.setProximo(noProximo);
            noProximo.setAnterior(noAnterior);
            noAtual = null;
            descritor--;
        }
    }

    public boolean contemNaLista(T elemento) {
        if (listaVazia()) {
            return false;
        } else {
            No noAtual = inicio;

            while (noAtual.getProximo() != null) {
                noAtual = noAtual.getProximo();

                if (noAtual.getElemento() == elemento) {
                    return true;
                }
            }
        }

        return false;
    }

    public int tamanhoDaLista() {
        return descritor;
    }

    public No primeiroDaLista() {
        return inicio;
    }

    public No ultimoDaLista() {
        return fim;
    }

    @Override
    public String toString() {
        if (inicio == null) {
            return "[]";
        } else {
            return inicio.toString();
        }
    }


    private boolean listaVazia() {
        return descritor == 0;
    }

    private boolean posicaoOcupada(int posicao) {
        return (posicao >= 0) && (posicao < descritor);
    }
}
