package org.gestao_reserva.dao;

import org.gestao_reserva.connection.DatabaseConnection;
import org.gestao_reserva.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    // metodo para cadastrar um novo cliente no banco de dados
    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO CLIENTES (nome, email, telefone) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try{

            ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());

            ps.execute();
            ps.close();

            System.out.println("\nCLIENTE ADICIONADO\n");
        }catch(SQLException e){

            e.printStackTrace();
        }
    }

    // metodo para listar todos os clientes do banco de dados
    public List<Cliente> listarClientes(){
        Connection con = DatabaseConnection.getConnection();
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTES";
        try(PreparedStatement smt = con.prepareStatement(sql)){
            ResultSet result = smt.executeQuery();
            while (result.next()){
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));

                lista.add(cliente);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    // metodo para atualizar os dados de um cliente no banco de dados
    public void actualizarCliente(Cliente cliente,int id){
        Connection con = DatabaseConnection.getConnection();
        String sql = "UPDATE CLIENTES SET nome = ?, email = ?, telefone = ? WHERE id = ?";

        try(PreparedStatement smt = con.prepareStatement(sql)){
           smt.setString(1, cliente.getNome());
           smt.setString(2, cliente.getEmail());
           smt.setString(3, cliente.getTelefone());
           smt.setInt(4, id);

           smt.executeUpdate();
           smt.close();
           System.out.println("\nDADOS DO CLIENTE ATUALIZDO\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //metodo para remover um cliente do banco de dados
    public void removerCliente(int id){
        Connection con = DatabaseConnection.getConnection();
        String sql = "DELETE FROM CLIENTES WHERE id = ? ";

        try(PreparedStatement smt = con.prepareStatement(sql)){
            smt.setInt(1, id);
            smt.executeUpdate();
            smt.close();
            System.out.println("\nCLIENTE REMOVIDO COM SUCESSO\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
