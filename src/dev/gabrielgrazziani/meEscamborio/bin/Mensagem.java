package dev.gabrielgrazziani.meEscamborio.bin;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Mensagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String comprador;
	private String telefone;
	@Column(nullable = true)
	private String mensagem;
	private int quantidade;
	private LocalDateTime dataTime;
	
	@ManyToOne(optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Loja loja;
	
	@ManyToOne(optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produto produto;
	
	public Mensagem() {
		this.dataTime = LocalDateTime.now();
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDateTime getDataTime() {
		return dataTime;
	}
	public void setDataTime(LocalDateTime dataTime) {
		this.dataTime = dataTime;
	}
	@Override
	public String toString() {
		return "Mensagem [id=" + getId() + ", comprador=" + comprador + ", telefone=" + telefone + ", mensagem=" + mensagem
				+ ", quantidade=" + quantidade + ", dataTime=" + dataTime + "]";
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
		this.loja = produto.getLoja();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
