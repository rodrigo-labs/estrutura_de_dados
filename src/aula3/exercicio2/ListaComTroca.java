package aula3.exercicio2;

/**
 * Created by rodrigo on 27/03/17.
 */
public class ListaComTroca {
    private int[] lista = {10, 32, 41, 12, 53, 14, 52, 65, 76, 0};


    public void change(int posicaoOrigem, int posicaoDestino) {
        if (posicaoOrigem == 9 || posicaoDestino == 9 || posicaoOrigem == posicaoDestino) {
            throw new IllegalArgumentException("Posição invalida");
        }

        int aux;

        if (posicaoOrigem < posicaoDestino) {
            aux = lista[posicaoOrigem];

            for (int i = posicaoOrigem; i < posicaoDestino; i++) {
                lista[i] = lista[i + 1];
            }

            lista[posicaoDestino] = aux;

        } else if (posicaoOrigem > posicaoDestino) {
            aux = lista[posicaoOrigem];

            for (int i = posicaoOrigem; i > posicaoDestino; i--) {
                lista[i] = lista[i - 1];
            }

            lista[posicaoDestino] = aux;
        }
    }

    @Override
    public String toString() {
        String mostrar = "";

        for (int i = 0; i < lista.length; i++) {
            if (i < lista.length - 1) {
                mostrar += "[" + lista[i] + "] - ";
            } else {
                mostrar += "[" + lista[i] + "]";
            }
        }

        return mostrar;
    }
}
