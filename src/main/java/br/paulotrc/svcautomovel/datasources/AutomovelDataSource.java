package br.paulotrc.svcautomovel.datasources;

import br.paulotrc.svcautomovel.entites.Automovel;
import br.paulotrc.svcautomovel.repositories.AutomovelRepository;
import br.paulotrc.svcautomovel.repositories.MongoAutomovelRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutomovelDataSource implements AutomovelRepository {

    private final Logger log = LoggerFactory.getLogger(AutomovelDataSource.class);
    private MongoAutomovelRepository mongoAutomovelRepository;

    public Automovel save(Automovel automovel){
        return this.mongoAutomovelRepository.save(automovel);
    }

    public List<Automovel> findAll(){
        return this.mongoAutomovelRepository.findAll();
    }

    @Override
    public List<Automovel> consultarPorCpf(String cpf) {
        return mongoAutomovelRepository.consultarPorCpf(cpf);
    }

    @Override
    public List<Automovel> consultarPorPlaca(String placa) {
        return mongoAutomovelRepository.consultarPorPlaca(placa);
    }
}
