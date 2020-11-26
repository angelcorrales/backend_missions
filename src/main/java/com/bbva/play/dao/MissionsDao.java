package com.bbva.play.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.bbva.play.dao.entity.MissionsEntity;
import com.bbva.play.dao.mapper.Mapper;
import com.bbva.play.services.dto.MissionsDto;

import org.jboss.logging.Logger;

@ApplicationScoped
public class MissionsDao {

    private static final Logger LOGGER = Logger.getLogger(MissionsDao.class);

    public List<MissionsDto> getAllMissons() {
        List<MissionsEntity> missions = MissionsEntity.listAll();
        LOGGER.info("Se obtiene información de BBDD: "+missions);
        return Mapper.listMissionsDaoDtoToListMissionsDto(missions);
    }

    public List<MissionsDto> getSomeMissions(List<Long> id) {
        List<MissionsEntity> missions = MissionsEntity.list("id in ?1", id);
        LOGGER.info("Se obtiene información de BBDD: "+missions);
        return Mapper.listMissionsDaoDtoToListMissionsDto(missions);
    }
}