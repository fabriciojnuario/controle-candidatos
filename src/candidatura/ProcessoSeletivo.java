package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
	public static void main(String [] args) {
		imprimirSelecionados();
	}
	public static void imprimirSelecionados() {
		String [] candidatos = {"FABRICIO", "JANUÁRIO", "ELIZIANE", "TIAGO","CATIANE"};
		System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
		for(String candidato: candidatos) {
			System.out.println("O candidato é: "+ candidato);
			entrandoEmContato(candidato);
		}
	}
	
	public static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) {
				tentativasRealizadas++;
			}
		}while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu) {
			System.out.println("Conseguimos contato com o(a) "+candidato+
					" na "+tentativasRealizadas+" tentativa.");
		}else {
			System.out.println("Não conseguimos contato com a(o) "+candidato+
					". nº tentativas realizadas: "+tentativasRealizadas);
		}
	}
	
	public static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	public static void selecaoCandidatos() {
		String [] candidatos = {"FABRICIO", "JANUÁRIO", "ELIZIANE", "TIAGO","CATIANE",
								"ALICE", "ALEX", "ALESSANDRA", "ANA", "CLÁUDIA"};
		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		double salarioBase = 2000.0;
		while(candidatosSelecionados<5 && candidatosAtual<candidatos.length) {
			String candidato = candidatos[candidatosAtual];
			double salarioPretendido = valorPretendido();
			System.out.println("O candidato "+candidato+
								" solicitou o valor de salário: "+ salarioPretendido);
			if(salarioBase>salarioPretendido) {
				System.out.println("O candidato "+ candidato + " foi selecionado para a vaga!");
				candidatosSelecionados++;
			}
			candidatosAtual++;
		}
	}
	
	public static void analizarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase>salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO!");	
		}else if(salarioBase==salarioPretendido) {
			System.out.println("LIGAR COM UMA CONTRA_PROPOSTA.");
		}else {
			System.out.println("AGUARDANDO NOVOS CANDIDATOS.");
		}
	}
	
	public static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
}
