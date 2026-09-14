using static System.Runtime.InteropServices.JavaScript.JSType;

namespace CadastroEvento
{
    public class Evento
    {
        public string Nome { get; set; }
        public string Data { get; set; }
        public string Local { get; set; }
        public string Tipo { get; set; }
        public string Modalidade { get; set; }
        public string Situacao { get; set; }

        public Evento(string nome, string data, string local, string tipo, string modalidade, string situacao)
        {
            this.Nome = nome;
            this.Data = data;
            this.Local = local;
            this.Tipo = tipo;
            this.Modalidade = modalidade;
            this.Situacao = situacao;
        }


        public override string ToString()
        {
            return "Evento{" + "nome=" + Nome + ", data=" + Data + ", local=" + Local + ", tipo=" + Tipo + ", modalidade=" + Modalidade + ", situacao=" + Situacao + '}';
        }

        public object[] ObterDados()
        {
            return new object[] { Nome, Data, Local, Tipo, Modalidade, Situacao };
        }
    }
}
