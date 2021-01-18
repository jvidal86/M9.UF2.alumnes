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

## Condicions de  costats (*Boundary*)


