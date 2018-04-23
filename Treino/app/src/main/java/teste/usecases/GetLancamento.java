package teste.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import teste.domains.LancamentoContabil;
import teste.gateways.ContabilGateway;

import java.util.UUID;

public class GetLancamento {
    @Autowired
    @Qualifier(value = "ContabilGateway")
    private ContabilGateway contabilGateway;

    public LancamentoContabil execute(final UUID id) {
        return contabilGateway.get(id);
    }

}
