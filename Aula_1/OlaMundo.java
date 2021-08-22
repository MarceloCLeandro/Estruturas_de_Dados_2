/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estruturas_de_Dados_2.Aula_1;

/**
 *
 * @author mcl_l
 */
public class OlaMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Olá Mundo!");
        Aluno Alu1 = new Aluno("Marcelo", 124575, 28);
        Aluno Alu2 = new Aluno("Thatyane", 151625, 27);

        System.out.println(Alu1.toString());
        System.out.println(Alu2.toString());
    }

}
