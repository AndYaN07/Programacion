# 🧠 Comparación de vocabularios con conjuntos

## Descripción

Dadas **dos cadenas de texto**, se debe escribir una función que devuelva la siguiente información:

1. Las **palabras únicas** de cada texto.
2. Las **palabras en común** entre ambos textos.
3. **Todas las palabras** de ambos textos **ordenadas alfabéticamente**, sin duplicados.



## Requisitos

- Utilizar las funciones y estructuras de JAVA.  (En Python serian **`set()`** y **`sorted()`**) para resolver el ejercicio.


## Ejemplo

**Entrada:**

```java
texto1 = "el gato negro corre rápido"
texto2 = "el perro marrón corre lento"

```

**Salida esperada:**

```
Palabras únicas en texto1: {'negro', 'rápido', 'gato'}
Palabras únicas en texto2: {'marrón', 'perro', 'lento'}
Palabras en común: {'el', 'corre'}
Todas las palabras ordenadas: ['corre', 'el', 'gato', 'lento', 'marrón', 'negro', 'perro', 'rápido']

