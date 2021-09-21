// 
// Esta classe implementa uma árvore árvore rubro-negra (ARN).
// © Manuel Fdez. Paradela Ledón, 2017-2018.
// Utilize livremente este código mas, por favor, referencie.
// 
// Os métodos 'inserir' e 'ajustesDepoisDeInserir' utilizam como base a lógica
// dos algoritmos RB-INSERT e RB-INSERT-FIXUP do (CORMEN, 2002), e foram codificados em Java, 
// comentados, ajustados e ampliados nesta implementação pelo Prof. Ledón.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_7_Testar_ARN;

import java.util.LinkedList;

public class ARN<E extends Comparable<E>> {

    private NoARN raiz;                 //Raiz da árvore.
    private NoARN nil;                  //Nodo fictício ou sentinela.

    private final byte VERMELHO = 0;    //Constante para nodos vermelhos.
    private final byte PRETO = 1;           //Constante para nodos pretos.

    public ARN() {
        nil = new NoARN(); // criamos o nodo fictício ou sentinela nil
        nil.setEsq(nil);
        nil.setDir(nil);
        nil.setPai(nil);
        nil.setCor(PRETO);
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
                    z.getPai().setCor(PRETO); // o pai do z ficará preto
                    y.setCor(PRETO); // o tio de z também ficará preto 
                    z.getPai().getPai().setCor(VERMELHO); // e o avô de z ficará vermelho
                    z = z.getPai().getPai(); // z agora apontará para o avô, para continuar o ciclo while
                } else { // se o tio for preto, necessitaremos rotações e trocas de cores
                    if (z == z.getPai().getDir()) { // vemos se é uma topografia de tipo <
                        z = z.getPai();
                        rotacaoSE(z); // neste caso será necessária uma rotacaoDD, esta 1ª será uma rotacaoSE
                    }
                    z.getPai().setCor(PRETO); // o pai trocará de cor para preto
                    z.getPai().getPai().setCor(VERMELHO); // e o avô trocará para vermelho
                    rotacaoSD(z.getPai().getPai()); // esta rotacaoSD serve para topografia / e <
                }
            } else { // semelhantes, estes agora são os casos das topografias de tipo \ e >
                NoARN y = z.getPai().getPai().getEsq();
                if (y.getCor() == VERMELHO) {
                    z.getPai().setCor(PRETO);
                    y.setCor(PRETO);
                    z.getPai().getPai().setCor(VERMELHO);
                    z = z.getPai().getPai();
                } else {
                    if (z == z.getPai().getEsq()) {
                        z = z.getPai();
                        rotacaoSD(z);
                    }
                    z.getPai().setCor(PRETO);
                    z.getPai().getPai().setCor(VERMELHO);
                    rotacaoSE(z.getPai().getPai());
                }
            }
        }
        raiz.setCor(PRETO);
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

}
