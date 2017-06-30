package aula8.exercicio2;

/**
 * Created by rodrigo on 10/05/17.
 */
public class ListaDL<T> {
    private No<T> inicio;

    public void adicionarNoInicio(T elemento) {
        No novoNo = new No(elemento, null, inicio);

        inicio = novoNo;
    }

    public void adicionarNoFim(T elemento) {
        if (inicio == null) {
            adicionarNoInicio(elemento);
        } else {
            No noAtual = inicio;

            while (noAtual.getProximo() != null) {
                noAtual = noAtual.getProximo();
            }

            noAtual.setProximo(new No(elemento, noAtual, null));
        }
    }

    public void adicionarNaPosicao(T elemento, int posicao) {
        if (posicao == 0) {
            adicionarNoInicio(elemento);
        } else {
            No noAtual = inicio;
            No noAnterior = null;

            for (int i = 0; i < posicao; i++) {
                noAnterior = noAtual;
                noAtual = noAtual.getProximo();
            }

            No novoNo = new No(elemento, noAnterior, noAtual);

            noAnterior.setProximo(novoNo);
            noAtual.setAnterior(novoNo);
        }
    }

    public void removerNoInicio() {
        if (inicio == null) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (inicio.getProximo() == null) {
            inicio = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }
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
            noProximo.setAnterior(noAnterior);
            noAtual = null;
        }
    }

    public boolean contem(T elemento) {
        if (inicio == null) {
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

    public int tamanho() {
        if (inicio == null) {
            return 0;
        } else {
            No noAtual = inicio;
            int contador = 1;

            while (noAtual.getProximo() != null) {
                noAtual = noAtual.getProximo();
                contador++;
            }

            return contador;
        }
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
