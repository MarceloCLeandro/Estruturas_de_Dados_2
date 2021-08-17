// Classe ABB para demonstrar a inserção e o atravessamento em-ordem 
// em uma Árvore Binária de Busca (ABB)
// Ledón, 2016-2020.

// EXEMPLOS DADOS PELO PROFESSOR LEDÓN 

package Estruturas_de_Dados_2.Aula_2;

import java.util.LinkedList;

class ABB<E extends Comparable<E>> {  // Árvore Binária de Busca 

    private Node raiz;

    public ABB() {
        raiz = null; // a ABB criada estará inicialmente vazia
    }

    public boolean isEmpty() {
        return (raiz == null);
    }

    public E inserir(E valor) {
        try {
            Node novo = new Node(valor);
            this.inserir(novo, raiz);
        } catch (Exception exMemoria) {
            return null;
        }   // memória insuficiente
        return (valor);
    }

    /*
      Os métodos 'inserir' e 'add' utilizam o método 'compareTo', que deverá existir na classe de objetos a inserir na ABB.
      O método 'compareTo' da interface Comparable (implementado nas classes Double, Integer, String etc.) lançará 
      uma exception se são comparados objetos de tipos diferentes.
      Consequentemente, este método 'inserir' só conseguirá adicionar novos nodos que guardem objetos do mesmo tipo
      que o objeto inicial guardado na ABB, ou seja, a ABB guardará objetos do mesmo tipo.
     */
    private Node inserir(Node novo, Node anterior) {
        if (raiz == null) {
            raiz = novo;
            return raiz;
        }
        if (anterior != null) {
            if (novo.getValue().compareTo(anterior.getValue()) < 0) {
                anterior.setFilhoEsquerdo(inserir(novo, anterior.getFilhoEsquerdo()));
            } else {
                anterior.setFilhoDireito(inserir(novo, anterior.getFilhoDireito()));
            }
        } else {
            anterior = novo;
        }
        return anterior;
    }

    // versão mais detalhada:
    public E add(E valor) {
        try {
            Node novo = new Node(valor);
            this.add(novo, raiz);
        } catch (Exception erroMemoria) {
            return null;
        }   // memória insuficiente
        return (valor);
    }

    private Node add(Node novo, Node anterior) {
        if (raiz == null) {
            raiz = novo;
            return raiz;
        }
        if (anterior != null) {
            if (novo.getValue().compareTo(anterior.getValue()) < 0) {
                // inserir o novo objeto na sub-árvore esquerda
                Node esquerdo = anterior.getFilhoEsquerdo();
                Node proximo = add(novo, esquerdo);
                anterior.setFilhoEsquerdo(proximo);
            } else {
                // inserir o novo objeto na sub-árvore direita
                Node direito = anterior.getFilhoDireito();
                Node proximo = add(novo, direito);
                anterior.setFilhoDireito(proximo);
            }
        } else {
            anterior = novo;
        }
        return anterior;
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    public void emOrdem2() {
        emOrdem2(raiz);
    }

    public void emOrdem(Node no) { // mostra os objetos separados por espaços
        if (no != null) {
            emOrdem(no.getFilhoEsquerdo());
            System.out.print(no.getValue() + "   ");
            emOrdem(no.getFilhoDireito());
        }
    }

    public void emOrdem2(Node no) { // mostra os objetos separados por linhas
        if (no != null) {
            emOrdem2(no.getFilhoEsquerdo());
            System.out.print(no.getValue() + "\n");
            emOrdem2(no.getFilhoDireito());
        }
    }

}
