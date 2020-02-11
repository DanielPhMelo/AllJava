package ExceptionsExercises.model;

public class Funcionario extends Pessoa {
    public Funcionario(String name, Integer idade) {
        super(name, idade);
    }

    public void calculaIdadeEm10Anos() {
        this.setIdade(this.getIdade() + 10);
    }
}
