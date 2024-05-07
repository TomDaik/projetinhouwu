/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Pedro Queiroz <pqlb1512@gmail.com>
 * @date 06/05/2024
 * @brief Class ListaNo
 */
//classe para representar um nó em uma lista
public class ListaNo {

    Object data;
    ListaNo proximoNo;

    ListaNo(Object object) {
        this(object, null);
    }// Fim do construtor de um argumento ListaNo

    // construtor cria ListaNo que referencia
    // Object e o próximo ListaNo
    ListaNo(Object object, ListaNo node) {
        data = object;
        proximoNo = node;
    }// fim do construtor de dois argumentos ListaNo

    //seta um objeto data
    public void setData(Object data) {
        this.data = data;
    }

    // retorna referência aos dados no nó
    Object getData() {
        return data; // retorna Object nesse nó
    }// fim do método getObject
    // retorna referência ao próximo nó na lista

    ListaNo getProximoNo() {
        return proximoNo; // obtém próximo nó
    }// fim do método getNext

    public void setProximoNo(ListaNo novo) {
        // TODO Auto-generated method stub
        this.proximoNo = novo;
    }
}// fim da classe ListaNo
