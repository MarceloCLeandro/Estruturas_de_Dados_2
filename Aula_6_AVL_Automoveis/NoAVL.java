// Esta classe define um nó de uma AVL.
// Elaboração (2016-2021): Prof. Amilton; adaptações: Prof. Ledón.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_6_AVL_Automoveis;

public class NoAVL {

    private Object dado;        //Dado do nó
    private NoAVL pai;		//Pai do nó
    private NoAVL esq;		//Filho Esquerdo
    private NoAVL dir;		//Filho Direito
    private int fb;             //Fator de Balanceamento

    public NoAVL(Object x, NoAVL p, NoAVL e, NoAVL d) {
        dado = x;
        pai = p;
        esq = e;
        dir = d;
        fb = 0;
    }

    public String toString() {
        return dado.toString();
    }

    public NoAVL() {
        this("", null, null, null);
    }

    public NoAVL(Object _dado) {
        this(_dado, null, null, null);
    }

    public Object getDado() {
        return dado;
    }

    public void setDado(Object _dado) {
        dado = _dado;
    }

    public NoAVL getPai() {
        return pai;
    }

    public void setPai(NoAVL _pai) {
        pai = _pai;
    }

    public NoAVL getEsq() {
        return esq;
    }

    public void setEsq(NoAVL _esq) {
        esq = _esq;
    }

    public NoAVL getDir() {
        return dir;
    }

    public void setDir(NoAVL _dir) {
        dir = _dir;
    }

    public void setFb(int _fb) {
        fb = _fb;
    }

    public int getFb() {
        return fb;
    }

}
