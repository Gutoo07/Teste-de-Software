package br.edu.labbd.fateczl.TrabalhoLabBd;

import java.sql.SQLException;

import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.labbd.fateczl.TrabalhoLabBd.persistence.ConsultaDao;
import br.edu.labbd.fateczl.TrabalhoLabBd.persistence.EspecialidadeDao;
import br.edu.labbd.fateczl.TrabalhoLabBd.persistence.GenericDAO;
import junit.framework.TestCase;

@Testable
public class PrimeiroTeste extends TestCase {
	@Autowired
	private GenericDAO gDAO;
	
	public void testaInsercaoDeConsulta() throws SQLException, ClassNotFoundException {
		String rg = "987654321";
		String especialidade = "Ortopedista";
		String dia = "12/04/2025";
		String hora = "12:00";
		boolean particular = false;
		String codigo_autorizacao = "";
		
		EspecialidadeDao eDao = new EspecialidadeDao(gDAO);
		ConsultaDao cDao = new ConsultaDao(gDAO);

		int especialidadeId = (int) eDao.getIdByNome(especialidade);
		String saida = "";
		String erro = "";
		try {
			saida = cDao.inserir(rg, especialidadeId, dia, hora, particular, codigo_autorizacao);
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			System.out.println("Saida: "+saida);	
			System.out.println("Erro: "+erro);
		}
	}
}
