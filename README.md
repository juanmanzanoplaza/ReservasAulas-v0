# Tarea Reservas de Aulas
## Profesor: Andr�s Rubio del R�o
## Alumno: Juan Antonio Manzano Plaza

La tarea va a consistir en modelar la gesti�n de reservas de aulas del IES Al-�ndalus. Despu�s de todas las especificaciones y requerimientos anotados, en ese primer spring de la aplicaci�n se ha decidido abarcar los siguientes:

- Hay unas aulas que se pueden reservar, aunque en este primer spring s�lo contemplaremos la reserva del sal�n de actos. Por tanto, un **aula** ser� identificada por su **nombre**, el cu�l no puede estar vac�o y tampoco se puede modificar dicho nombre una vez creada. Podremos crear nuevas aulas (siempre que no exista otra aula con el mismo nombre), borrarlas, buscar aulas por su nombre y listar las aulas.
- Los profesores podr�n realizar reservas. Un **profesor** se identifica por su **nombre**, su **correo electr�nico** (que debe ser correcto) y su **tel�fono**. El tel�fono puede proporcionarlo el profesor o no. Si lo indica ser� una cadena de 9 d�gitos y siempre debe comenzar por 6 o 9. Si no lo indica, no se asociar� ning�n tel�fono a dicho profesor. Una vez creado un profesor no se le podr� cambiar el nombre, pero s� se podr� cambiar su correo o su tel�fono, pudiendo ser este �ltimo vac�o. Podremos a�adir nuevos profesores (siempre que no exista otro profesor con el mismo nombre), borrarlos, buscar profesores por su nombre y listar los profesores dados de alta.
- Como en este primer spring s�lo contemplamos la reserva del sal�n de actos, �ste se podr� reservar para una **permanencia** de un **d�a** y para el **tramo** de ma�ana o tarde.
- Un **profesor** podr� **reservar** un **aula** para una **permanencia** dada. No se llevar� a cabo la reserva si para dicha permanencia y aula ya hay otra reserva dada de alta. Tambi�n podremos anular una reserva, buscar una reserva para un aula  permanencia dada y listar todas las reservas existentes. Tambi�n podremos listar las reservas que ha realizado un profesor, listar las reservas de un aula dada y listar las reservas para una permanencia concreta. C�mo no, tambi�n podremos consultar la disponibilidad de un aula para una permanencia dada.

Tu tarea consiste en realizar una aplicaci�n para gestionar la reserva de aulas para el IES Al-�ndalus. Con los conocimientos adquiridos hasta el momento realizaremos una implementaci�n basada en arrays para gestionar las colecciones. Aunque a�n no tenemos los conocimientos necesarios para aplicar el patr�n MVC, s� haremos una distinci�n entre la vista (encargada de interaccionar con el usuario) y el modelo (encargado de gestionar los datos) que dividiremos entre clases del dominio y las clases DAO que nos permiten interactuar con las colecciones.

Debes tener en cuenta el problema existente con las referencias, por lo que para cada clase que sea cliente de otra deber�s devolver referencias a objetos nuevos en los m�todos de acceso y tambi�n crear nuevas referencias a nuevos objetos cuando los vayamos a asignar a atributos. En los m�todos de las clases DAO tambi�n deber�s devolver una copia profunda de los elementos de la colecci�n en dicho m�todo de acceso.

Tambi�n siempre se deben validar todas los valores que se intentan asignar y si no lanzar una excepci�n adecuada para evitar inconsistencias en el estado de los objetos.

Para ello te pongo un diagrama de clases para el mismo y poco a poco te ir� explicando los diferentes pasos a realizar:

![Diagrama de clases para reservasaulas](src/main/resources/reservasAulas.png)

He subido a GitHub un esqueleto de proyecto gradle que ya lleva incluidos todos los test necesarios que el programa debe pasar. Dichos test est�n todos comentados y deber�s ir descoment�ndolos conforme vayas avanzando con la tarea. La URL del repositorio es en la que te encuentras.

Por tanto, tu tarea va a consistir en completar los siguientes apartados:

