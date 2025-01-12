package com.alinesno.infra.smart.ocr.service.impl;

import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.smart.ocr.entity.ImagesEntity;
import com.alinesno.infra.smart.ocr.mapper.ImagesMapper;
import com.alinesno.infra.smart.ocr.service.IImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
