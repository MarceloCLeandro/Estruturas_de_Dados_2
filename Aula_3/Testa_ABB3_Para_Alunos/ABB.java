// Classe ABB para demonstrar a inserção, busca, remoção, atravessamentos etc.
// em uma Árvore Binária de Busca (ABB).
// Ledón, 2016/2017; Amilton Souza Martha, 2015/2017.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_3.Testa_ABB3_Para_Alunos;

import java.util.LinkedList;

class ABB<E extends Comparable<E>> {  // Árvore Binária de Busca 

    private Node raiz;

    public ABB() {
        raiz = null;
    }

    public boolean isEmpty() {
        return (raiz == null);
    }

    //Configura a raiz da árvore
    public void setRaiz(Node araiz) {
        raiz = araiz;
    }

    public Node getRaiz() {
        return raiz;
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

    private Node inserir(Node novo, Node anterior) {
        if (raiz == null) {    // ou if(isEmpty())
            raiz = novo;  // ou setRaiz(novo);
            return raiz;
        }
        if (anterior == null) {
            return novo; // chegou em uma folha
        } else {
            if (novo.getValue().compareTo(anterior.getValue()) < 0) {
                anterior.setFilhoEsquerdo(inserir(novo, anterior.getFilhoEsquerdo()));
            } else {
                anterior.setFilhoDireito(inserir(novo, anterior.getFilhoDireito()));
            }
            return anterior;
        }
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    public void emOrdem2() {
        emOrdem2(raiz);
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    public void emOrdem(Node no) {
        if (no != null) {
            emOrdem(no.getFilhoEsquerdo());
            System.out.print(no.getValue() + "   ");
            emOrdem(no.getFilhoDireito());
        }
    }

    public void emOrdem2(Node no) {
        if (no != null) {
            emOrdem2(no.getFilhoEsquerdo());
            System.out.print(no.getValue() + "\n");
            emOrdem2(no.getFilhoDireito());
        }
    }

    public void preOrdem(Node no) {
        if (no != null) {
            System.out.print(no.getValue() + "   ");
            preOrdem(no.getFilhoEsquerdo());
            preOrdem(no.getFilhoDireito());
        }
    }

    public void posOrdem(Node no) {
        if (no != null) {
            posOrdem(no.getFilhoEsquerdo());
            posOrdem(no.getFilhoDireito());
            System.out.print(no.getValue() + "   ");
        }
    }

    public void emNivel() {
        //Método iterativo que utiliza uma fila auxiliar
        Node noAux;
        LinkedList fila = new LinkedList();
        fila.addLast(raiz);
        while (!fila.isEmpty()) {
            noAux = (Node) fila.removeFirst();
            if (noAux.getFilhoEsquerdo() != null) {
                fila.addLast(noAux.getFilhoEsquerdo());
            }
            if (noAux.getFilhoDireito() != null) {
                fila.addLast(noAux.getFilhoDireito());
            }
            System.out.print(noAux.getValue() + "   ");
        }
    }

    private int compara(Object ob1, Object ob2) {
        return ((Comparable) ob1).compareTo(((Comparable) ob2));
    }

    // Algumas implementações de operações com ABBs em forma iterativa:
    public Node find(Object obj) {  // método (iterativo) para buscar um obj na ABB                          
        if (isEmpty()) {
            return null;
        }
        Node atual = raiz; // começamos na raiz
        while (compara(obj, atual.getValue()) != 0) { // enquanto não encontremos o item procurado
            if (compara(obj, atual.getValue()) < 0) {
                atual = atual.getFilhoEsquerdo();
            } else {
                atual = atual.getFilhoDireito();
            }
            if (atual == null) {
                return null;  // retornamos null se não encontramos o item procurado               
            }
        }
        return atual; // retornamos o nodo encontrado
    }

    public E insert(E valor) { // implementação iterativa da inserção na ABB
        Node novoNodo;
        try {
            novoNodo = new Node(valor);
        } catch (Exception ex) {
            return null;
        } // memória insuficiente
        if (isEmpty()) {
            raiz = novoNodo; // se a ABB estiver vazia, inserimos na raiz 
        } else {
            Node atual = raiz;  // começamos procurar pela raiz      
            Node pai;
            while (true) {  // ciclo que só será interrompido ao acontecer a inserção (break interno)
                pai = atual;
                if (compara(valor, atual.getValue()) < 0) { // verificamos se devemos ir para a esquerda
                    atual = atual.getFilhoEsquerdo();
                    if (atual == null) {  // inserir à esquerda
                        pai.setFilhoEsquerdo(novoNodo);
                        break;
                    }
                } else { // ou ir para direita
                    atual = atual.getFilhoDireito();
                    if (atual == null) { // inserir a direita
                        pai.setFilhoDireito(novoNodo);
                        break;
                    }
                }
            }
        }
        return valor;
    }

    public E insertContrary(E valor) { // implementação iterativa da inserção na ABB
        Node novoNodo;
        try {
            novoNodo = new Node(valor);
        } catch (Exception ex) {
            return null;
        } // memória insuficiente
        if (isEmpty()) {
            raiz = novoNodo; // se a ABB estiver vazia, inserimos na raiz 
        } else {
            Node atual = raiz;  // começamos procurar pela raiz      
            Node pai;
            while (true) {  // ciclo que só será interrompido ao acontecer a inserção (break interno)
                pai = atual;
                if (compara(valor, atual.getValue()) < 0) { // verificamos se devemos ir para a esquerda
                    atual = atual.getFilhoEsquerdo();
                    if (atual == null) {  // inserir à esquerda
                        pai.setFilhoEsquerdo(novoNodo);
                        break;
                    }
                } else { // ou ir para direita
                    atual = atual.getFilhoDireito();
                    if (atual == null) { // inserir a direita
                        pai.setFilhoDireito(novoNodo);
                        break;
                    }
                }
            }
        }
        return valor;
    }

    public Node findContrary(Object obj) {  // método (iterativo) para buscar um obj na ABB                          
        if (isEmpty()) {
            return null;
        }
        Node atual = raiz; // começamos na raiz
        while (compara(obj, atual.getValue()) != 0) { // enquanto não encontremos o item procurado
            if (compara(obj, atual.getValue()) < 0) {
                atual = atual.getFilhoEsquerdo();
            } else {
                atual = atual.getFilhoDireito();
            }
            if (atual == null) {
                return null;  // retornamos null se não encontramos o item procurado               
            }
        }
        return atual; // retornamos o nodo encontrado
    }

}
