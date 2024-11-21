
import java.util.Random;
import java.util.Scanner;
public class simulador{

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        var entrada = new Scanner(System.in);
        String listaPlanetas[] = { "Mercurio", "Venus", "Marte", "Jupiter", "saturno", "Urano", "neptuno" };
        String listaNaves[] = { "Bronce", "Plata", "Oro", "Diamante", "Rubi" };
        int[] distancias = { 91, 41, 225, 778, 1400, 2870, 4300 };

        boolean exit =false;
        int menuPrincipal, menuNaves;

        String planetaSeleccionado = null;
        int distanciaSeleccionada = 0;
        String naveSeleccionada = null;
        int velocidadNave = 0;

            do {
                System.out.printf("%n%n====SIMULADOR DE VIAJE INTERPLANETARIO=====%n%n");
                System.out.println("1. Seleccion de planetas de destino");
                System.out.println("2. Seleccion de nave espacial");
                System.out.println("3. Iniciar simulacion del viaje");
                System.out.printf("4. Salir%n%n");
    
                menuPrincipal = solicitarEntero(entrada, "Seleccione una opción del menú (1-4): ");
    
                switch (menuPrincipal) {
                    case 1:
                        boolean exitPlaneta = false;
                        do {
                            System.out.printf("%nSeleccione el planeta al que desea viajar: %n%n");
                            for (int i = 0; i < listaPlanetas.length; i++) {
                                System.out.printf("%s. %s%n", i + 1, listaPlanetas[i]);
                            }
    
                            int seleccionPlaneta = solicitarEntero(entrada, "Seleccione un planeta (1-7): ");
    
                            if (seleccionPlaneta < 1 || seleccionPlaneta > listaPlanetas.length) {
                                System.out.println("Selección inválida. Intente de nuevo.");
                                continue;
                            }
    
                            planetaSeleccionado = listaPlanetas[seleccionPlaneta - 1];
                            distanciaSeleccionada = distancias[seleccionPlaneta - 1];
    
                            mostrarInfoPlaneta(seleccionPlaneta);
                            int confirmar = solicitarEntero(entrada, "¿Está seguro que quiere viajar al planeta seleccionado? (1. Sí / 2. No): ");
                            exitPlaneta = (confirmar == 1);
    
                        } while (!exitPlaneta);
    
                        break;
    
                    case 2:
                        boolean exitNave = false;
                        do {
                            System.out.printf("%nSeleccione la nave con la que desea viajar: %n%n");
                            for (int i = 0; i < listaNaves.length; i++) {
                                System.out.printf("%s. %s%n", i + 1, listaNaves[i]);
                            }
    
                            menuNaves = solicitarEntero(entrada, "Seleccione una nave (1-5): ");
    
                            if (menuNaves < 1 || menuNaves > listaNaves.length) {
                                System.out.println("Selección inválida. Intente de nuevo.");
                                continue;
                            }
    
                            naveSeleccionada = listaNaves[menuNaves - 1];
                            velocidadNave = 50000 + (menuNaves - 1) * 10000; 
                            System.out.printf("Ha seleccionado la nave: %s con velocidad: %d km/h%n", naveSeleccionada, velocidadNave);
                            exitNave = true;
    
                        } while (!exitNave);
    
                        break;
    
                    case 3:
                        if (planetaSeleccionado == null || naveSeleccionada == null) {
                            System.out.println("Debe seleccionar un planeta y una nave antes de iniciar la simulación.");
                        } else {
                            simularViaje(planetaSeleccionado, distanciaSeleccionada, velocidadNave);
                        }
                        break;
    
                    case 4:
                        System.out.printf("%nHasta pronto!!!");
                        exit = true;
                        break;
    
                    default:
                        System.out.printf("%nOpción incorrecta, por favor selecciona una opción válida.%n");
                        break;
                }
    
            } while (!exit);
            entrada.close();
         }
    private static void mostrarInfoPlaneta(int planetaSeleccionado) {
        String mensaje = "";
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

        }else if (planetaSeleccionado == 3) {
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
            
        }else if(planetaSeleccionado == 4){
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
        }else if (planetaSeleccionado == 5) {
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
        }else if (planetaSeleccionado == 6) {
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
        }else if (planetaSeleccionado == 7) {
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
        }else {
            System.out.println("Opcion incorrecta, escoge uno de los planetas listados.");
        }

        System.out.println(mensaje);  
    }

    private static void simularViaje(String planeta, int distancia, int velocidad) {
        Random random = new Random();
        int progreso = 0;
        int tiempoTotalHoras = distancia * 1000000 / velocidad; 
        int tiempoTranscurrido = 0;

        System.out.printf("%nIniciando viaje hacia %s...%n", planeta);
        System.out.printf("Distancia: %d millones de km%n", distancia);
        System.out.printf("Velocidad: %d km/h%n", velocidad);
        System.out.printf("Tiempo estimado: %d horas%n", tiempoTotalHoras);

        while (progreso < 100) {
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            progreso += 10;
            tiempoTranscurrido += tiempoTotalHoras / 10;

            System.out.print("Progreso del viaje: " + progreso + "% ");
            System.out.print("[");
            for (int i = 0; i < progreso / 10; i++) {
                System.out.print("-");
            }
            for (int i = progreso / 10; i < 10; i++) {
                System.out.print(" ");
            }
            System.out.println("]");

            System.out.printf("Tiempo transcurrido: %d horas de %d%n", tiempoTranscurrido, tiempoTotalHoras);

            if (random.nextInt(10) < 2) {
                String evento = switch (random.nextInt(3)) {
                    case 0 -> "¡Alerta! Asteroides detectados.";
                    case 1 -> "¡Falla en el sistema! Reparando...";
                    case 2 -> "¡Desvío inesperado! Calculando nueva ruta...";
                    default -> "";
                };
                System.out.println(evento);
            }
        }

        System.out.printf("%n¡Has llegado a %s!%n", planeta);
    }

    private static int solicitarEntero(Scanner entrada, String mensaje) {
        int numero = -1;
        boolean valido = false;

        do {
            System.out.print(mensaje);
            if (entrada.hasNextInt()) {
                numero = entrada.nextInt();
                valido = true;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                entrada.next(); 
            }
        } while (!valido);

        return numero;
    

}
}