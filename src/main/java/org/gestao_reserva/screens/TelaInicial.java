package org.gestao_reserva.screens;

import org.gestao_reserva.service.ClienteService;

import java.util.Scanner;

public class TelaInicial {

    public static void telaInicial() {
        ClienteService clienteService = new ClienteService();
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("|-----------------------------|");
            System.out.println("| 1. Criar Cliente            |");
            System.out.println("| 2. Listar todos os clientes |");
            System.out.println("| 3. Atualizar cliente        |");
            System.out.println("| 4. Remover cliente          |");
            System.out.println("| 0. Sair                     |");
            System.out.println("|-----------------------------|");

            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("--------------- Criar Cliente ------------");
                    System.out.print("Insira o nome: ");
                    String nome = input.nextLine();

                    System.out.print("Insira o email: ");
                    String email = input.nextLine();

                    System.out.print("Insira o telefone: ");
                    String telefone = input.nextLine();

                    clienteService.criaCliente(nome, email, telefone);
                    break;
                case 2:
                    System.out.println("----------------------- LISTA DE CLIENTES ----------------------");
                    clienteService.listarClientes();
                    break;
                case 3:
                    System.out.print("Insira o id do cliente que você quer atualizar: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Insira o nome: ");
                    nome = input.nextLine();

                    System.out.print("Insira o email: ");
                    email = input.nextLine();

                    System.out.print("Insira o telefone: ");
                    telefone = input.nextLine();

                    clienteService.actualizarCliente(nome, email, telefone, id);
                    break;
                case 4:
                    System.out.print("Insira o id do cliente que você quer remover: ");
                    id = input.nextInt();
                    clienteService.apagarCliente(id);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Número inválido");
            }
        } while (opcao != 0);

        input.close();
    }
}
