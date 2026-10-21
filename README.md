# Laboratorio 02: Errores de ejecución en Java

## Objetivo
Distinguir los errores de compilación de los fallos que aparecen al ejecutar un programa Java. Identificar la excepción, el mensaje y la línea de origen a partir del *stack trace*.

**Requisitos:** JDK 21 y Apache Maven 3.9+.

## Preparación

```bash
java -version
mvn -version
mvn clean compile
```

El proyecto **compila sin errores**. Cada escenario se ejecuta individualmente. Los ejemplos son intencionalmente defectuosos y **no incluyen `try/catch`**: ese será el tema de un laboratorio posterior.

## Ejecución

```bash
mvn exec:java -Dexec.args=1
```

Cambie `1` por el número de caso (1–7). Maven puede informar `BUILD FAILURE` porque la excepción no se captura: **es el resultado esperado**.

Para ver una traza ampliada, ejecute:

```bash
mvn -e exec:java -Dexec.args=1
```

También puede ejecutar `Laboratorio.main()` desde IntelliJ IDEA, Eclipse o VS Code y pasar un argumento de programa con el número del caso.

## Casos

| Caso | Operación | Resultado esperado |
|---|---|---|
| 1 | División entera entre cero | `ArithmeticException` |
| 2 | Invocar método sobre referencia `null` | `NullPointerException` |
| 3 | Acceder al índice 3 de arreglo de 3 elementos | `ArrayIndexOutOfBoundsException` |
| 4 | Convertir `12O0` a entero | `NumberFormatException` |
| 5 | Convertir un `String` a `Integer` mediante cast | `ClassCastException` |
| 6 | Eliminar de una lista durante un `for-each` | `ConcurrentModificationException` |
| 7 | Recursión infinita | `StackOverflowError` (es un `Error`, no una `Exception`) |

**Precaución:** el caso 7 consume la pila hasta agotarla; ejecútelo aisladamente. No use este código en producción.

## Guía para cada caso

1. Prediga qué ocurrirá antes de ejecutarlo.
2. Compile el proyecto. ¿Por qué el compilador acepta el código?
3. Ejecute únicamente el caso seleccionado.
4. Anote el nombre de la excepción/error, su mensaje y la línea donde se origina.
5. Explique la diferencia entre la causa del fallo y su síntoma.
6. Corrija la causa y vuelva a ejecutar. No añada `try/catch` todavía.

## Soluciones orientativas (para el docente)

- **1:** verificar `cuotas != 0` antes de dividir.
- **2:** inicializar `cliente` o verificar que no sea `null`.
- **3:** comprobar `indice >= 0 && indice < movimientos.length`.
- **4:** corregir el dato o validarlo antes de convertirlo.
- **5:** comprobar `dato instanceof Integer` o utilizar el tipo correcto.
- **6:** usar `Iterator.remove()`, `removeIf(...)` o eliminar después de iterar.
- **7:** definir una condición de terminación de la recursión.

## Retos

**Reto 1:** haga que los casos 1, 2 y 3 terminen correctamente mediante validaciones, sin capturar excepciones.

**Reto 2:** escriba una nueva operación que compile, pero produzca `StringIndexOutOfBoundsException`. Explique cómo prevenirla.

**Reto 3:** explique por qué `StackOverflowError` no debe tratarse como una excepción de negocio recuperable.

## Preguntas de discusión

- ¿Qué diferencia hay entre compilar correctamente y funcionar correctamente?
- ¿Qué partes del *stack trace* ayudan a localizar el problema?
- ¿Todas las excepciones implican un fallo de infraestructura?
- ¿Cuál es la diferencia entre `Exception` y `Error`?

## Próximo laboratorio

Laboratorio 03: errores de lógica — programas que compilan y se ejecutan, pero entregan resultados incorrectos.
