package aula15.exercicio1;

/**
 * Created by rodrigo on 26/06/17.
 */
public class No {

    private No proximo;
    private int valor;


    public No(No proximo, int valor) {
        this.proximo = proximo;
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
