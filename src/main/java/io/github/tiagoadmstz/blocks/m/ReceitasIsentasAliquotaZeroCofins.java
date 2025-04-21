package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro M800: Receitas Isentas, Não Alcançadas pela Incidência da Contribuição, Sujeitas a Alíquota Zero ou de Vendas Com Suspensão – Cofins.
 */
@Data
public class ReceitasIsentasAliquotaZeroCofins implements EfdBlockPart {

    private final String register = "M800";
    private String cstCofins;
    private BigDecimal vlTotRec;
    private String codCta;
    private String descCompl;
    private final List<DetalhamReceitasIsentasAliquotaZeroCofins> detalhamReceitasIsentasAliquotaZeroCofins;

    public ReceitasIsentasAliquotaZeroCofins() {
        this.detalhamReceitasIsentasAliquotaZeroCofins = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M810", detalhamReceitasIsentasAliquotaZeroCofins, DetalhamReceitasIsentasAliquotaZeroCofins.class);
    }
}
