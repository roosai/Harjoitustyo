package kevat22.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kevat22.Harjoitustyo.web.ElokuvaController;

@SpringBootTest
class HarjoitustyoApplicationTests {
	
	@Autowired
	private ElokuvaController controller;

	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
