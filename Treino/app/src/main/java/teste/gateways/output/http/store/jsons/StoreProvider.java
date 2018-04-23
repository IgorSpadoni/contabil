package teste.gateways.output.http.store.jsons;

import lombok.Data;

@Data
public class StoreProvider {

  private Long codigoLojista;
  private String nomeLojista;
  private String skuLojista;

  public StoreProvider()
  {}

  public StoreProvider(final Provider provider) {
    this.codigoLojista = provider.getCode();
    this.nomeLojista = provider.getName();
    this.skuLojista = provider.getSkuSeller();
  }

  public Provider toDomain() {
    Provider provider = new Provider();

    provider.setCode(this.codigoLojista);
    provider.setName(this.nomeLojista);
    provider.setSkuSeller(this.skuLojista);

    return provider;

  }

}
