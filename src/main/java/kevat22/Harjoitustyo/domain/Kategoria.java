package kevat22.Harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Kategoria {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kategoriaid;
	private String kategoriaNimi;
	
	@OneToMany(cascade =CascadeType.ALL, mappedBy = "kategoria")
	@JsonIgnore
	private List<Elokuva> elokuvat;
	
	public Long getKategoriaid() {
		return kategoriaid;
	}
	public void setKategoriaid(Long kategoriaid) {
		this.kategoriaid = kategoriaid;
	}
	public String getKategoriaNimi() {
		return kategoriaNimi;
	}
	public void setKategoriaNimi(String kategoriaNimi) {
		this.kategoriaNimi = kategoriaNimi;
	}
	public Kategoria(String kategoriaNimi) {
		super();
		this.kategoriaNimi = kategoriaNimi;
	}
	public Kategoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Elokuva> getElokuvat(){
		return elokuvat;
	}
	
	public void setElokuvat(List<Elokuva> elokuvat) {
		this.elokuvat=elokuvat;
	}
	
	@Override
	public String toString() {
		return "Kategoria [kategoriaid=" + kategoriaid + ", kategoriaNimi=" + kategoriaNimi + "]";
	}
	

}
