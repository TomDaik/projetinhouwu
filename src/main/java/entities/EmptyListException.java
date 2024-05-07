/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Pedro Queiroz <pqlb1512@gmail.com>
 * @date 06/05/2024
 * @brief Class EmptyListException
 */
public class EmptyListException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmptyListException() {

        this("List"); //chama outro construtor de EmptyListException
    }//fim do construtor sem argumento EmptyListException

    //construtor de um argumento
    public EmptyListException(String name) {
        super("A lista: " + name + " - está vazia"); //chama construtor de superclasse
    }//fim do construtor de um argumento EmptyException
}	//fim da classe EmptyListException
