package aula9.exercicio1;

/**
 * Created by rodrigo on 22/05/17.
 */
public class No<T> {
    private T elemento;
    private No anterior;
    private No proximo;


    public No(T elemento, No anterior, No proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }


    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
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
            return "[" + elemento + "]" + " -> " + proximo;
        } while (proximo != null);
    }
}
