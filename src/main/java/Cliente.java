public class Cliente extends Pessoa {
    public Cliente(String name, Integer idade) {
        super(name, idade);
    }

    public void calculaIdadeEm10Anos() {
        this.setIdade(this.getIdade() + 20);
    }
}
