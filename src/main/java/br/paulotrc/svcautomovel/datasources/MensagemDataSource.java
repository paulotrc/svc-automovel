package br.paulotrc.svcautomovel.datasources;

public final class MensagemDataSource {

    private MensagemDataSource(){
    }

    public static class Erro {
        private Erro(){
        }

        public static final String LOG = " Erro messsage : {} , cause: {}, stacktrace : {}";
    }

    public static class Origem {
        private Origem(){
        }

        public static final String SERVICE_AUTOMOVEL = "SERVICE AUTOMOVEL";
        public static final String SERVICE_API_CEP = "SERVICE API CEP";
    }

    public static class MessageDataSource {

        private MessageDataSource() {
        }

        public static final String ERRO_CONSULTA_AUTOMOVEL = "Erro ao consultar o automovel";
        public static final String INTERNAL_ERROR_EXCEPTION = "ERRO AO EXECUTAR UMA OPERAÇÃO";
        public static final String JSON_ERROR_EXCEPTION = "ERRO AO EFETUAR UMA OPERAÇÃO COM JSON";

    }
}
