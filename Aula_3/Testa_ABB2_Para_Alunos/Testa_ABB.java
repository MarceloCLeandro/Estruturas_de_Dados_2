// Classe ABB para demonstrar a inserção, busca, remoção, atravessamentos etc.
// em uma Árvore Binária de Busca (ABB).

// Ledón, 2016/2017; Amilton Souza Martha, 2015/2017.

// EXEMPLOS DADOS PELO PROFESSOR LEDÓN

package Estruturas_de_Dados_2.Aula_3.Testa_ABB2_Para_Alunos;

public class Testa_ABB {

    public static void main(String[] args) {
        
        System.out.println("\n\nVamos criar uma ABB com objetos da classe Integer:\n");
        ABB abb1 = new ABB();
        System.out.println( "Inserimos " + abb1.inserir(12) );
        System.out.println( "Inserimos " + abb1.inserir(6) );
        System.out.println( "Inserimos " + abb1.inserir(4) );
        System.out.println( "Inserimos " + abb1.inserir(15) );
        System.out.println( "Inserimos " + abb1.inserir(13) );
        System.out.println( "Inserimos " + abb1.inserir(25) );
        System.out.println( "Inserimos " + abb1.inserir(2) );
        System.out.println( "Inserimos " + abb1.inserir(5) );
        System.out.println("Encontrou " + abb1.searchABB(12));
        System.out.println("Encontrou " + abb1.searchABB(15));
        System.out.println("Encontrou " + abb1.searchABB(25));
        System.out.println("Encontrou " + abb1.searchABB(6));
        System.out.println("Encontrou " + abb1.searchABB(4));
        System.out.println("Encontrou 33 " + abb1.searchABB(33));
        System.out.println("Encontrou 11 " + abb1.searchABB(11));
        System.out.println("Encontrou " + abb1.searchABB(15));
        
        System.out.println("\n\nVamos mostrar a ABB percorrendo em-ordem:\n");
        abb1.emOrdem();
        System.out.println("\n\nVamos mostrar a ABB percorrendo pré-ordem:\n");
        abb1.preOrdem();
        System.out.println("\n\nVamos mostrar a ABB percorrendo pós-ordem:\n");
        abb1.posOrdem();
        System.out.println("\n\nVamos mostrar a ABB percorrendo em nível:\n");
        abb1.emNivel();
        System.out.println("\n\nO menor valor desta árvore é: " + abb1.getMenor( abb1.getRaiz() ) );
        System.out.println("O maior valor desta árvore é: " + abb1.getMaior( abb1.getRaiz() ));
        
        System.out.println("\n\n\nAgora vamos criar uma ABB de objetos da classe Aluno (inserir pelos RGMs e percorrer em-ordem, ordenados):\n");
        ABB abb2 = new ABB();
        Aluno alA = new Aluno("888-8", "Caio", 'M', 5.5f);
        Aluno alB = new Aluno("333-3", "Lara", 'F', 9.8f);
        Aluno alC = new Aluno("666-6", "Vanessa", 'F', 8.8f);
        Aluno alD = new Aluno("111-1", "Luiz", 'M', 6.5f);
        Aluno alE = new Aluno("999-9", "Ana", 'F', 9.5f);
        
        abb2.inserir(new Aluno("123-4", "Rosa", 'F', 4.5f));
        abb2.inserir(alE);
        abb2.inserir(alD);
        abb2.inserir(new Aluno("444-4", "Betty", 'F', 9.0f));
        abb2.inserir(new Aluno("222-2", "Pedro", 'M', 7.0f));
        abb2.inserir(new Aluno("777-7", "Renata", 'F', 7.2f));
        abb2.inserir(alA);
        abb2.inserir(alB);
        
        abb2.emOrdem2();  
        
        System.out.println("\nBuscas - implementações recursivas");
        System.out.println("Encontrou " + abb2.searchABB(alA));
        System.out.println("Encontrou " + abb2.searchABB(alB));
        System.out.println("Não encontrou " + alC.toString() + "   " + abb2.searchABB(alC));
        System.out.println("Encontrou " + abb2.searchABB(alD));

        System.out.println("\nBuscas - implementações iterativas");
        System.out.println("Encontrou " + abb2.find(alA));
        System.out.println("Encontrou " + abb2.find(alB));
        System.out.println("Não encontrou " + alC.toString() + "   " + abb2.find(alC));
        System.out.println("Encontrou " + abb2.find(alD));

        System.out.println("\nMenor valor desta árvore (pelo RGM): " + abb2.getMenor( abb2.getRaiz()) );
        System.out.println("Maior valor desta árvore (pelo RGM): " + abb2.getMaior( abb2.getRaiz()) );
        
        System.out.println("\nInserimos " + abb2.inserir(alC) + " e a árvore fica: \n" );
        abb2.emOrdem2();  
        System.out.println("\nEliminamos " + alC + "  " + abb2.eliminar(alC) + " e a árvore fica: \n" );
        abb2.emOrdem2();  
        System.out.println("\nEliminamos " + alD + "  " + abb2.eliminar(alD) + " e a árvore fica: \n" );
        abb2.emOrdem2();  
        System.out.println("\nEliminamos " + alE + "  " + abb2.eliminar(alE) + " e a árvore fica: \n" );
        abb2.emOrdem2();  
        System.out.println("\nTentamos eliminar " + alE + "  " + abb2.eliminar(alE) + " e a árvore fica igual: \n" );
        abb2.emOrdem2();  
        System.out.println("\n");

        System.out.println("Testes com inserção, usando agora um método iterativo:");
        ABB abb3 = new ABB();
        System.out.println( "Inserimos " + abb3.insert(12) );
        System.out.println( "Inserimos " + abb3.inserir(6) );
        System.out.println( "Inserimos " + abb3.inserir(4) );
        System.out.println( "Inserimos " + abb3.inserir(15) );
        System.out.println( "Inserimos " + abb3.inserir(13) );
        System.out.println( "Inserimos " + abb3.inserir(25) );
        System.out.println( "Inserimos " + abb3.inserir(2) );
        System.out.println( "Inserimos " + abb3.inserir(5) );     
        System.out.println("Percorrendo em-ordem:");
        abb3.emOrdem();  
        System.out.println("\n");
    }
    

}
