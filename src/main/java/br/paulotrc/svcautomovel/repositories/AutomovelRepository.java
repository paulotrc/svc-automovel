package br.paulotrc.svcautomovel.repositories;

import br.paulotrc.svcautomovel.entites.Automovel;

import java.util.List;

public interface AutomovelRepository {

        Automovel save(Automovel automovel);
        List<Automovel> findAll();
        List<Automovel> consultarPorCpf(String cpf);
        List<Automovel> consultarPorPlaca(String cep);

    }