1. Lo primero que debes hacer es realizar un **fork** del repositorio donde he colocado el proyecto gradle con la estructura del proyecto y todos los test necesarios.
2. Clona tu repositorio remoto reci�n copiado en github a un repositorio local que ser� donde ir�s realizando lo que a continuaci�n se te pide. A�ade tu nombre al fichero `README.md` en el apartado "Alumno". Haz tu primer commit.
3. Crea el enumerado `Tramo` con las siguientes constantes: `MANANA` y `TARDE`, en este orden. Haz un commit.
4. Crea la clase `Permanencia` con sus atributos especificados, los m�todos de acceso y modificaci�n con su visibilidad adecuada y el constructor con dos par�metros y copia tal y como se indica en el diagrama de clases. El formato de un d�a debe ser "dd/mm/aaaa".  Crea tambi�n los m�todos `equals`, `hashCode` y `toString`, teniendo en cuenta que dos permanencias ser�n iguales si son para el mismo d�a y para el mismo tramo. Haz un commit.
5. Crea la clase `Aula` con los atributos indicados, los m�todos de acceso y modificaci�n con su visibilidad adecuada y el constructor con un par�metro y copia tal y como se indica en el diagrama de clases. Crea tambi�n los m�todos `equals`, `hashCode` y `toString`, teniendo en cuenta que dos aulas ser�n iguales si sus nombres son los mismos. Haz un commit.
6. Crea la clase `Profesor` con los atributos indicados, los m�todos de acceso y modificaci�n con su visibilidad adecuada y el constructor con dos o tres par�metros y el constructor copia. Crea tambi�n los m�todos `equals`, `hashCode` y `toString`, teniendo en cuenta que dos profesores ser�n iguales si su nombre es el mismo. Haz un commit.
7. Crea la clase `Reserva` con los atributos indicados, los m�todos de acceso y modificaci�n con su visibilidad adecuada y el constructor con tres par�metros y copia tal y como se indica en el diagrama de clases. Crea también los m�todos `equals`, `hashCode` y `toString`, teniendo en cuenta que dos reservas ser�n iguales si el aula y la permanencia son iguales, independientemente del profesor. Haz un commit.
8. Crea la clase `Aulas` con los atributos indicados, los m�todos de acceso y modificaci�n con su visibilidad adecuada y el constructor por defecto y copia. Crea los m�todos `insertar`, `buscar`, `borrar` y `representar` apoy�ndote en los m�todos privados que se exponen en el diagrama de clases. Haz un commit.
9. Crea la clase `Profesores` con los atributos indicados, los m�todos de acceso y modificaci�n con su visibilidad adecuada y el constructor por defecto y copia. Crea los m�todos `insertar`, `buscar`, `borrar` y `representar` apoy�ndote en los m�todos privados que se exponen en el diagrama de clases. Haz un commit.
10. Crea la clase `Reservas` con los atributos indicados, los m�todos de acceso y modificaci�n con su visibilidad adecuada y el constructor por defecto y copia. Crea los m�todos `insertar`, `buscar`, `borrar`, `representar`, `getReservasAula`, `getReservasProfesor`, `getReservasPermanencia` y `consultarDisponibilidad` apoy�ndote en los m�todos privados que se exponen en el diagrama de clases. Haz un commit.
11. Crea la clase `ModeloReservasAulas` con los atributos indicados, los m�todos que se especifican en el diagrama y que simplemente llamar�n a cada uno de los m�todos de la clase DAO implicada. Haz un commit.
12. Crea el enumerado `Opcion` que ser� el encargado de representar el men� de opciones de nuestra aplicaci�n y que se adecue al diagrama de clases expuesto. Haz un commit.
13. Crea la clase `Consola` de ayuda, que ser� la encargada de realizar las diferentes lecturas de los objetos desde la consola. Recuerda evitar que se cree el constructor por defecto. Haz un commit.
14. Crea la clase `IUTextual` con los m�todos que se especifican y que ser� la encargada de ejecutar cada una de las opciones del men� de nuestra aplicaci�n. Haz un commit.
15. Crea una clase llamada `MainApp` que incluya un m�todo `main`. El m�todo `main` deber� mostrarnos un men� con las diferentes opciones y actuar en consecuencia. El men� se repetir� mientras no elijamos la opci�n salir. Haz un commit.



###### Se valorar�:
- La nomenclatura del repositorio de GitHub y del archivo entregado sigue las indicaciones de entrega.
- La indentaci�n debe ser correcta en cada uno de los apartados.
 -El nombre de las variables debe ser adecuado.
 - Se debe utilizar la clase Entrada para realizar la entrada por teclado.
 - El proyecto debe pasar todas las pruebas que van en el esqueleto del mismo y toda entrada del programa ser� validada para evitar que el programa termine abruptamente debido a una excepci�n.
 - Se deben utilizar los comentarios adecuados.
 - Se valorar� la correcci�n ortogr�fica tanto en los comentarios como en los mensajes que se muestren al usuario.

