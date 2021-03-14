package br.com.altimus.salescar.controller.carro;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.altimus.salescar.controller.util.Mensagens;
import br.com.altimus.salescar.model.carro.Carro;
import br.com.altimus.salescar.model.carro.CarroRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/carros")
public class CarroController {

	private final CarroRepository repository;

	public CarroController(CarroRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public @ResponseBody List<Carro> getAll() {
		return (List<Carro>) this.repository.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Carro getById(@PathVariable("id") Integer id) {
		try {
			Optional<Carro> entidade = this.repository.findById(id);
			return entidade.get();
		} catch (NoSuchElementException nsee) {
			return new Carro(Mensagens.REGISTRO_NAO_ENCONTRADO);
		}
	}

	@PostMapping
	public @ResponseBody Carro add(@RequestBody Carro entidade) {
		try {
			entidade.setCadastro(Calendar.getInstance());
			return this.repository.save(entidade);
		} catch (DataIntegrityViolationException dive) {
			return new Carro(dive.getMessage());
		} catch (Exception e) {
			return new Carro(e.getMessage());
		}
	}

	@PutMapping
	public @ResponseBody Carro update(@RequestBody Carro entidade) {
		try {
			if (entidade.getId() == null) {
				return new Carro(Mensagens.ID_OBRIGATORIO);
			}
			Optional<Carro> existe = this.repository.findById(entidade.getId());
			existe.get();
			return this.repository.save(entidade);
		} catch (NoSuchElementException nsee) {
			return new Carro(Mensagens.REGISTRO_NAO_ENCONTRADO);
		} catch (JpaObjectRetrievalFailureException jorfe) {
			return new Carro(Mensagens.DEPENDENCIA_REGISTRO);
		} catch (Exception e) {
			return new Carro(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public @ResponseBody Carro delete(@PathVariable("id") Integer id) {
		try {
			Optional<Carro> existe = this.repository.findById(id);
			this.repository.delete(existe.get());
			return new Carro(Mensagens.REGISTRO_EXCLUIDO);
		} catch (NoSuchElementException nsee) {
			return new Carro(Mensagens.REGISTRO_NAO_ENCONTRADO);
		} catch (IllegalArgumentException iae) {
			return new Carro(Mensagens.ERRO_AO_EXCLUIR);
		}
	}

}
