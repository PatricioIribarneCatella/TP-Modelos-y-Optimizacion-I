from geopy.distance import great_circle

capitalesEur =[
# Albania 	Tirana
[41.33, 19.82],
# Andorra 	Andorra la Vella
[42.51, 	1.52],
# Austria 	Vienna
[48.21,	16.37],
# Belarus 	Minsk
[53.90,	27.57],
# Belgium 	Brussels
[50.85,	4.35],
# Bosnia and Herzegovina 	Sarajevo
[43.85, 	18.36],
# Bulgaria 	Sofia
[42.70, 	23.32],
# Croatia 	Zagreb
[45.81, 	15.98],
# Cyprus 	Nicosia
[35.17, 	33.37],
# Czech Republic 	Prague
[50.09, 	14.42],
# Denmark 	Copenhagen
[55.68, 	12.57],
# Estonia 	Tallinn
[59.44, 	24.75],
# Faroe Islands 	Torshavn
[62.01, 	-6.77],
# Finland 	Helsinki
[60.17, 	24.94],
# France 	Paris
[48.85, 	2.35],
# Germany 	Berlin
[52.52, 	13.41],
# Gibraltar 	Gibraltar
[36.14, 	-5.35],
# Greece 	Athens
[37.98, 	23.72],
# Guernsey 	St Peter Port
[49.46, 	-2.54],
# Hungary 	Budapest
[47.50, 	19.04],
# Iceland 	Reykjavik
[64.14, 	-21.90],
# Ireland 	Dublin
[53.33, 	-6.25],
# Isle of Man 	Douglas
[54.15, 	-4.48],
# Italy 	Rome
[41.89, 	12.48],
# Jersey 	Saint Helier
[49.19, 	-2.10],
# Kosovo 	Pristina
[42.67, 	21.17],
# Latvia 	Riga
[56.95, 	24.11],
# Liechtenstein 	Vaduz
[47.14, 	9.52],
# Lithuania 	Vilnius
[54.69, 	25.28],
# Luxembourg 	Luxembourg
[49.61, 	6.13],
# Macedonia 	Skopje
[42.00, 	21.43],
# Malta 	Valletta
[35.90, 	14.51],
# Moldova 	Chisinau
[47.01, 	28.86],
# Monaco 	Monaco
[43.73, 	7.42],
# Montenegro 	Podgorica
[42.44, 	19.26],
# Netherlands 	Amsterdam
[52.37, 	4.89],
# Norway 	Oslo
[59.91, 	10.75],
# Poland 	Warsaw
[52.23, 	21.01],
# Portugal 	Lisbon
[38.72, 	-9.13],
# Romania 	Bucharest
[44.43, 	26.11],
# Russia 	Moscow
[55.75, 	37.62],
# San Marino 	San Marino
[43.94, 	12.45],
# Serbia 	Belgrade
[44.80, 	20.47],
# Slovakia 	Bratislava
[48.15, 	17.11],
# Slovenia 	Ljubljana
[46.05, 	14.51],
# Spain 	Madrid
[40.42, 	-3.70],
# Svalbard and Jan Mayen 	Longyearbyen
[78.22, 	15.64],
# Sweden 	Stockholm
[59.33, 	18.06],
# Switzerland 	Berne
[46.95, 	7.45],
# Ukraine 	Kiev
[50.45, 	30.52],
# United Kingdom 	London
[51.51, 	-0.13],
# Vatican 	Vatican
[41.90, 	12.45]]


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

capitalesSud = [ARG, BOL, BRA, CHI, COL, ECU, GUA, PAR, PER, SUR, URU, VEN]

print "Distancia entre las ciudades de Europa"

for i,item1 in enumerate(capitalesEur):
    for j,item2 in enumerate(capitalesEur):
        if(i != j):
            print i+1,j+1, round(great_circle(item1, item2).km)
    print ""

print "Distancia entre las ciudades de Sudamerica"

for i,item1 in enumerate(capitalesSud):
    for j,item2 in enumerate(capitalesSud):
        if(i != j):
            print i+1,j+1, round(great_circle(item1, item2).km)
    print ""