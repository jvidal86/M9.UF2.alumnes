# Informació Adicional


* Web per a veure el com funciona els colors HSB
  
  [link](http://colorizer.org/)
  

* Inicialitar un array bidimensional en el codi font:

  [link](https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=233:arrays-arreglos-multidimensionales-en-java-declaracion-y-uso-ejemplos-y-ejercicios-resueltos-cu00905c&catid=58&Itemid=180)

  mireu a la part de Solució:
```java
int[][]  alumnosfxniveleidioma = {{7,14,8,3},{6,19,7,2},{3,13,4,1}};
```
![matriu](https://www.aprenderaprogramar.com/images/stories/Cursos/CU009/CU00905C.png)

# Codi

## Pseudocodi

* Necessitem 2 arrays bidimensional que contindran les dades de la difusio.
  * llegim de `source` i escrivim a `dest`.
  * A cada pas, haurem de canviar l'origen i el destí.
  * source i dest son references als arrays reals A i B.
  
```java
        A = new double[ample][alt];
        B = new double[ample][alt];

        double source[][];
        double dest[][]; //referencias a A i B

        source = B;
        dest = A;

        double val =  source[0][0]; // en realidad lee del array A[0][0]

        // 1r source = A; dest = B
        // 2n source = B; dest = A
        // 3r source = A; dest = B
        // 4t paso source = B; dest = A
        // 5o paso source = A; dest = B
```

* pseudocodi del pas de difusió
```java
        //bucle de pasos de difusio (los pasos)
        //si nPaso es par
        // source = A;
        // dest = B
        //sino
        // source = B;
        // dest = A;
        //fisi

        // pas de difusio
        // c(x,y) = 1/4*c(x-1,y)+.....
        //quina variable s'ha d'utilitzar?
        // source (llegir) i dest (escriure)
        ///B[x][y] = 1/4 * A[x-1][y] + ...
        //

```