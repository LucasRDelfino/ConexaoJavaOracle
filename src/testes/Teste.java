package testes;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Usuario;
import repository.UsuarioDAO;

public class Teste {
	public static void main(String[] args) {
	UsuarioDAO dao = new UsuarioDAO();
	Usuario lucas = new Usuario();
	
	Calendar hoje = Calendar.getInstance();
	Date data = new Date(hoje.getTimeInMillis());
	
	lucas.setId(1L);	
	lucas.setNome("Lucas Delfino");
	lucas.setEmail("lucasdelfino205@gmail.com");
	lucas.setTelefone(5511953738141L);
	lucas.setData(data);
	
	try {
		dao.insert(lucas);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}