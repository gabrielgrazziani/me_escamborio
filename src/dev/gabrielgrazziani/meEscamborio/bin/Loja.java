package dev.gabrielgrazziani.meEscamborio.bin;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Loja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String logista;
	
	@Column(unique = true)
	private String loja;
	
	@Column(unique = true)
	private String email;
	
	private String senha;
	
	@OneToMany(mappedBy = "loja")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Mensagem> mensagens = new LinkedList<Mensagem>();
	
	@OneToMany(mappedBy = "loja")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<Produto> produtos = new HashSet<Produto>();
		
	public Loja(String loja, String email, String senha) {
		this.loja = loja;
		this.email = email;
		this.senha = senha;
	}
	@Deprecated
	public Loja() {
		
	}
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getLogista() {
		return logista;
	}
	public void setLogista(String logista) {
		this.logista = logista;
	}
	public String getLoja() {
		return loja;
	}
	public void setLoja(String loja) {
		this.loja = loja;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void getSenha(String senha) {
		this.senha = senha;
	}
	public boolean senhaCorreta(String senha) {
		return this.senha.equals(senha);
	}
	public List<Mensagem> getMensagens() {
		return Collections.unmodifiableList(mensagens);
	}
	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	public boolean addMensagem(Mensagem mensagem) {
		return this.mensagens.add(mensagem);
	}
	public Collection<Produto> getProdutos() {
		return Collections.unmodifiableCollection(this.produtos);
	}
	public boolean addProduto(Produto produto) {
		return this.produtos.add(produto);
	}
	@Override
	public String toString() {
		return "Loja [id=" + id + ", logista=" + logista + ", loja=" + loja + ", email=" + email + ", mensagens=" + mensagens + ", produtos=" + produtos + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((loja == null) ? 0 : loja.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		return true;
	}
}
