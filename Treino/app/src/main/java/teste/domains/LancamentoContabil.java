package teste.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class LancamentoContabil {
    private UUID id;
    private Integer contaContabil;
    private Date data;
    private Double valor;

}
