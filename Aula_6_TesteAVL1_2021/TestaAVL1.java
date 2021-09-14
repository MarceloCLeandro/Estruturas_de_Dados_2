// Testes com uma árvore AVL
// Elaboração (2016-2021): Prof. Amilton; adaptações: Prof. Ledón.
// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_6_TesteAVL1_2021;

public class TestaAVL1 {

    public static void main(String[] args) {
        AVL avl0 = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        System.out.println("Inserimos: 20, 15, 18, 29, 26, 27");
        avl0.insereAVL("20");
        avl0.insereAVL("15");
        avl0.insereAVL("18");
        avl0.insereAVL("29");
        avl0.insereAVL("26");
        avl0.insereAVL("27");
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl0.emOrdemString());
        avl0.emNivel();

        System.out.println("\n");

        AVL avl1 = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        System.out.println("Inserimos objetos strings: 20, 15, 18, 29, 26, 27, 02, 07, 19, 10");
        avl1.insereAVL("20");
        avl1.insereAVL("15");
        avl1.insereAVL("18");
        avl1.insereAVL("29");
        avl1.insereAVL("26");
        avl1.insereAVL("27");
        avl1.insereAVL("02");
        avl1.insereAVL("07");
        avl1.insereAVL("19");
        avl1.insereAVL("10");
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl1.emOrdemString());
        avl1.emNivel();

        System.out.println("\n");

        AVL avl1x = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        System.out.println("Inserimos objetos inteiros: 20, 15, 18, 29, 26, 27, 2, 7, 19, 10");
        avl1x.insereAVL(20);
        avl1x.insereAVL(15);
        avl1x.insereAVL(18);
        avl1x.insereAVL(29);
        avl1x.insereAVL(26);
        avl1x.insereAVL(27);
        avl1x.insereAVL(2);
        avl1x.insereAVL(7);
        avl1x.insereAVL(19);
        avl1x.insereAVL(10);
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl1x.emOrdemString());
        avl1x.emNivel();

        System.out.println("\n");
        System.out.println("Inserimos: José, Eduardo, Alberto, Gilberto, Esteban, Zoe, Berta, Juan, Luis, Ana");
        AVL avl2 = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        avl2.insereAVL("José");
        avl2.insereAVL("Eduardo");
        avl2.insereAVL("Alberto");
        avl2.insereAVL("Gilberto");
        avl2.insereAVL("Esteban");
        avl2.insereAVL("Zoe");
        avl2.insereAVL("Berta");
        avl2.insereAVL("Juan");
        avl2.insereAVL("Luis");
        avl2.insereAVL("Ana");
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl2.emOrdemString());
        avl2.emNivel();

        System.out.println("\n");

        System.out.println("Inserimos: 48, 23, 89, 12, 30, 70, 90, 31, 32");
        AVL avl3 = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        avl3.insereAVL("48");
        avl3.insereAVL("23");
        avl3.insereAVL("89");
        avl3.insereAVL("12");
        avl3.insereAVL("30");
        avl3.insereAVL("70");
        avl3.insereAVL("90");
        avl3.insereAVL("31");
        avl3.insereAVL("32");
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl3.emOrdemString());
        avl3.emNivel();

        System.out.println("\n");

        AVL avl4 = new AVL();
        System.out.println("Inserimos: Beta, Alfa, Amb, Lamb, Lab, Lua, Abba, Aaa, Abu");
        avl4.insereAVL("Beta");
        avl4.insereAVL("Alfa");
        avl4.insereAVL("Amb");
        avl4.insereAVL("Lamb");
        avl4.insereAVL("Lab");
        avl4.insereAVL("Lua");
        avl4.insereAVL("Abba");
        avl4.insereAVL("Aaa");
        avl4.insereAVL("Abu");
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl4.emOrdemString());
        avl4.emNivel();

        System.out.println("\n");

        AVL avl5 = new AVL();
        System.out.println("Inserimos: 60, 20, 80, 10, 40, 70, 30, 65");
        System.out.println("Que é equivalente ao exemplo no material: 6, 2, 8, 1, 4, 7, 3, 6 1/2");
        avl5.insereAVL(60);
        avl5.insereAVL(20);
        avl5.insereAVL(80);
        avl5.insereAVL(10);
        avl5.insereAVL(40);
        avl5.insereAVL(70);
        avl5.insereAVL(30);
        avl5.insereAVL(65);
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl5.emOrdemString());
        avl5.emNivel();

        System.out.println("\n");

        AVL avl5x = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        System.out.println("Inserimos: 6.0, 2.0, 8.0, 1.0, 4.0, 7.0, 3.0, 6.5, como ex. no material, 6 1/2 é 6.5");
        avl5x.insereAVL(6.0);
        avl5x.insereAVL(2.0);
        avl5x.insereAVL(8.0);
        avl5x.insereAVL(1.0);
        avl5x.insereAVL(4.0);
        avl5x.insereAVL(7.0);
        avl5x.insereAVL(3.0);
        avl5x.insereAVL(6.5);
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl5x.emOrdemString());
        avl5x.emNivel();
        System.out.println("\n");

        AVL avl6 = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        System.out.println("Inserimos: 1, 2, 3, 4, 5, 6, 7");
        avl6.insereAVL(1);
        avl6.insereAVL(2);
        avl6.insereAVL(3);
        avl6.insereAVL(4);
        avl6.insereAVL(5);
        avl6.insereAVL(6);
        avl6.insereAVL(7);
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl6.emOrdemString());
        avl6.emNivel();

        System.out.println("\n");

        AVL avl7 = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        System.out.println("Inserimos: 99,  80,  120,  50,  95,  100,  140,  45,  52, 42");
        avl7.insereAVL(99);
        avl7.insereAVL(80);
        avl7.insereAVL(120);
        avl7.insereAVL(50);
        avl7.insereAVL(95);
        avl7.insereAVL(100);
        avl7.insereAVL(140);
        avl7.insereAVL(45);
        avl7.insereAVL(52);
        avl7.insereAVL(42);
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl7.emOrdemString());
        avl7.emNivel();

        System.out.println("\n");

        AVL avl8 = new AVL();
        //Vamos usar a mesma sequência de um exemplo no material
        System.out.println("Inserimos: 99,  80,  120,  50,  95,  100,  140,  45,  52, 53");
        avl8.insereAVL(99);
        avl8.insereAVL(80);
        avl8.insereAVL(120);
        avl8.insereAVL(50);
        avl8.insereAVL(95);
        avl8.insereAVL(100);
        avl8.insereAVL(140);
        avl8.insereAVL(45);
        avl8.insereAVL(52);
        avl8.insereAVL(53);
        System.out.println("Atravessamentos em-ordem e em nível:");
        System.out.println(avl8.emOrdemString());
        avl8.emNivel();

        System.out.println("\n");
    }

}
