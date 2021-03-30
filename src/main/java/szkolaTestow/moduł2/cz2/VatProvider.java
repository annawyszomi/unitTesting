package szkolaTestow.moduł2.cz2;

public interface VatProvider {

    double getDefaultVat();

    double getVatForType(String type);
}
