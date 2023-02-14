package br.paulotrc.svcautomovel.datasources;

import br.paulotrc.svcautomovel.entites.Automovel;
import br.paulotrc.svcautomovel.entites.feign.ResponseApiCepData;
import br.paulotrc.svcautomovel.exceptions.bussiness.CepInexistenteException;
import br.paulotrc.svcautomovel.exceptions.feign.GatewayResourceIntegrationRuntimeException;
import br.paulotrc.svcautomovel.repositories.ApiCepRepository;
import br.paulotrc.svcautomovel.repositories.AutomovelRepository;
import br.paulotrc.svcautomovel.repositories.MongoAutomovelRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutomovelDataSource implements AutomovelRepository {

    private final Logger log = LoggerFactory.getLogger(AutomovelDataSource.class);
    private MongoAutomovelRepository mongoAutomovelRepository;
    private ApiCepRepository apiCepRepository;

    public Automovel save(Automovel automovel){
        ResponseApiCepData data = apiCepRepository.consultarPorCep(automovel.getCep());
        if(null != data){
            atualizaDadosComDadosRecuperadosDaApi(automovel, data);
            return this.mongoAutomovelRepository.save(automovel);
        }else{
            throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
        }
    }

    private void atualizaDadosComDadosRecuperadosDaApi(Automovel automovel, ResponseApiCepData data) {
        automovel.setEstado(data.getState());
        automovel.setCidade(data.getCity());
        automovel.setBairro(data.getDistrict());
        automovel.setEndereco(data.getAddress());
    }

    public List<Automovel> findAll(){
        return this.mongoAutomovelRepository.findAll();
    }

    @Override
    public List<Automovel> consultarPorCpf(String cpf) {
        return mongoAutomovelRepository.consultarPorCpf(cpf);
    }

    @Override
    public List<Automovel> consultarPorCep(String cep) {
        try {
            ResponseApiCepData data = apiCepRepository.consultarPorCep(cep);
            if(null != data){
                return mongoAutomovelRepository.consultarPorCep(cep);
            }else{
                throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
            }
        }catch (GatewayResourceIntegrationRuntimeException e){
            throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
        }
    }
}
