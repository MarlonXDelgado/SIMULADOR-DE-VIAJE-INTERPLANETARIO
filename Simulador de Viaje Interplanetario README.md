## Descripción del Proyecto

El Simulador de Viajes Interplanetarios es un programa interactivo desarrollado en Java que permite a los usuarios realizar simulaciones de viajes a distintos planetas del sistema solar. Los jugadores pueden seleccionar planetas, elegir naves espaciales, gestionar recursos como oxígeno y combustible, e interactuar con eventos aleatorios que hacen el viaje más dinámico y desafiante.

El programa también incorpora cálculos precisos sobre consumo de recursos basado en pasajeros, tiempo de viaje y distancia recorrida. Además, incluye elementos narrativos como estaciones espaciales, piratas espaciales, zonas de bajas temperaturas y hasta el rescate de la perrita Laika.

## Tecnologías utilizadas

- **Lenguaje:** JAVA

## Características Principales

1. Selección de Planetas y Naves:

Los usuarios pueden elegir entre siete planetas del sistema solar.
Cuatro naves espaciales disponibles, cada una con características únicas:
Capacidad de pasajeros.
Velocidad máxima.
Capacidad de combustible y oxígeno.
Habilidad especial (por ejemplo, reserva de oxígeno).

2. Gestión de Recursos:

Los usuarios deben gestionar el oxígeno y el combustible según la distancia del viaje, la cantidad de pasajeros y eventos ocurridos.
El consumo de combustible depende de la distancia recorrida (1 galón para 50,000 km).
El consumo de oxígeno se calcula según el número de pasajeros (1 tanque para 5 pasajeros por día).

3. Interacción con Eventos Aleatorios:

Eventos programados para aparecer durante el viaje con un 50% de probabilidad:
Agujero de Gusano: Avanza un 40% del progreso total.
Lluvia de Meteoritos: Aumenta el tiempo de viaje y el consumo de recursos.
Piratas Espaciales: Roban el 50% del oxígeno y combustible.
Zona de Bajas Temperaturas: Reduce la velocidad en un 50%, aumentando tiempo y consumo de recursos.
Salvar a Laika: Reduce el tiempo de viaje si se rescata, o desencadena el evento de piratas si se ignora.

4. Estaciones Espaciales:

Si los recursos llegan a cero, se ofrece la posibilidad de recargar combustible y oxígeno en una estación espacial.

5. Cálculos Dinámicos:

-Basados en distancia, número de pasajeros, y tiempo transcurrido.
-Garantiza que no haya valores negativos para los recursos.

##Requisitos del Sistema

-Java 21 o superior instalado.
-Un IDE como IntelliJ IDEA, Eclipse o Visual Studio Code (opcional).
-Consola para ejecutar el programa.

##Estructura del Proyecto

El proyecto está organizado en un único archivo principal: simulador.java.

##Clases y Métodos

1. Métodos principales:
   
-startGame(): Controla el flujo principal del programa, mostrando los menús y ejecutando las opciones seleccionadas.
-simularViaje(double distancia, double velocidad, int oxigeno, int combustible, int pasajeros): Controla la simulación del viaje, incluyendo el progreso, consumo de recursos y eventos aleatorios.
3. Cálculos importantes:

-tripDuration(double velocidadNave, double distanciaPlaneta): Calcula la duración aproximada del viaje en horas.
-manageResources(int combustible, int oxigeno): Verifica si los recursos ingresados son válidos.
4. Gestión de recursos:

-obtenerCapacidadMaximaNave(double velocidadNave): Devuelve la capacidad máxima de pasajeros según la nave seleccionada.
-obtenerCapacidadMaximaCombustibleYOxigeno(double velocidadNave): Devuelve los límites máximos de combustible y oxígeno según la nave seleccionada.
5. Eventos aleatorios:

-Agujero de Gusano: Reduce el tiempo del viaje.
-Piratas Espaciales: Roban recursos.
-Lluvia de Meteoritos: Aumenta el tiempo de viaje.
-Zona de Bajas Temperaturas: Reduce la velocidad y aumenta el consumo de recursos.
-Salvar a Laika: Premia o penaliza según la decisión del usuario.

##Cálculos Implementados
1. Consumo de Combustible:

-Un galón de combustible permite recorrer 5.000.000 km.
-El cálculo se realiza dinámicamente según la distancia recorrida


2. Consumo de Oxígeno:

-Un tanque de oxígeno alcanza para 10 pasajeros por día.
-El cálculo depende del número de pasajeros y días transcurridos


##Cómo Jugar
1. Selecciona un planeta de destino.
2. Elige una nave espacial con características específicas.
3. Configura los recursos: combustible y oxígeno.
4. Comienza el viaje y enfrenta los eventos aleatorios:
5. Toma decisiones clave que afectarán el progreso del viaje.
6. Administra eficientemente los recursos para llegar al destino.

## Autores

**Marlon Xavier Delgado Ruiz**  
- GitHub: [MarlonXDelgado](https://github.com/MarlonXDelgado)  
- Correo: [marlonxavi6@gmail.com]

**KEVIN ESTEBAN SANCHEZ MENDEZ**  
- GitHub: [osamu993](https://github.com/osamu993)  
- Correo: [kevinesmms@gmail.com]

## Contacto

Si tienes preguntas o sugerencias, no dudes en contactarnos a través del correo o abrir un issue en el repositorio.




