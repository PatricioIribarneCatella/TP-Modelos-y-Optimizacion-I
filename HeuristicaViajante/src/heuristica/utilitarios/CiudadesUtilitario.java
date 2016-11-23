package heuristica.utilitarios;

import java.util.LinkedList;

public abstract class CiudadesUtilitario {

    private static String[] ciudadesEnStringAmerica = {"Buenos-Aires", "Sucre", "Brasilia", "Santiago", "Bogotá",
            "Quito", "Georgetown", "Asunción", "Lima", "Paramaribo", "Montevideo", "Caracas"};

    private static String[] ciudadesEnStringAmericaABSU = {"Buenos-Aires", "Santiago", "Brasilia", "Montevideo"};

    private static String[] ciudadesEnStringEuropa = {"Tirana", "Andorra-la-Vella", "Vienna", "Minsk",
            "Brussels", "Sarajevo", "Sofia", "Zagreb", "Nicosia", "Prague", "Copenhagen", "Tallinn", "Torshavn",
            "Helsinki", "Paris", "Berlin", "Gibraltar", "Athens", "St-Peter-Port", "Budapest", "Reykjavik", "Dublin",
            "Douglas", "Rome", "Saint-Helier", "Pristina", "Riga", "Vaduz", "Vilnius", "Luxembourg", "Skopje",
            "Valletta", "Chisinau", "Monaco", "Podgorica", "Amsterdam", "Oslo", "Warsaw", "Lisbon", "Bucharest",
            "Moscow", "San-Marino", "Belgrade", "Bratislava", "Ljubljana", "Madrid", "Longyearbyen", "Stockholm",
            "Berne", "Kiev", "London", "Vatican"};

    public static String transformarAString(LinkedList<Integer> ciudades, String[] ciudadesEnString) {

        StringBuilder sb = new StringBuilder();

        for (Integer ciudad : ciudades) {
            sb.append(ciudadesEnString[ciudad]);
            sb.append(" ");
        }

        return sb.toString();
    }

    public static String transformarCiudadesEuropeas(LinkedList<Integer> ciudades) {

        return transformarAString(ciudades, ciudadesEnStringEuropa);
    }

    public static String transformarCiudadesDeAmerica(LinkedList<Integer> ciudades) {

        return transformarAString(ciudades, ciudadesEnStringAmerica);
    }

    public static String transformarCiudadesDeAmericaABCU(LinkedList<Integer> ciudades) {

        return transformarAString(ciudades, ciudadesEnStringAmericaABSU);
    }
}
