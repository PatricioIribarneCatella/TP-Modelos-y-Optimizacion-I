/*Parte B*/

param pDineroDisponible := 100000000;
param pCantidadDeCapitales := 10;
param pCostoGrafica := 20000;
param pCostoEvento := 1000;
param pCostoSegundoTele := 5000;
param pAtraidosPorGrafica := 150;
param pAtraidosPorSegundoTele := 50;
param pAtraidosPorEvento := 800	;
param pPublicistasPorEvento := 1;
param pPublicistasCada100SegundosTele := 1;
param pPublicistasPorSegundoTele:= 0.01;
param pPublicistasCada20Graficas := 1;
param pPublicistasPorGrafica:= 0.05;
param pPublicistasDisponibles := 300;
param tiempoMaximoDeTelevision := 1000;

#variables auxiliares

var dineroGastado >= 0;
var publicistasOcupados >= 0;

#variables del problema

var cantidadDeGraficas >= 0;
var segundosDeTelevision >= 0;
var cantidadDeEventos >= 0;
#limitaciones

#Uso de recursos

s.t. definicionDineroGastado:
dineroGastado = cantidadDeGraficas*pCostoGrafica + cantidadDeEventos*pCostoEvento + segundosDeTelevision*pCostoSegundoTele;
s.t. definicionPublicistasOcupados:
publicistasOcupados = cantidadDeGraficas*pPublicistasPorGrafica + cantidadDeEventos*pPublicistasPorEvento +     segundosDeTelevision*pPublicistasPorSegundoTele;


#Limitacion de recursos

s.t. limiteDinero: dineroGastado <= pDineroDisponible;
s.t. limitePublicistas: publicistasOcupados <= pPublicistasDisponibles;
s.t. limiteTiempoMaximoDeTelevision: segundosDeTelevision <= tiempoMaximoDeTelevision;

#Minimo de graficas:

s.t. graficaParaCadaCapital: cantidadDeGraficas >= pCantidadDeCapitales;

#Funcion a maximizar

maximize personasAtraidas: cantidadDeGraficas*pAtraidosPorGrafica + cantidadDeEventos*pAtraidosPorEvento +   									 segundosDeTelevision*pAtraidosPorSegundoTele;
solve;

end;

