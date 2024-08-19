package br.com.fiap.ms_pagamento.service;

import br.com.fiap.ms_pagamento.dto.PagamentoDTO;
import br.com.fiap.ms_pagamento.model.Pagamento;
import br.com.fiap.ms_pagamento.model.Status;
import br.com.fiap.ms_pagamento.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Transactional(readOnly = true)
    public List<PagamentoDTO> findAll() {
        List<Pagamento> list = repository.findAll();
        return list.stream().map(PagamentoDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PagamentoDTO findById(long id) {
        Pagamento entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado.")
        );

        return new PagamentoDTO(entity);
    }

    @Transactional
    public PagamentoDTO insert (PagamentoDTO dto) {
        Pagamento entity = new Pagamento();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new PagamentoDTO(entity);
    }

    private void copyDtoToEntity(PagamentoDTO dto, Pagamento entity) {
        entity.setValor(dto.getValor());
        entity.setNome(dto.getNome());
        entity.setNumeroCartao(dto.getNumeroCartao());
        entity.setValidade(dto.getValidade());
        entity.setCodigoSeguranca(dto.getCodigoSeguranca());
        entity.setStatus(Status.CRIADO); //quando incluirmos o pagamento o status será CRIADO por default.
        entity.setPedidoId(dto.getId());
        entity.setFormaPagamento(dto.getIdformaPagamento());

    }

    public void delete (Long id) {
        if(!repository.existsById(id))
            throw new EntityNotFoundException("Recurso nao encontrado!");
        try {
            repository.deleteById(id);
        }
        catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Recurso nao encontrado!");
        }
    }

}
