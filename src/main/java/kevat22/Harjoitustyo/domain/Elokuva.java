package kevat22.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Elokuva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nimi;
	private int vuosi, kesto;
	
	@ManyToOne
	@JoinColumn(name="kategoriaid")
	private Kategoria kategoria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public int getVuosi() {
		return vuosi;
	}
	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}
	public int getKesto() {
		return kesto;
	}
	public void setKesto(int kesto) {
		this.kesto = kesto;
	}
	public Elokuva(String nimi, int vuosi, int kesto, Kategoria kategoria) {
		super();
		this.nimi = nimi;
		this.vuosi = vuosi;
		this.kesto = kesto;
		this.kategoria = kategoria;
	}
	public Elokuva() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kategoria getKategoria() {
		return kategoria;
	}
	
	public void setKategoria(Kategoria kategoria) {
		this.kategoria=kategoria;
	}
	
	@Override
	public String toString() {
		if(this.kategoria != null)
		return "Elokuva [id=" + id + ", nimi=" + nimi + ", vuosi=" + vuosi + ", kesto=" + kesto + ", kategoria "+ this.getKategoria()+"]";
		else
			return "Elokuva [id=" + id + ", nimi=" + nimi + ", vuosi=" + vuosi + ", kesto=" + kesto + "]";
	}


}
