package entities;

//definicao da classe List
public class Lista {

    private ListaNo primeiroNo;// Declara variavel de instancia com o nome de
    // PrimeiroNó
    private ListaNo ultimoNo;// Declara variavel de instancia com o nome de
    // UltimoNó
    private String nome; // String como 'lista' usada na impressao

    private int tamanhoLista;

    // construtor cria List vazia com 'list' como o nome
    public Lista() {
        this("Lista");
        this.tamanhoLista = 0;
    }// fim do construtor sem argumentos List

    // construtor cria uma List vazia com um nome
    public Lista(String nomeDaLista) {
        nome = nomeDaLista;
        primeiroNo = ultimoNo = null;
        this.tamanhoLista = 0;
    }// fim do construtor de um argumento List
    // Insere Object na frente de List

    public void insereNoInicio(Object insertItem) {
        if (estaVazia())
        { // first e lastNode referenciam o mesmo objeto
            primeiroNo = ultimoNo = new ListaNo(insertItem);
        } else
        {
            primeiroNo = new ListaNo(insertItem, primeiroNo);
        }// fim do método insereNoInicio

        this.tamanhoLista++;
    }// fim do método insereNoInicio

    // insere Object no fim de Lista
    public void insereNoFim(Object insertItem) {
        if (estaVazia())
        {
            primeiroNo = ultimoNo = new ListaNo(insertItem);
        } else
        {
            ultimoNo = ultimoNo.proximoNo = new ListaNo(insertItem);
        }
        this.tamanhoLista++;
    }// fim do método insereNoFim

    //Insere na posição informada
    public void insertAtPosicao(int posicao, Object elemento) {
        if (estaVazia())
        {
            primeiroNo = ultimoNo = new ListaNo(elemento);
        } else
        {
            int contador = 1;
            ListaNo current = primeiroNo;

            while (contador != posicao - 1)
            {
                current = current.proximoNo;
                contador++;
            }

            ListaNo novoNo = new ListaNo(elemento);
            novoNo.proximoNo = current.proximoNo;
            current.proximoNo = novoNo;
        }
    }

    // remove o primeiro nó de List
    public Object removeNoInicio() throws EmptyListException {
        if (estaVazia())
        {
            throw new EmptyListException(nome);
        }
        Object removedItem = primeiroNo.data; // recupera dados sendo removidos
        // atualiza referências primeiroNo e ultimoNo
        if (primeiroNo == ultimoNo)
        {
            primeiroNo = ultimoNo = null;
        } else
        {
            primeiroNo = primeiroNo.proximoNo;
        }
        this.tamanhoLista--;
        return removedItem;// retorna dados de nó removidas
    }// fim do método removeNoFim

    public Object removeNoFim() throws EmptyListException {
        if (estaVazia())
        {
            throw new EmptyListException(nome); //lança excessão se List estiver vazia
        }

        Object removedItem = ultimoNo.data; //recupera dados sendo removidos

        //atualiza referências primeiroNo e ultimoNo
        if (primeiroNo == ultimoNo)
        {
            primeiroNo = ultimoNo = null;
        } else
        { //localiza o novo último nó
            ListaNo current = primeiroNo;

            //faz loop enquanto nó atual não referencia lastNode
            while (current.proximoNo != ultimoNo)
            {
                current = current.proximoNo;
            }

            ultimoNo = current; //atual é novo lastNode
            current.proximoNo = null;
        }//fim do else

        this.tamanhoLista--;
        return removedItem; //retorna dados de nó removidos
    }//fim do método removeNoFim

    public Object removePorValor(Object valor) throws EmptyListException {
        Object removedItem = null;
        ListaNo current = primeiroNo;
        if (estaVazia())
        {
            throw new EmptyListException(nome); //lança exceção se a lista estiver vazia
        }
        while (current != null && current.proximoNo != null)
        {
            if (current.proximoNo.data.equals(valor))
            {
                removedItem = current.proximoNo.data;
                current.proximoNo = current.proximoNo.proximoNo;
                this.tamanhoLista--;
                return removedItem;
            }
            current = current.proximoNo;
        }
        this.tamanhoLista--;
        return removedItem;
    }

    public Object removeFromPosicao(int posicao) throws EmptyListException {
        if (estaVazia())
        {
            throw new EmptyListException(nome); // Lança exceção se a lista estiver vazia
        }

        Object removedItem;
        if (posicao == 1)
        {
            removedItem = primeiroNo.data;
            primeiroNo = primeiroNo.proximoNo;
            this.tamanhoLista--;
            return removedItem;
        }

        ListaNo anterior = primeiroNo;
        for (int contador = 1; contador < posicao - 1; contador++)
        {
            anterior = anterior.proximoNo;
            if (anterior == null || anterior.proximoNo == null)
            {
                throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
            }
        }

        removedItem = anterior.proximoNo.data;
        anterior.proximoNo = anterior.proximoNo.proximoNo;
        this.tamanhoLista--;
        return removedItem;
    }

    public boolean buscaElemento(Object elemento) {
        ListaNo current = primeiroNo;
        while (current != null)
        {
            if (current.data == elemento)
            {
                return true;
            }
            current = current.proximoNo;
        }
        return false;
    }

    // Determina se a lista estiver vazia
    public boolean estaVazia() {
        return primeiroNo == null; // retorna true se List estiver vazia
    }// fim do método estaVazia
    // gera saída do conteúdo de List

    public void print() {
        if (estaVazia())
        {
            System.out.printf("Lista Vazia %s\n", nome);
            System.out.println(imprimeTamanho());
            return;
        }// fim do if

        System.out.printf("A lista %s é: ", nome);
        ListaNo current = primeiroNo;
        // enquanto não estiver no fim da lista, gera saída dos dados do nó
        // atual
        while (current != null)
        {
            System.out.printf("%s -> ", current.data);
            current = current.proximoNo;
        }// fim do While
        System.out.printf("\n");
        System.out.println(imprimeTamanho());
    } // fim do método print

    public String imprimeTamanho() {
        return "Tamanho da Lista: " + this.tamanhoLista;
    }
}// fim da classe List
