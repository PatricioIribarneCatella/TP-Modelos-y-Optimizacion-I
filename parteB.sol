Problem:    parteB
Rows:       7
Columns:    5
Non-zeros:  15
Status:     OPTIMAL
Objective:  personasAtraidas = 804210.5263 (MAXimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 definicionDineroGastado
                    NS             0            -0             =   -0.00551378 
     2 definicionPublicistasOcupados
                    NS             0            -0             =      -794.486 
     3 limiteDinero NU         1e+08                       1e+08    0.00551378 
     4 limitePublicistas
                    NU           300                         300       794.486 
     5 limiteTiempoMaximoDeTelevision
                    NU          1000                        1000       14.4862 
     6 graficaParaCadaCapital
                    B        4747.37            10               
     7 personasAtraidas
                    B         804211                             

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 dineroGastado
                    B          1e+08             0               
     2 publicistasOcupados
                    B            300             0               
     3 cantidadDeGraficas
                    B        4747.37             0               
     4 segundosDeTelevision
                    B           1000             0               
     5 cantidadDeEventos
                    B        52.6316             0               

Karush-Kuhn-Tucker optimality conditions:

KKT.PE: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.DE: max.abs.err = 0.00e+00 on column 0
        max.rel.err = 0.00e+00 on column 0
        High quality

KKT.DB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
