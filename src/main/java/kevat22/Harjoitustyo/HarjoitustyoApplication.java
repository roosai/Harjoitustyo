package kevat22.Harjoitustyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat22.Harjoitustyo.domain.Elokuva;
import kevat22.Harjoitustyo.domain.ElokuvaRepository;
import kevat22.Harjoitustyo.domain.Kategoria;
import kevat22.Harjoitustyo.domain.KategoriaRepository;
import kevat22.Harjoitustyo.domain.User;
import kevat22.Harjoitustyo.domain.UserRepository;

@SpringBootApplication
public class HarjoitustyoApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner elokuvatiedot (ElokuvaRepository erepository, KategoriaRepository krepository, UserRepository urepository) {
	return (args) ->{
		
		krepository.save(new Kategoria("Toiminta"));
		krepository.save(new Kategoria("Kauhu"));
		krepository.save(new Kategoria("Draama"));
		krepository.save(new Kategoria("Komedia"));
		
		erepository.save(new Elokuva("Uncharted: Drake’s Fortune", 2022, 116, krepository.findByKategoriaNimi("Toiminta").get(0)));
		erepository.save(new Elokuva("Spider-Man: No Way Home", 2021, 148, krepository.findByKategoriaNimi("Toiminta").get(0)));
		erepository.save(new Elokuva("Sinister", 2012, 110, krepository.findByKategoriaNimi("Kauhu").get(0)));
		erepository.save(new Elokuva("Manaaja", 1973, 132, krepository.findByKategoriaNimi("Kauhu").get(0)));
		erepository.save(new Elokuva("Texasin moottorisahamurhat", 2003, 98, krepository.findByKategoriaNimi("Kauhu").get(0)));
		erepository.save(new Elokuva("The Worst person in the World", 2021, 127, krepository.findByKategoriaNimi("Draama").get(0)));
		erepository.save(new Elokuva("The Imitation Game", 2014, 114, krepository.findByKategoriaNimi("Draama").get(0)));
		erepository.save(new Elokuva("Pitkä kuuma kesä", 1999, 95, krepository.findByKategoriaNimi("Draama").get(0)));
		erepository.save(new Elokuva("Napapiirin sankarit", 2010, 92, krepository.findByKategoriaNimi("Komedia").get(0)));
		erepository.save(new Elokuva ("Kauhea Kankkunen", 2009, 100, krepository.findByKategoriaNimi("Komedia").get(0)));
		erepository.save(new Elokuva ( "Johnny English - uudestisyntynyt", 2011, 102, krepository.findByKategoriaNimi("Komedia").get(0)));
		
		User user1 = new User("user", "$2a$10$rGIhRobwZK0Dm.DD9ioO5ukRpb07lE87qMB9MHbFUU6iRRibv8cLa", "USER");
		User user2 = new User("admin", "$2a$10$/ZC3oooPBjof0W61eWIKj.GygpadcTUlm6bMHrY7JMiv.bkcH.ika", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
	};
	}

}
