// Classe ABB para demonstrar a inserção, busca, remoção, atravessamentos etc.
// em uma Árvore Binária de Busca (ABB).
// Ledón, 2016/2017; Amilton Souza Martha, 2015/2017.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_4_Maior_Menor_Iterativo;

public class Testa_ABB {

    public static void main(String[] args) {
        
        System.out.println("Vamos criar uma ABB com objetos da classe Integer:\n");
        ABB abb1 = new ABB();
        System.out.println( "Inserimos " + abb1.inserir(12) );
        System.out.println( "Inserimos " + abb1.inserir(6) );
        System.out.println( "Inserimos " + abb1.inserir(4) );
        System.out.println( "Inserimos " + abb1.inserir(15) );
        System.out.println( "Inserimos " + abb1.inserir(13) );
        System.out.println( "Inserimos " + abb1.inserir(25) );
        System.out.println( "Inserimos " + abb1.inserir(2) );
        System.out.println( "Inserimos " + abb1.inserir(5) );        
        System.out.println( "Média dos nodos: " + abb1.mediaDosNodos() );
        
        ABB abbReais = new ABB();
        System.out.println( "\nEm uma ABB com valores reais inserimos " + abbReais.inserir(12.5f) );
        System.out.println( "Inserimos " + abbReais.inserir(66.2f) );
        System.out.println( "Inserimos " + abbReais.inserir(4.3f) );  
        System.out.println( "Média dos nodos: " + abbReais.mediaDosNodos() );
        
        System.out.println("\nVamos mostrar a ABB percorrendo pré-ordem (método recursivo):");
        abb1.preOrdem();
        System.out.println("\n\nVamos mostrar a ABB percorrendo pré-ordem (método iterativo):");
        abb1.preOrdemIterativo();
        System.out.println("\nVamos mostrar a ABB percorrendo em nível (método iterativo):");
        abb1.emNivel();
        System.out.println("\n\nVamos mostrar a ABB percorrendo em nível, mas invertido (método iterativo):");
        abb1.emNivelInvertido();
        System.out.println("\nVamos mostrar a ABB percorrendo em nível, mas invertido (método iterativo, versão 2):");
        abb1.emNivelInvertidoVersao2();

        System.out.println("\nO menor valor desta árvore é: " + abb1.getMenorIterativo() );
        System.out.println("O maior valor desta árvore é: " + abb1.getMaiorIterativo() );
        
        System.out.println("\n\nAgora vamos criar uma ABB de objetos da classe Aluno (inserir pelos RGMs e percorrer em-ordem, ordenados):\n");
        ABB abb2 = new ABB();     
        abb2.inserir(new Aluno("123-4", "Rosa", 'F', 4.5f));
        abb2.inserir(new Aluno("999-9", "Ana", 'F', 9.5f));
        abb2.inserir(new Aluno("111-1", "Luiz", 'M', 6.5f));
        abb2.inserir(new Aluno("444-4", "Betty", 'F', 9.0f));
        abb2.inserir(new Aluno("222-2", "Pedro", 'M', 7.0f));
        abb2.inserir(new Aluno("777-7", "Renata", 'F', 7.2f));
        abb2.inserir(new Aluno("888-8", "Caio", 'M', 5.5f));
        abb2.inserir(new Aluno("333-3", "Lara", 'F', 9.8f));
        
        abb2.emOrdem2();          
        System.out.println();
        
        System.out.println("Menor valor desta árvore (pelo RGM): " + abb2.getMenorIterativo() );
        System.out.println("Maior valor desta árvore (pelo RGM): " + abb2.getMaiorIterativo() + "\n");

        System.out.println("Vamos mostrar esta ABB percorrendo pré-ordem (método recursivo):\n");
        abb2.preOrdem2();
        System.out.println("\nVamos mostrar esta ABB percorrendo pré-ordem (método iterativo):\n");
        abb2.preOrdemIterativo2();
    }

}
