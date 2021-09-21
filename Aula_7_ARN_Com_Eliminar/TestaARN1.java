//
// Testes da implementação da árvore árvore rubro-negra (ARN).
// © Manuel Fdez. Paradela Ledón, 2017-2018.
// Utilize livremente este código mas, por favor, referencie.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_7_ARN_Com_Eliminar;

public class TestaARN1 {

    public static void main(String[] args) {
        ARN arn1 = new ARN();
        //Vamos inserir nodos na ARN:  2, 5, 8, 1, 15, 21, 9, 3, 11 e 16
        //que é o mesmo exemplo no pdf:
        arn1.inserir(2);
        arn1.inserir(5);
        arn1.inserir(8);
        arn1.inserir(1);
        arn1.inserir(15);
        System.out.println("Inserimos na ARN: 2, 5, 8, 1, 15");
        String resp = arn1.emOrdemString().substring(0, arn1.emOrdemString().length() - 2);
        System.out.println("Percurso em-ordem (nodos ordenados):   " + resp);
        System.out.print("ARN original em nível:   ");
        arn1.emNivelComCores();
        System.out.println("\n");
        arn1.delete(arn1.buscaNodo(5));
        System.out.println("Depois de eliminar o objeto 5, a ARN fica assim:");
        arn1.emNivelComCores();
        System.out.println("\n");

        System.out.println("---------------------------------------\n");

        //Outro teste, inserir em outra ARN vazia: Betty, Diana, Hélio, Ana, Olívia, Vitor
        ARN arn2 = new ARN();
        System.out.println("Inserimos em outra ARN vazia: Betty, Diana, Hélio, Ana, Olívia, Vítor");
        arn2.inserir("Betty");
        arn2.inserir("Diana");
        arn2.inserir("Hélio");
        arn2.inserir("Ana");
        arn2.inserir("Olívia");
        arn2.inserir("Vítor");
        System.out.println("Percurso em-ordem (nodos ordenados):   \n" + arn2.emOrdemString());
        System.out.println("ARN original em nível:   ");
        arn2.emNivelComCores();
        System.out.println("\n");
        arn2.delete(arn2.buscaNodo("Betty"));
        System.out.println("Depois de eliminar o objeto Betty, a ARN fica assim:");
        arn2.emNivelComCores();
        arn2.delete(arn2.buscaNodo("Olívia"));
        System.out.println("\nDepois de eliminar o objeto Olívia, a ARN fica assim:");
        arn2.emNivelComCores();
        System.out.println("\n");
    }

}
