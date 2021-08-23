
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN

package Estruturas_de_Dados_2.Aula_3.Testa_ABB3_Para_Alunos;

class Node <E extends Comparable<E>> {  // Nodo, nó ou elemento da árvore

    private E value;
    private Node filhoEsquerdo;
    private Node filhoDireito;
    
    public String toString () {
        return value.toString();
    }
        
    public Node(E valor) {
        this.value = valor;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(Node filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public Node getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(Node filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
    
}