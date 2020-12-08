package WorkShopMongoDB.dto;

import java.io.Serializable;

import WorkShopMongoDB.domain.User;

public class AuthorDTO implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	public AuthorDTO() {
		super();
	}
	
	public AuthorDTO(User user) {
		this.id = user.getId();
		this.nome = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
