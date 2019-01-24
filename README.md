# TP-Viajante

Problema del Viajante (Modelos y Optimización I)

## Generar soluciones para los modelos

```bash
 $ glpsol --math europa.mod -o europa.sol

 $ glpsol --math america.mod -o america.sol

 $ glpsol --math parteB.mod -o parteB.sol
```

## Correr la heurística del Viajante

### NN

```bash
$ cd HeuristicaViajanteNN

$ ant
```

### MST

```bash
$ cd HeuristicaViajanteMST

$ ant
```

