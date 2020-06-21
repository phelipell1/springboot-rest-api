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

import com.rest.poject.exception.ResourceNotFoundException;
import com.rest.poject.model.Empresas;
import com.rest.poject.repository.EmpresaRepository;

import javassist.expr.NewArray;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class EmpresasController {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@GetMapping("empresas")
	public List<Empresas> getAlEmpresas(){
		return empresaRepository.findAll();
	}
	
	@GetMapping("/empresas/{id}")
	public ResponseEntity<Empresas> getEmpresasById(@PathVariable(value = "id") Long empresaId)
			throws ResourceNotFoundException{
		Empresas empresa = empresaRepository.findById(empresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma empresa localizada :: " + empresaId));
		return ResponseEntity.ok().body(empresa);
	}
	
	@PostMapping("/empresas")
	public Empresas addEmpresas(@Validated @RequestBody Empresas empresa) {
		return empresaRepository.save(empresa);
	}
	
	@PutMapping("/empresa/{id}")
	public ResponseEntity<Empresas> updateEmpresa(@PathVariable(value = "id") Long empresaId,
			@Validated @RequestBody Empresas empresaDetalhes) throws ResourceNotFoundException{
		Empresas empresa = empresaRepository.findById(empresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar :: " +empresaId + ":: não localizado"));
		
		empresa.setNomeEmpresa(empresaDetalhes.getNomeEmpresa());
		empresa.setCnpjEmpresa(empresaDetalhes.getCnpjEmpresa());
		empresa.setDataFundacao(empresaDetalhes.getDataFundacao());
		empresa.setProprietario(empresaDetalhes.getProprietario());
		empresa.setListEmpregados(empresaDetalhes.getListEmpregados());
		final Empresas upEmpresa = empresaRepository.save(empresa);
		return ResponseEntity.ok(upEmpresa);
	}
	
	@DeleteMapping("/empresa/{id}")
	public Map<String, Boolean> deleteEmpresa(@PathVariable(value = "id") Long empresaId)
		throws ResourceNotFoundException{
		Empresas empresa = empresaRepository.findById(empresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe empresa para esse id :: "+empresaId));
		empresaRepository.delete(empresa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado", Boolean.TRUE);
		return response;
	}

}