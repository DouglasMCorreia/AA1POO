/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dodog
 */
public class Main {
    public static void main(String[] args) {
        // Teste ConversorTemperaturaInstancia
        ConversorTemperaturaInstancia conversorInstancia = new ConversorTemperaturaInstancia();
        double tempF = conversorInstancia.celsiusParaFahrenheit(25);
        double tempC = conversorInstancia.fahrenheitParaCelsius(77);
        System.out.println("Conversor de Temperatura Instância:");
        System.out.println("25°C para Fahrenheit: " + tempF);
        System.out.println("77°F para Celsius: " + tempC);

        // Teste ConversorTemperaturaEstatico
        tempF = ConversorTemperaturaEstatico.celsiusParaFahrenheit(25);
        tempC = ConversorTemperaturaEstatico.fahrenheitParaCelsius(77);
        System.out.println("\nConversor de Temperatura Estático:");
        System.out.println("25°C para Fahrenheit: " + tempF);
        System.out.println("77°F para Celsius: " + tempC);

        // Teste ValidadorCPFCNPJ
        ValidadorCPFCNPJ validador = new ValidadorCPFCNPJ();
        String cpf = "123.456.789-09";
        String cnpj = "12.345.678/0001-95";
        System.out.println("\nValidação de CPF e CNPJ:");
        System.out.println("CPF " + cpf + " é válido? " + validador.validarCPF(cpf));
        System.out.println("CNPJ " + cnpj + " é válido? " + validador.validarCNPJ(cnpj));

        // Teste Passeio do Cavalo Sem Heurística
        PasseioCavaloSemHeuristica passeioSemHeuristica = new PasseioCavaloSemHeuristica();
        System.out.println("\nPasseio do Cavalo Sem Heurística:");
        passeioSemHeuristica.resolverPasseio();

        // Teste Passeio do Cavalo Com Heurística
        PasseioCavaloComHeuristica passeioComHeuristica = new PasseioCavaloComHeuristica();
        System.out.println("\nPasseio do Cavalo Com Heurística:");
        passeioComHeuristica.resolverPasseio();
    }
}
