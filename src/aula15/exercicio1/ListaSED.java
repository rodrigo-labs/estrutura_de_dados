package aula15.exercicio1;

/**
 * Created by rodrigo on 26/06/17.
 */
public class ListaSED {

    private No inicio;
    private No fim;
    private int descritor;


    public void inserir(int valor) {
        if (inicio == null) {
            inserirNoInicio(valor);
        } else {
            No novoNo = new No(null, valor);

            fim.setProximo(novoNo);
            fim = novoNo;
            descritor++;
        }
    }

    private void inserirNoInicio(int valor) {
        No novoNo = new No(inicio, valor);
        inicio = novoNo;

        if (inicio == null) {
            fim = inicio;
        }

        descritor++;
    }

    public void romover(int valor) {
        int indice = localizar(valor);
        remover(valor, indice);
    }

    private void remover(int valor, int indice) {
        No noAtual = inicio;
        No noAnterior = null;
        No noProximo = null;

        if (inicio == null) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (indice == 0) {
            inicio = inicio.getProximo();
            descritor--;

            if (descritor == 0) {
                fim = null;
            }
        } else if (inicio.getProximo() == null) {
            inicio = null;
        } else {
            for (int i = 0; i < indice; i++) {
                noAnterior = noAtual;
                noAtual = noAtual.getProximo();
            }

            noProximo = noAtual.getProximo();
            noAnterior.setProximo(noProximo);
            noAtual = null;
        }
    }

    public int localizar(int valor) {
        return valor;
    }

    @Override
    public String toString() {
        return "";
    }
}
