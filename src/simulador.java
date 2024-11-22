import java.util.Scanner;

public class simulador {

    public static void startGame() {
        var entrada = new Scanner(System.in);
        String listaPlanetas[] = { "Mercurio", "Venus", "Marte", "Jupiter", "saturno", "Urano", "neptuno" };
        String listaNaves[] = { "Falcon001", "Falcon002", "Falcon003", "Falcon004" };
        boolean exit = false;
        int menuPrincipal, menuNaves, pasajeros, oxigeno, combustible;

        do {
            System.out.printf("%n%n====SIMULADOR DE VIAJE INTERPLANETARIO=====%n%n");
            System.out.println("1. Seleccion de planetas de destino");
            System.out.println("2. Seleccion de nave espacial");
            System.out.println("3. Iniciar simulacion del viaje");
            System.out.printf("4. Salir%n%n");

            menuPrincipal = entrada.nextInt();

            switch (menuPrincipal) {
                case 1:
                    boolean exitPlaneta = false;
                    int salidaPlaneta;

                    do {
                        System.out.printf("%nSeleccione el planeta al que desea viajar: %n%n");
                        for (int i = 0; i < listaPlanetas.length; i++) {
                            System.out.printf("%s. %s%n", i + 1, listaPlanetas[i]);
                        }
                        var planetaSeleccionado = entrada.nextInt();
                        mostrarInfoPlaneta(planetaSeleccionado);
                        System.out.printf(
                                "%n¿Esta seguro que quiere viajar al planeta seleccionado?%n%n1. Si%n2. No%n%n");
                        salidaPlaneta = entrada.nextInt();
                        exitPlaneta = (salidaPlaneta == 1) ? exitPlaneta = true : exitPlaneta;
                    } while (!exitPlaneta);

                    break;
                case 2:
                    do {
                        System.out.printf("%n%n====GESTION DE LA NAVE ESPACIAL=====%n%n");
                        System.out.println("1. Seleccionar una nave para el viaje");
                        System.out.println("2. Ingresar la cantidad de pasajeros");
                        System.out.println("3. Gestionar recursos de la nave");
                        System.out.println("4. Calculo de la duración del viaje");
                        System.out.printf("5. Salir al menu principal%n%n");

                        menuNaves = entrada.nextInt();

                        switch (menuNaves) {
                            case 1:
                                boolean exitNave = false;
                                int salidaNave;

                                do {
                                    System.out.printf("%nSeleccione la nave con la que desea viajar: %n%n");
                                    for (int i = 0; i < listaNaves.length; i++) {
                                        System.out.printf("%s. %s%n%n", i + 1, listaNaves[i]);
                                    }
                                    var naveSeleccionado = entrada.nextInt();
                                    mostrarInfoNave(naveSeleccionado);
                                    System.out.printf(
                                            "%n¿Esta seguro que desea usar la nave seleccionada?%n%n1. Si%n2. No%n%n");
                                    salidaNave = entrada.nextInt();
                                    exitNave = (salidaNave == 1) ? exitNave = true : exitNave;
                                } while (!exitNave);

                                break;
                            case 2:
                                System.out.printf("%n%nIngrese la cantidad de pasajeros que van a viajar: %n%n");
                                pasajeros = entrada.nextInt();
                                boolean exitPasajeros = false;
                                do {
                                    if (pasajeros <= 0) {
                                        System.out.printf("Ingrese al menos 1 pasajero para el viaje: %n%n");
                                        pasajeros = entrada.nextInt();
                                    } else {
                                        System.out.printf("La cantidad de pasajeros es: %s%n%n", pasajeros);
                                        exitPasajeros = true;
                                    }
                                } while (!exitPasajeros);
                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            default:
                                System.out.printf("%nOpcion incorrecta, por favor selecciona una opcion valida.%n");
                                break;
                        }

                    } while (menuNaves != 5);

                    break;
                case 3:

                    break;

                case 4:
                    System.out.printf("%nHasta pronto!!!");
                    exit = true;
                    break;

                default:
                    System.out.printf("%nOpcion incorrecta, por favor selecciona una opcion valida.%n");
                    break;
            }

        } while (!exit);
        entrada.close();
    }

