// 
// Esta classe implementa uma árvore árvore rubro-negra (ARN).
// © Manuel Fdez. Paradela Ledón, 2017-2018.
// Utilize livremente este código mas, por favor, referencie.
//
// Os métodos 'inserir' e 'ajustesDepoisDeInserir' utilizam como base a lógica
// dos algoritmos RB-INSERT e RB-INSERT-FIXUP do (CORMEN, 2002), e foram codificados em Java, 
// comentados, ajustados e ampliados nesta implementação pelo Prof. Ledón.
//
// Os métodos de eliminação de um nodo da ARN utilizam como base os algoritmos 
// do (CORMEN, 2002), e foram codificados em Java por Rebeca Menezes, 2018 / Prof. Ledón.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_7_ARN_Com_Eliminar;

import java.util.LinkedList;
import java.util.Stack;

public class ARN<E extends Comparable<E>> {

    private NoARN raiz;                 //Raiz da árvore.
    private NoARN nil;                  //Nodo fictício ou sentinela.

    private final byte VERMELHO = 0;    //Constante para nodos vermelhos.
    private final byte NEGRO = 1;           //Constante para nodos negros.

    public ARN() {
        nil = new NoARN(); // criamos o nodo fictício ou sentinela nil
        nil.setEsq(nil);
        nil.setDir(nil);
        nil.setPai(nil);
        nil.setCor(NEGRO);
        raiz = nil;
    }

    public NoARN getRaiz() {
        return raiz;
    }

