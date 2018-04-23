package teste.gateways.output.http.store;

import teste.domains.LancamentoContabil;
import teste.domains.ResumoContabil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "contabil", url = "http://localhost:8085/contabil")
public interface RestIntegration {

    @RequestMapping(value = "/lancamentos-contabeis", method = RequestMethod.POST, consumes = "application/json")
    void post(LancamentoContabil lancamentoContabil);

    @RequestMapping(value = "/lancamentos-contabeis/{id}", method = RequestMethod.GET)
    LancamentoContabil get(@PathVariable(name = "id") UUID id);

    @RequestMapping(value = "/lancamentos-contabeis/{contaContabil}", method = RequestMethod.OPTIONS, produces = "application/json")
    List<LancamentoContabil> get(@PathVariable(name = "contaContabil") Integer contaContabil);

    @RequestMapping(value = "/lancamentos-contabeis/_stats", method = RequestMethod.HEAD, produces = "application/json")
    ResumoContabil get();
}
