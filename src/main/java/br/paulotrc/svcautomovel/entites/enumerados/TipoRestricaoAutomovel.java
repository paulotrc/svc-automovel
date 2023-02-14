package br.paulotrc.svcautomovel.entites.enumerados;

public enum TipoRestricaoAutomovel {
    DIVIDA("Dívida"),
    SITUACAO_CADASTRAL("Situação Cadastral"),
    CPF_CANCELADO("CPF Cancelado"),
    CPF_PENDENTE("CPF Pendente"),
    CPF_NULO("CPF Nulo");

    private String descricao;

    TipoRestricaoAutomovel(String descricao) {
        this.descricao = descricao;
    }
}