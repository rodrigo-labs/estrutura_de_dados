package aula7.exercicio1;

/**
 * Created by rodrigo on 19/04/17.
 */
public class ListaSED {

    private No inicio;
    private No fim;
    private int totalDeElementos;


    private void inserirNoInicio(Aluno aluno) {
        No novoNo = new No(aluno, inicio);
        inicio = novoNo;

        if (listaVazia()) {
            fim = inicio;
        }

        totalDeElementos++;
    }

    public void inserirNoFim(Aluno aluno) {
        if (listaVazia()) {
            inserirNoInicio(aluno);
        } else {
            No novoNo = new No(aluno, null);

            fim.setProximo(novoNo);
            fim = novoNo;
            totalDeElementos++;
        }
    }

    public void inserirNaPosicao(Aluno aluno, int posicao) {
        if (listaVazia() || posicao == 0) {
            inserirNoInicio(aluno);
        } else if (posicao == totalDeElementos) {
            inserirNoFim(aluno);
        } else {
            No noAnterior = getPosicao(posicao - 1);
            No novoNo = new No(aluno, noAnterior.getProximo());

            noAnterior.setProximo(novoNo);
            totalDeElementos++;
        }
    }

    public void removerNoInicio() {
        if (listaVazia()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
            inicio = inicio.getProximo();
            totalDeElementos--;

            if (totalDeElementos == 0) {
                fim = null;
            }
        }
    }

    public void removerNoFim() {
        if (listaVazia()) {
            throw new IllegalArgumentException("Lista vazia");
        } else {
            No noAtual = inicio;
            No noAuxiliar = noAtual;

            for (int i = 0; i < totalDeElementos - 1; i++) {
                noAuxiliar = noAtual;
                noAtual = noAtual.getProximo();
            }

            noAtual.setProximo(null);
            fim = noAuxiliar;
            totalDeElementos--;

            if (totalDeElementos == 0) {
                inicio = null;
                fim = null;
            }
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

    public Aluno getInicio() {
        return inicio.getAluno();
    }

    public Aluno getFim() {
        return fim.getAluno();
    }

    public Aluno buscarPorNome(String nome) {
        if (listaVazia()) {
            return null;
        } else {
            No noAtual = inicio;

            for (int i = 0; i < totalDeElementos; i++) {
                noAtual = noAtual.getProximo();

                if (nome.equals(noAtual.getAluno().getNome())) {
                    return noAtual.getAluno();
                } else {
                    return null;
                }
            }
        }

        return null;
    }

    public int tamanho() {
        return totalDeElementos;
    }

    @Override
    public String toString() {
        if (listaVazia()) {
            return "[]";
        } else {
            No noAtual = inicio;
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < totalDeElementos; i++) {
                if (i < totalDeElementos - 1) {
                    builder.append("[" + noAtual.getAluno().getNome() + "] - ");
                } else {
                    builder.append("[" + noAtual.getAluno().getNome() + "]");
                }

                noAtual = noAtual.getProximo();
            }

            return builder.toString();
        }
    }

    private No getPosicao(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        } else {
            No noAtual = inicio;

            for (int i = 0; i < posicao; i++) {
                noAtual = noAtual.getProximo();
            }

            return noAtual;
        }
    }

    private boolean listaVazia() {
        return totalDeElementos == 0;
    }

    private boolean posicaoOcupada(int posicao) {
        return (posicao >= 0) && (posicao < totalDeElementos);
    }
}
