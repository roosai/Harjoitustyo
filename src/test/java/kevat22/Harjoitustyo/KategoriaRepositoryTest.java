package kevat22.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import kevat22.Harjoitustyo.domain.Kategoria;
import kevat22.Harjoitustyo.domain.KategoriaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KategoriaRepositoryTest {
	
	@Autowired 
	KategoriaRepository krepository;
	
	@Test
	public void findByKategoriaNimiShouldReturnKategoriaNimi() {
		List<Kategoria> kategoriat = krepository.findByKategoriaNimi("Toiminta");
		assertThat(kategoriat.get(0).getKategoriaNimi()).isEqualTo("Toiminta");
	}
	
	@Test
	public void findByKategorianimiShouldReturnSize() {
		List<Kategoria> kategoriat = krepository.findByKategoriaNimi("Komedia");
		assertThat(kategoriat).hasSize(1);
	}


}
