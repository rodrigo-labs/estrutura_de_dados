package aula6.exercicio1;

/**
 * Created by rodrigo on 18/04/17.
 */
public class ListaSL {
    private No inicio;


    public void adicionarNoInicio(int valor) {
        No novoNo = new No(valor, inicio);

        inicio = novoNo;
    }

    public void adicionarNoFim(int valor) {
        if (inicio == null) {
            adicionarNoInicio(valor);
        } else {
            No noAtual = inicio;

            while (noAtual.getProximo() != null) {
                noAtual = noAtual.getProximo();
            }

            noAtual.setProximo(new No(valor, null));
        }
    }

    public void adicionarNaPosicao(int valor, int posicao) {
        if (posicao == 0) {
            adicionarNoInicio(valor);
        } else {
            No noAtual = inicio;
            No noAnterior = null;

            for (int i = 0; i < posicao; i++) {
                noAnterior = noAtual;
                noAtual = noAtual.getProximo();
            }

            No novoNo = new No(valor, noAtual);

            noAnterior.setProximo(novoNo);
        }
    }

    public void removerNoInicio() {
        if (inicio == null) {
            throw new IllegalArgumentException("Lista vazia");
        }

        inicio = inicio.getProximo();
    }

    public void removerNoFim() {
        if (inicio == null) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (inicio.getProximo() == null) {
            inicio = null;
        } else {
            No noAtual = inicio;
            No noAnterior = null;

            while (noAtual.getProximo() != null) {
                noAnterior = noAtual;
                noAtual = noAtual.getProximo();
            }

            noAnterior.setProximo(null);
        }
    }

    public void removerNaPosicao(int posicao) {
        No noAtual = inicio;
        No noAnterior = null;
        No noProximo = null;

        if (inicio == null) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (posicao == 0) {
            removerNoInicio();
        } else if (inicio.getProximo() == null) {
            inicio = null;
        } else {
            for (int i = 0; i < posicao; i++) {
                noAnterior = noAtual;
                noAtual = noAtual.getProximo();
            }

            noProximo = noAtual.getProximo();
            noAnterior.setProximo(noProximo);
            noAtual = null;
        }
    }

    public boolean comtem(int valor) {
        if (inicio == null) {
            throw new IllegalArgumentException("Lista vazia");
        }

        No noAuxiliar = inicio;

        while (noAuxiliar.getProximo() != null) {
            if (noAuxiliar.getValor() == valor || noAuxiliar.getProximo().getValor() == valor) {
                return true;
            }

            noAuxiliar = noAuxiliar.getProximo();
        }

        return false;
    }

    @Override
    public String toString() {
        if (inicio == null) {
            return "[]";
        } else {
            return inicio.toString();
        }
    }
}
