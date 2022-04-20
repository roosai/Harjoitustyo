package kevat22.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import kevat22.Harjoitustyo.domain.Elokuva;
import kevat22.Harjoitustyo.domain.ElokuvaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ElokuvaRepositoryTest {
	
	@Autowired
	ElokuvaRepository erepository;
	
	@Test
	public void findByNameShouldReturnName() {
		List<Elokuva> elokuvat = erepository.findByNimi("Manaaja");
		assertThat(elokuvat.get(0).getNimi()).isEqualTo("Manaaja");
	}
	
	@Test
	public void findByNameShouldReturnSize() {
		List<Elokuva> elokuvat = erepository.findByNimi("Manaaja");
		assertThat(elokuvat).hasSize(1);
	}
	
	@Test
	public void lisaaElokuva() {
		Elokuva elokuva = new Elokuva("Ihmeotukset: Dumbledoren salaisuudet", 2022, 143);
		erepository.save(elokuva);
		assertThat(elokuva.getId()).isNotNull();
	}

}
