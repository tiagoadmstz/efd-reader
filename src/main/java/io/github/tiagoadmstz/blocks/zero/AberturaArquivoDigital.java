package io.github.tiagoadmstz.blocks.zero;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Objects;

@Data
public class AberturaArquivoDigital implements EfdBlockPart {

    @JsonProperty("registro")
    private String register = "0000";
    @JsonProperty("versao")
    private String codVer;
    @JsonProperty("tipo-escrita")
    private String tipoEscrit;
    @JsonProperty("ind-sit-esp")
    private String indSitEsp;
    @JsonProperty("numero-rec-anterior")
    private String numRecAnterior;
    @JsonProperty("data-inicio")
    private LocalDate dtIni;
    @JsonProperty("data-final")
    private LocalDate dtFin;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("cnpj")
    private String cnpj;
    @JsonProperty("uf")
    private String uf;
    @JsonProperty("codigo-municipio")
    private String codMun;
    @JsonProperty("suframa")
    private String suframa;
    @JsonProperty("ind-nat-pessoa-juridica")
    private String indNatPJ;
    @JsonProperty("ind-ativo")
    private String indAtiv;

    public String[] headers() {
        return new String[]{"Reg", "CodVer", "TipoEscrit", "IndSitEsp", "NumRecAnterior", "DtIni", "DtFin", "Nome", "CNPJ", "UF", "CodMun", "Suframa", "IndNatPJ", "IndAtiv"};
    }

    public Sheet createSheet(final Workbook workbook) {
        final Sheet sheet = workbook.createSheet(register);
        addsHeaders(sheet);
        addsValues(sheet);
        return sheet;
    }

    private void addsHeaders(final Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        final String[] headers = headers();
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
    }

    private void addsValues(final Sheet sheet) {
        final Row dataRow = sheet.createRow(1);
        try {
            final Field[] declaredFields = getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                declaredFields[i].setAccessible(true);
                final Object value = declaredFields[i].get(this);
                dataRow.createCell(i).setCellValue(Objects.nonNull(value) ? value.toString() : "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        dataRow.createCell(0).setCellValue(aberturaArquivoDigital.getRegister());
//        dataRow.createCell(1).setCellValue(aberturaArquivoDigital.getCodVer());
//        dataRow.createCell(2).setCellValue(aberturaArquivoDigital.getTipoEscrit());
//        dataRow.createCell(3).setCellValue(aberturaArquivoDigital.getIndSitEsp());
//        dataRow.createCell(4).setCellValue(aberturaArquivoDigital.getNumRecAnterior());
//        dataRow.createCell(5).setCellValue(aberturaArquivoDigital.getDtIni());
//        dataRow.createCell(6).setCellValue(aberturaArquivoDigital.getDtFin());
//        dataRow.createCell(7).setCellValue(aberturaArquivoDigital.getNome());
//        dataRow.createCell(8).setCellValue(aberturaArquivoDigital.getCnpj());
//        dataRow.createCell(9).setCellValue(aberturaArquivoDigital.getUf());
//        dataRow.createCell(10).setCellValue(aberturaArquivoDigital.getCodMun());
//        dataRow.createCell(11).setCellValue(aberturaArquivoDigital.getSuframa());
//        dataRow.createCell(12).setCellValue(aberturaArquivoDigital.getIndNatPJ());
//        dataRow.createCell(13).setCellValue(aberturaArquivoDigital.getIndAtiv());
    }
}
