# M9-UF2: Projecte Difusió del Calor 

## Introducció

La difusió del calor és un procés fonamental en la Física.
Tot i existir solucions matemàtiques exactes, sovint en el món real no és poden obtenir i s'ha de recórrer a les **simulacions**.
Aquestes simulacions en ordenadors poden ser *computacionalment intenses* i acaben requerint de càlculs en paral·lel.



![Imatge](https://demonstrations.wolfram.com/ACellularAutomatonBasedHeatEquation/img/popup_3.png)

### Demostració online

[Wolfram Demonstrations: Heat Equation Cellular Automata](https://demonstrations.wolfram.com/ACellularAutomatonBasedHeatEquation/)


## La Difusió en una *Lattice*

Al tenir una lattice quadrada cada cel·la té 4 cel·les veïnes:
 - Nord: N
 - Sud: S
 - Est: E
 - Oest: W

L'operació de difusió per a cada cel·la és 

C = 1/4*N + 1/4*S + 1/4*E + 1/4*W


C(x,y) = 0.25*C(x,y-1) + 0.25*C(x,y+1) + 0.25*C(x-1,y) + 0.25*(x+1,y)

## Condicions de  costats (*Boundary*)

* O: sink (.), valor = 0.
* E: source (^), valor = 1.
* N i S: Reflector: quan y=0, llavors C(x,y-1) = C(x, y+1) i similar per al sud.
## Repartiment de càrrega de treball (paral·lelització en espai)


```txt
0 .*********^
1 .*********^
2 .*********^
3 .*********^
4 .*********^
5 .*********^
6 .*********^
7 .*********^
8 .*********^
9 .*********^
```

 ### Divisió en l'espai per files

```txt
1.0 .*********^
1.1 .*********^
1.2 .*********^

2.3 .*********^
2.4 .*********^
2.5 .*********^

3.6 .*********^
3.7 .*********^
3.8 .*********^
3.9 .*********^
```

# Codeificació en Java

## Semàfors

```java
synchronized (msg) {
    if (finished < 2) {
        finished++;
        System.out.printf("[%d] gonna wait, finished: %d\n", Thread.currentThread().getId(), finished);
        try {
            msg.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } else {
        System.out.printf("[%d] gonna notify\n", Thread.currentThread().getId());
        finished = 0;
        msg.notifyAll();
    }
}
```



