package br.paulotrc.svcautomovel.iteractors;

import br.paulotrc.svcautomovel.entites.Automovel;
import br.paulotrc.svcautomovel.repositories.AutomovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovelUseCase {

    private AutomovelRepository automovelRepository;

    public AutomovelUseCase(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    public Automovel gravarAutomovel(Automovel automovel) {
        return automovelRepository.save(automovel);
    }

    public List<Automovel> consultaTodos() {
        return automovelRepository.findAll();
    }

    public List<Automovel> consultarPorCpf(String cpf) {
        return automovelRepository.consultarPorCpf(cpf);
    }

    public List<Automovel> consultarPorCep(String cep) {
        return automovelRepository.consultarPorCep(cep);
    }

    public Boolean cepExiste(String cep){

        return false;
    }

}
