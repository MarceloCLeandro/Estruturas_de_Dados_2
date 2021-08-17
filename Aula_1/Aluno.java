/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula_1;

/**
 *
 * @author mcl_l
 */
public class Aluno {

    private String nome;
    private int rgm, idade;

    public Aluno(String nome, int rgm, int idade) {
        this.nome = nome;
        this.rgm = rgm;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRgm() {
        return rgm;
    }

    public void setRgm(int rgm) {
        this.rgm = rgm;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome = " + nome + ", rgm = " + rgm + ", idade = " + idade + '}';
    }

}
