package br.com.altimus.salescar.controller.modelo;

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
import br.com.altimus.salescar.model.modelo.Modelo;
import br.com.altimus.salescar.model.modelo.ModeloRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/modelos")
public class ModeloController {

	private final ModeloRepository repository;

	public ModeloController(ModeloRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public @ResponseBody List<Modelo> getAll() {
		return (List<Modelo>) this.repository.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Modelo getById(@PathVariable("id") Integer id) {
		try {
			Optional<Modelo> entidade = this.repository.findById(id);
			return entidade.get();
		} catch (NoSuchElementException nsee) {
			return new Modelo(0, Mensagens.REGISTRO_NAO_ENCONTRADO);
		}
	}

	@PostMapping
	public @ResponseBody Modelo add(@RequestBody Modelo entidade) {
		try {
			return this.repository.save(entidade);
		} catch (DataIntegrityViolationException dive) {
			return new Modelo(0, Mensagens.DEPENDENCIA_REGISTRO);
		} catch (Exception e) {
			return new Modelo(0, e.getMessage());
		}
	}

	@PutMapping
	public @ResponseBody Modelo update(@RequestBody Modelo entidade) {
		try {
			if (entidade.getId() == null) {
				return new Modelo(0, Mensagens.ID_OBRIGATORIO);
			}
			Optional<Modelo> existe = this.repository.findById(entidade.getId());
			existe.get();
			return this.repository.save(entidade);
		} catch (NoSuchElementException nsee) {
			return new Modelo(0, Mensagens.REGISTRO_NAO_ENCONTRADO);
		} catch (JpaObjectRetrievalFailureException jorfe) {
			return new Modelo(0, Mensagens.DEPENDENCIA_REGISTRO);
		} catch (Exception e) {
			return new Modelo(0, e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public @ResponseBody Modelo delete(@PathVariable("id") Integer id) {
		try {
			Optional<Modelo> existe = this.repository.findById(id);
			this.repository.delete(existe.get());
			return new Modelo(0, Mensagens.REGISTRO_EXCLUIDO);
		} catch (NoSuchElementException nsee) {
			return new Modelo(0, Mensagens.REGISTRO_NAO_ENCONTRADO);
		} catch (IllegalArgumentException iae) {
			return new Modelo(0, Mensagens.ERRO_AO_EXCLUIR);
		}
	}

}
