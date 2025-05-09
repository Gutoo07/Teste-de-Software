package br.edu.labbd.fateczl.TrabalhoLabBd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.edu.labbd.fateczl.TrabalhoLabBd.model.Cliente;
import br.edu.labbd.fateczl.TrabalhoLabBd.persistence.ClienteDao;
import br.edu.labbd.fateczl.TrabalhoLabBd.persistence.GenericDAO;

public class Req02CadastroDeCliente {
    private GenericDAO gDAO = new GenericDAO();

    @Test
    void ct01CadastroComSucesso() {
        String rg = "381823283";
        String nome = "ClienteComSucesso";
        String telefone = "11912345678";
        LocalDate dt_Nasc = LocalDate.of(1998, 01, 01);
        String senha = "SenhaForte1234";

        assertNotNull(gDAO);
        
        ClienteDao cDao = new ClienteDao(gDAO);

        Cliente teste = new Cliente();
        teste.setRg(rg);
        teste.setNome(nome);
        teste.setTelefone(telefone);
        teste.setDt_nasc(dt_Nasc);
        teste.setSenha(senha);

        String saida = "";
        String erro = "";
        try {
            saida = cDao.inserir(teste);
        } catch (SQLException | ClassNotFoundException e) {
            erro = e.getMessage();
        } finally {
            assertEquals("", saida);
			System.out.println("Saida: "+saida);
			System.out.println("Erro: "+erro);
        }
    } 
}
