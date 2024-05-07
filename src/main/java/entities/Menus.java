package entities;

public class Menus {

    public static String menuPrincipal() {
        return """
           ------ Menu Principal ------
           1. Inserir Novo Elemento
           2. Remover Elemento
           3. Buscar Elemento
           4. Imprimir Elementos
           0. Sair
           Escolha uma opção (0-4):
           """;
    }

    public static String menuInserir() {
        return """
           ----- Inserir Novo Elemento -----
           1. Inserir no Início
           2. Inserir no Fim
           3. Inserir por Posição
           0. Retornar ao Menu Principal
           Escolha uma opção (0-3):
           """;
    }

    public static String menuRemover() {
        return """
          ----- Remover Elemento -----
          1. Remover do Início
          2. Remover do Fim
          3. Remover por Valor
          4. Remover por Posição
          0. Retornar ao Menu Principal
          Escolha uma opção (0-4):
          """;
    }

}
