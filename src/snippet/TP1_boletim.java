package snippet;

import java.util.Arrays;
import java.util.Scanner;

public class TP1_boletim {
	static String[] nomes;
	static float[] av_um;
	static float[] av_dois;
	static float[] medias;
	static String[] situacao;
	
	static final int QTDE = 100;
	
	private static float calcula_media(int id) {
		return (av_um[id] + av_dois[id]) / 2;
	}

	private static String situacao_aluno(int id, float media) {
		situacao[id] = "";
		
		if (medias[id] >= 7) {
			situacao[id] = "Aprovado";
		}else if(medias[id] < 7 && medias[id] > 4) {
			situacao[id] = "Prova Final";
		}else if(medias[id] < 4) {
			situacao[id] = "Reprovado";
		} 
		
		return situacao[id];
	}
	
	
	private static void imprimir(int id) {
		medias[id] = calcula_media(id);
		
		situacao[id] = situacao_aluno(id, medias[id]);
		
		System.out.printf("<< %d >> %s - %.2f - %.2f - Media: %.2f - Situacao: %s \n", id, nomes[id], av_um[id], av_dois[id], medias[id], situacao[id]);
		
	}
	
	
	private static void imprimir() {
		for (int i = 0; i < QTDE; i++) {
			if (nomes[i] != null) {
				imprimir(i);
				System.out.println("=================================================================");
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		nomes = new String[QTDE];
		av_um = new float[QTDE];
		av_dois = new float[QTDE];
		medias = new float[QTDE];
		situacao = new String[QTDE];
		
		
		Scanner in = new Scanner(System.in);
		Integer[] opcoes = {0,1,2,3};
		
		int i = 0;
		int opcao;
		do {
			
//			Menu
			System.out.println("[1] Registrar as notas de um novo aluno");
			System.out.println("[2] Consultar boletim de um aluno");
			System.out.println("[3] Consultar notas da turma");
			System.out.println("[4] Sair");
			System.out.println("Informe a opcao requerida: ");
			opcao = in.nextInt();
			
			
			if(Arrays.asList(opcoes).contains(opcao)) {
				if (opcao == 1) {
								
					if(i >= 0 && i < QTDE){
						System.out.printf("Informe o nome do aluno: ");
						nomes[i] = in.next();
						
						System.out.printf("Informe a nota da AV1: ");
						av_um[i] = in.nextFloat();
						
						System.out.printf("Informe a nota da AV2: ");
						av_dois[i] = in.nextFloat();
							
						imprimir(i);
						
						System.out.println("");
						System.out.printf("Aluno <<%d>> incluido conforme solicitado", i);
						System.out.println("");
						i++;
					}else {
						System.out.println("Não foi possivel cadastrar o aluno!");
					}
					
				}else if (opcao == 2) {
					
					System.out.print("Informe o ID do aluno requerido: ");
					int id_user = in.nextInt();
					
					if(id_user >= 0 && id_user < i) {
						imprimir(id_user);
					}else {
						System.out.printf("ID de aluno solicitado nao existe! Somente permitido cadastrar %d alunos!", QTDE);
						System.out.println("");
					}
						
				}else if (opcao == 3) {
					System.out.println("=================================================================");
					imprimir();
				}
			}else{
				System.out.println("Opcao de entrada não existe!");
			}
		} while(opcao != 4);
		
		
		imprimir();
		System.out.println("Cadastramento realizado com sucesso!");
		in.close();
	}
	
}
