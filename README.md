# TP-Viajante

Problema del Viajante (Modelos y Optimización I)

## Generar soluciones para los modelos

$ glpsol --math europa.mod -o europa.sol

$ glpsol --math america.mod -o america.sol

$ glpsol --math parteB.mod -o parteB.sol

## Correr la heurística del Viajante

### NN

$ cd HeuristicaViajanteNN

$ ant

### MST

$ cd HeuristicaViajanteMST

$ ant
