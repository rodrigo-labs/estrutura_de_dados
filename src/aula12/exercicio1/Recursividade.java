package aula12.exercicio1;

/**
 * Created by rodrigo.vieira9 on 29/05/2017.
 */
public class Recursividade {

    public int fatorial(int valor) {
        int resultado = 0;

        if (valor <= 1) {
            resultado = 1;
        } else {
            resultado = valor * fatorial(valor - 1);
        }

        return resultado;
    }

    public int somatorio(int valor) {
        if (valor < 0) {
            return 0;
        }

        return valor + somatorio(valor - 1);
    }

    public int pontencia(int base, int expoente) {
        int resultado = 1;

        if (expoente > 0) {
            resultado = base * pontencia(base, expoente - 1);
        }

        return resultado;
    }

    public int fibonacci(int posicao) {
        if (posicao == 0 || posicao == 1) {
            return posicao;
        } else {
            return fibonacci(posicao - 1) + fibonacci(posicao - 2);
        }
    }
}