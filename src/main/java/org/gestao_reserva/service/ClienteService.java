package org.gestao_reserva.service;

import org.gestao_reserva.entity.Cliente;
import org.gestao_reserva.dao.ClienteDAO;

import java.util.List;

public class ClienteService {
    ClienteDAO clienteDAO = new ClienteDAO();


    public void criaCliente(String nome, String email, String telefone) {
      Cliente cliente = new Cliente();
      cliente.setNome(nome);
      cliente.setEmail(email);
      cliente.setTelefone(telefone);

      clienteDAO.cadastrarCliente(cliente);
    }

    public void listarClientes(){
        List<Cliente> listaCliente = clienteDAO.listarClientes();

        // Defina a largura das colunas
        int idWidth = 4;
        int nomeWidth = 15;
        int emailWidth = 25;
        int telefoneWidth = 15;

        // Cabeçalho
        String format = "|%-" + idWidth + "s|%-" + nomeWidth + "s|%-" + emailWidth + "s|%-" + telefoneWidth + "s|";
        System.out.println(String.format(format, "ID", "NOME", "EMAIL", "TELEFONE"));
        System.out.println("----------------------------------------------------------------");

        // Conteúdo
        for (Cliente cliente : listaCliente) {
            System.out.println(String.format(format,
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getEmail(),
                    cliente.getTelefone()));
        }

        System.out.println("----------------------------------------------------------------\n");

    }

    public void actualizarCliente(String nome, String email, String telefone, int id){
        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);

        clienteDAO.actualizarCliente(cliente, id);
    }

    public void apagarCliente(int id){
        clienteDAO.removerCliente(id);
    }
}
