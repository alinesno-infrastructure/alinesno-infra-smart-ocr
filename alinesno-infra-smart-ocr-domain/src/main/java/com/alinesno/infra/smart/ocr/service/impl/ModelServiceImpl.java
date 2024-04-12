package com.alinesno.infra.smart.ocr.service.impl;

import com.alinesno.infra.smart.ocr.mapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.alinesno.infra.smart.ocr.entity.ModelEntity;
import com.alinesno.infra.smart.ocr.service.IModelService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Service
public class ModelServiceImpl extends IBaseServiceImpl<ModelEntity, ModelMapper> implements IModelService {

}
