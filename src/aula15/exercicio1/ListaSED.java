package aula15.exercicio1;

/**
 * Created by rodrigo on 26/06/17.
 */
public class ListaSED {

    private No inicio;
    private No fim;
    private int descritor;


    public void inserir(int valor) {
        No novoNo = new No(null, valor);

        if (descritor == 0) {
            inicio = fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }

        descritor++;
    }

    public void remover(int valor) {
        No noAtual = inicio;
        No noAnterior = null;
        No noProximo = null;

        if (descritor == 0) {
            throw new IllegalArgumentException("Lista vazia");
        } else if (inicio.getValor() == valor) {
            inicio = inicio.getProximo();
            descritor--;
        } else if (fim.getValor() == valor) {
            while (noAtual.getProximo() != null) {
                noAtual = noAtual.getProximo();
            }

            noAtual.setProximo(null);
            descritor--;
        } else if (descritor == 1) {
            inicio = fim = null;
            descritor--;
        } else {
            for (int i = 0; i < descritor; i++) {
                if (noAtual.getValor() == valor) {
                    noProximo = noAtual.getProximo();
                    noAnterior.setProximo(noProximo);
                    noAtual = null;
                }

                noAnterior = noAtual;
                noAtual = noAtual.getProximo();
            }
        }
    }

    public boolean localizar(int valor) {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}
