package teste.gateways;

import teste.domains.LancamentoContabil;
import teste.domains.ResumoContabil;

import java.util.List;
import java.util.UUID;

public interface ContabilGateway {

    UUID post(LancamentoContabil product);

    LancamentoContabil get(UUID id);

    List<LancamentoContabil> get(Integer contaContabil);

    ResumoContabil get();
}
