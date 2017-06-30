package aula2.exercicio1;

import aula1.exercicio1.ListaSequencial;

import java.util.Scanner;

/**
 * Created by rodrigo on 13/03/17.
 */
public class SorteioPub {
    public static void main(String[] args) {
        ListaSequencial ls = new ListaSequencial();
        Scanner sc = new Scanner(System.in);

        String menu = "1 - Adiciona um número a lista\n" +
                "2 - Remove um número da lista\n" +
                "3 - Sorteia um número da lista\n" +
                "0 - Finaliza o programa\n";

        do {
            System.out.println();
            System.out.println(menu);

            int opcao = Integer.parseInt(sc.nextLine());
            int posicao;
            int celular;

            // interacao com o menu do sistema
            switch (opcao) {
                case 1:
                    System.out.println();
                    System.out.print("Informe o número do celular: ");
                    ls.adicionaFinal(Integer.parseInt(sc.nextLine()));
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Números cadatrados: " + ls.mostraLista());
                    System.out.println();
                    System.out.print("Informe o número do celular: ");
                    celular = Integer.parseInt(sc.nextLine());
                    posicao = ls.contem(celular);

                    if (posicao == -1) {
                        System.out.println();
                        System.out.println("Celular não encontrado");
                    } else {
                        System.out.println();
                        ls.removePosicao(posicao);
                        System.out.println("Celular removido com sucesso");
                    }

                    break;

                case 3:
                    posicao = ls.sorteiaPosicao();
                    System.out.println();
                    System.out.print("O celular sorteado é: " + ls.pega(posicao));
                    ls.removePosicao(posicao);
                    break;

                case 0:
                    System.out.print("Até logo");
                    System.exit(0);
                    break;

                default:
                    System.out.println();
                    System.out.println("Opção Invalida!");
                    break;
            }

        } while (true);
    }
}