    private static double mostrarInfoNave(int naveSeleccionado) {
        double velocidadNave = 0;
        String mensaje = "";

        if (naveSeleccionado == 1) {
            mensaje = """
                                    Información de la Nave seleccionada

                    Nombre: Falcon001
                    Especialidad: Carga de pasajeros
                    Capacidad de carga: 10 personas
                    Velocidad Maxima: 1.900.000 km/hora
                    Tanques de oxigeno: 15
                    Combustible maximo: 100 galones

                    """;
            velocidadNave = 1900000;
        } else if (naveSeleccionado == 2) {
            mensaje = """
                                    Información de la Nave seleccionada

                    Nombre: Falcon002
                    Especialidad: Velocidad Ultra
                    Capacidad de carga: 5 personas
                    Velocidad Maxima: 3.500.000 km/hora
                    Tanques de oxigeno: 10
                    Combustible maximo: 50 galones

                    """;
            velocidadNave = 3500000;
        } else if (naveSeleccionado == 3) {
            mensaje = """
                                    Información de la Nave seleccionada

                    Nombre: Falcon003
                    Especialidad: Carga Mixta
                    Capacidad de carga: 7 personas
                    Velocidad Maxima: 2.700.000 km/hora
                    Tanques de oxigeno: 12
                    Combustible maximo: 70 galones

                    """;
            velocidadNave = 2700000;
        } else if (naveSeleccionado == 4) {
            mensaje = """
                                    Información de la Nave seleccionada

                    Nombre: Falcon004
                    Especialidad: Reserva de oxigeno
                    Capacidad de carga: 8 personas
                    Velocidad Maxima: 3.000.000 km/hora
                    Tanques de oxigeno: 20
                    Combustible maximo: 60 galones

                    """;
            velocidadNave = 2700000;
        }
        System.out.println(mensaje);
        return velocidadNave;
    }

