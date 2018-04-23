package teste.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import teste.domains.LancamentoContabil;
import teste.gateways.ContabilGateway;

import java.util.List;
import java.util.UUID;

public class GetLancamentos {


    @Autowired
    @Qualifier(value = "ContabilGateway")
    private ContabilGateway contabilGateway;

    public List<LancamentoContabil> execute(final Integer contaContabil) {
        return contabilGateway.get(contaContabil);
    }
}
