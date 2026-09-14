
using System;
using System.Collections.Generic;
using System.IO;

namespace CadastroEvento
{
    public class Arquivo
    {
        private List<Evento> eventos;
        private string nomeArquivo;

        public Arquivo(string nomeArquivo)
        {
            this.nomeArquivo = nomeArquivo;
            eventos = new List<Evento>();
        }

        public List<Evento> LeArquivo()
        {
            eventos.Clear();

            try
            {
                using StreamReader leitor = new(nomeArquivo + ".txt");

                string? linha;

                while ((linha = leitor.ReadLine()) != null)
                {
                    string[] campos = linha.Split(';');

                    Evento evento = new Evento(
                        campos[0],
                        campos[1],
                        campos[2],
                        campos[3],
                        campos[4],
                        campos[5]
                    );

                    eventos.Add(evento);
                }
            }
            catch (FileNotFoundException)
            {
                Console.WriteLine("Arquivo não encontrado!");
            }
            catch (IOException ex)
            {
                Console.WriteLine($"Erro ao ler o arquivo: {ex.Message}");
            }

            return eventos;
        }

        public List<Evento> GetEventos()
        {
            return eventos;
        }

        public void GravaArquivo()
        {
            try
            {
                using StreamWriter escritor = new(nomeArquivo + ".txt", false);

                foreach (Evento evento in eventos)
                {
                    escritor.WriteLine(
                        evento.Nome + ";" +
                        evento.Data + ";" +
                        evento.Local + ";" +
                        evento.Tipo + ";" +
                        evento.Modalidade + ";" +
                        evento.Situacao
                    );
                }
            }
            catch (IOException ex)
            {
                Console.WriteLine($"Erro ao gravar o arquivo: {ex.Message}");
            }
        }
    }
}

