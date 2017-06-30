package aula7.exercicio1;

/**
 * Created by rodrigo on 19/04/17.
 */
public class No {

    private Aluno aluno;
    private No proximo;


    public No(Aluno aluno, No proximo) {
        this.aluno = aluno;
        this.proximo = proximo;
    }


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
