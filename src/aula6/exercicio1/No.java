package aula6.exercicio1;

/**
 * Created by rodrigo on 18/04/17.
 */
public class No {

    private int valor;
    private No proximo;


    public No(int valor, No proximo) {
        this.valor = valor;
        this.proximo = proximo;
    }


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        do {
            return "[" + valor + "]" + " -> " + proximo;
        } while (proximo != null);
    }
}
