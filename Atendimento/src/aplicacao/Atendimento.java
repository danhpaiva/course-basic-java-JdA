package aplicacao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Atendimento {
	private static final String NOME = "NOME: ";
	private static final String SOBRENOME = "SOBRENOME: ";
	static final String MENSAGEMDOPROGRAMA = "MENSAGEM DO PROGRAMA";
	static final String NAOHAATENDIMENTOS = "NAO HA ATENDIMENTOS";
	static final String VALOR = "VALOR";
	static Logger log = Logger.getLogger("");

	private static class Atende {
		private int cartao;
		private String nome;
		private String sobreNome;
		double valor;
		private Atende varProx;

		public int getCartao() {
			return cartao;
		}

		public void setCartao(int cartao) {
			this.cartao = cartao;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSobreNome() {
			return sobreNome;
		}

		public void setSobreNome(String sobreNome) {
			this.sobreNome = sobreNome;
		}

		public Atende getVarProx() {
			return varProx;
		}

		public void setVarProx(Atende varProx) {
			this.varProx = varProx;
		}

	}

	static Atende begin = null;
	static Atende end = null;
	static Atende varAuxiliar;

	public static void main(String[] args) {

		int op = 0;
		do {
			try {

				String texto = "\nMENU DE OPÇÕES\n" + "\n1  - Recepcionar cliente"
						+ "\n2  - Consultar clientes a serem atendidos" + "\n3  - Atender cliente"
						+ "\n4  - Liberar todos os clientes" + "\n5  - Verificar quantidade de clientes a atender"
						+ "\n6  - Localizar cliente por número" + "\n7  - Localizar cliente por nome"
						+ "\n8  - Emitir relatório de clientes" + "\n9  - Ver relatório de clientes"
						+ "\n10 - Filtrar clientes por valor" + "\n11 - Ver endereços hash" + "\n12 - Sobre"
						+ "\n13 - Sair\n";

				op = Integer.parseInt(JOptionPane.showInputDialog(texto, "1"));

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"A tecla <<Cancelar>> foi acionada!\nEscolha a opção 6 para encerrar.", "Mensagem",
						JOptionPane.CLOSED_OPTION);
				continue;
			}
			if (op < 1 || op > 13) {
				log.info("Opção Inválida!!");
			}
			if (op == 1) {
				int numero = 0;
				try {
					numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO CARTÃO: ", "0"));
				} catch (NumberFormatException e) {
					agenteDeErro(e);
					continue;
				}
				varAuxiliar = begin;
				boolean achou = false;
				while (varAuxiliar != null) {
					if (varAuxiliar.getCartao() == numero) {
						achou = true;
						JOptionPane.showMessageDialog(null, "Esse número do cartão já foi usado.\nFavor verificar!");
						break;
					}
					varAuxiliar = varAuxiliar.getVarProx();
				}
				if (!achou) {
					Atende novo = new Atende();
					novo.setCartao(numero);

					try {
						novo.setNome(JOptionPane.showInputDialog(NOME, ""));
						novo.setSobreNome(JOptionPane.showInputDialog(SOBRENOME, ""));

						novo.setNome(novo.getNome().toUpperCase());
						novo.setSobreNome(novo.getSobreNome().toUpperCase()); 

						novo.valor = Double.parseDouble(JOptionPane.showInputDialog(VALOR, "0"));
					} catch (NumberFormatException e) {
						agenteDeErro(e);
						continue;
					}

					if (begin == null) {
						begin = novo;
						end = novo;
					} else {
						end.setVarProx(novo);
						end = novo;
					}

					JOptionPane.showMessageDialog(null,
							"O cartão número " + novo.getCartao() + ", foi inserido para atendimento: ", MENSAGEMDOPROGRAMA,
							JOptionPane.CLOSED_OPTION);
					log.info("Acessou opção: Recepcionar cliente - " + getDateTime());
				}
			}
			if (op == 2) {

				if (begin == null) {
					JOptionPane.showMessageDialog(null, NAOHAATENDIMENTOS, MENSAGEMDOPROGRAMA,
							JOptionPane.CLOSED_OPTION);
				} else {
					JTextArea saida = new JTextArea(6, 45); // HEIGHT X WIDTH
					JScrollPane scroll = new JScrollPane(saida);
					saida.append("CARTÃO\t" + NOME + "\tSOBRENOME\t" + "VALOR\n");
					saida.append("-------------------------------------------------------------------------\n");
					varAuxiliar = begin;
					while (varAuxiliar != null) {
						saida.append(varAuxiliar.getCartao() + "\t" + varAuxiliar.getNome() + "\t" + varAuxiliar.getSobreNome()
								+ "\t" + varAuxiliar.valor + "\n");
						varAuxiliar = varAuxiliar.getVarProx();
					}
					saida.append("\n");
					JOptionPane.showMessageDialog(null, scroll, "CONSULTAR DADOS DO ATENDIMENTO",
							JOptionPane.CLOSED_OPTION);
				}
				log.info("Acessou opção: Consultar clientes a serem atendidos - " + getDateTime());
			}
			if (op == 3) {
				if (begin == null) {
					JOptionPane.showMessageDialog(null, NAOHAATENDIMENTOS, MENSAGEMDOPROGRAMA,
							JOptionPane.CLOSED_OPTION);
				} else {
					JOptionPane.showMessageDialog(null,
							"CARTÃO:  " + begin.getCartao() + ", NOME: " + begin.getNome() + " foi atendido(a)!",
							MENSAGEMDOPROGRAMA, JOptionPane.CLOSED_OPTION);
					begin = begin.getVarProx();
				}
				log.info("Acessou opção: Atender cliente - " + getDateTime());
			}
			if (op == 4) {
				if (begin == null) {
					JOptionPane.showMessageDialog(null, NAOHAATENDIMENTOS, MENSAGEMDOPROGRAMA,
							JOptionPane.CLOSED_OPTION);
				} else {
					begin = null;
					JOptionPane.showMessageDialog(null, " * * O ATENDIMENTO FOI LIBERADO * *", MENSAGEMDOPROGRAMA,
							JOptionPane.CLOSED_OPTION);
				}
				log.info("Acessou opção: Liberar todos os clientes - " + getDateTime());
			}
			if (op == 5) {
				varAuxiliar = begin;
				int n = 0;
				double soma = 0;
				while (varAuxiliar != null) {
					soma = soma + varAuxiliar.valor;
					varAuxiliar = varAuxiliar.getVarProx();
					n++;
				}
				JOptionPane.showMessageDialog(null,
						"O ATENDIMENTO CONTÉM: " + n + " ELEMENTOS.\nVALOR TOTAL: " + soma + "\n", MENSAGEMDOPROGRAMA,
						JOptionPane.CLOSED_OPTION);
				log.info("Acessou opção: Verificar quantidade de clientes a atender - " + getDateTime());
			}
			if (op == 6) {
				int cartao = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do cartão", "0"));
				varAuxiliar = begin;
				int posicao = 1;
				while (varAuxiliar != null) {
					if (cartao == varAuxiliar.cartao) {
						String texto = "CARTÃO: " + varAuxiliar.getCartao() + "\n" + NOME + varAuxiliar.getNome() + "\n"
								+ SOBRENOME + varAuxiliar.getSobreNome() + "\n" + VALOR + varAuxiliar.valor + "\n"
								+ "POSIÇÃO: " + posicao + "a. POSIÇÃO";
						JOptionPane.showMessageDialog(null, "DADOS DO CLIENTE: \n\n" + texto, MENSAGEMDOPROGRAMA,
								JOptionPane.CLOSED_OPTION);
					}
					posicao++;
					varAuxiliar = varAuxiliar.getVarProx();
				}
				log.info("Acessou opção: Localizar cliente por número - " + getDateTime());

			}
			if (op == 7) {
				String nome = JOptionPane.showInputDialog("Nome do cliente", "");
				varAuxiliar = begin;
				int posicao = 1;
				while (varAuxiliar != null) {
					if (varAuxiliar.getNome().equals(nome)) {
						String texto = "CARTÃO: " + varAuxiliar.getCartao() + "\n" + NOME + varAuxiliar.getNome() + "\n"
								+ SOBRENOME + varAuxiliar.getSobreNome() + "\n" + VALOR + varAuxiliar.valor + "\n"
								+ "POSIÇÃO: " + posicao + "a. POSIÇÃO";
						JOptionPane.showMessageDialog(null, "DADOS DO CLIENTE: \n\n" + texto, MENSAGEMDOPROGRAMA,
								JOptionPane.CLOSED_OPTION);
					}
					posicao++;
					varAuxiliar = varAuxiliar.getVarProx();
				}

				log.info("Acessou opção: Localizar cliente por nome - " + getDateTime());

			}
			if (op == 8) {
				if (begin == null) {
					JOptionPane.showMessageDialog(null, NAOHAATENDIMENTOS, MENSAGEMDOPROGRAMA,
							JOptionPane.CLOSED_OPTION);
				} else {
					varAuxiliar = begin;

					final String diretorio = "C:/DADOS";
					// Verifica se a pasta existe, se não existe, cria!
					File file = new File(diretorio);
					if (!file.exists()) {
						file.mkdirs();
					}

					try (PrintWriter gravar = new PrintWriter(new FileWriter("c:\\Dados\\Atendimento.txt"))) {
						FileWriter arq = new FileWriter("c:\\Dados\\Atendimento.txt");

						while (varAuxiliar != null) {

							gravar.printf("%d, %s, %s, %.2f %n", varAuxiliar.getCartao(), varAuxiliar.getNome(),
									varAuxiliar.getSobreNome(), +varAuxiliar.valor);
							varAuxiliar = varAuxiliar.getVarProx();
						}
						gravar.printf("%s %n", "--------------------------");
						gravar.printf("%s %n", "copyright (c) by: Fulano de Tal, Sicrano de Tal");
						arq.close();

					} catch (IOException e) {
						log.info("MENSAGEM / CLASS ArquivoTexto:\nErro ao tentar gravar no arquivo");
					}

					JOptionPane.showMessageDialog(null, "ARQUIVO GRAVADO COM SUCESSO", "MENSAGEM DO SISTEMA",
							JOptionPane.CLOSED_OPTION);
				}
				log.info("Acessou opção: Emitir relatório de clientes - " + getDateTime());
			}
			if (op == 9) {
				int resposta = JOptionPane.showConfirmDialog(null, "DESEJA VER ARQUIVO?", "MENSAGEM",
						JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					try {
						Process pro = Runtime.getRuntime().exec("cmd.exe /c  c://Dados//Atendimento.txt");
						pro.waitFor();
					} catch (Exception e) {
						log.info("Erro . . . ");
					}
				}
				log.info("Acessou opção: Ver relatório de clientes - " + getDateTime());
			}
			if (op == 10) {
				double filtro = Double.parseDouble(
						JOptionPane.showInputDialog("FILTRAR ATENDIMENTOS PARA VALORES SUPERIORES A: ", ""));
				JTextArea saida = new JTextArea(6, 45); // HEIGHT X WIDTH
				JScrollPane scroll = new JScrollPane(saida);
				saida.append("CARTÃO\t" + NOME + "\tSOBRENOME\t" + "VALOR\n");
				saida.append("----------------------------------------------------------------------------\n");
				varAuxiliar = begin;

				while (varAuxiliar != null) {

					if (varAuxiliar.valor > filtro) {
						saida.append(varAuxiliar.getCartao() + "\t" + varAuxiliar.getNome() + "\t" + varAuxiliar.getSobreNome()
								+ "\t" + varAuxiliar.valor + "\n");
					}

					varAuxiliar = varAuxiliar.getVarProx();
				}
				saida.append("\n");
				JOptionPane.showMessageDialog(null, scroll, "ATENDIMENTOS COM VALORES SUPERIORES A: " + filtro,
						JOptionPane.CLOSED_OPTION);
				log.info("Acessou opção: Filtrar clientes por valor - " + getDateTime());
			}
			if (op == 11) {
				if (begin == null) {
					JOptionPane.showMessageDialog(null, NAOHAATENDIMENTOS, MENSAGEMDOPROGRAMA,
							JOptionPane.CLOSED_OPTION);
				} else {
					JTextArea saida = new JTextArea(7, 45); // HEIGHT X WIDTH
					JScrollPane scroll = new JScrollPane(saida);
					saida.append(NOME + "\tENDEREÇO\tPROX\t\n");
					saida.append("-------------------------------------------------------------\n");
					varAuxiliar = begin;
					while (varAuxiliar != null) {
						if (varAuxiliar.getVarProx() != null)
							saida.append(varAuxiliar.getNome() + "\t" + varAuxiliar.hashCode() + "\t"
									+ varAuxiliar.getVarProx().hashCode() + "\n");
						else
							saida.append(varAuxiliar.getNome() + "\t" + varAuxiliar.hashCode() + "\tfim\n");

						varAuxiliar = varAuxiliar.getVarProx();
					}
					saida.append("\n");
					JOptionPane.showMessageDialog(null, scroll, "CONSULTAR DADOS DO ATENDIMENTO",
							JOptionPane.CLOSED_OPTION);
				}
				log.info("Acessou opção: Ver endereços hash - " + getDateTime());

			}
			if (op == 12) {
				JTextArea saida = new JTextArea(8, 30); // HEIGHT X WIDTH
				saida.append("\n");
				saida.append("PROGRAMA DE ATENDIMENTO AO CLIENTE\n");
				saida.append("-------------------------------------------------------------\n");
				saida.append("Copyright (c) Byta Bug Informática Ltda\n");
				saida.append("Programadores: Asdrubal, Zemprônia e Gilmar\n");
				saida.append("Versão 1.0\n");
				saida.append("Data: Abril de 2021\n");
				saida.append("Necessita refatoração URGENTE!");
				saida.append("\n");
				JOptionPane.showMessageDialog(null, saida, "SOBRE O PROGRAMA", JOptionPane.CLOSED_OPTION);
				log.info("Acessou opção: Sobre - " + getDateTime());
			}
		} while (op != 13);
		log.info("-------------------------------------------");
		log.info("Programa finalizado em: " + getDateTime());
		log.info("-------------------------------------------");
		JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO!");

	}

	private static void agenteDeErro(NumberFormatException e) {
		JOptionPane.showMessageDialog(null,
				"ERRO AO TENTAR CONVERTER UM VALOR\nFAVOR VERIRIFICAR\nMENSAGEM ORIGINAL: " + e.getMessage(),
				"AGENTE DE ERRO", JOptionPane.CLOSED_OPTION);
	}

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
