import java.util.Scanner;

public class AppConversor {

    public static void main(String[] args) {
        Double cantidadAConvertir;
        String claveMonedaOriginal = "USD";
        String claveMonedaNueva = "EUR";
        Scanner teclado = new Scanner(System.in);
        Integer opcionUsuario;



        do{
            String menu = """ 
                    
                    ############ Conversor de Moneda ############
                    #Elija una opción:
                    #		1) Dolar =>> Peso argentino         #
                    #		2) Peso argentino =>> Dolar         #
                    #		3) Dolar =>> Real Brasileño         #
                    #		4) Real Brasileño =>> Dolar         #
                    #		5) Dolar =>> Peso Colombiano        #
                    #		6) Peso Colombiano =>> Dolar        #
                    #		7) Dolar =>> Peso Méxicano          #
                    #		8) Peso Méxicano =>> Dolar          #
                    #		0) Salir                            #
                    #		                                    #
                    ______________________________________________
                    """;
            System.out.println(menu);
            try{
                opcionUsuario = Integer.valueOf(teclado.nextLine());
                Boolean opcionValida;

                switch(opcionUsuario){
                    case 1:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "ARS";
                        opcionValida = true;
                        break;
                    case 2:
                        claveMonedaOriginal = "ARS";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 3:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "BRL";
                        opcionValida = true;
                        break;
                    case 4:
                        claveMonedaOriginal = "BRL";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 5:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "COP";
                        opcionValida = true;
                        break;
                    case 6:
                        claveMonedaOriginal = "COP";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 7:
                        claveMonedaOriginal = "MXN";
                        claveMonedaNueva = "ARS";
                        opcionValida = true;
                        break;
                    case 8:
                        claveMonedaOriginal = "MXN";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 0:
                        System.out.println("Finalizando el programa");
                        opcionValida = false;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        opcionValida = false;
                }

                if (opcionValida){
                    System.out.println("Ingresa el valor a convertir");
                    cantidadAConvertir = Double.valueOf(teclado.nextLine());

                    // consulta a la API
                    ConsultaMoneda consultaMoneda = new ConsultaMoneda();
                    Moneda monedaOriginal = consultaMoneda.buscaMoneda(claveMonedaOriginal);

                    //convertir
                    ConversorDeMoneda conversorMoneda = new ConversorDeMoneda();
                    Double nuevaCantidad = conversorMoneda.convertir(cantidadAConvertir, monedaOriginal, claveMonedaNueva);
                    System.out.println("La cantidad que quieres convertir es: " + cantidadAConvertir + " " + claveMonedaOriginal);
                    System.out.println("El valor en "+ claveMonedaNueva + " es: " + nuevaCantidad + " " + claveMonedaNueva);
                }
            }catch (Exception e){
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                opcionUsuario = 1;
            }

        }while (opcionUsuario != 0);


    }
}
