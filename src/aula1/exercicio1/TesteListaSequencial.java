package aula1.exercicio1;

import java.util.Scanner;

/**
 * Created by rodrigo on 10/03/17.
 */
public class TesteListaSequencial {
    public static void main(String[] args) {
        ListaSequencial ls = new ListaSequencial();
        Scanner sc = new Scanner(System.in);

        String menu = "1 - Listar todos os elementos da lista\n" +
                "2 - Adicionar elemento no inicio da lista\n" +
                "3 - Adicionar elemento no final da lista\n" +
                "4 - Adicionar elemento em uma posicao especifica da lista\n" +
                "5 - Remover elemento no inicio da lista\n" +
                "6 - Remover elemento no final da lista\n" +
                "7 - Remover elemento em uma posicao especifica da lista\n" +
                "8 - Pesquisar um elemento\n" +
                "0 - Finalizar programa\n";

        do {
            System.out.println();
            System.out.println(menu);

            int opcao = Integer.parseInt(sc.nextLine());
            int posicao;
            int valor;

            // interacao com o menu do sistema
            switch (opcao) {
                case 1:
                    System.out.println();
                    System.out.print(ls.mostraLista());
                    break;

                case 2:
                    System.out.println();
                    System.out.print("Informe o valor do elemento: ");
                    ls.adicionaInicio(Integer.parseInt(sc.nextLine()));
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Informe o valor do elemento: ");
                    ls.adicionaFinal(Integer.parseInt(sc.nextLine()));
                    break;

                case 4:
                    System.out.println();
                    System.out.print("Informe a posição do elemento: ");
                    posicao = Integer.parseInt(sc.nextLine());
                    System.out.print("Informe a valor do elemento: ");
                    valor = Integer.parseInt(sc.nextLine());
                    ls.adicionaPosicao(posicao, valor);
                    break;

                case 5:
                    System.out.println();
                    ls.removeInicio();
                    break;

                case 6:
                    System.out.println();
                    ls.removeFinal();
                    break;

                case 7:
                    System.out.println();
                    System.out.print("Informe a posição do elemento: ");
                    posicao = Integer.parseInt(sc.nextLine());
                    ls.removePosicao(posicao);
                    break;

                case 8:
                    System.out.println();
                    System.out.print("Informe valor do elemento: ");
                    valor = Integer.parseInt(sc.nextLine());
                    if (ls.contem(valor) == -1) {
                        System.out.println();
                        System.out.println("Valor nao encontrado");
                    } else {
                        System.out.println();
                        System.out.println("Valor encontrado");
                    }

                case 0:
                    System.out.print("Até logo ");
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
