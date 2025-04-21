package io.github.tiagoadmstz.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.tiagoadmstz.EfdFile;
import io.github.tiagoadmstz.blocks.zero.AberturaArquivoDigital;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class EfdCommons {

    private final EfdFile efdFile;

    public EfdCommons(EfdFile efdFile) {
        this.efdFile = efdFile;
    }

    public void writeToExcel(String filePath) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            efdFile.getAberturaArquivoDigital().createSheet(workbook);
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        }
    }

    public void writeToTxtFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            //writer.write(toTxtFormat());
        }
    }

    private String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public void writeToJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), this);
    }
}
