//classe meio pa

abstract class Funcionario {
    protected String nome;
    protected int idade;
    protected int idfuncionario;
    protected double salarioBase;

    public Funcionario(String nome, int idade, int idfuncionario, double salarioBase) {
        this.nome = nome;
        this.idade = idade;
        this.idfuncionario = idfuncionario;
        this.salarioBase = salarioBase;
    }

    //pagamento
    public abstract double Pagamento();

    public void exibirDados() {
        System.out.println("ID: " + idfuncionario);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("salarioBase: " + salarioBase);
    }
}

//Funcionario por hora

class FuncionarioHora extends Funcionario {
    private double horasTrabalhadas;
    private double taxaPorHora;

    public FuncionarioHora(String nome, int idade, int idfuncionario, double salarioBase, double horasTrabalhadas, double taxaPorHora) {
        super(nome, idade, idfuncionario, salarioBase);
        this.horasTrabalhadas = horasTrabalhadas;
        this.taxaPorHora = taxaPorHora;
    }

    @Override
    public double Pagamento() {
        return horasTrabalhadas * taxaPorHora;
    }
}

//Funcionario Mensal

class FuncionarioMensal extends Funcionario {
    private double bonus;

    public FuncionarioMensal(String nome, int idade, int idfuncionario, double salarioBase, double bonus) {
        super(nome, idade, idfuncionario, salarioBase);
        this.bonus = bonus;
    }

    @Override
    public double Pagamento() {
        return salarioBase + bonus;
    }
}

//Teste do sistema

 class SistemaFuncionarios {
    public static void main(String[] args) {
        FuncionarioHora horista = new FuncionarioHora("Eduardo", 30, 1, 0, 160, 20);
        FuncionarioMensal mensalista = new FuncionarioMensal("Marcia", 40, 2, 3000, 500);

        System.out.println("Dados de funcionarios por hora:");
        horista.exibirDados();
        System.out.println("Pagamento total: " + horista.Pagamento());

        System.out.println("\nDados do funcionario mensal:");
        mensalista.exibirDados();
        System.out.println("Pagamento total: " + mensalista.Pagamento());
    }
}
