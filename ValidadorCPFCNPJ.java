public class ValidadorCPFCNPJ {
    public boolean validarCPF(String cpf) {
        // Implementação simplificada para validação de CPF
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return false;

        // Validação dos dígitos verificadores
        // ...

        return true;
    }

    public boolean validarCNPJ(String cnpj) {
        // Implementação simplificada para validação de CNPJ
        cnpj = cnpj.replaceAll("[^0-9]", "");
        if (cnpj.length() != 14) return false;

        // Validação dos dígitos verificadores
        // ...

        return true;
    }
}
