
package cadastro_de_alunos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;




public class Arquivo {
    
    private FileReader arqR;
    private BufferedReader leitor;


    private ArrayList<Aluno> listaAlunos;

    public String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaAlunos = new ArrayList<>();
    }

    /**
     * le arquivo
     * @return
     */

    public ArrayList<Aluno> leArquivo() {
        listaAlunos.clear();

        try {
            arqR = new FileReader(nomeArquivo + ".txt");    
            leitor = new BufferedReader(arqR);

            String linha;

            while ((linha = leitor.readLine()) != null) {

                String[] espaços = linha.split(";");

                Aluno aluno = new Aluno();
                aluno.setNome(espaços[0]);
                aluno.setDataNasc(espaços[1]);
                aluno.setSexo(espaços[2]);
                aluno.setMatricula(Integer.parseInt(espaços[3]));
                aluno.setCurso(espaços[4]);
                aluno.setCpf(espaços[5]);
                aluno.setRuaCasa(espaços[6]);
                aluno.setNumeroCasa(Integer.parseInt(espaços[7]));
                aluno.setBairroCasa(espaços[8]);
                aluno.setCidadeCasa(espaços[9]);
                aluno.setCepCasa(Integer.parseInt(espaços[10]));
                aluno.setEstado(espaços[11]);
                aluno.setTelefone(Integer.parseInt(espaços[12]));

                listaAlunos.add(aluno);
            }
            arqR.close();
            leitor.close();

        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return listaAlunos;
    }


    /**
     * retorna a lista de alunos
     * @return
     */
    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }


    public void gravaArquivo() {
        
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo + ".txt", false))) {

            for (Aluno a : listaAlunos) {
                
                escritor.write(
                    a.getNome() + 
                    ";" + a.getDataNasc() + 
                    ";" + a.getSexo() + 
                    ";" + a.getMatricula() + 
                    ";" + a.getCurso() + 
                    ";" + a.getCpf() + 
                    ";" + a.getRuaCasa() + 
                    ";" + a.getNumeroCasa() + 
                    ";" + a.getBairroCasa() + 
                    ";" + a.getCidadeCasa() + 
                    ";" + a.getCepCasa() + 
                    ";" + a.getEstado() + 
                    ";" + a.getTelefone()
                );
                escritor.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
