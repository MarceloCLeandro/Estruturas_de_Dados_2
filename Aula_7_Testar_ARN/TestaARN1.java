//
// Testes da implementação da árvore árvore rubro-negra (ARN).
// © Manuel Fdez. Paradela Ledón, 2017-2018.
// Utilize livremente este código mas, por favor, referencie.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_7_Testar_ARN;

public class TestaARN1 {

    public static void main(String[] args) {
        ARN arn1 = new ARN();
        //Vamos inserir nodos na ARN:  2, 5, 8, 1, 15, 21, 9, 3, 11 e 16
        //que é o mesmo exemplo no material do .pdf:
        arn1.inserir(2);
        arn1.inserir(5);
        arn1.inserir(8);
        arn1.inserir(1);
        arn1.inserir(15);
        arn1.inserir(21);
        arn1.inserir(9);
        arn1.inserir(3);
        arn1.inserir(11);
        arn1.inserir(16);
        //String resp = arn1.emOrdemString();   mas, para eliminar a vírgula final:
        String resp = arn1.emOrdemString();
        resp = resp.substring(0, resp.length() - 2);
        System.out.println("Percurso em-ordem (objetos da ARN em ordem crescente):   " + resp);
        System.out.print("ARN em nível:   ");
        arn1.emNivelComCores();  //atravessamento em nível, mostrando o objeto e também a cor do nodo ARN

        /*
                Mostrará:
                Percurso em-ordem (nodos ordenados):   1, 2, 3, 5, 8, 9, 11, 15, 16, 21, 
                ARN em nível:   
                5 preto, 
                2 preto, 15 vermelho, 
                1 vermelho, 3 vermelho, 9 preto, 21 preto, 
                8 vermelho, 11 vermelho, 16 vermelho,         
         */

 /*
		//outro teste:
                arn.inserir("01"); 
		arn.inserir("15");
                arn.inserir("17");
                arn.inserir("18");	
                arn.inserir("19");	
                arn.inserir("20");
         */
        //outro teste (exercício solicitado no material):
        System.out.println("\n");
        ARN arn2 = new ARN();
        arn2.inserir("D");
        arn2.inserir("C");
        arn2.inserir("A");
        arn2.inserir("G");
        arn2.inserir("H");
        arn2.inserir("C2");
        resp = arn2.emOrdemString();
        resp = resp.substring(0, resp.length() - 2);
        System.out.println("Percurso em-ordem (objetos da ARN em ordem crescente):   " + resp);
        System.out.print("ARN em nível:   ");
        arn2.emNivelComCores();  //atravessamento em nível, mostrando o objeto e também a cor do nodo ARN                

        //outro teste (exercício solicitado no material):
        System.out.println("\n");
        ARN arn3 = new ARN();
        arn3.inserir("G");
        arn3.inserir("B");
        arn3.inserir("C");
        arn3.inserir("A");
        arn3.inserir("J");
        arn3.inserir("K");
        arn3.inserir("M");
        arn3.inserir("H");
        arn3.inserir("D");
        resp = arn3.emOrdemString();
        resp = resp.substring(0, resp.length() - 2);
        System.out.println("Percurso em-ordem (objetos da ARN em ordem crescente):   " + resp);
        System.out.print("ARN em nível:   ");
        arn3.emNivelComCores();  //atravessamento em nível, mostrando o objeto e também a cor do nodo ARN 

        /*
                //outro teste (exercício solicitado no material da próxima aula):
                System.out.println("\n");
                ARN arn5 = new ARN();
		arn5.inserir("Betty");
		arn5.inserir("Diana");
		arn5.inserir("Hélio");
		arn5.inserir("Ana");
		arn5.inserir("Olívia");
		arn5.inserir("Vítor");
                resp = arn5.emOrdemString();
                resp = resp.substring(0, resp.length()-2);
                System.out.println("Percurso em-ordem (objetos da ARN em ordem crescente):   " + resp);
                System.out.print("ARN em nível:   ");
                arn5.emNivelComCores();  //atravessamento em nível, mostrando o objeto e também a cor do nodo ARN 
         */
        System.out.println("\n");
    }

}
