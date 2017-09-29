package Ex_01;

import java.text.NumberFormat;

public class FuncionarioAdministrativo extends Funcionario
{
	public FuncionarioAdministrativo(String nome, float salarioBase, int faltas, int horasExtras)
	{		
		super(nome, salarioBase, faltas, horasExtras);
		super.diasMensaisDeTrabalho = 30;
		super.horasDiariasDeTrabalho = 8;
		super.valorHoraExtra = 1.5f;
		super.folhaPagamento.setSalarioFinal(this.getFolhaPagamento());
	}

	@Override
	public float getSalario()
	{
		return super.salarioBase;
	}

	@Override
	public float getFolhaPagamento()
	{
		return this.calculaFolhaPagamento();
	}
	
	public float calculaFolhaPagamento()
	{
		float valorHoraDeTrabalho = salarioBase / (diasMensaisDeTrabalho * horasDiariasDeTrabalho);
		float salarioFinal = super.salarioBase;
		salarioFinal -= valorHoraDeTrabalho * horasDiariasDeTrabalho * faltas;
		salarioFinal += valorHoraDeTrabalho * valorHoraExtra * horasExtras;	
		return salarioFinal;		
	}
	
	@Override
	public void imprimirDados()
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		String mesAno = this.folhaPagamento.getMes() + "/" + this.folhaPagamento.getAno();
		System.out.println("Sal�rio base: R$" + super.salarioBase);
		System.out.println("Folha de pagamento do m�s " + mesAno + ": " + nf.format(this.folhaPagamento.getSalarioFinal()));
	}
}