package com.example.helpdesk.services;

import com.example.helpdesk.domain.Chamado;
import com.example.helpdesk.domain.Cliente;
import com.example.helpdesk.domain.Tecnico;
import com.example.helpdesk.domain.enums.Perfil;
import com.example.helpdesk.domain.enums.Prioridade;
import com.example.helpdesk.domain.enums.Status;
import com.example.helpdesk.repositories.ChamadoRepository;
import com.example.helpdesk.repositories.ClienteRepository;
import com.example.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;



@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB(){


        Tecnico tec1 = new Tecnico(null, "DAVID", "48705070058","david@mail.com", "1515");
        tec1.addtPerfil(Perfil.ADMIN);

        Tecnico tec2 = new Tecnico(null, "adam", "48703070058","adam@mail.com", "1616");

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "44705070038", "torvalds@mail.com","1212");
        Cliente cli2 = new Cliente(null, "Lord Thor", "44705070228", "lord@mail.com","12123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec2, cli2);

        tecnicoRepository.saveAll(Arrays.asList(tec1,tec2));
        clienteRepository.saveAll(Arrays.asList(cli1,cli2));
        chamadoRepository.saveAll(Arrays.asList(c1,c2));
    }

}
