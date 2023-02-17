package br.paulotrc.svcautomovel.transportlayers.dto.request;

import br.paulotrc.svcautomovel.entites.enumerados.TipoAutomovel;
import br.paulotrc.svcautomovel.entites.enumerados.TipoRestricaoAutomovel;
import br.paulotrc.svcautomovel.entites.validators.TipoAutomovelValidator;
import br.paulotrc.svcautomovel.entites.validators.TipoRestricaoAutomovelValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AutomovelRequest {

    private UUID id = UUID.randomUUID();
    @NotBlank(message = "CPF é obrigatório")
    private String cpf; //Documento de identificação do dono do automóvel
    @NotBlank(message = "Placa é obrigatório")
    @Pattern(regexp = "^([a-zA-Z]{2}|[a-zA-Z]{3})[0-9][A-Za-z0-9][0-9]{2}$", message = "Placa inválida, utilize os seguintes formatos: (AA9999|AAA9999|AAA9A99).")
    private String placa;
    private String renavam;
    private String categoria;
    private String combustivel;
    private String marca;
    private String modelo;
    private String anoFabricacao;
    private String anoModelo;
    private String cor;
    private String potencia;
    private Boolean financiado;
    @PastOrPresent(message = "DataCompra é obrigatório e não pode ser compra futura.")
    private LocalDate dataCompra;
    private LocalDate dataFimContrato;
    private LocalDate dataQuitacao;
    @Positive(message = "ParcelasTotais é obrigatório e deve ser maior que zero.")
    private Integer parcelasTotais;
    @PositiveOrZero(message = "ParcelasPagas é obrigatório, caso ainda não tenha nenhuma parcela paga, indicar como 0 (zero).")
    private Integer parcelasPagas;
    @TipoRestricaoAutomovelValidator(regexp = "IMPOSTO_ATRASADO|SITUACAO_CADASTRAL|FURTADO|PERDA_TOTAL|MULTA")
    private TipoRestricaoAutomovel restricaoAutomovel;
    @TipoAutomovelValidator(regexp = "CARRO|MOTO|SUV|CAMINHONETE|VAN|CAMINHAO|CARRETINHA|ONIBUS")
    private TipoAutomovel tipoAutomovel;
}


