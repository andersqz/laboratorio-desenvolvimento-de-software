
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaEvento extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaEvento.class.getName());

    private ArrayList<Evento> eventos;
    private int linhaEdicao = -1;
    private Arquivo arquivo;
    DefaultTableModel modeloTabela;
   
    public TelaEvento() {
        initComponents();
        arquivo = new Arquivo("eventos");
        eventos = arquivo.leArquivo();
        carregarTabela();
        
    }
    
    public void carregarTabela() {
        modeloTabela = (DefaultTableModel) tblEventos.getModel();
        modeloTabela.setRowCount(0);
        
        for (Evento ev : eventos) {
            modeloTabela.addRow(ev.obterDados());
        }
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpModalidade = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGrpSituacao = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rdoPresencial = new javax.swing.JRadioButton();
        rdoOnline = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rdoAgendado = new javax.swing.JRadioButton();
        rdoRealizado = new javax.swing.JRadioButton();
        rdoCancelado = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEventos = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Data");

        jLabel3.setText("Local");

        jLabel4.setText("Tipo");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Palestra", "WorkShop", "Curso", "Conferencia" }));

        jLabel5.setText("Modalidade");

        btnGrpModalidade.add(rdoPresencial);
        rdoPresencial.setText("Presencial");

        btnGrpModalidade.add(rdoOnline);
        rdoOnline.setText("Online");

        jLabel6.setText("Situação");

        btnGrpSituacao.add(rdoAgendado);
        rdoAgendado.setText("Agendado");

        btnGrpSituacao.add(rdoRealizado);
        rdoRealizado.setText("Realizado");

        btnGrpSituacao.add(rdoCancelado);
        rdoCancelado.setText("Cancelado");

        tblEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Data", "Local", "Tipo", "Modalidade", "Situação"
            }
        ));
        jScrollPane2.setViewportView(tblEventos);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoAgendado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoRealizado)
                                .addGap(18, 18, 18)
                                .addComponent(rdoCancelado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoPresencial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoOnline))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome)
                                    .addComponent(txtData)
                                    .addComponent(txtLocal)
                                    .addComponent(cmbTipo, 0, 172, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSalvar)
                                        .addComponent(btnEditar))
                                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(27, 27, 27))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdoPresencial)
                    .addComponent(rdoOnline))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoAgendado)
                    .addComponent(rdoRealizado)
                    .addComponent(rdoCancelado))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        try {
            String nome = txtNome.getText();
            String data = txtData.getText();
            String local = txtLocal.getText();
            String tipo = (String) cmbTipo.getSelectedItem();
            String modalidade;
            String situacao;
            
            if (rdoPresencial.isSelected()) {
                modalidade = "Presencial";
            } else {
                modalidade = "Online";
            }
            
            if (rdoAgendado.isSelected())
                situacao = "Agendado";
            else if (rdoRealizado.isSelected())
                situacao = "Realizado";
            else
                situacao = "Cancelado";
            
            Evento ev = new Evento(nome, data, local, tipo, modalidade, situacao);
            
            if (linhaEdicao == -1){
                eventos.add(ev);
            } else {
                eventos.set(linhaEdicao, ev);
                linhaEdicao = -1;
            }
            
            arquivo.gravaArquivo();
            carregarTabela();
            
            txtNome.setText("");
            txtData.setText("");
            txtLocal.setText("");
            cmbTipo.getSelectedIndex();
            rdoAgendado.setSelected(false);
            rdoCancelado.setSelected(false);
            rdoRealizado.setSelected(false);
            rdoPresencial.setSelected(false);
            rdoOnline.setSelected(false);
            txtNome.requestFocus();  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblEventos.getSelectedRow();
        
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um evento para ediçao!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        linhaEdicao = linha;
        
        Evento ev = eventos.get(linha);
        
        txtNome.setText(ev.getNome());
        txtData.setText(ev.getData());
        txtLocal.setText(ev.getLocal());
        rdoAgendado.setSelected(false);
        rdoCancelado.setSelected(false);
        rdoRealizado.setSelected(false);
        rdoPresencial.setSelected(false);
        rdoOnline.setSelected(false);
        cmbTipo.getSelectedIndex();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblEventos.getSelectedRow();
        
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um evento para excluir!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir esse evento?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            eventos.remove(linha);
            arquivo.gravaArquivo();
            
            modeloTabela = (DefaultTableModel) tblEventos.getModel();
            modeloTabela.removeRow(linha);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaEvento().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btnGrpModalidade;
    private javax.swing.ButtonGroup btnGrpSituacao;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdoAgendado;
    private javax.swing.JRadioButton rdoCancelado;
    private javax.swing.JRadioButton rdoOnline;
    private javax.swing.JRadioButton rdoPresencial;
    private javax.swing.JRadioButton rdoRealizado;
    private javax.swing.JTable tblEventos;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
