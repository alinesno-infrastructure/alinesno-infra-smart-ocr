package com.alinesno.infra.smart.ocr.api.controller;

import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.alinesno.infra.smart.ocr.entity.OcrResultsEntity;
import com.alinesno.infra.smart.ocr.service.IOcrResultsService;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理与OcrResultsEntity相关的请求的Controller。
 * 继承自BaseController类并实现IOcrResultsService接口。
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Api(tags = "OcrResults")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/smart/ocr/ocr_results")
public class OcrResultsController extends BaseController<OcrResultsEntity, IOcrResultsService> {

    // 日志记录
    private static final Logger log = LoggerFactory.getLogger(OcrResultsController.class);

    @Autowired
    private IOcrResultsService service;

    /**
     * 获取OcrResultsEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model   Model对象。
     * @param page    DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign(), page);
    }

    @Override
    public IOcrResultsService getFeign() {
        return this.service;
    }
}
