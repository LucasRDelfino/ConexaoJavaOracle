package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionFactory.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO {
	private Connection conexao;
	
	
	public UsuarioDAO() {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	public void insert(Usuario usuario) throws SQLException {
		String sql = "insert into usuario (id,nome,email,telefone,data) values (?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setLong(1,usuario.getId());
		stmt.setString(2,usuario.getNome());
		stmt.setString(3,usuario.getEmail());
		stmt.setLong(4,usuario.getTelefone());
		stmt.setDate(5,usuario.getData());
		
		stmt.execute();
		stmt.close();
		
		
		
	}
	public List<Usuario> select() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario. setTelefone(rs.getLong("telefone"));
			usuario.setData(rs.getDate("data"));
			usuarios .add(usuario);
}
		
			rs.close();
			stmt.close();
			return usuarios;
	}
	
	
	public Usuario selectById(Long id) throws SQLException {
		Usuario usuario = null;
		String sql = "select * from usuario where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			usuario = new Usuario();
			usuario. setId(rs.getLong("id"));
			usuario. setNome(rs.getString("nome"));
			usuario. setEmail(rs.getString("email"));
			usuario. setTelefone(rs.getLong("telefone"));
			usuario. setData(rs.getDate("data"));
			rs.close();
			stmt.close();
			return usuario;
			
		}
		return usuario;
	}	
			public void delete(Long id) throws SQLException {
			String sql = "delete from usuario where id=?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			}
			
		public void update(Usuario usuario) throws SQLException {
			String sql = "update usuario set nome=?, email=?,teleone=?,where id=?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getNome());
			stmt.setLong(3, usuario.getTelefone());
			stmt.setLong(4, usuario.getId());
			stmt.execute();
			stmt.close();
		}
	
}
