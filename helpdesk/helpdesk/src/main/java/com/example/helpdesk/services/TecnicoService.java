package com.example.helpdesk.services;

import com.example.helpdesk.domain.Pessoa;
import com.example.helpdesk.domain.Tecnico;
import com.example.helpdesk.dtos.TecnicoDTO;
import com.example.helpdesk.repositories.PessoaRepository;
import com.example.helpdesk.repositories.TecnicoRepository;
import com.example.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.example.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository  repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado?! Id: " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Tecnico newObj =new Tecnico(objDTO);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(TecnicoDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
            if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
                throw new DataIntegrityViolationException("CPF já cadastrado no Sistema!");
        }
            obj = pessoaRepository.findByEmail(objDTO.getEmail());
            if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("EMAIL já cadastrado no Sistema!");
        }
    }
}
