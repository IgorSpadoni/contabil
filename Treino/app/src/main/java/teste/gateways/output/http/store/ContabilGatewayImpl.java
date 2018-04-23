package teste.gateways.output.http.store;

import org.springframework.beans.factory.annotation.Autowired;
import teste.domains.LancamentoContabil;
import teste.domains.ResumoContabil;
import teste.gateways.ContabilGateway;

import java.util.List;
import java.util.UUID;

public class ContabilGatewayImpl implements ContabilGateway {

    @Autowired
    private RestIntegration restIntegration;

    @Override
    public void post(LancamentoContabil lancamentoContabil) {
        restIntegration.post(lancamentoContabil);
    }

    @Override
    public LancamentoContabil get(UUID id) {
        return restIntegration.get(id);
    }

    @Override
    public List<LancamentoContabil> get(Integer contaContabil) {
        return restIntegration.get(contaContabil);
    }

    @Override
    public ResumoContabil get() {
        return restIntegration.get();
    }
}
