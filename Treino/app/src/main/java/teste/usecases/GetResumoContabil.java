package teste.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import teste.domains.ResumoContabil;
import teste.gateways.ContabilGateway;

public class GetResumoContabil {
    @Autowired
    @Qualifier(value = "ContabilGateway")
    private ContabilGateway contabilGateway;

    public ResumoContabil execute() {
        return contabilGateway.get();
    }
}
