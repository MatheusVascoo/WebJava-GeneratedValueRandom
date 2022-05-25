package entidade;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//QUESTÃO A
public class Jogo {
	//QUESTÃO B
	@Id
	@GeneratedValue
	private Integer Id;
	private String descricao;
	@Column(name="data_criacao")
	private LocalDate dataCriacao = LocalDate.now();
	private Integer v1 = new Random().nextInt(30)+1;
	private Integer v2 = new Random().nextInt(30)+1;
	private Integer v3 = new Random().nextInt(30)+1;
	private Integer v4 = new Random().nextInt(30)+1;
	private Integer v5 = new Random().nextInt(30)+1;
	private Integer v6 = new Random().nextInt(30)+1;
	private Integer v7 = new Random().nextInt(30)+1;
	private Integer v8 = new Random().nextInt(30)+1;
	private Integer v9 = new Random().nextInt(30)+1;
	private Integer v10 = new Random().nextInt(30)+1;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getV1() {
		return v1;
	}
	public void setV1(Integer v1) {
		this.v1 = v1;
	}
	public Integer getV2() {
		return v2;
	}
	public void setV2(Integer v2) {
		this.v2 = v2;
	}
	public Integer getV3() {
		return v3;
	}
	public void setV3(Integer v3) {
		this.v3 = v3;
	}
	public Integer getV4() {
		return v4;
	}
	public void setV4(Integer v4) {
		this.v4 = v4;
	}
	public Integer getV5() {
		return v5;
	}
	public void setV5(Integer v5) {
		this.v5 = v5;
	}
	public Integer getV6() {
		return v6;
	}
	public void setV6(Integer v6) {
		this.v6 = v6;
	}
	public Integer getV7() {
		return v7;
	}
	public void setV7(Integer v7) {
		this.v7 = v7;
	}
	public Integer getV8() {
		return v8;
	}
	public void setV8(Integer v8) {
		this.v8 = v8;
	}
	public Integer getV9() {
		return v9;
	}
	public void setV9(Integer v9) {
		this.v9 = v9;
	}
	public Integer getV10() {
		return v10;
	}
	public void setV10(Integer v10) {
		this.v10 = v10;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	

}
