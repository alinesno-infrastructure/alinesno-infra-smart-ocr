package com.alinesno.infra.smart.ocr.service;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.smart.ocr.api.*;

import java.util.Map;

/**
 * OCR服务接口，定义了所有OCR识别功能的方法。
 */
public interface IOcrService {

    /**
     * 通用文字识别服务方法。
     * 支持多语言文本识别，能够处理各类文档中的印刷体和手写体文字。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    String recognizeGeneralText(GeneralTextOcrRequestDto request);

    /**
     * 个人证照识别服务方法。
     * 针对身份证、护照等个人证件，快速精准地提取关键信息。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    Map<String, String> recognizeIdCard(PersonalIdOcrRequestDto request);

    /**
     * 票据凭证识别服务方法。
     * 对发票、收据等财务票据进行结构化信息抽取，便于财务管理。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    AjaxResult recognizeInvoice(InvoiceOcrRequestDto request);

    /**
     * 企业资质识别服务方法。
     * 识别公司营业执照、组织机构代码证等企业相关文件，辅助商业验证。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    AjaxResult recognizeBusinessLicense(BusinessLicenseOcrRequestDto request);

    /**
     * 车辆物流识别服务方法。
     * 包括车牌号、运输单据等车辆与物流行业的特定文件识别。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    AjaxResult recognizeVehicleLogistics(VehicleLogisticsOcrRequestDto request);

    /**
     * 教育场景识别服务方法。
     * 针对试卷、作业、证书等教育领域材料的文字识别优化。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    AjaxResult recognizeEducationScene(EducationSceneOcrRequestDto request);

    /**
     * 小语种识别服务方法。
     * 扩展支持非主流语言的文本识别，满足国际化需求。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    AjaxResult recognizeMinorityLanguage(MinorityLanguageOcrRequestDto request);

    /**
     * 医疗场景识别服务方法。
     * 专注于病历、处方笺等医疗文件的特殊格式和术语识别。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    AjaxResult recognizeMedicalScene(MedicalSceneOcrRequestDto request);

    /**
     * 票证核验服务方法。
     * 不仅识别票证内容，还提供真伪校验服务，确保信息安全。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    AjaxResult verifyTicket(TicketVerificationOcrRequestDto request);
}