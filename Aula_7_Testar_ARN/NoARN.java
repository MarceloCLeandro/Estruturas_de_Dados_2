//
// Esta classe implementa um nó (NoARN) de uma árvore árvore rubro-negra (ARN).
// © Manuel Fdez. Paradela Ledón, 2017-2018.
// Utilize livremente este código mas, por favor, referencie. 
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_7_Testar_ARN;

public class NoARN<E extends Comparable<E>> {

    private E dado;             //Objeto guardado no nodo
    private NoARN pai;		//Pai do nó
    private NoARN esq;		//Filho Esquerdo
    private NoARN dir;		//Filho Direito
    private byte cor;		//Cor do nó - 0 vermelho - 1 preto

    private final byte VERMELHO = 0;
    private final byte PRETO = 1;

    public NoARN(E x, NoARN nil) {
        dado = x;
        pai = nil;
        esq = nil;
        dir = nil;
        this.cor = VERMELHO;
    }

    public NoARN(E x, NoARN p, NoARN e, NoARN d) {
        dado = x;
        pai = p;
        esq = e;
        dir = d;
        this.cor = VERMELHO;
    }

    public NoARN() {
        this(null, null, null, null);
    }

    public E getDado() {
        return dado;
    }

    public void setDado(E dado) {
        this.dado = dado;
    }

    public NoARN getPai() {
        return pai;
    }

    public void setPai(NoARN pai) {
        this.pai = pai;
    }

    public NoARN getEsq() {
        return esq;
    }

    public void setEsq(NoARN esq) {
        this.esq = esq;
    }

    public NoARN getDir() {
        return dir;
    }

    public void setDir(NoARN dir) {
        this.dir = dir;
    }

    public byte getCor() {
        return cor;
    }

    public void setCor(byte cor) {
        this.cor = cor;
    }
}
