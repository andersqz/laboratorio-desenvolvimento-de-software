
package view;

import DAO.ProdutoDAO;
import beans.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ConsultaProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsultaProduto.class.getName());


    public ConsultaProduto() {
        initComponents();
        tblProdutos.setDefaultEditor(Object.class, null);
        preencheTabela();
    }
    
    public void preencheTabela() {
        
        ProdutoDAO pDAO = new ProdutoDAO();
        
        List<Produto> produtos = pDAO.getProdutoComFiltro(txtNome.getText());
        DefaultTableModel modeloTabela = (DefaultTableModel) tblProdutos.getModel();
        
        modeloTabela.setRowCount(0);
        
        for (Produto p : produtos) {
            modeloTabela.addRow(p.obterDados());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        chkAtivo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        txtNome.addCaretListener(this::txtNomeCaretUpdate);

        chkAtivo.setText("Somente ativos");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Categoria", "Nome", "Preço", "Quantidade", "Ativo", "Criado em"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(this::btnFecharActionPerformed);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(chkAtivo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFechar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnRefresh)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNomeCaretUpdate
        preencheTabela();
    }//GEN-LAST:event_txtNomeCaretUpdate

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblProdutos.getSelectedRow();
        
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar!");
            return;
        }
        
        int linhaModelo = tblProdutos.convertRowIndexToModel(linha); // seguro mesmo com ordenação
        int id = (Integer) tblProdutos.getModel().getValueAt(linhaModelo, 0);
        
        ProdutoDAO pDAO = new ProdutoDAO();
        Produto produto = pDAO.getById(id);
        
        EditaProduto editaProduto = new EditaProduto(produto);
        editaProduto.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        preencheTabela();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblProdutos.getSelectedRow();
        
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
            return;
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este produto?", "Confirmação", JOptionPane.YES_NO_OPTION);
            
            if (resposta == JOptionPane.YES_OPTION) {
                DefaultTableModel modeloTabela = (DefaultTableModel) tblProdutos.getModel();
                modeloTabela.removeRow(linha);

                int linhaModelo = tblProdutos.convertRowIndexToModel(linha); // seguro mesmo com ordenação
                int id = (Integer) tblProdutos.getModel().getValueAt(linhaModelo, 0);

                ProdutoDAO pDAO = new ProdutoDAO();
                pDAO.excluir(id);
            }
 
        }
        
        
    }//GEN-LAST:event_btnExcluirActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new ConsultaProduto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
