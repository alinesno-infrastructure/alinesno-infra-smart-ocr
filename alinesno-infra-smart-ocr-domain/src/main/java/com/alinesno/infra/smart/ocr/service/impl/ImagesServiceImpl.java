package com.alinesno.infra.smart.ocr.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.smart.ocr.entity.ImagesEntity;
import com.alinesno.infra.smart.ocr.mapper.ImagesMapper;
import com.alinesno.infra.smart.ocr.service.IImagesService;
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
public class ImagesServiceImpl extends IBaseServiceImpl<ImagesEntity, ImagesMapper> implements IImagesService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ImagesServiceImpl.class);

}
