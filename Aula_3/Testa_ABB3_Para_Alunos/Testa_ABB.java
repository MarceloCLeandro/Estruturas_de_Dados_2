// Classe ABB para demonstrar a inserção, busca, remoção, atravessamentos etc.
// em uma Árvore Binária de Busca (ABB).

// Ledón, 2016/2017; Amilton Souza Martha, 2015/2017.

// EXEMPLOS DADOS PELO PROFESSOR LEDÓN

package Estruturas_de_Dados_2.Aula_3.Testa_ABB3_Para_Alunos;

public class Testa_ABB {

    public static void main(String[] args) {
        
        System.out.println("\n\nVamos criar uma ABB com objetos da classe Integer:\n");
        ABB abb1 = new ABB();
        System.out.println( "Inserimos " + abb1.insertContrary(12) );
        System.out.println( "Inserimos " + abb1.insertContrary(6) );
        System.out.println( "Inserimos " + abb1.insertContrary(4) );
        System.out.println( "Inserimos " + abb1.insertContrary(15) );
        System.out.println( "Inserimos " + abb1.insertContrary(13) );
        System.out.println( "Inserimos " + abb1.insertContrary(25) );
        System.out.println( "Inserimos " + abb1.insertContrary(2) );
        System.out.println( "Inserimos " + abb1.insertContrary(5) );
        
        System.out.println("\n\nVamos mostrar a ABB percorrendo em-ordem:\n");
        abb1.emOrdem();
        System.out.println("\n\nVamos mostrar a ABB percorrendo pré-ordem:\n");
        abb1.preOrdem();
        System.out.println("\n\nVamos mostrar a ABB percorrendo pós-ordem:\n");
        abb1.posOrdem();
        System.out.println("\n\nVamos mostrar a ABB percorrendo em nível:\n");
        abb1.emNivel();

        System.out.println("\n\n\nAgora vamos criar uma ABB de objetos da classe Aluno (inserir pelos RGMs e percorrer em-ordem, ordenados):\n");
        ABB abb2 = new ABB();
        Aluno alA = new Aluno("888-8", "Caio", 'M', 5.5f);
        Aluno alB = new Aluno("333-3", "Lara", 'F', 9.8f);
        Aluno alC = new Aluno("666-6", "Vanessa", 'F', 8.8f);
        Aluno alD = new Aluno("111-1", "Luiz", 'M', 6.5f);
        Aluno alE = new Aluno("999-9", "Ana", 'F', 9.5f);
        
        abb2.insertContrary(new Aluno("123-4", "Rosa", 'F', 4.5f));
        abb2.insertContrary(alE);
        abb2.insertContrary(alD);
        abb2.insertContrary(new Aluno("444-4", "Betty", 'F', 9.0f));
        abb2.insertContrary(new Aluno("222-2", "Pedro", 'M', 7.0f));
        abb2.insertContrary(new Aluno("777-7", "Renata", 'F', 7.2f));
        abb2.insertContrary(alA);
        abb2.insertContrary(alB);
        
        abb2.emOrdem2();  
        
        System.out.println("\nBuscamos " + alA +   "   " + abb2.findContrary(alA) + "\n");
        System.out.println("\nBuscamos " + alC +   "   " + abb2.findContrary(alC) + "\n");

        // buscar alunos nesta árvore
    }
    

}
