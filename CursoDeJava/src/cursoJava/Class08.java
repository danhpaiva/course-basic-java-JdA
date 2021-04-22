/**
 * @author danhpaiva
 *
 */
package cursoJava;

public class Class08 {

	public static void main(String[] args) {
		long age = 18;

		System.out.println("Uso do IF");
		if (age == 18)
			System.out.println("Idade � igual a 18 anos");

		System.out.println("Uso do IF ELSE");
		if (age < 18)
			System.out.println("Idade � menor que 18 anos");
		else
			System.out.println("Idade � igual a 18 anos");

		System.out.println("Uso do ELSE IF");
		if (age > 18)
			System.out.println("Idade � maior que 18 anos");
		else if (age == 28)
			System.out.println("Idade � maior a 18 anos");
		else
			System.out.println("Idade � igual a 18 anos");

		System.out.println("Uso do Switch\n");
		System.out.println("Cadastro de Clientes\n");
		System.out.println("1. Cadastrar | 2. Deletar | 3. Atualizar");
		int opcao = 7;

		switch (opcao) {
		case 1:
			System.out.println("Cliente cadastrado com sucesso!");
			break;
		case 2:
			System.out.println("Cliente deletado com sucesso!");
			break;
		case 3:
			System.out.println("Cliente atualizado com sucesso!");
			break;
		default:
			System.out.println("Erro! Op��o inv�lida.");
			break;
		}
	}

}
