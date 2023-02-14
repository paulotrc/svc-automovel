package br.paulotrc.svcautomovel.transportlayers.dto.response;

import br.paulotrc.svcautomovel.entites.enumerados.TipoAutomovel;
import br.paulotrc.svcautomovel.entites.enumerados.TipoRestricaoAutomovel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AutomovelResponse {

    private UUID id;
    private String cpf; //Documento de identificação do dono do automovel
    private String placa;
    private String estado;
    private String cidade;
    private Boolean financiado;
    private LocalDate dataCompra;
    private LocalDate dataFimContrato;
    private LocalDate dataQuitacao;
    private Integer parcelasTotais;
    private Integer parcelasPagas;
    private TipoRestricaoAutomovel restricaoAutomovel;
    private TipoAutomovel tipoAutomovel;
}

