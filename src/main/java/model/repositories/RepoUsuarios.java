package model.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Usuario;

public class RepoUsuarios {

	private List<Usuario> usuarios;
	
	public RepoUsuarios() { 
		this.usuarios = Arrays.asList(
					new Usuario("admin", "admin")
				); 
	}

	public List<Usuario> getUsuarios() { return usuarios; }

	public Usuario getUsuario(String user) {
		List<Usuario> usuariosFiltrados = usuarios.stream()
												  .filter(alu -> alu.getUser().equals(user))
												  .collect(Collectors.toList());
		return usuariosFiltrados.isEmpty() ? null : usuariosFiltrados.get(0);
	}

}
