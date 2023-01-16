package com.fabrick.banking.enumerable;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TaxReliefType {

    INTERVENTI_SUPER_BONUS("119R", "Interventi superbonus"),
    BONUS_FACCIATE("L027", "Bonus faccaite"),
    INTERVENTI_ANTISISMICI("DL50", "Interventi antisismici"),
    AQUISTO_MOBILIO_PER_RISTRUTTURAZIONE("L090", "Acquisto mobilio per ristrutturazione"),
    RISPARMIO_ENERGETICO("L296", "Risparmio energetico"),
    RISTRUTTURAZIONE("L449", "Ristrutturazione"),
    BARRIERE_ARCHITETTONICHE("L234", "Barriere Architettoniche");


    private final String taxReliefValue;
    private final String taxReliefDescription;

    public static boolean contains(String val){
        return Arrays.stream(TaxReliefType.values())
                .anyMatch(taxId -> taxId.getTaxReliefValue().equals(val));
    }
}
