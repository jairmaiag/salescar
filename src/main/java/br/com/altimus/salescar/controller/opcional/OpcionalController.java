package br.com.altimus.salescar.controller.opcional;

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
import br.com.altimus.salescar.model.opcional.Opcional;
import br.com.altimus.salescar.model.opcional.OpcionalRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/opcionais")
public class OpcionalController {

	private final OpcionalRepository repository;

	public OpcionalController(OpcionalRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public @ResponseBody List<Opcional> getAll() {
		return (List<Opcional>) this.repository.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Opcional getById(@PathVariable("id") Integer id) {
		try {
			Optional<Opcional> entidade = this.repository.findById(id);
			return entidade.get();
		} catch (NoSuchElementException nsee) {
			return new Opcional(Mensagens.REGISTRO_NAO_ENCONTRADO);
		}
	}

	@PostMapping
	public @ResponseBody Opcional add(@RequestBody Opcional entidade) {
		try {
			return this.repository.save(entidade);
		} catch (DataIntegrityViolationException dive) {
			return new Opcional(Mensagens.DEPENDENCIA_REGISTRO);
		} catch (Exception e) {
			return new Opcional(0, e.getMessage());
		}
	}

	@PutMapping
	public @ResponseBody Opcional update(@RequestBody Opcional entidade) {
		try {
			if (entidade.getId() == null) {
				return new Opcional(Mensagens.ID_OBRIGATORIO);
			}
			Optional<Opcional> existe = this.repository.findById(entidade.getId());
			existe.get();
			return this.repository.save(entidade);
		} catch (NoSuchElementException nsee) {
			return new Opcional(Mensagens.REGISTRO_NAO_ENCONTRADO);
		} catch (JpaObjectRetrievalFailureException jorfe) {
			return new Opcional(Mensagens.DEPENDENCIA_REGISTRO);
		} catch (Exception e) {
			return new Opcional(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public @ResponseBody Opcional delete(@PathVariable("id") Integer id) {
		try {
			Optional<Opcional> existe = this.repository.findById(id);
			this.repository.delete(existe.get());
			return new Opcional(Mensagens.REGISTRO_EXCLUIDO);
		} catch (NoSuchElementException nsee) {
			return new Opcional(Mensagens.REGISTRO_NAO_ENCONTRADO);
		} catch (IllegalArgumentException iae) {
			return new Opcional(Mensagens.ERRO_AO_EXCLUIR);
		}
	}

}
