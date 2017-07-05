package aula13.exercicio1;

/**
 * Created by rodrigo on 11/06/17.
 */
public class Arvore {
    public No raiz;
    private int contador = 0;


    public void incluir(int valor) {
        No novoNo = new No();
        novoNo.setValor(valor);

        incluir(raiz, novoNo);
    }

    private No incluir(No noAtual, No novoNo) {
        if (noAtual == null) {
            noAtual = novoNo;
            if (raiz == null) {
                raiz = noAtual;
            }
        } else if (novoNo.getValor() < noAtual.getValor()) {
            noAtual.setEsquerda(incluir(noAtual.getEsquerda(), novoNo));
        } else if (novoNo.getValor() > noAtual.getValor()) {
            noAtual.setDireita(incluir(noAtual.getDireita(), novoNo));
        } else {
            System.out.println("Valor ja cadastrado");
        }

        return noAtual;
    }

    public void excluir(int valor) {
        excluir(raiz, valor);
    }

    private No excluir(No noAtual, int valor) {
        if (noAtual == null) {
            return null;
        } else if (noAtual.getValor() > valor) {
            noAtual.setEsquerda(excluir(noAtual.getEsquerda(), valor));
        } else if (noAtual.getValor() < valor) {
            noAtual.setDireita(excluir(noAtual.getDireita(), valor));
        } else {
            if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) {
                noAtual = null;
            } else if (noAtual.getEsquerda() == null) {
                noAtual = noAtual.getDireita();
            } else if (noAtual.getDireita() == null) {
                noAtual = noAtual.getEsquerda();
            } else {
                No noAuxiliar = noAtual.getEsquerda();

                while (noAuxiliar.getDireita() != null) {
                    noAuxiliar = noAuxiliar.getDireita();
                }

                noAtual.setValor(noAuxiliar.getValor()); // troca os valores
                noAuxiliar.setValor(valor);
                noAtual.setEsquerda(excluir(noAtual.getEsquerda(), valor));
            }
        }

        return noAtual;
    }

    public void pesquisar(int valor) {
        pesquisar(raiz, valor);
    }

    private void pesquisar(No noAtual, int valor) {
        if (noAtual != null) {
            if (noAtual.getValor() == valor) {
                System.out.println("valor encontrado");
            }

            pesquisar(noAtual.getEsquerda(), valor);
            pesquisar(noAtual.getDireita(), valor);
        }
    }

    public int contar() {
        contador = 0;

        return contar(raiz);
    }

    private int contar(No noAtual) {
        if (noAtual != null) {
            contador++;
            contar(noAtual.getEsquerda());
            contar(noAtual.getDireita());
        }

        return contador;
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(No noAtual) {
        if (noAtual != null) {
            System.out.print(noAtual.getValor() + " ");
            preOrdem(noAtual.getEsquerda());
            preOrdem(noAtual.getDireita());
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(No noAtual) {
        if (noAtual != null) {
            posOrdem(noAtual.getEsquerda());
            posOrdem(noAtual.getDireita());
            System.out.print(noAtual.getValor() + " ");
        }
    }

    public void centralOrdem() {
        centralOrdem(raiz);
    }

    private void centralOrdem(No noAtual) {
        if (noAtual != null) {
            centralOrdem(noAtual.getEsquerda());
            System.out.print(noAtual.getValor() + " ");
            centralOrdem(noAtual.getDireita());
        }
    }
}
