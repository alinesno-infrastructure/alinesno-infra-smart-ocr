package com.alinesno.infra.smart.ocr.mapper;

import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import com.alinesno.infra.smart.ocr.entity.ApplicationEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicationMapper extends IBaseMapper<ApplicationEntity> {
}
