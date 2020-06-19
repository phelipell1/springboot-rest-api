package com.rest.poject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.poject.repository.EmpregadosRepository;
import com.rest.poject.exception.ResourceNotFoundException;
import com.rest.poject.model.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class EmpregadosController {
	
	@Autowired
	private EmpregadosRepository empregadosrepository;
	
	@GetMapping("/empregados")
	public List<Empregados> getAllEmpregados(){
		return empregadosrepository.findAll();
	}
	
	@GetMapping("/empregados/{id}")
	public ResponseEntity<Empregados> getEmpregadosById(@PathVariable(value = "id") Long empregadosId)
		throws ResourceNotFoundException{
		Empregados empregados = empregadosrepository.findById(empregadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível localizar :: " + empregadosId));
		return ResponseEntity.ok().body(empregados);
	}
	
	@PostMapping("/empregados")
	public Empregados addEmpregados(@Validated @RequestBody Empregados empregados) {
		return empregadosrepository.save(empregados);
	}
	
	@PutMapping("/empregados/{id}")
	public ResponseEntity<Empregados> updateEmpregados(@PathVariable(value = "id") Long empregadosId,
			@Validated @RequestBody Empregados empregadosDetalhes) throws ResourceNotFoundException{
		Empregados empregados = empregadosrepository.findById(empregadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Empregados não existe :: "+empregadosId));
		
		
		
		empregados.setNomeCompleto(empregadosDetalhes.getNomeCompleto());
		empregados.setEndereco(empregadosDetalhes.getEndereco());
		empregados.setEmail(empregadosDetalhes.getEmail());
		empregados.setTelefone(empregados.getEmail());
		empregados.setCPF(empregadosDetalhes.getCPF());
		empregados.setDateNascimento(empregadosDetalhes.getDateNascimento());
		empregados.setFuncao(empregadosDetalhes.getFuncao());
		empregados.setSalario(empregadosDetalhes.getSalario());
		final Empregados upaEmpregados = empregadosrepository.save(empregados);
		return ResponseEntity.ok(upaEmpregados);
	}
	
	@DeleteMapping("/empregados/{id}")
	public Map<String, Boolean> deleteEmpregados(@PathVariable(value = "id") Long empregadosId)
	throws ResourceNotFoundException{
		Empregados empregados = empregadosrepository.findById(empregadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe empregado para esse id :: "+empregadosId));
		empregadosrepository.delete(empregados);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado",Boolean.TRUE);
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
