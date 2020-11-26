package com.bbva.play.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import com.bbva.play.dao.entity.MissionsEntity;
import com.bbva.play.services.dto.Amount;
import com.bbva.play.services.dto.MissionsDto;

public class Mapper {

    private Mapper() {
        super();
    }

    public static List<MissionsDto> listMissionsDaoDtoToListMissionsDto(List<MissionsEntity> in) {
        if (null == in || in.isEmpty()) {
            return new ArrayList<>();
        }

        List<MissionsDto> out = new ArrayList<>();
        in.forEach((MissionsEntity item) -> out.add(getMissionDto(item)));
        return out;
    }

    private static MissionsDto getMissionDto(MissionsEntity in) {
        if (null == in) {
            return null;
        }

        MissionsDto out = new MissionsDto();
        out.setId(String.valueOf(in.getId()));
        out.setAmount(getAmount(in.getAmount(), in.getCurrency()));
        out.setDescription(in.getDescription());
        out.setImage(in.getImage());
        return out;
    }

    private static Amount getAmount(Double amount, String currency) {
        if (null == amount) {
            return null;
        }

        return new Amount(amount, currency);
    }
}