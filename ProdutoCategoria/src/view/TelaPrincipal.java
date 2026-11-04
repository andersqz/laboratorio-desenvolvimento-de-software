
package view;


public class TelaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());


    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        MenuItemCadastroCategoria = new javax.swing.JMenuItem();
        MenuItemCadastroProduto = new javax.swing.JMenuItem();
        MenuConsulta = new javax.swing.JMenu();
        MenuItemConsultaCategoria = new javax.swing.JMenuItem();
        MenuItemConsultaProduto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuCadastro.setText("Cadastro");

        MenuItemCadastroCategoria.setText("Cadastro Categoria");
        MenuItemCadastroCategoria.addActionListener(this::MenuItemCadastroCategoriaActionPerformed);
        MenuCadastro.add(MenuItemCadastroCategoria);

        MenuItemCadastroProduto.setText("Cadastro Produto");
        MenuItemCadastroProduto.addActionListener(this::MenuItemCadastroProdutoActionPerformed);
        MenuCadastro.add(MenuItemCadastroProduto);

        jMenuBar1.add(MenuCadastro);

        MenuConsulta.setText("Consulta");

        MenuItemConsultaCategoria.setText("Consulta Categoria");
        MenuItemConsultaCategoria.addActionListener(this::MenuItemConsultaCategoriaActionPerformed);
        MenuConsulta.add(MenuItemConsultaCategoria);

        MenuItemConsultaProduto.setText("Consulta Produto");
        MenuItemConsultaProduto.addActionListener(this::MenuItemConsultaProdutoActionPerformed);
        MenuConsulta.add(MenuItemConsultaProduto);

        jMenuBar1.add(MenuConsulta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemCadastroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastroCategoriaActionPerformed
        CadastroCategoria cadastroCategoria = new CadastroCategoria();
        cadastroCategoria.setVisible(true);
    }//GEN-LAST:event_MenuItemCadastroCategoriaActionPerformed

    private void MenuItemConsultaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemConsultaCategoriaActionPerformed
        ConsultaCategoria consultaCategoria = new ConsultaCategoria();
        consultaCategoria.setVisible(true);
    }//GEN-LAST:event_MenuItemConsultaCategoriaActionPerformed

    private void MenuItemCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastroProdutoActionPerformed
        CadastroProduto cadastroProduto = new CadastroProduto();
        cadastroProduto.setVisible(true);
    }//GEN-LAST:event_MenuItemCadastroProdutoActionPerformed

    private void MenuItemConsultaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemConsultaProdutoActionPerformed
        ConsultaProduto consultaProduto = new ConsultaProduto();
        consultaProduto.setVisible(true);
    }//GEN-LAST:event_MenuItemConsultaProdutoActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenu MenuConsulta;
    private javax.swing.JMenuItem MenuItemCadastroCategoria;
    private javax.swing.JMenuItem MenuItemCadastroProduto;
    private javax.swing.JMenuItem MenuItemConsultaCategoria;
    private javax.swing.JMenuItem MenuItemConsultaProduto;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
