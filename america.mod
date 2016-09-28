

param n, integer;
set V := 1..n;
set vOrigen := 11..11;
set vSinOrigen := V diff vOrigen;
/*Armo un set de tamanio nxn*/
set E, within V cross V;
param  horasDeViajePorKilometro := 6/1000;
param c{(i,j) in E};

var x{(i,j) in E}, binary;
var w{(i,j) in E: i!=11 and j!=11}, binary;
var horasViajeInicial >= 0;
var horasViajeAcumulado{i in vSinOrigen} >= 0;
var horasEstadiaAcumuladas{i in vSinOrigen} >= 0;
var horasAcumuladasHastaLlegarA{i in vSinOrigen};

/*Esta variable es entera, pero no es necesaria definirla como tal*/
var u{i in vSinOrigen} >= 1;

minimize total: sum{(i,j) in E} c[i,j] * x[i,j];

s.t. uMaximo{i in vSinOrigen}:
	u[i] <= n-1;

s.t. soloSalgoUnaVez{i in V}: sum{(i,j) in E: i != j} x[i,j] = 1;

s.t. soloEntroUnaVez{j in V}: sum{(i,j) in E: i != j} x[i,j] = 1;	

s.t. noSubTour{i in vSinOrigen, j in vSinOrigen: i!=j}:
  u[i]-u[j] + n*x[i,j] <= n - 1;

s.t. visitoAntesIqueJ{i in vSinOrigen, j in vSinOrigen: i != j}:
	u[i] <= u[j] + 100*(1-w[i,j]);

s.t. visitoAntesJqueI{i in vSinOrigen, j in vSinOrigen: i != j}:
	u[j] <= u[i] + 100*w[i,j];

/*5 dias*24horas/dia*/
/*Esta estadia en cada lugar no es la pedida por el problema*/
s.t. tiemposDeEstadia{j in vSinOrigen}:
	horasEstadiaAcumuladas[j] = sum{i in vSinOrigen: i!=j} 5*24 * w[i,j] + 24*5;

s.t. tiempoViajeInicial:
	horasViajeInicial = sum{(i,j) in E: i = 11} c[i,j] * x[i,j] * horasDeViajePorKilometro;

s.t. tiempoViajeAcumulado{j in vSinOrigen}:
	horasViajeAcumulado[j] = sum{i in vSinOrigen: i != j} w[i,j]*c[i,j]*horasDeViajePorKilometro + horasViajeInicial;

s.t. tiempoTotal{i in vSinOrigen}:
	horasAcumuladasHastaLlegarA[i] = horasViajeAcumulado[i] + horasEstadiaAcumuladas[i];

s
solve;



printf "El largo del tour optimo es de %d km\n",
   sum{(i,j) in E} c[i,j] * x[i,j];
printf("Nodo de partida   Nodo destino   Distancia\n");
printf{(i,j) in E: x[i,j]} "      %3d       %3d   %8g\n",
   i, j, c[i,j];

data;

param n := 12;
/*
Argentina. Buenos Aires = 1
Bolivia. Sucre = 2
Brasil. Brasalia = 3
Chile. Santiago = 4
Colombia. Bogota = 5
Ecuador. Quito = 6
Guyana. Georgetown = 7
Paraguay. Asuncian = 8
Peru. Lima = 9
Surinam. Paramaribo = 10
Uruguay. Montevideo = 11
Venezuela. Caracas = 12
*/
param : E : c :=
1 2 1861.0
1 3 2340.0
1 4 1137.0
1 5 4662.0
1 6 4360.0
1 7 4606.0
1 8 1038.0
1 9 3139.0
1 10 4515.0
1 11 204.0
1 12 5096.0
2 1 1861.0
2 3 1874.0
2 4 1692.0
2 5 2801.0
2 6 2543.0
2 7 2977.0
2 8 1049.0
2 9 1481.0
2 10 2982.0
2 11 1973.0
2 12 3288.0
3 1 2340.0
3 2 1874.0
3 4 3011.0
3 5 3665.0
3 6 3777.0
3 7 2753.0
3 8 1463.0
3 9 3167.0
3 10 2537.0
3 11 2273.0
3 12 3591.0
4 1 1137.0
4 2 1692.0
4 3 3011.0
4 5 4250.0
4 6 3786.0
4 7 4668.0
4 8 1551.0
4 9 2469.0
4 10 4669.0
4 11 1340.0
4 12 4905.0
5 1 4662.0
5 2 2801.0
5 3 3665.0
5 4 4250.0
5 6 730.0
5 7 1779.0
5 8 3771.0
5 9 1880.0
5 10 2099.0
5 11 4771.0
5 12 1028.0
6 1 4360.0
6 2 2543.0
6 3 3777.0
6 4 3786.0
6 5 730.0
6 7 2391.0
6 8 3579.0
6 9 1324.0
6 10 2680.0
6 11 4494.0
6 12 1755.0
7 1 4606.0
7 2 2977.0
7 3 2753.0
7 4 4668.0
7 5 1779.0
7 6 2391.0
7 8 3571.0
7 9 2958.0
7 10 346.0
7 11 4635.0
7 12 1043.0
8 1 1038.0
8 2 1049.0
8 3 1463.0
8 4 1551.0
8 5 3771.0
8 6 3579.0
8 7 3571.0
8 9 2514.0
8 10 3477.0
8 11 1069.0
8 12 4105.0
9 1 3139.0
9 2 1481.0
9 3 3167.0
9 4 2469.0
9 5 1880.0
9 6 1324.0
9 7 2958.0
9 8 2514.0
9 10 3133.0
9 11 3295.0
9 12 2745.0
10 1 4515.0
10 2 2982.0
10 3 2537.0
10 4 4669.0
10 5 2099.0
10 6 2680.0
10 7 346.0
10 8 3477.0
10 9 3133.0
10 11 4528.0
10 12 1387.0
11 1 204.0
11 2 1973.0
11 3 2273.0
11 4 1340.0
11 5 4771.0
11 6 4494.0
11 7 4635.0
11 8 1069.0
11 9 3295.0
11 10 4528.0
11 12 5166.0
12 1 5096.0
12 2 3288.0
12 3 3591.0
12 4 4905.0
12 5 1028.0
12 6 1755.0
12 7 1043.0
12 8 4105.0
12 9 2745.0
12 10 1387.0
12 11 5166.0
;

end;
