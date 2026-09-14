namespace CadastroEvento
{
    partial class TelaEvento
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            txtNome = new TextBox();
            label2 = new Label();
            txtData = new TextBox();
            label3 = new Label();
            txtLocal = new TextBox();
            cmbTipo = new ComboBox();
            label4 = new Label();
            label5 = new Label();
            btnGrpModalidade = new GroupBox();
            rdoPresencial = new RadioButton();
            rdoOnline = new RadioButton();
            tblEventos = new DataGridView();
            Nome = new DataGridViewTextBoxColumn();
            Data = new DataGridViewTextBoxColumn();
            Local = new DataGridViewTextBoxColumn();
            Tipo = new DataGridViewTextBoxColumn();
            Modalidade = new DataGridViewTextBoxColumn();
            btnSalvar = new Button();
            btnEditar = new Button();
            btnExcluir = new Button();
            btnGrpModalidade.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)tblEventos).BeginInit();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(94, 70);
            label1.Name = "label1";
            label1.Size = new Size(50, 20);
            label1.TabIndex = 0;
            label1.Text = "Nome";
            // 
            // txtNome
            // 
            txtNome.Location = new Point(182, 67);
            txtNome.Name = "txtNome";
            txtNome.Size = new Size(200, 27);
            txtNome.TabIndex = 1;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(94, 109);
            label2.Name = "label2";
            label2.Size = new Size(41, 20);
            label2.TabIndex = 2;
            label2.Text = "Data";
            // 
            // txtData
            // 
            txtData.Location = new Point(182, 106);
            txtData.Name = "txtData";
            txtData.Size = new Size(125, 27);
            txtData.TabIndex = 3;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(94, 157);
            label3.Name = "label3";
            label3.Size = new Size(44, 20);
            label3.TabIndex = 4;
            label3.Text = "Local";
            // 
            // txtLocal
            // 
            txtLocal.Location = new Point(182, 157);
            txtLocal.Name = "txtLocal";
            txtLocal.Size = new Size(200, 27);
            txtLocal.TabIndex = 5;
            // 
            // cmbTipo
            // 
            cmbTipo.DropDownStyle = ComboBoxStyle.DropDownList;
            cmbTipo.FormattingEnabled = true;
            cmbTipo.Items.AddRange(new object[] { "Workshop", "Palestra", "Curso", "Estágio" });
            cmbTipo.Location = new Point(182, 215);
            cmbTipo.Name = "cmbTipo";
            cmbTipo.Size = new Size(151, 28);
            cmbTipo.TabIndex = 6;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(94, 215);
            label4.Name = "label4";
            label4.Size = new Size(39, 20);
            label4.TabIndex = 7;
            label4.Text = "Tipo";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(94, 267);
            label5.Name = "label5";
            label5.Size = new Size(90, 20);
            label5.TabIndex = 8;
            label5.Text = "Modalidade";
            // 
            // btnGrpModalidade
            // 
            btnGrpModalidade.Controls.Add(rdoPresencial);
            btnGrpModalidade.Controls.Add(rdoOnline);
            btnGrpModalidade.Location = new Point(190, 249);
            btnGrpModalidade.Name = "btnGrpModalidade";
            btnGrpModalidade.Size = new Size(201, 50);
            btnGrpModalidade.TabIndex = 11;
            btnGrpModalidade.TabStop = false;
            // 
            // rdoPresencial
            // 
            rdoPresencial.AutoSize = true;
            rdoPresencial.Location = new Point(96, 17);
            rdoPresencial.Name = "rdoPresencial";
            rdoPresencial.Size = new Size(96, 24);
            rdoPresencial.TabIndex = 12;
            rdoPresencial.TabStop = true;
            rdoPresencial.Text = "Presencial";
            rdoPresencial.UseVisualStyleBackColor = true;
            // 
            // rdoOnline
            // 
            rdoOnline.AutoSize = true;
            rdoOnline.Location = new Point(15, 17);
            rdoOnline.Name = "rdoOnline";
            rdoOnline.Size = new Size(73, 24);
            rdoOnline.TabIndex = 11;
            rdoOnline.TabStop = true;
            rdoOnline.Text = "Online";
            rdoOnline.UseVisualStyleBackColor = true;
            // 
            // tblEventos
            // 
            tblEventos.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            tblEventos.Columns.AddRange(new DataGridViewColumn[] { Nome, Data, Local, Tipo, Modalidade });
            tblEventos.Location = new Point(12, 350);
            tblEventos.Name = "tblEventos";
            tblEventos.RowHeadersWidth = 51;
            tblEventos.Size = new Size(675, 219);
            tblEventos.TabIndex = 12;
            // 
            // Nome
            // 
            Nome.HeaderText = "Nome";
            Nome.MinimumWidth = 6;
            Nome.Name = "Nome";
            Nome.Width = 125;
            // 
            // Data
            // 
            Data.HeaderText = "Data";
            Data.MinimumWidth = 6;
            Data.Name = "Data";
            Data.Width = 125;
            // 
            // Local
            // 
            Local.HeaderText = "Local";
            Local.MinimumWidth = 6;
            Local.Name = "Local";
            Local.Width = 125;
            // 
            // Tipo
            // 
            Tipo.HeaderText = "Tipo";
            Tipo.MinimumWidth = 6;
            Tipo.Name = "Tipo";
            Tipo.Width = 125;
            // 
            // Modalidade
            // 
            Modalidade.HeaderText = "Modalidade";
            Modalidade.MinimumWidth = 6;
            Modalidade.Name = "Modalidade";
            Modalidade.Width = 125;
            // 
            // btnSalvar
            // 
            btnSalvar.Location = new Point(566, 260);
            btnSalvar.Name = "btnSalvar";
            btnSalvar.Size = new Size(88, 41);
            btnSalvar.TabIndex = 13;
            btnSalvar.Text = "Salvar";
            btnSalvar.UseVisualStyleBackColor = true;
            btnSalvar.Click += btnSalvar_Click;
            // 
            // btnEditar
            // 
            btnEditar.Location = new Point(457, 260);
            btnEditar.Name = "btnEditar";
            btnEditar.Size = new Size(94, 41);
            btnEditar.TabIndex = 14;
            btnEditar.Text = "Editar";
            btnEditar.UseVisualStyleBackColor = true;
            btnEditar.Click += btnEditar_Click;
            // 
            // btnExcluir
            // 
            btnExcluir.Location = new Point(566, 196);
            btnExcluir.Name = "btnExcluir";
            btnExcluir.Size = new Size(88, 39);
            btnExcluir.TabIndex = 15;
            btnExcluir.Text = "Excluir";
            btnExcluir.UseVisualStyleBackColor = true;
            btnExcluir.Click += btnExcluir_Click;
            // 
            // TelaEvento
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(699, 581);
            Controls.Add(btnExcluir);
            Controls.Add(btnEditar);
            Controls.Add(btnSalvar);
            Controls.Add(tblEventos);
            Controls.Add(btnGrpModalidade);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(cmbTipo);
            Controls.Add(txtLocal);
            Controls.Add(label3);
            Controls.Add(txtData);
            Controls.Add(label2);
            Controls.Add(txtNome);
            Controls.Add(label1);
            Name = "TelaEvento";
            Text = "Form1";
            btnGrpModalidade.ResumeLayout(false);
            btnGrpModalidade.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)tblEventos).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox txtNome;
        private Label label2;
        private TextBox txtData;
        private Label label3;
        private TextBox txtLocal;
        private ComboBox cmbTipo;
        private Label label4;
        private Label label5;
        private GroupBox btnGrpModalidade;
        private RadioButton rdoPresencial;
        private RadioButton rdoOnline;
        private DataGridView tblEventos;
        private DataGridViewTextBoxColumn Nome;
        private DataGridViewTextBoxColumn Data;
        private DataGridViewTextBoxColumn Local;
        private DataGridViewTextBoxColumn Tipo;
        private DataGridViewTextBoxColumn Modalidade;
        private Button btnSalvar;
        private Button btnEditar;
        private Button btnExcluir;
    }
}
