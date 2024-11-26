
import java.util.Random;
import java.util.Scanner;

public class simulador {

    public static void startGame() {
        var entrada = new Scanner(System.in);
        String listaPlanetas[] = { "Mercurio", "Venus", "Marte", "Jupiter", "saturno", "Urano", "neptuno" };
        String listaNaves[] = { "Falcon001", "Falcon002", "Falcon003", "Falcon004" };
        boolean exit = false;
        double velocidadNave = 0, distanciaPlaneta = 0;
        int menuPrincipal, menuNaves, pasajeros = 0, oxigeno = 0, combustible = 0;

        do {
            //Menu principal del juego que muestra las opciones disponibles del simulador del viaje interplanetario.
            System.out.printf("%n%n====SIMULADOR DE VIAJE INTERPLANETARIO=====%n%n");
            System.out.println("1. Seleccion de planetas de destino");
            System.out.println("2. Seleccion de nave espacial");
            System.out.println("3. Iniciar simulacion del viaje");
            System.out.printf("4. Salir%n%n");

            menuPrincipal = entrada.nextInt();

            switch (menuPrincipal) {
                case 1:
                    // Este código implementa un bucle que permite al usuario seleccionar un planeta al que viajar, mediante el metodo showInfoPlaneta.
                    // muestra una lista de planetas, solicita al usuario que seleccione un planeta, muestra información sobre el planeta
                    // seleccionado y pide al usuario que confirme su seleccion, el ciclo continúa hasta que el usuario confirma el planeta a viajar.

                    boolean exitPlaneta = false;
                    int salidaPlaneta;

                    do {
                        System.out.printf("%nSeleccione el planeta al que desea viajar: %n%n");
                        for (int i = 0; i < listaPlanetas.length; i++) {
                            System.out.printf("%s. %s%n", i + 1, listaPlanetas[i]);
                        }
                        var planetaSeleccionado = entrada.nextInt();
                        distanciaPlaneta = showInfoPlaneta(planetaSeleccionado);
                        System.out.printf(
                                "%n¿Esta seguro que quiere viajar al planeta seleccionado?%n%n1. Si%n2. No%n%n");
                        salidaPlaneta = entrada.nextInt();
                        exitPlaneta = (salidaPlaneta == 1) ? exitPlaneta = true : exitPlaneta;
                    } while (!exitPlaneta);

                    break;
                case 2:
                    //Menú que muestra las opciones disponibles para gestionar la nave, los pasajeros y sus recursos.
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
                                // Este codigo crea un bucle que permite al usuario seleccionar una nave para viajar. Mediante el metodo showInfoNave
                                // muestra una lista de naves disponibles, solicita al usuario que seleccione una y muestra información sobre la nave, 
                                // pide al usuario que confirme su seleccion. Si el usuario confirma, la variable `exitNave` se establece en verdadero, 
                                // rompiendo el ciclo y regresando al usuario al menu principal.
                                boolean exitNave = false;
                                int salidaNave;

                                do {
                                    System.out.printf("%nSeleccione la nave con la que desea viajar: %n%n");
                                    for (int i = 0; i < listaNaves.length; i++) {
                                        System.out.printf("%s. %s%n%n", i + 1, listaNaves[i]);
                                    }
                                    var naveSeleccionado = entrada.nextInt();
                                    velocidadNave = showInfoNave(naveSeleccionado);
                                    if (velocidadNave != 0) {
                                        System.out.printf(
                                                "%n¿Esta seguro que desea usar la nave seleccionada?%n%n1. Si%n2. No%n%n");
                                        salidaNave = entrada.nextInt();
                                        exitNave = (salidaNave == 1) ? exitNave = true : exitNave;
                                    }

                                } while (!exitNave);

                                break;
                            case 2:
                                // Este código solicita al usuario que ingrese la cantidad de pasajeros que viajarán,  
                                // valida si la entrada es menor o igual a 0. Si es así, se muestra un mensaje de error pidiendo al usuario que ingrese al menos 1 pasajero.
                                // si es mayor a 0, muestra el número de pasajeros ingresados, el ciclo continúa hasta que se proporciona una entrada válida.
                                System.out.printf("%n%nIngrese la cantidad de pasajeros que van a viajar: %n%n");
                                pasajeros = entrada.nextInt();
                                boolean exitPasajeros = false;
                                do {
                                    if (pasajeros <= 0) {
                                        System.err.printf("Ingrese al menos 1 pasajero para el viaje: %n%n");
                                        break;
                                    } else {
                                        System.out.printf("La cantidad de pasajeros es: %s%n%n", pasajeros);
                                        exitPasajeros = true;
                                    }
                                } while (!exitPasajeros);
                                break;
                            case 3:
                                // Este codigo comprueba si ya se ha escogido una nave, de ser verdadero entra a un bucle que pide al usuario 
                                // que ingrese la cantidad de combustible y oxígeno necesarios para un viaje; mediante el metodo
                                // manageResources valida si se ingresaron correctamente los recursos y se rompe el ciclo de ser verdadero.
                                boolean exitRecursos = false;
                                if (velocidadNave == 0) {
                                    System.err.printf("%nPrimero debe de seleccionar una nave...%n");
                                } else {
                                    do {
                                        System.out.printf(
                                                "%n%nIngrese la cantidad de galones de combustible para el viaje: %n");
                                        combustible = entrada.nextInt();
                                        System.out.printf(
                                                "%n%nIngrese la cantidad de tanques de oxigeno para el viaje: %n");
                                        oxigeno = entrada.nextInt();
                                        exitRecursos = manageResources(combustible, oxigeno);
                                    } while (!exitRecursos);
                                }

                                break;
                            case 4:
                                // Este codigo comprueba si ya se ha escogido una nave y un deestino, de ser verdadero
                                // calcula e imprime la duración aproximada del viaje utilizando el método tripDuration,
                                // generando validaciones de errores constantes hasta dar el resultado correcto.
                                if (velocidadNave == 0 || distanciaPlaneta == 0) {
                                    System.err.printf(
                                            "%nPara calcular la duracion del viaje debe de elegir un planeta y escoger una nave...%n%n");
                                } else {
                                    System.out.printf("%nLa duracion del viaje seria aproximadamente de: %.2f horas.",
                                            tripDuration(velocidadNave, distanciaPlaneta));
                                }

                                break;
                            case 5:
                                   System.out.println("Regresando al menú principal...");
                                   break; 

                            default:
                                System.err.printf("%nOpcion incorrecta, por favor selecciona una opcion valida.%n");
                                break;
                        }

                    } while (menuNaves != 5);

                    break;
                case 3:
                if (distanciaPlaneta == 0 || velocidadNave == 0 || pasajeros == 0 || oxigeno == 0 || combustible == 0) {
                    System.err.printf("%nDebe completar la configuración del viaje antes de iniciar la simulación.%n");
                } else {
                    double duracionViaje = tripDuration(velocidadNave, distanciaPlaneta);
            
                    // Verificar recursos, pero permitir continuar
                    if (!verificarRecursos(duracionViaje, pasajeros, oxigeno, combustible)) {
                        System.out.println("Advertencia: Los recursos son insuficientes. Continuaremos la simulación bajo estas condiciones.");
                    }
            
                    // Llamar a la simulación independientemente de los recursos
                    simularViaje(distanciaPlaneta, velocidadNave, oxigeno, combustible, pasajeros);
                }
                break;


                case 4:
                    System.out.printf("%nHasta pronto!!!");
                    exit = true;
                    break;

                default:
                    System.err.printf("%nOpcion incorrecta, por favor selecciona una opcion valida.%n");
                    break;
            }

        } while (!exit);
        entrada.close();
    }

    private static boolean verificarRecursos(double duracionViaje, int pasajeros, int oxigeno, int combustible) {
    int oxigenoRequerido = (int) Math.ceil(duracionViaje * pasajeros); // Oxígeno necesario
    int combustibleRequerido = (int) Math.ceil(duracionViaje); // Combustible necesario

    if (oxigeno < oxigenoRequerido || combustible < combustibleRequerido) {
        System.out.printf("%nRecursos insuficientes:%n");
        if (oxigeno < oxigenoRequerido) {
            System.out.printf("- Oxígeno faltante: %d tanques%n", oxigenoRequerido - oxigeno);
        }
        if (combustible < combustibleRequerido) {
            System.out.printf("- Combustible faltante: %d galones%n", combustibleRequerido - combustible);
        }
        return false; // Recursos insuficientes
    }

    System.out.println("Recursos suficientes para el viaje.");
    return true; // Recursos suficientes
}
    
    private static void simularViaje(double distancia, double velocidad, int oxigeno, int combustible, int pasajeros) {
        Random random = new Random();
        double progreso = 0;
        double tiempoTotal = distancia / velocidad;
        double tiempoTranscurrido = 0;
        int consumoOxigenoPorHora = pasajeros;
        int consumoCombustiblePorHora = 1; 

        System.out.printf("%nIniciando viaje...%nDistancia: %.2f km%nVelocidad: %.2f km/h%nTiempo estimado: %.2f horas%n",
                distancia, velocidad, tiempoTotal);

        while (progreso < 100 && oxigeno > 0 && combustible > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            progreso += 10;
            tiempoTranscurrido += tiempoTotal / 10;
            oxigeno -= consumoOxigenoPorHora;
            combustible -= consumoCombustiblePorHora ;

            System.out.printf("Progreso: %.0f%% [", progreso);
            for (int i = 0; i < progreso / 10; i++) {
                System.out.print("-");
            }
            for (int i = (int) progreso / 10; i < 10; i++) {
                System.out.print(" ");
            }
            System.out.println("]");

            if (oxigeno > 0 && combustible > 0) {
                System.out.printf("Oxígeno restante: %d | Combustible restante: %d%n", oxigeno, combustible);
            } else {
                System.out.println("Recursos agotados: Nave en modo de emergencia.");
               
            }

            if (random.nextInt(10) < 2) {
                String evento = switch (random.nextInt(3)) {
                    case 0 -> "¡Alerta! Asteroides detectados.";
                    case 1 -> "¡Falla técnica! Reparando sistemas...";
                    case 2 -> "¡Desvío inesperado! Recalculando ruta...";
                    default -> "";
                };
                System.out.println(evento);
                tiempoTranscurrido += 0.5;
            }
        }

        if (oxigeno <= 0 || combustible <= 0) {
            System.out.println("El viaje no pudo completarse debido a recursos insuficientes.");
        } else {
            System.out.printf("%n¡Has llegado a tu destino! Tiempo total: %.2f horas%n", tiempoTranscurrido);
        }
    }
   
    /**
     * El metodo 'tripDuration'calcula la distancia en dias que demora el viaje desde la tierra hasta el planeta seleccionado.
     * @param velocidadNave Representa la velocidad de la nave escogida para el viaje.
     * @param distanciaPlaneta Representa la distancia del planeta escogido para el viaje.
     * @return El método retorna un double con la duracion aproximada del viaje.
     */
    private static double tripDuration(double velocidadNave, double distanciaPlaneta) {
        double traveltime;
        traveltime = distanciaPlaneta / velocidadNave;
        return traveltime;
    }

    /**
     * El metodo 'manageResources' verifica si los recursos de oxigeno y combustible son suficientes.
     * @param combustible Representa la cantidad de combustible en galones disponible para el viaje.
     * @param oxigeno Representa la cantidad de anques de oxígeno idsponibles para el viaje.
     * @return El método retorna un boolean que es verdadero si los recursos son los minimos y falso sino lo son.
     */
    private static boolean manageResources(int combustible, int oxigeno) {
        if (combustible <= 0 || oxigeno <= 0) {
            System.err.printf(
                    "%nCantidad minima de tanques de oxigeno a ingresar: 1 tanque.%nCantidad minima de galones de combustible a ingresar: 1%n%n");
            return false;
        } else {
            System.out.printf("%nRecursos embarcados y listos para el viaje...");
            return true;
        }
    }

    /**
     * El metodo `showInfoNave` muestra la informacion de la nave seleccionada y retorna la velocidad máxima de la misma.
     * @param naveSeleccionado Representa la nave espacial seleccionada.
     * @return El método retorna un double con la velocidad de la nave escogida para el viaje.
     */
    private static double showInfoNave(int naveSeleccionado) {
        double velocidadNave = 0;
        String mensaje = "";

        if (naveSeleccionado == 1) {
            mensaje = """
                                    Información de la Nave seleccionada

                    Nombre: Falcon001
                    Especialidad: Carga de pasajeros
                    Capacidad de carga: 10 personas
                    Velocidad Maxima: 1.900.000 km/h
                    Tanques de oxigeno: 250
                    Combustible maximo: 100 galones

                    """;
            velocidadNave = 1900000;
        } else if (naveSeleccionado == 2) {
            mensaje = """
                                    Información de la Nave seleccionada

                    Nombre: Falcon002
                    Especialidad: Velocidad Ultra
                    Capacidad de carga: 5 personas
                    Velocidad Maxima: 3.500.000 km/h
                    Tanques de oxigeno: 100
                    Combustible maximo: 50 galones

                    """;
            velocidadNave = 3500000;
        } else if (naveSeleccionado == 3) {
            mensaje = """
                                    Información de la Nave seleccionada

                    Nombre: Falcon003
                    Especialidad: Carga Mixta
                    Capacidad de carga: 7 personas
                    Velocidad Maxima: 2.700.000 km/h
                    Tanques de oxigeno: 180
                    Combustible maximo: 70 galones

                    """;
            velocidadNave = 2700000;
        } else if (naveSeleccionado == 4) {
            mensaje = """
                                    Información de la Nave seleccionada

                    Nombre: Falcon004
                    Especialidad: Reserva de oxigeno
                    Capacidad de carga: 8 personas
                    Velocidad Maxima: 3.000.000 km/h
                    Tanques de oxigeno: 200
                    Combustible maximo: 60 galones

                    """;
            velocidadNave = 3000000;
        } else {
            System.out.printf("%n%nOpcion incorrecta, por favor selecciona una opcion valida...");
        }
        System.out.println(mensaje);
        return velocidadNave;
    }

    /**
     * El metodo `showInfoPlaneta` muestra la informacion del planeta seleccionado y retorna la distancia desde la tierra.
     * 
     * @param planetaSeleccionado Representa el planeta seleccionado.
     * @return El método retorna un double con la distancia aproximada desde la tierra hasta el planeta selecionado.
     */
    private static double showInfoPlaneta(int planetaSeleccionado) {
        String mensaje = "";
        var distanciaPlaneta = 0l;
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
            System.err.println("Opcion incorrecta, escoge uno de los planetas listados.");
        }

        System.out.println(mensaje);
        return distanciaPlaneta;
    }
}
