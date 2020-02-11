package ExceptionsExercises.model;

public abstract class Pessoa {
    private String name;
    private Integer idade;

    public Pessoa(String name, Integer idade) {
        this.name = name;
        this.idade = idade;
    }

    public abstract void calculaIdadeEm10Anos();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
