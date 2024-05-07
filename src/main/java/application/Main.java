package application;

import entities.EmptyListException;
import entities.Lista;
import static entities.Menus.*;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista listaInt = new Lista("ListaInt");
        listaInt.insereNoInicio(10);
        listaInt.insereNoInicio(5);
        listaInt.insereNoInicio(7);
        listaInt.insereNoInicio(9);
        listaInt.insereNoInicio(1);
        listaInt.insereNoInicio(14);

        boolean continuarPrincipal = true;
        while (continuarPrincipal)
        {
            System.out.println(menuPrincipal());
            int opc = scanner.nextInt();
            switch (opc)
            {
                case 1 ->
                {
                    boolean continuarInserir = true;
                    while (continuarInserir)
                    {
                        System.out.println(menuInserir());
                        int opcMenuInserir = scanner.nextInt();
                        switch (opcMenuInserir)
                        {
                            case 1 ->
                            {
                                // Inserir no Início
                                System.out.println("Insira o número que deseja adicionar: ");
                                int n = scanner.nextInt();
                                if (listaInt.buscaElemento(n))
                                {
                                    System.out.println("O elemento já existe na lista");
                                } else
                                {
                                    listaInt.insereNoInicio(n);
                                    System.out.println("Elemento inserido!!!");
                                    listaInt.print();
                                }
                            }
                            case 2 ->
                            {
                                // Inserir no Fim
                                System.out.println("Insira o número que deseja adicionar: ");
                                int n = scanner.nextInt();
                                if (listaInt.buscaElemento(n))
                                {
                                    System.out.println("O elemento já existe na lista");
                                } else
                                {
                                    listaInt.insereNoFim(n);
                                    System.out.println("Elemento inserido!!!");
                                    listaInt.print();
                                }
                            }
                            case 3 ->
                            {
                                // Inserir por Posição
                                System.out.println("Insira o número que deseja adicionar: ");
                                int n = scanner.nextInt();
                                if (listaInt.buscaElemento(n))
                                {
                                    System.out.println("O elemento já existe na lista");
                                } else
                                {
                                    System.out.println("Informe em qual posição deseja inserir o item: ");
                                    int position = scanner.nextInt();
                                    listaInt.insertAtPosicao(position, n);
                                    System.out.println("Elemento Inserido");
                                    listaInt.print();
                                }
                            }
                            case 0 ->
                                continuarInserir = false;
                            default ->
                                throw new AssertionError();
                        }
                    }
                }
                case 2 ->
                {
                    // Remover Elemento
                    boolean continuarRemover = true;
                    while (continuarRemover)
                    {
                        System.out.println(menuRemover());
                        int opcMenuRemover = scanner.nextInt();
                        switch (opcMenuRemover)
                        {
                            case 1 ->
                            {
                                // Remover do Início
                                try
                                {
                                    listaInt.removeNoInicio();
                                    System.out.println("Elemento Removido!!!");
                                    listaInt.print();
                                } catch (EmptyListException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                            case 2 ->
                            {
                                // Remover do Fim
                                try
                                {
                                    listaInt.removeNoFim();
                                    System.out.println("Elemento Removido!!!");
                                    listaInt.print();
                                } catch (EmptyListException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                            case 3 ->
                            {
                                // Remover por Valor
                                listaInt.print();
                                System.out.println("Informe o valor que deseja remover: ");
                                int valor = scanner.nextInt();
                                if (!listaInt.buscaElemento(valor))
                                {
                                    System.out.println("O elemento não existe na lista");
                                } else
                                {
                                    try
                                    {
                                        listaInt.removePorValor(valor);
                                        System.out.println("Elemento Removido!!!");
                                        listaInt.print();
                                    } catch (EmptyListException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            case 4 ->
                            {
                                // Remover por Posição
                                listaInt.print();
                                System.out.println("Informe a posição do elemento que deseja remover");
                                int posicao = scanner.nextInt();
                                try
                                {
                                    listaInt.removeFromPosicao(posicao);
                                    System.out.println("Elemento Removido!!!");
                                    listaInt.print();
                                } catch (EmptyListException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                            case 0 ->
                                continuarRemover = false;
                            default ->
                                throw new AssertionError();
                        }
                    }
                }
                case 3 ->
                {
                    // Buscar Elemento
                    boolean continuarBusca = true;
                    while (continuarBusca)
                    {
                        System.out.println("Insira o Elemento que deseja buscar: ");
                        int elemento = scanner.nextInt();
                        if (listaInt.buscaElemento(elemento))
                        {
                            System.out.println("O elemento existe na Lista");
                        } else
                        {
                            System.out.println("O elemento não existe na Lista");
                        }
                        System.out.println("""
                                           Deseja Fazer uma nova busca?
                                           1. Sim
                                           2. Não
                                           """);
                        int opcBusca = scanner.nextInt();
                        if (opcBusca == 2)
                        {
                            continuarBusca = false;
                        }
                    }
                }
                case 4 ->
                {
                    // Imprimir Elementos
                    listaInt.print();
                }
                case 0 ->
                {
                    // Sair do Programa
                    System.out.println("FIM DO PROGRAMA !!!");
                    continuarPrincipal = false;
                }
                default ->
                    throw new AssertionError();
            }
        }
    }
}