    public void setRaiz(NoARN raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty() {
        return (raiz == nil);
    }

    private int compara(Object ob1, Object ob2) {
        return ((Comparable) ob1).compareTo(((Comparable) ob2));
    }

    public void inserir(E obj) { //inserir um objeto obj na ARN
        NoARN z = new NoARN(obj, nil);
        NoARN y = nil;  //anterior (aponta para o nodo sentinela)
        NoARN x = raiz; //posterior (começa na raiz)
        while (x != nil) { // neste ciclo y,x avançam simultaneamente
            y = x;
            if (compara(z.getDado(), x.getDado()) < 0) { // se z < x
                x = x.getEsq(); //avança pela esquerda
            } else {
                x = x.getDir(); //avança pela direita
            }
        }
        z.setPai(y); //enlaçamos o novo nodo z com seu pai
        if (y == nil) { // caso: a árvore estava árvore vazia
            raiz = z; // o novo nodo z será a raiz da árvore
            nil.setPai(raiz);
        } else if (compara(z.getDado(), y.getDado()) < 0) { // se z < y
            y.setEsq(z); // insere z à esquerda de y
        } else {
            y.setDir(z); // insere z à direita de y
        }
        z.setCor(VERMELHO); //porque um novo nodo sempre será inserido na cor vemelha
        z.setEsq(nil); //aponta para o nodo sentinela
        z.setDir(nil); //aponta para o nodo sentinela
        ajustesDepoisDeInserir(z);
    }

    public void ajustesDepoisDeInserir(NoARN z) {
        // Implementação baseada na lógica de ajustes de cores/rotações no algoritmo de (CORMEN, 2002)
        while (z.getPai().getCor() == VERMELHO) { // enquanto o pai do z for vermelho
            if (z.getPai() == z.getPai().getPai().getEsq()) { // o pai de z é filho esquerdo do avô de z
                // estes são os casos das topografias de tipo / e <
                NoARN y = z.getPai().getPai().getDir(); // y é o tio, filho direito do avô de z
                if (y.getCor() == VERMELHO) { // se o tio for vermelho, uma simples troca de cores resolverá
                    z.getPai().setCor(NEGRO); // o pai do z ficará negro
                    y.setCor(NEGRO); // o tio de z também ficará negro 
                    z.getPai().getPai().setCor(VERMELHO); // e o avô de z ficará vermelho
                    z = z.getPai().getPai(); // z agora apontará para o avô, para continuar o ciclo while
                } else { // se o tio for negro, necessitaremos rotações e trocas de cores
                    if (z == z.getPai().getDir()) { // vemos e é uma topografia de tipo <
                        z = z.getPai();
                        rotacaoSE(z); // neste caso será necessária uma rotacaoDD, esta 1ª será rotacaoSE
                    }
                    z.getPai().setCor(NEGRO); // o pai trocará de cor para negro
                    z.getPai().getPai().setCor(VERMELHO); // e o avô trocará para vermelho
                    rotacaoSD(z.getPai().getPai()); // esta rotacaoSD serve para topografia / e <
                }
            } else { // semelhantes,  estes agora são os casos das topografias de tipo \ e >
                NoARN y = z.getPai().getPai().getEsq();
                if (y.getCor() == VERMELHO) {
                    z.getPai().setCor(NEGRO);
                    y.setCor(NEGRO);
                    z.getPai().getPai().setCor(VERMELHO);
                    z = z.getPai().getPai();
                } else {
                    if (z == z.getPai().getEsq()) {
                        z = z.getPai();
                        rotacaoSD(z);
                    }
                    z.getPai().setCor(NEGRO);
                    z.getPai().getPai().setCor(VERMELHO);
                    rotacaoSE(z.getPai().getPai());
                }
            }
        }
        raiz.setCor(NEGRO);
    }

    public NoARN buscaNodo(E x) {
        return buscaNodo(raiz, x);
    }

    private NoARN buscaNodo(NoARN raiz, E x) {
        //Se a raiz for nula, o elemento não existe
        if (raiz == nil) { // a árvore está vazia? podemos usar isEmpty()
            return nil;
        } else if (compara(x, raiz.getDado()) == 0) { //x foi encontrado na raiz
            return raiz;
        } else if (compara(x, raiz.getDado()) < 0) { //procurar à esquerda
            return buscaNodo(raiz.getEsq(), x);
        } else { //procurar à direita
            return buscaNodo(raiz.getDir(), x);
        }
    }

    //Rotação Simples para a Esquerda
    private void rotacaoSE(NoARN a) {
        NoARN b = a.getDir();
        a.setDir(b.getEsq());
        b.getEsq().setPai(a);
        b.setPai(a.getPai());
        if (a.getPai() == nil) {
            raiz = b;
        } else {
            if (a == a.getPai().getEsq()) {
                a.getPai().setEsq(b);
            } else {
                a.getPai().setDir(b);
            }
        }
        b.setEsq(a);
        a.setPai(b);
    }

    //Rotação Simples para a Direita
    private void rotacaoSD(NoARN a) {
        NoARN b = a.getEsq();
        if (a.getPai() == nil) {
            raiz = b;
        } else if (a == a.getPai().getDir()) {
            a.getPai().setDir(b);
        } else {
            a.getPai().setEsq(b);
        }
        b.setPai(a.getPai());
        a.setEsq(b.getDir());
        if (a.getEsq() != nil) {
            a.getEsq().setPai(a);
        }
        b.setDir(a);
        a.setPai(b);
    }

    public String emOrdemString() {
        return emOrdemString(raiz);
    }

    private String emOrdemString(NoARN raiz) {
        String resp = "";
        if (raiz != nil) {
            resp += emOrdemString(raiz.getEsq());
            resp += raiz.getDado() + ", ";
            resp += emOrdemString(raiz.getDir());
        }
        return resp;
    }

    public String preOrdemString() {
        return preOrdemString(raiz);
    }

    private String preOrdemString(NoARN raiz) {
        String resp = "";
        if (raiz != nil) {
            resp += raiz.getDado() + ", ";
            resp += preOrdemString(raiz.getEsq());
            resp += preOrdemString(raiz.getDir());
        }
        return resp;
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(NoARN raiz) {
        if (raiz != nil) {
            posOrdem(raiz.getEsq());
            posOrdem(raiz.getDir());
            System.out.print(raiz.getDado() + ", ");
        }
    }

    public String posOrdemString() {
        return posOrdemString(raiz);
    }

    private String posOrdemString(NoARN raiz) {
        String resp = "";
        if (raiz != nil) {
            resp += posOrdemString(raiz.getEsq());
            resp += posOrdemString(raiz.getDir());
            resp += raiz.getDado() + ", ";
        }
        return resp;
    }

    public void emNivel() {
        NoARN noAux;
        LinkedList f;
        if (!isEmpty()) {
            f = new LinkedList();
            f.addLast(raiz);
            while (!f.isEmpty()) {
                noAux = (NoARN) f.removeFirst();
                if (noAux.getEsq() != nil) {
                    f.addLast(noAux.getEsq());
                }
                if (noAux.getDir() != nil) {
                    f.addLast(noAux.getDir());
                }
                System.out.print(noAux.getDado() + ", ");
            }
        }
    }

    public void emNivelComCores() {
        NoARN noAux;
        LinkedList f;
        if (!isEmpty()) {
            f = new LinkedList();
            f.addLast(raiz);
            while (!f.isEmpty()) {
                noAux = (NoARN) f.removeFirst();
                if (noAux.getEsq() != nil) {
                    f.addLast(noAux.getEsq());
                }
                if (noAux.getDir() != nil) {
                    f.addLast(noAux.getDir());
                }
                String strCor = (noAux.getCor() == 1) ? " preto" : " vermelho";
                System.out.print("" + noAux.getDado() + strCor);
                if (!f.isEmpty()) {
                    System.out.print(", ");
                }
            }
        }
    }

    public String emNivelString() {
        NoARN noAux;
        LinkedList f;
        String resp = "";
        if (!isEmpty()) {
            f = new LinkedList();
            f.addLast(raiz);
            while (!f.isEmpty()) {
                noAux = (NoARN) f.removeFirst();
                if (noAux.getEsq() != nil) {
                    f.addLast(noAux.getEsq());
                }
                if (noAux.getDir() != nil) {
                    f.addLast(noAux.getDir());
                }
                resp += noAux.getDado() + ", ";
            }
        }
        return resp;
    }

    //Exercicio 8
    Stack pilha = new Stack();

    public String listarNodosVermelhos() {
        String resp = "";
        listarNodosVermelhos(raiz);
        while (!pilha.isEmpty()) {
            resp += "" + pilha.pop() + "  ";
        }
        return resp;
    }

    private void listarNodosVermelhos(NoARN raiz) {
        if (raiz != nil) {
            listarNodosVermelhos(raiz.getEsq());
            if (raiz.getCor() == VERMELHO) {
                pilha.push(raiz.getDado());
            }
            listarNodosVermelhos(raiz.getDir());
        }
    }

    //Metodos REMOVER
    NoARN treeMinimum(NoARN x) {
        while (x.getEsq() != nil) {
            x = x.getEsq();
        }
        return x;
    }

    void transplant(NoARN u, NoARN v) {
        if (u.getPai() == nil) {
            raiz = v;
        } else if (u == u.getPai().getEsq()) {
            u.getPai().setEsq(v);
        } else {
            u.getPai().setDir(v);
        }
        //if (v != nil) {
        v.setPai(u.getPai());
        //}
    }

    void delete(NoARN z) {
        NoARN y = z;
        NoARN x;
        byte yOriginal = y.getCor();

        if (z.getEsq() == nil) {
            x = z.getDir();
            transplant(z, z.getDir());
        } else if (z.getDir() == nil) {
            x = z.getEsq();
            transplant(z, z.getEsq());
        } else {
            y = treeMinimum(z.getDir());
            yOriginal = y.getCor();
            x = y.getDir();
            if (y.getPai() == z) {
                x.setPai(y);
            } else {
                transplant(y, y.getDir());
                y.setDir(z.getDir());
                y.getDir().setPai(y);
            }
            transplant(z, y);
            y.setEsq(z.getEsq());
            y.getEsq().setPai(y);
            y.setCor(z.getCor());
        }
        if (yOriginal == NEGRO) {
            deleteFixUp(x);
        }
    }

    void deleteFixUp(NoARN x) {
        NoARN w;
        while ((x != raiz) && (x.getCor() == NEGRO)) {
            if (x == x.getPai().getEsq()) {
                w = x.getPai().getDir();
                if (w.getCor() == VERMELHO) {
                    w.setCor(NEGRO);
                    x.getPai().setCor(VERMELHO);
                    rotacaoSE(x.getPai());
                    w = x.getPai().getDir();
                }
                if ((w.getEsq().getCor() == NEGRO) && (w.getDir().getCor() == NEGRO)) {
                    w.setCor(VERMELHO);
                    x = x.getPai();
                } else {
                    if (w.getDir().getCor() == NEGRO) {
                        w.getEsq().setCor(NEGRO);
                        w.setCor(VERMELHO);
                        rotacaoSD(w);
                        w = x.getPai().getDir();
                    }
                    w.setCor(x.getPai().getCor());
                    x.getPai().setCor(NEGRO);
                    w.getDir().setCor(NEGRO);
                    rotacaoSE(x.getPai());
                    x = raiz;
                }
            } else { //same as then clause with right and left exchanged
                w = x.getPai().getEsq();
                if (w.getCor() == VERMELHO) {
                    w.setCor(NEGRO);
                    x.getPai().setCor(VERMELHO);
                    rotacaoSD(x.getPai());
                    w = x.getPai().getEsq();
                }
                if ((w.getDir().getCor() == NEGRO) && (w.getEsq().getCor() == NEGRO)) {
                    w.setCor(VERMELHO);
                    x = x.getPai();
                } else {
                    if (w.getEsq().getCor() == NEGRO) {
                        w.getDir().setCor(NEGRO);
                        w.setCor(VERMELHO);
                        rotacaoSE(w);
                        w = x.getPai().getEsq();
                    }
                    w.setCor(x.getPai().getCor());
                    x.getPai().setCor(NEGRO);
                    w.getEsq().setCor(NEGRO);
                    rotacaoSD(x.getPai());
                    x = raiz;
                }
            }
        }
        x.setCor(NEGRO);
    }

}