    private static double mostrarInfoPlaneta(int planetaSeleccionado) {
        String mensaje = "";
        double distanciaPlaneta = 0;
        if (planetaSeleccionado == 1) {
            mensaje = """

                    SELECCIONASTE MERCURIO, AQUI TENEMOS INFORMACION DEL PLANETA AL QUE VAS A VIAJAR:

                    La distancia entre la Tierra y Mercurio varía constantemente debido a las órbitas elípticas de ambos planetas alrededor del Sol.
                    En promedio, la distancia es de aproximadamente 91 millones de kilómetros (57 millones de millas).


                    * Órbita rápida: Completa una vuelta alrededor del Sol en solo 88 días terrestres, siendo el planeta con el año más corto.

                    * Rotación lenta: Un día en Mercurio (rotación sobre su eje) dura casi 59 días terrestres.

                    * Sin lunas ni anillos: Es uno de los dos planetas (junto con Venus) que no tiene satélites naturales.

                    * Hierro en el núcleo: Su núcleo es enorme y representa aproximadamente el 85% de su volumen interno, lo que lo convierte en el planeta más denso después de la Tierra.

                    * Es difícil de observar: Solo es visible cerca del amanecer o el atardecer, ya que siempre está cerca del Sol desde nuestra perspectiva.


                                                            """;
            distanciaPlaneta = 91000000;

        } else if (planetaSeleccionado == 2) {
            mensaje = """

                    SELECCIONASTE VENUS, AQUI TENEMOS INFORMACION DEL PLANETA AL QUE VAS A VIAJAR:

                    La distancia entre la Tierra y Venus también varía debido a las órbitas elípticas de ambos planetas alrededor del Sol.
                    En promedio, la distancia es de 41 millones de kilómetros (25 millones de millas).


                    * Rotación al revés: Gira en dirección contraria a la mayoría de los planetas, lo que significa que en Venus el Sol sale por el oeste y se pone por el este.

                    * Días más largos que años: Un día en Venus (243 días terrestres) es más largo que su año (225 días terrestres).

                    * Lluvia de ácido: Su atmósfera contiene nubes de ácido sulfúrico, aunque estas no alcanzan la superficie debido al calor extremo.

                    * Sin lunas: Venus, al igual que Mercurio, no tiene satélites naturales.

                    * Superficie aplastada: La presión atmosférica en su superficie es 90 veces mayor que la de la Tierra, similar a estar a 1 km bajo el agua.
                                        """;
            distanciaPlaneta = 41000000;

        } else if (planetaSeleccionado == 3) {
            mensaje = """

                    SELECCIONASTE MARTE, AQUI TENEMOS INFORMACION DEL PLANETA AL QUE VAS A VIAJAR:

                    La distancia entre la Tierra y Marte varía ampliamente debido a sus órbitas elípticas alrededor del Sol.
                    En promedio, la distancia es de 225 millones de kilómetros (140 millones de millas).

                    * Dos lunas diminutas: Tiene dos pequeñas lunas, Fobos y Deimos, que podrían ser asteroides capturados.

                    * Montaña más alta: Posee el Monte Olimpo, el volcán más grande del sistema solar, con 22 km de altura.

                    * Cañón gigante: El Valles Marineris es un sistema de cañones que es 10 veces más largo y 4 veces más profundo que el Gran Cañón de la Tierra.

                    * Días similares a los de la Tierra: Un día en Marte (llamado sol) dura unas 24 horas y 39 minutos.

                    * Exploración activa: Actualmente, Marte es el planeta más visitado por robots, como los rovers Perseverance y Curiosity, que buscan signos de vida pasada.
                    """;
            distanciaPlaneta = 225000000;

        } else if (planetaSeleccionado == 4) {
            mensaje = """

                    SELECCIONASTE JUPITER, AQUI TENEMOS INFORMACION DEL PLANETA AL QUE VAS A VIAJAR:

                    La distancia entre la Tierra y Júpiter varía considerablemente debido a las órbitas elípticas de ambos planetas alrededor del Sol.
                    En promedio, la distancia es de aproximadamente 778 millones de kilómetros (484 millones de millas).

                    * El rey de las lunas: Posee 92 lunas conocidas, siendo las más grandes las Galileanas: Ío, Europa, Ganímedes y Calisto.

                    * Ganímedes es especial: Ganímedes es la luna más grande del sistema solar, incluso más grande que Mercurio.

                    * Rotación rápida: Completa un día en solo 10 horas, lo que lo convierte en el planeta con la rotación más rápida.

                    * Fuerza gravitacional: Su enorme gravedad actúa como un "escudo" para la Tierra, desviando cometas y asteroides.

                    * Magnetosfera inmensa: Tiene el campo magnético más fuerte de cualquier planeta, abarcando millones de kilómetros en el espacio.
                    """;
            distanciaPlaneta = 778000000;

        } else if (planetaSeleccionado == 5) {
            mensaje = """

                    SELECCIONASTE SATURNO, AQUI TENEMOS INFORMACION DEL PLANETA AL QUE VAS A VIAJAR:

                    La distancia entre la Tierra y Saturno varía significativamente debido a las órbitas elípticas de ambos planetas alrededor del Sol.
                    En promedio, la distancia es de aproximadamente 1.4 mil millones de kilómetros (870 millones de millas).

                    * Anillos famosos: Sus anillos son los más visibles y extensos del sistema solar, con un diámetro de unos 282,000 km, pero son extremadamente delgados.

                    * Numerosas lunas: Tiene 146 lunas conocidas, siendo Titán la más grande y una de las pocas lunas en el sistema solar con atmósfera.

                    * Vientos violentos: Sus vientos en la atmósfera pueden alcanzar velocidades de 1,800 km/h, más rápidos que en Júpiter.

                    * Hexágono misterioso: Tiene una formación en forma de hexágono en su polo norte, un fenómeno atmosférico único en el sistema solar.

                    * Corto día, largo año: Un día en Saturno dura solo 10.7 horas, pero tarda 29.5 años terrestres en completar una órbita alrededor del Sol.
                    """;
            distanciaPlaneta = 1400000000;

        } else if (planetaSeleccionado == 6) {
            mensaje = """

                    SELECCIONASTE URANO, AQUI TENEMOS INFORMACION DEL PLANETA AL QUE VAS A VIAJAR:

                    La distancia entre la Tierra y Urano varía considerablemente debido a las órbitas elípticas de ambos planetas alrededor del Sol.
                    En promedio, la distancia es de aproximadamente 2.87 mil millones de kilómetros (1.78 mil millones de millas).

                    * Rotación "de lado": Su inclinación extrema hace que parezca rodar alrededor del Sol, con estaciones de hasta 42 años terrestres de luz o oscuridad en sus polos.

                    * Vientos rápidos: Tiene vientos que alcanzan velocidades de 900 km/h, especialmente en su atmósfera inferior.

                    * Anillos oscuros: Posee 13 anillos finos y tenues, compuestos principalmente de partículas oscuras de hielo y polvo.

                    * Frío extremo: Es el planeta más frío del sistema solar, con temperaturas de hasta -224°C.

                    * 27 lunas: Sus lunas tienen nombres únicos, basados en personajes de obras de Shakespeare y Alexander Pope, como Titania y Oberón.
                    """;
            distanciaPlaneta = 2870000000l;

        } else if (planetaSeleccionado == 7) {
            mensaje = """

                    SELECCIONASTE NEPTUNO, AQUI TENEMOS INFORMACION DEL PLANETA AL QUE VAS A VIAJAR:

                    La distancia entre la Tierra y Neptuno varía ampliamente debido a las órbitas elípticas de ambos planetas alrededor del Sol.
                    En promedio, la distancia es de aproximadamente 4.3 mil millones de kilómetros (2.7 mil millones de millas).

                    * Vientos más rápidos: Los vientos en Neptuno pueden alcanzar velocidades de hasta 2,100 km/h.

                    * Gran Mancha Oscura: Similar a la Gran Mancha Roja de Júpiter, Neptuno tiene una tormenta gigante que se desplaza por su atmósfera.

                    * Anillos tenues: Posee un sistema de anillos oscuros y delgados, difíciles de observar desde la Tierra.

                    * Lunas interesantes: Tiene 14 lunas conocidas, siendo Tritón la más grande, famosa por su movimiento retrógrado y posibilidad de criovolcanes.

                    * Lento pero constante: Neptuno tarda 165 años terrestres en completar una órbita alrededor del Sol, pero su día dura solo 16 horas.
                    """;
            distanciaPlaneta = 4300000000l;

        } else {
            System.out.println("Opcion incorrecta, escoge uno de los planetas listados.");
        }

        System.out.println(mensaje);
        return distanciaPlaneta;
    }
}
