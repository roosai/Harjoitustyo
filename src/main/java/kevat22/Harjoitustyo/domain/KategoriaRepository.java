package kevat22.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KategoriaRepository extends CrudRepository<Kategoria, Long> {
		List<Kategoria> findByKategoriaNimi(String kategoriaNimi);
}
