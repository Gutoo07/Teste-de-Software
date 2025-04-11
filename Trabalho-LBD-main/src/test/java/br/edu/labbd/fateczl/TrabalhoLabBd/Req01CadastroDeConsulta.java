package br.edu.labbd.fateczl.TrabalhoLabBd;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.labbd.fateczl.TrabalhoLabBd.persistence.ConsultaDao;
import br.edu.labbd.fateczl.TrabalhoLabBd.persistence.EspecialidadeDao;
import br.edu.labbd.fateczl.TrabalhoLabBd.persistence.GenericDAO;

class Req01CadastroDeConsulta {
	private GenericDAO gDAO = new GenericDAO();

	@Test
	void ct01CadastroComSucesso() {
		String rg = "360510048";
		String especialidade = "Ortopedista";
		String dia = "13/04/2025";
		String hora = "13:00";
		boolean particular = false;
		String codigo_autorizacao = "";
		
		assertNotNull(gDAO);
		
		EspecialidadeDao eDao = new EspecialidadeDao(gDAO);
		ConsultaDao cDao = new ConsultaDao(gDAO);
		
		String saida = "";
		String erro = "";
		try {
			int especialidadeId = (int) eDao.getIdByNome(especialidade);
			saida = cDao.inserir(rg, especialidadeId, dia, hora, particular, codigo_autorizacao);
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			assertNotEquals("", saida);
			System.out.println("Saida: "+saida);
			System.out.println("Erro: "+erro);
			try {
				saida = cDao.excluir(rg);
				System.out.println(saida);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Test
	void ct02CadastroComRgInvalido() {
		String rg = "123";
		String especialidade = "Ortopedista";
		String dia = "13/04/2025";
		String hora = "13:00";
		boolean particular = false;
		String codigo_autorizacao = "";
		
		assertNotNull(gDAO);
		
		EspecialidadeDao eDao = new EspecialidadeDao(gDAO);
		ConsultaDao cDao = new ConsultaDao(gDAO);
		
		String saida = "";
		String erro = "";
		try {
			int especialidadeId = (int) eDao.getIdByNome(especialidade);
			saida = cDao.inserir(rg, especialidadeId, dia, hora, particular, codigo_autorizacao);
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			assertNotEquals("", erro);
			System.out.println("Saida: "+saida);
			System.out.println("Erro: "+erro);
			try {
				saida = cDao.excluir(rg);
				System.out.println(saida);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
