public class ConversorDeMoneda {
    Double convertir(Double cantidad, Moneda monedaOriginal, String claveMonedaNueva){
        return  cantidad * monedaOriginal.conversion_rates().get(claveMonedaNueva);
    }
}
