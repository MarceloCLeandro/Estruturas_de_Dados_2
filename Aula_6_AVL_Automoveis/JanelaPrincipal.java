// EXEMPLOS DADOS PELO PROFESSOR LEDÓN
package Estruturas_de_Dados_2.Aula_6_AVL_Automoveis;
//Visual baseado na solução da aluna Rebeca Menezes Costa

import javax.swing.JOptionPane;

public class JanelaPrincipal extends javax.swing.JFrame {
    private AVL avl = new AVL();
    
    public JanelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAtravessa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALV de automóveis");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(234, 61, 61));
        jLabel1.setText("Preço:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 260, 120, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(234, 61, 61));
        jLabel2.setText("ALV de automóveis");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 10, 480, 60);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(234, 61, 61));
        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(270, 160, 120, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(234, 61, 61));
        jLabel4.setText("Ano de Fab.:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(270, 210, 120, 30);

        txtPlaca.setBackground(new java.awt.Color(204, 204, 255));
        txtPlaca.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPlaca.setForeground(new java.awt.Color(159, 102, 102));
        jPanel1.add(txtPlaca);
        txtPlaca.setBounds(410, 110, 280, 30);

        txtMarca.setBackground(new java.awt.Color(204, 204, 255));
        txtMarca.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(159, 102, 102));
        jPanel1.add(txtMarca);
        txtMarca.setBounds(410, 160, 280, 30);

        txtAno.setBackground(new java.awt.Color(204, 204, 255));
        txtAno.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtAno.setForeground(new java.awt.Color(159, 102, 102));
        jPanel1.add(txtAno);
        txtAno.setBounds(410, 210, 280, 28);

        txtPreco.setBackground(new java.awt.Color(204, 204, 255));
        txtPreco.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPreco.setForeground(new java.awt.Color(159, 102, 102));
        jPanel1.add(txtPreco);
        txtPreco.setBounds(410, 260, 280, 30);

        btnSair.setBackground(new java.awt.Color(153, 153, 255));
        btnSair.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 0, 51));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair);
        btnSair.setBounds(760, 330, 90, 30);

        btnPesquisar.setBackground(new java.awt.Color(153, 153, 255));
        btnPesquisar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(0, 0, 51));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisar);
        btnPesquisar.setBounds(600, 330, 140, 30);

        btnRemover.setBackground(new java.awt.Color(153, 153, 255));
        btnRemover.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(0, 0, 51));
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemover);
        btnRemover.setBounds(450, 330, 130, 30);

        btnAtravessa.setBackground(new java.awt.Color(153, 153, 255));
        btnAtravessa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAtravessa.setForeground(new java.awt.Color(0, 0, 51));
        btnAtravessa.setText("Atravessamentos");
        btnAtravessa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtravessaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtravessa);
        btnAtravessa.setBounds(230, 330, 200, 30);

        txtArea.setBackground(new java.awt.Color(204, 204, 255));
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtArea.setForeground(new java.awt.Color(0, 0, 51));
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 380, 900, 440);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(234, 61, 61));
        jLabel5.setText("Placa: ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(270, 110, 120, 30);

        btnInserir.setBackground(new java.awt.Color(153, 153, 255));
        btnInserir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnInserir.setForeground(new java.awt.Color(0, 0, 51));
        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jPanel1.add(btnInserir);
        btnInserir.setBounds(90, 330, 120, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 1000, 850);

        setSize(new java.awt.Dimension(1033, 916));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Automovel au = new Automovel(txtPlaca.getText(), "", 0, 0.0f);
        NoAVL nodo = avl.searchAVL(au);
        if (nodo == null) {
            txtArea.setText("O automóvel não foi encontrado.\nVerifique a placa digitada.");
        } else {
            txtArea.setText("Encontrado:\n" + nodo.getDado().toString());
        }
        //txtPlaca.setText("");
        txtMarca.setText("");
        txtAno.setText("");
        txtPreco.setText("");
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAtravessaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtravessaActionPerformed
        txtArea.setText("");
        txtArea.setText("Em-ordem:\n"
                + avl.emOrdemString()
                + "\nPré-ordem:\n"
                + avl.preOrdemString()
                + "\nPós-ordem:\n"
                + avl.posOrdemString()
                + "\nEm nivel:\n"
                + avl.emNivelString() + "\n");
        txtPlaca.setText("");
        txtMarca.setText("");
        txtAno.setText("");
        txtPreco.setText("");
    }//GEN-LAST:event_btnAtravessaActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        String placa = txtPlaca.getText();
        String marca = txtMarca.getText();
        int ano = Integer.parseInt(txtAno.getText());
        float preco = Float.parseFloat(txtPreco.getText());

        avl.insereAVL(new Automovel(placa, marca, ano, preco));
        txtArea.setText("Automóvel inserido com sucesso!\n");
        txtPlaca.setText("");
        txtMarca.setText("");
        txtAno.setText("");
        txtPreco.setText("");

    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        Automovel au = new Automovel();
        au.setPlaca(txtPlaca.getText());
        if (!avl.removeAVL(au)) {
            txtArea.setText("O automóvel não foi eliminado.\nVerifique a placa digitada.");
        } else {
            txtArea.setText("O automóvel foi eliminado do cadastro.");
        }
        //txtPlaca.setText("");
        txtMarca.setText("");
        txtAno.setText("");
        txtPreco.setText("");
    }//GEN-LAST:event_btnRemoverActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtravessa;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
