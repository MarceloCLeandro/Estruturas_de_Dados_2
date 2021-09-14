// Ledón, 2016/2019; Amilton, 2015/2017.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_5_AVL;

public class Testa_ABB {

    public static void main(String[] args) {

        System.out.println("Vamos criar uma ABB com objetos da classe Integer, inserimos:");
        ABB abb1 = new ABB();
        System.out.print("" + abb1.inserir(8));
        System.out.print("  " + abb1.inserir(7));
        System.out.print("   " + abb1.inserir(6));
        System.out.print("   " + abb1.inserir(9));
        System.out.print("   " + abb1.inserir(6));
        System.out.print("   " + abb1.inserir(5));
        System.out.print("   " + abb1.inserir(1));
        System.out.print("   " + abb1.inserir(2));
        System.out.print("   " + abb1.inserir(3));
        System.out.print("   " + abb1.inserir(4));

        System.out.println("\nVamos mostrar a ABB inicial percorrendo em-ordem (ordem crescente):");
        abb1.emOrdem();
        System.out.println("\nA quantidade de nodos desta árvore é " + abb1.count()
                + ", o menor valor desta ABB é " + abb1.getMenor(abb1.getRaiz())
                + " e o maior valor é " + abb1.getMaior(abb1.getRaiz()));
        System.out.println("Percorremos em nível, antes de balancear:");
        abb1.emNivel("   ");
        System.out.println("\nBALANCEAMOS esta ABB ................");
        abb1.balancear();
        System.out.println("Percorremos em nível novamente, depois de balancear:");
        abb1.emNivel("   ");
        System.out.println("\nPercorremos em-ordem (crescente), depois de balancear:");
        abb1.emOrdem();
        System.out.println("\n");

        System.out.println("Agora vamos criar uma ABB de objetos da classe Aluno, inserimos:");
        ABB abb2 = new ABB();
        Aluno alA = new Aluno("888-8", "Caio", 'M', 5.5f);
        Aluno alB = new Aluno("777-7", "Renata", 'F', 7.2f);
        Aluno alC = new Aluno("666-6", "Vanessa", 'F', 8.8f);
        Aluno alD = new Aluno("999-9", "Ana", 'F', 9.5f);
        Aluno alE = new Aluno("666-6", "Luana", 'F', 6.6f);
        Aluno alF = new Aluno("555-5", "Rosa", 'F', 4.5f);
        Aluno alG = new Aluno("111-1", "Luiz", 'M', 6.5f);
        Aluno alH = new Aluno("222-2", "Pedro", 'M', 7.0f);
        Aluno alI = new Aluno("333-3", "Lara", 'F', 9.8f);
        Aluno alJ = new Aluno("444-4", "Betty", 'F', 9.0f);
        System.out.println(abb2.inserir(alA));
        System.out.println(abb2.inserir(alB));
        System.out.println(abb2.inserir(alC));
        System.out.println(abb2.inserir(alD));
        System.out.println(abb2.inserir(alE));
        System.out.println(abb2.inserir(alF));
        System.out.println(abb2.inserir(alG));
        System.out.println(abb2.inserir(alH));
        System.out.println(abb2.inserir(alI));
        System.out.println(abb2.inserir(alJ));

        System.out.println("Menor valor desta árvore (pelo RGM): " + abb2.getMenor(abb2.getRaiz()));
        System.out.println("Maior valor desta árvore (pelo RGM): " + abb2.getMaior(abb2.getRaiz()));
        System.out.println("Quantidade de nodos desta árvore: " + abb2.count());
        System.out.println("Percorremos em nível, antes de balancear:");
        abb2.emNivel("\n");
        System.out.println("BALANCEAMOS esta ABB..................................");
        abb2.balancear();
        System.out.println("Percorremos em nível, depois de balancear:");
        abb2.emNivel("\n");
        System.out.println("Percorremos em-ordem, ordenados pelos RGMs:");
        abb2.emOrdem2();
        System.out.println("\n");
    }

}
