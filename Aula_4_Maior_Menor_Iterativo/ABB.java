// Classe ABB para demonstrar a inserção, busca, remoção, atravessamentos etc.
// em uma Árvore Binária de Busca (ABB).
// Ledón, 2016/2018; Amilton Souza Martha, 2015/2017.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_4_Maior_Menor_Iterativo;

import java.util.LinkedList;
import java.util.Stack;

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

    /*
      O Método 'inserir' utiliza o método 'compareTo', que deverá existir na classe de objetos a inserir na ABB.
      O método 'compareTo' da interface Comparable (implementado nas classes Double, Integer, String etc.) lançará 
      uma exception se são comparados objetos de tipos diferentes.
      Consequentemente, este método 'inserir' só conseguirá adicionar novos nodos que guardem objetos do mesmo tipo
      que o objeto inicial guardado na ABB, ou seja, a ABB guardará objetos do mesmo tipo.
     */
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
    
    public void preOrdem2() {
        preOrdem2(raiz);
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
    
    public void preOrdem2(Node no) {
        if (no != null) {
            System.out.println(no.getValue());
            preOrdem2(no.getFilhoEsquerdo());
            preOrdem2(no.getFilhoDireito());
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

    //Determina o menor elemento a partir de um nó
    public Node getMenor(Node node) {
        if (isEmpty()) {
            return null;
        }
        if (node.getFilhoEsquerdo() == null) {
            return node;
        } else {
            return getMenor(node.getFilhoEsquerdo());
        }
    }

    //Determina o maior elemento a partir de um nó
    public Node getMaior(Node node) {
        if (isEmpty()) {
            return null;
        }
        if (node.getFilhoDireito() == null) {
            return node;
        } else {
            return getMaior(node.getFilhoDireito());
        }
    }

    //Determina o maior elemento a partir de um nó.
    //Retorna o nó com o maior valor da subárvore esquerda que começa em raiz.
    public Node getMax(Node raiz, Node paiRaiz) {
        if (isEmpty()) {
            return null;
        }
        Node aux;
        if (raiz.getFilhoDireito() == null) {  // se não tiver mais filho direito
            aux = raiz;
            if (paiRaiz != null) {  // se tiver um pai, ele assume o filho esquerdo
                if (paiRaiz.getFilhoEsquerdo() == raiz) {  // se é filho esquerdo
                    paiRaiz.setFilhoEsquerdo(raiz.getFilhoEsquerdo());
                } else {
                    paiRaiz.setFilhoDireito(raiz.getFilhoEsquerdo());
                }
            }
            return aux;
        } else {
            return getMax(raiz.getFilhoDireito(), raiz);
        }
    }

    private int compara(Object ob1, Object ob2) {
        return ((Comparable) ob1).compareTo(((Comparable) ob2));
    }

    public boolean eliminar(Object e) {
        return eliminar(raiz, null, e);
    }

    private boolean eliminar(Node node, Node paiRaiz, Object e) {  // remove um elemento da árvore, retorna true ou false
        Node aux;
        if (node == null) {  // não achou o elemento, não existe (chegou em uma folha, ou árvore vazia)
            return false;  // abandonamos o método retornando false, não foi possível eliminar
        } else { // a árvore ou sub-árvore não está vazia:
            if (compara(e, node.getValue()) == 0) {  // se o nó a eliminar, node, foi encontrado (ele guarda o objeto e)
                aux = node;
                if (node.getFilhoEsquerdo() == null && node.getFilhoDireito() == null) {  // caso A: se node não possui filhos, basta eliminar o nó
                    if (paiRaiz == null) {  // se o node a eliminar não tiver pai, ele era a raiz da árvore, então a árvore ficou vazia
                        setRaiz(null);  // convenção para ABB vazia
                    } else {  // senão, o pai deve "deserdar" o filho (ficar sem esse filho eliminado)
                        // verifica se o nó que será eliminado é o filho esquerdo ou direito  do pai:
                        if (paiRaiz.getFilhoEsquerdo() != null && compara(paiRaiz.getFilhoEsquerdo().getValue(), e) == 0) {
                            paiRaiz.setFilhoEsquerdo(null);
                        } else if (paiRaiz.getFilhoDireito() != null && compara(paiRaiz.getFilhoDireito().getValue(), e) == 0) {
                            paiRaiz.setFilhoDireito(null);
                        }
                    }
                } else if (node.getFilhoDireito() == null) {   // Caso B1: se node só tiver o filho esquerdo
                    if (paiRaiz != null) {  // se node tiver um pai, o pai (paiRaiz) assume o filho esquerdo de node
                        // verifica se a raiz é filho esquerdo ou direito de paiRaiz, para assumir o neto:
                        if (paiRaiz.getFilhoEsquerdo() != null && compara(paiRaiz.getFilhoEsquerdo().getValue(), e) == 0) {
                            paiRaiz.setFilhoEsquerdo(node.getFilhoEsquerdo());
                        } else {
                            paiRaiz.setFilhoDireito(node.getFilhoEsquerdo());
                        }
                    } else { // se node não tiver pai (caso da raiz da árvore, paiRaiz é nulo), adotar seu filho ou mover a raiz:
                        node.setValue(node.getFilhoEsquerdo().getValue());
                        raiz = raiz.getFilhoEsquerdo();  // mover a raiz da árvore
                        //ou adotar o filho:
                        //node.setFilhoEsquerdo(node.getFilhoEsquerdo().getFilhoEsquerdo());
                        //node.setFilhoDireito(node.getFilhoEsquerdo().getFilhoDireito());
                    }
                } else if (node.getFilhoEsquerdo() == null) {   // Caso B2: se node só tiver o filho direito                    
                    if (paiRaiz != null) {  //se node tiver um pai, o pai (paiRaiz) assume o filho direito de node:
                        // verifica se a raiz paiRaiz tem node como filho esquerdo ou direito, para assumir o neto:
                        if (paiRaiz.getFilhoEsquerdo() != null && compara(paiRaiz.getFilhoEsquerdo().getValue(), e) == 0) {
                            paiRaiz.setFilhoEsquerdo(node.getFilhoDireito());
                        } else {
                            paiRaiz.setFilhoDireito(node.getFilhoDireito());
                        }
                    } else {  // se node não tiver pai (caso da raiz da árvore, paiRaiz é nulo), adotar seu filho ou mover a raiz:
                        node.setValue(node.getFilhoDireito().getValue());
                        raiz = raiz.getFilhoDireito();  // mover a raiz da árvore
                        //ou adotar o filho:
                        //node.setFilhoEsquerdo(node.getFilhoDireito().getFilhoEsquerdo());
                        //node.setFilhoDireito(node.getFilhoDireito().getFilhoDireito());
                    }
                } else {   // Caso C: o nodo node possui os dois filhos:
                    aux = getMax(node.getFilhoEsquerdo(), node); //determina o maior da subárvore esquerda
                    node.setValue(aux.getValue());
                }
                aux = null;
                return true;  // fim dos casos em que o nó a eliminar foi encontrado, retornamos true
            } else { // se node não é o nó a eliminar, continuamos procurando recursivamente:
                if (compara(e, node.getValue()) < 0) { // se o objeto e for menor que o objeto em node, continuar procurando à esquerda:
                    return eliminar(node.getFilhoEsquerdo(), node, e);  // chamada recursiva
                } else { // senão, procurar à direita:
                    return eliminar(node.getFilhoDireito(), node, e);  // chamada recursiva
                }
            }
        }
    }

    public Node searchABB(Object obj) {
        return searchABB(raiz, obj);
    }

    //Busca um elemento na árvore e retorna o nó onde encontrou ou null se não encontrou o nodo
    private Node searchABB(Node node, Object obj) { // procura obj a partir do nó node
        //Se a raiz for nula (árvore vazia) ou chegou em uma folha => não achou o objeto procurado:
        if (node == null) { // ou   if (isEmpty()) 
            return null;
        } else {
            //Se achou o elemento, retornar o nó:
            if (((Comparable) obj).compareTo(node.getValue()) == 0) {
                return node;
            } else {
                //Se não achou, buscar recursivamente para a esquerda ou direita:
                if (((Comparable) obj).compareTo(node.getValue()) < 0) {
                    return searchABB(node.getFilhoEsquerdo(), obj);
                } else {
                    return searchABB(node.getFilhoDireito(), obj);
                }
            }
        }
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

    // Solução do exercício 2 da aula 4
    public Node getMenorIterativo(Node p) { //Método iterativo para verificar o menos elemento da ABB
        if (isEmpty()) {
            return null;
        }
        while (p.getFilhoEsquerdo() != null) {
            p = p.getFilhoEsquerdo();
        }

        return p;
    }

    public Node getMaiorIterativo(Node p) { //Método iterativo para verificar o maior elemento da ABB
        if (isEmpty()) {
            return null;
        }
        while (p.getFilhoDireito() != null) {
            p = p.getFilhoDireito();
        }

        return p;
    }
      //Solução do professor Ledon
     //SOLUÇÃO DO EXERCÍCIO 1  
    
    public void preOrdemIterativo() {  // ou preOrdemNaoRecursivo
        if (isEmpty()) {
            return;
        }
        LinkedList pilha = new LinkedList(); // pilha auxiliar
        // Em lugar de LinkedList poderíamos usar a classe Stack do Java/Oracle
        // e os métodos push (addFirst), pop (removeFirst), isEmpty
        Node p;
        pilha.addFirst(raiz);
        while (!pilha.isEmpty()) {
            p = (Node) pilha.removeFirst();
            System.out.print(p.getValue() + "   ");
            if (p.getFilhoDireito() != null) {
                pilha.addFirst(p.getFilhoDireito());
            }
            if (p.getFilhoEsquerdo() != null) {
                pilha.addFirst(p.getFilhoEsquerdo());
            }
        }
        System.out.println("");
    }

    public void preOrdemIterativo2() {   // ou chamar preOrdemNaoRecursivo2
        if (isEmpty()) {
            return;
        }
        Stack pi = new Stack(); // pilha auxiliar
        Node p;
        pi.push(raiz);
        while (!pi.isEmpty()) {
            p = (Node) pi.pop();
            System.out.println(p.getValue());
            if (p.getFilhoDireito() != null) {
                pi.push(p.getFilhoDireito());
            }
            if (p.getFilhoEsquerdo() != null) {
                pi.push(p.getFilhoEsquerdo());
            }
        }
        System.out.println("");
    }

    
    //SOLUÇÃO DO EXERCÍCIO 2    
    
    public Node getMenorIterativo() {
        if (isEmpty()) return null;
        Node node = raiz;
        while (node.getFilhoEsquerdo() != null) {
            node = node.getFilhoEsquerdo();
        }
        return node;
    }
    
    /*
    Observe que estes dois métodos poderiam retornar o objeto guardado no nodo
    //em lugar de retornar o nodo. Por exemplo: 
    
    public Object getMenorIterativo() {
        if (isEmpty()) return null;
        Node node = raiz;
        while (node.getFilhoEsquerdo() != null) {
            node = node.getFilhoEsquerdo();
        }
        return node.getValue();
    }    
    */

    public Node getMaiorIterativo() {
        if (isEmpty()) return null;
        Node node = raiz;
        while (node.getFilhoDireito() != null) {
            node = node.getFilhoDireito();
        }
        return node;
    }

    //SOLUÇÃO DO EXERCÍCIO 3
    
    public double mediaDosNodos() {
        //Percorre os elementos em pré-ordem (não recursivo, iterativo, como programamos antes)
        //e soma e conta todos os valores.
        //Qualquer outro percurso poderia ser utilizado, sempre que visitemos todos os nós.
        //Esta função funciona somente com ABBs que armazenem valores numéricos.
        if (isEmpty()) return 0.0f;
        LinkedList pilha = new LinkedList(); // pilha auxiliar
        Node p;
        double soma = 0.0;
        int qtde = 0;
        pilha.addFirst(raiz);
        while (!pilha.isEmpty()) {
            p = (Node) pilha.removeFirst();
            soma = soma + Double.parseDouble(p.getValue().toString());
            qtde++;
            if (p.getFilhoDireito() != null) {
                pilha.addFirst(p.getFilhoDireito());
            }
            if (p.getFilhoEsquerdo() != null) {
                pilha.addFirst(p.getFilhoEsquerdo());
            }
        }
        return soma / qtde;
    }


    //SOLUÇÕES DO EXERCÍCIO 4
    
    public void emNivelInvertido() {
        //Método iterativo que utiliza uma fila auxiliar e uma pilha auxiliar
        Node noAux;
        LinkedList fila = new LinkedList();
        LinkedList pilha = new LinkedList();
        fila.addLast(raiz);
        while (!fila.isEmpty()) {
            noAux = (Node) fila.removeFirst();
            if (noAux.getFilhoEsquerdo() != null) {
                fila.addLast(noAux.getFilhoEsquerdo());
            }
            if (noAux.getFilhoDireito() != null) {
                fila.addLast(noAux.getFilhoDireito());
            }
            pilha.addFirst(noAux.getValue());
        }
        //visualizamos a pilha completa que foi criada:
        System.out.println(pilha.toString());
    }

    public void emNivelInvertidoVersao2() {
        //Método iterativo utilizando uma fila auxiliar e uma lista auxiliar 
        Node noAux;
        LinkedList fila = new LinkedList();
        LinkedList lista = new LinkedList();
        fila.addLast(raiz);
        while (!fila.isEmpty()) {
            noAux = (Node) fila.removeFirst();
            lista.addLast(noAux);
            if (noAux.getFilhoEsquerdo() != null) {
                fila.addLast(noAux.getFilhoEsquerdo());
            }
            if (noAux.getFilhoDireito() != null) {
                fila.addLast(noAux.getFilhoDireito());
            }
        }
        //percorremos a lista, do final para o início:
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.print(lista.get(i) + "   ");
        }
        System.out.println();
    }

}
