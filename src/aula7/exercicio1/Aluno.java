package aula7.exercicio1;

/**
 * Created by rodrigo on 19/04/17.
 */
public class Aluno {

    private int matricula;
    private String nome;
    private char sexo;
    private String telefone;


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + "\n" +
                "Nome:      " + nome + "\n" +
                "Sexo:      " + sexo + "\n" +
                "Telefone:  " + telefone;
    }
}
