package br.com.seiya.barbershop.infraestrutura.adaptadores.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.portas.repositorios.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

@Component
public class BarbeiroRepository implements BarbeiroRepositoryPort{
	
	@Autowired
	private SpringBarbeiroRepository springRepository;

	@Override
	public Barbeiro salvar(BarbeiroDTO barbeiro) {
		return springRepository.save(new Barbeiro(barbeiro));
	}

	@Override
	public Barbeiro buscarPorId(Long id) {
		return springRepository.findById(id).orElseThrow(() -> new RuntimeException("Barbeiro não existe!"));
	}

	@Override
	public Page<Barbeiro> buscarTodos(Pageable pagima) {
		return springRepository.findAll(pagima);
	}

}
