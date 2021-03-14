package br.com.altimus.salescar.controller.fabricante;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
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
import br.com.altimus.salescar.model.fabricante.Fabricante;
import br.com.altimus.salescar.model.fabricante.FabricanteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/fabricantes")
public class FabricanteController {

	private final FabricanteRepository repository;

	public FabricanteController(FabricanteRepository fabricanteRepository) {
		this.repository = fabricanteRepository;
	}

	@GetMapping
	public @ResponseBody List<Fabricante> getFabricantes() {
		return (List<Fabricante>) this.repository.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Fabricante getFabricanteById(@PathVariable("id") Integer id) {
		try {
			Optional<Fabricante> fabricante = this.repository.findById(id);
			return fabricante.get();
		} catch (NoSuchElementException nsee) {
			return new Fabricante(Mensagens.REGISTRO_NAO_ENCONTRADO);
		}
	}

	@PostMapping
	public @ResponseBody Fabricante addFabricante(@RequestBody Fabricante fabricante) {
		try {
			return this.repository.save(fabricante);
		} catch (DataIntegrityViolationException dive) {
			return new Fabricante(Mensagens.DEPENDENCIA_REGISTRO);
		} catch (Exception e) {
			return new Fabricante(e.getMessage());
		}
	}

	@PutMapping
	public @ResponseBody Fabricante alterFabricante(@RequestBody Fabricante entidade) {
		try {
			if (entidade.getId() == null) {
				return new Fabricante(Mensagens.ID_OBRIGATORIO);
			}
			Optional<Fabricante> existe = this.repository.findById(entidade.getId());
			existe.get();
			return this.repository.save(entidade);
		} catch (NoSuchElementException nsee) {
			return new Fabricante(Mensagens.REGISTRO_NAO_ENCONTRADO);
		} catch (Exception e) {
			return new Fabricante(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public @ResponseBody Fabricante deleteFabricante(@PathVariable("id") Integer id) {
		try {
			Optional<Fabricante> existe = this.repository.findById(id);
			this.repository.delete(existe.get());
			return new Fabricante(Mensagens.REGISTRO_EXCLUIDO);
		} catch (IllegalArgumentException iae) {
			return new Fabricante(Mensagens.ERRO_AO_EXCLUIR);
		} catch (NoSuchElementException nsee) {
			return new Fabricante(Mensagens.REGISTRO_NAO_ENCONTRADO);
		}
	}
}
