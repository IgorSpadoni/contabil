package teste.gateways.input.http;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.domains.LancamentoContabil;
import teste.domains.ResumoContabil;
import teste.usecases.GetLancamento;
import teste.usecases.GetLancamentos;
import teste.usecases.GetResumoContabil;
import teste.usecases.PostLancamentoContabil;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/lancamentos-contabeis", produces = APPLICATION_JSON_VALUE)
@Api(value = "Contabil", description = "Rest API para Lançamentos Contábeis", produces = APPLICATION_JSON_VALUE)
public class ContabilRestController {

    @Autowired
    private GetLancamento getLancamento;

    @Autowired
    private GetLancamentos getLancamentos;

    @Autowired
    private GetResumoContabil getResumoContabil;

    @Autowired
    private PostLancamentoContabil postLancamentoContabil;

    @ApiOperation(value = "Encontra lançamento por ID")
    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<LancamentoContabil> findLancamentoContabilById(@PathVariable final UUID id)
    {
        return ResponseEntity.ok(getLancamento.execute(id));
    }

    @ApiOperation(value = "Encontra lançamentos de uma Conta Contábil")
    @RequestMapping(value = "/{contaContabil}", method = OPTIONS)
    public ResponseEntity<List<LancamentoContabil>> findProducts(@PathVariable final Integer contaContabil) {
        return ResponseEntity.ok(getLancamentos.execute(contaContabil));
    }

    @ApiOperation(value = "Determina Resumo Contábil")
    @RequestMapping(value = "/_stats", method = HEAD)
    public ResponseEntity<ResumoContabil> findProducts() {
        return ResponseEntity.ok(getResumoContabil.execute());
    }

    @ApiOperation(value = "Insere um lançamento")
    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UUID> save(@RequestBody final LancamentoContabil lancamentoContabil) {
        return ResponseEntity.ok(postLancamentoContabil.execute(lancamentoContabil));
    }

}
