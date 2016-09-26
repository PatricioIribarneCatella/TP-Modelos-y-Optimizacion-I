#Argentina. Buenos Aires
# -34.61 	-58.38
#Bolivia. Sucre
# -19.03 	-65.26
#Brasil. Brasalia
# -15.78 	-47.93
#Chile. Santiago
# -33.46 	-70.65
#Colombia. Bogota
# 4.61 	-74.08
#Ecuador. Quito
# -0.23 	-78.52
#Guyana. Georgetown
#6.80 	-58.16
#Paraguay. Asuncian
#-25.30 	-57.64
#Peru. Lima
# 	-12.04 	-77.03
#Surinam. Paramaribo
#5.87 	-55.17
#Uruguay. Montevideo
# 	-34.83 	-56.17
#Venezuela. Caracas
# 	10.49 	-66.88

from geopy.distance import great_circle
ciudad = list
ARG = [-34.61, -58.38]
BOL = [-19.03, -65.26]
BRA = [-15.78, -47.93]
CHI = [-33.46, -70.65]
COL = [4.61, -74.08]
ECU = [-0.23, -78.52]
GUA = [6.80, -58.16]
PAR = [-25.30, -57.64]
PER = [-12.04, -77.03]
SUR = [5.87, -55.17]
URU = [-34.83, -56.17]
VEN = [10.49, -66.88]

ciudad = [ARG, BOL, BRA, CHI, COL, ECU, GUA, PAR, PER, SUR, URU, VEN]

for i,item1 in enumerate(ciudad):
    for j,item2 in enumerate(ciudad):
        if(i != j):
            print i+1,j+1, round(great_circle(item1, item2).km)
