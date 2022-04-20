package kevat22.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import kevat22.Harjoitustyo.domain.Tila;
import kevat22.Harjoitustyo.domain.TilaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TilaRepositoryTest {
	
	@Autowired
	TilaRepository trepository;
	
	@Test
	public void findByTilaShouldReturnTila() {
		List <Tila> tilat = trepository.findByTila("Vapaa");
		assertThat(tilat.get(0).getTila()).isEqualTo("Vapaa");
	}
	
	@Test
	public void findByTilaShouldReturnSize() {
		List <Tila> tilat = trepository.findByTila("Vapaa");
		assertThat(tilat).hasSize(1);
	}

}
