namespace CadastroEvento
{
    public partial class TelaEvento : Form
    {
        private Arquivo Arquivo;
        private List<Evento> eventos;
        private int LinhaEdicao = -1;

        public TelaEvento()
        {
            InitializeComponent();
            Arquivo = new Arquivo("eventos");
            eventos = Arquivo.LeArquivo();
            CarregarTabela();
        }

        private void CarregarTabela()
        {
            tblEventos.Rows.Clear();

            foreach (Evento ev in eventos)
            {
                tblEventos.Rows.Add(ev.ObterDados());
            }
        }


        private void btnSalvar_Click(object sender, EventArgs e)
        {

            if (cmbTipo.SelectedItem == null)
            {
                MessageBox.Show("Por favor, selecione um tipo de evento!", "Aviso", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }


            string modalidade = "";

            if (rdoOnline.Checked)
                modalidade = "Online";
            else if (rdoPresencial.Checked)
                modalidade = "Presencial";
            else
            {
                MessageBox.Show("Por favor, selecione se o evento é Online ou Presencial!", "Aviso", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            string? tipo = cmbTipo.SelectedItem.ToString();
            string nome = txtNome.Text;
            string data = txtData.Text;
            string local = txtLocal.Text;

            Evento ev = new Evento(nome, data, local, tipo, modalidade, "null");

            if (LinhaEdicao == -1)
                eventos.Add(ev);
            else
            {
                eventos[LinhaEdicao] = ev;
                LinhaEdicao = -1;
            }

            Arquivo.GravaArquivo();
            CarregarTabela();

            txtNome.Text = "";
            txtData.Text = "";
            txtLocal.Text = "";
            cmbTipo.SelectedIndex = -1;
            rdoOnline.Checked = false;
            rdoPresencial.Checked = false;
            txtNome.Focus();
        }

        private void btnEditar_Click(object sender, EventArgs e)
        {
            int linha = tblEventos.CurrentRow.Index;

            if (linha == -1)
            {
                MessageBox.Show(
                    "Por favor, selecione uma linha para edição!",
                    "Atenção",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Warning);
                return;
            }

            LinhaEdicao = linha;

            Evento ev = eventos[linha];

            txtNome.Text = ev.Nome;
            txtData.Text = ev.Data;
            txtLocal.Text = ev.Local;
            cmbTipo.SelectedIndex = -1;
            rdoOnline.Checked = false;
            rdoPresencial.Checked = false;
            txtNome.Focus();
        }

        private void btnExcluir_Click(object sender, EventArgs e)
        {
            int linha = tblEventos.CurrentRow.Index;

            if (linha == -1)
            {
                MessageBox.Show(
                    "Por favor, selecione uma linha para edição!",
                    "Atenção",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Warning);
                return;
            }

            var resposta = MessageBox.Show(
                "Deseja mesmo excluir esse evento?",
                "Atenção",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Question);

            if (resposta == DialogResult.Yes)
            {
                eventos.Remove(eventos[linha]);
                Arquivo.GravaArquivo();

                tblEventos.Rows.RemoveAt(linha);
            }


        }
    }
}
