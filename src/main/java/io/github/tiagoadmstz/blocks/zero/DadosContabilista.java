package io.github.tiagoadmstz.blocks.zero;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.util.List;

// Registro 0100: Dados do Contabilista
@Data
public class DadosContabilista implements EfdBlockPart {

    private String register = "0100";
    private String nome;
    private Number cpf;
    private String crc;
    private Number cnpj;
    private Number cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String fone;
    private String fax;
    private String email;
    private Number codMun;

    @Override
    public void setByLine(List<String> blockLines) {
        final List<String> valuesLine = getValuesLine(blockLines, register);
        if (!valuesLine.isEmpty()) setByLine(valuesLine.getFirst());
    }

    @Override
    public void setByLine(final String valuesLine) {
        final String[] values = splitLine(valuesLine);
        nome = parseString(values[2]);
        cpf = parseNumber(values[3]);
        crc = parseString(values[4]);
        cnpj = parseNumber(values[5]);
        cep = parseNumber(values[6]);
        endereco = parseString(values[7]);
        numero = parseString(values[8]);
        complemento = parseString(values[9]);
        bairro = parseString(values[10]);
        fone = parseString(values[11]);
        fax = parseString(values[12]);
        email = parseString(values[13]);
        codMun = parseNumber(values[14]);
    }
}
