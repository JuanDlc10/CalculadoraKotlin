# Manual de Uso - Calculadora en Kotlin

Este manual describe el funcionamiento de una calculadora implementada en Kotlin que permite realizar operaciones aritméticas básicas: **Suma, Resta, Multiplicación y División**. Para ello, utiliza dos botones y un `Spinner` que actúa como selector de operaciones.

## Descripción de la Actividad

La calculadora permite al usuario realizar cálculos básicos entre dos números. La interfaz incluye:
- Un `Spinner` para seleccionar la operación aritmética.
- Un botón para **regresar** al menú principal.
- Un botón para **mostrar el resultado** de la operación seleccionada.

## Componentes Principales

### 1. Función Principal `onCreate`

La función `onCreate` es la encargada de cargar la vista de la actividad y asignar los valores necesarios a los elementos de la interfaz. Esto se logra mediante la instrucción `setContentView(R.layout.activity_calculadora)`.

#### Asignación de Elementos de la Vista

Cada componente se vincula a través de su ID en el archivo de diseño XML, permitiendo un acceso directo en el código:
- **Botón de Regreso** (`boton`): Permite regresar al menú principal.
- **Botón de Resultado** (`boton2`): Muestra el resultado de la operación seleccionada.
- **Spinner de Operaciones** (`operaciones`): Permite al usuario seleccionar entre las operaciones de Suma, Resta, Multiplicación y División.

### 2. Configuración del Spinner

El `Spinner` se configura utilizando un `ArrayAdapter` que contiene una lista de operaciones (`Suma`, `Resta`, `Multiplicar`, `Dividir`). Este adaptador permite desplegar las opciones dentro del `Spinner` cuando el usuario hace clic en él.

### 3. Funcionalidad de los Botones

#### Botón de Regreso

El botón de regreso llama a la función `retornar()`, la cual redirige al usuario al menú principal, utilizando una **navegación** a la actividad `Home`.

#### Botón de Resultado

El botón de resultado llama a la función `calculadora()`, que toma los valores ingresados por el usuario, verifica la validez de los datos y, luego, realiza la operación seleccionada en el `Spinner`.

## Funciones Detalladas

### Función `retornar()`

Esta función crea una **intención** (Intent) para regresar a la actividad `Home`. Al ser llamada por el botón de regreso, permite al usuario volver al menú principal.

### Función `calculadora()`

1. **Ingreso de Datos**: Solicita dos números al usuario mediante `EditText` (`numero1` y `numero2`).
2. **Validación de Datos**: Comprueba que los datos ingresados sean válidos (números). Si alguno es nulo, muestra un mensaje de advertencia.
3. **Operación Seleccionada**: Obtiene la operación seleccionada en el `Spinner` y, mediante una estructura `when`, ejecuta la operación correspondiente llamando a funciones específicas:
   - `sumar`: Realiza la suma.
   - `restar`: Realiza la resta.
   - `multiplicar`: Realiza la multiplicación.
   - `dividir`: Realiza la división.
4. **Mostrar Resultado**: Muestra el resultado en un cuadro de diálogo personalizado (`AlertDialog`) que contiene:
   - **Título**: La operación seleccionada.
   - **Mensaje**: El resultado de la operación.

### Funciones de Operación Aritmética

Estas funciones ejecutan la operación correspondiente entre los dos números ingresados y devuelven el resultado.

- `sumar(numero1: Double, numero2: Double): Double`
- `restar(numero1: Double, numero2: Double): Double`
- `multiplicar(numero1: Double, numero2: Double): Double`
- `dividir(numero1: Double, numero2: Double): Double`

Cada una de estas funciones realiza su operación respectiva y se utiliza en la función `calculadora()` para obtener el resultado final.

## Mensaje de Diálogo

El mensaje de resultado se muestra en un diálogo personalizado (`AlertDialog`) que contiene:
- **Título**: Nombre de la operación.
- **Mensaje**: El resultado de la operación.
- **Botones de Confirmación y Cancelación**: Permiten cerrar el cuadro de diálogo.

## Navegación Inferior (`BottomNavigationView`)

La aplicación también incluye un menú de navegación inferior (`BottomNavigationView`) con dos opciones:
1. **Home**: Redirige al usuario a la pantalla principal (`Home`).
2. **Calculadora**: Vuelve a la calculadora.

Cada opción del menú está programada para realizar una acción mediante `Intent`.

## Resumen

La calculadora en Kotlin es una herramienta simple y efectiva que permite realizar cálculos básicos con una interfaz intuitiva y de fácil navegación. Utiliza un `Spinner` para seleccionar la operación deseada y muestra los resultados en un cuadro de diálogo claro y bien estructurado.
