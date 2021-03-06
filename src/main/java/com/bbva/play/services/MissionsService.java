package com.bbva.play.services;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.bbva.play.dao.MissionsDao;
import com.bbva.play.services.dto.Amount;
import com.bbva.play.services.dto.MissionsDto;

import org.jboss.logging.Logger;

@ApplicationScoped
public class MissionsService {

    private static final Logger LOGGER = Logger.getLogger(MissionsService.class);

    @Inject
    MissionsDao dao;

    public List<MissionsDto> getMissions(List<String> id) {
        List<MissionsDto> missions;

        // Si se informan identificadores, buscamos por 
        // En caso contrario, hacemos una búsqueda completa
        if (id != null && !id.isEmpty()) {
            List<Long> ids = new ArrayList<>();
            id.forEach((String item) -> ids.add(Long.valueOf(item)));
            missions = dao.getSomeMissions(ids);
        } else {
            missions = dao.getAllMissons();
        }

        // Convertimos la divisa en simbolo
        missions.forEach((MissionsDto item) -> convertCurrencyToSymbol(item.getAmount()));
        return missions;
    }

    /*
     * Metodo que convierte el literal del currency en formato ISO
     * en el simbolo
     */
    private void convertCurrencyToSymbol(Amount in) {
        if (null != in) {
            String symbol = Currency.getInstance(in.getCurrency()).getSymbol();
            LOGGER.info("Se convierte la divisa " + in.getCurrency() + " en el symbolo "+symbol);
            in.setCurrency(symbol);
        }
    }
}