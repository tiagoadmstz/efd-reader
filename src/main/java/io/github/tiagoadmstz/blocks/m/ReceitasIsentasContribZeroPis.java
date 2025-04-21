package io.github.tiagoadmstz.blocks.m;

import io.github.tiagoadmstz.interfaces.EfdBlockPart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Registro M400: Receitas Isentas, Não Alcançadas pela Incidência da Contribuição, Sujeitas à Alíquota Zero ou de Vendas com Suspensão – PIS/PASEP.
 */
@Data
public class ReceitasIsentasContribZeroPis implements EfdBlockPart {

    private final String register = "M400";
    private String cstPis;
    private BigDecimal vlTotRec;
    private String codCta;
    private String descCompl;
    private final List<DetalhamReceitasIsentasContribZeroPis> detalhamReceitasIsentasContribZeroPis;

    public ReceitasIsentasContribZeroPis() {
        this.detalhamReceitasIsentasContribZeroPis = new ArrayList<>(1);
    }

    @Override
    public void setByLine(List<String> blockLines) {
        EfdBlockPart.super.setByLine(blockLines);
        setPartListByBlock(blockLines, "M410", detalhamReceitasIsentasContribZeroPis, DetalhamReceitasIsentasContribZeroPis.class);
    }
}
