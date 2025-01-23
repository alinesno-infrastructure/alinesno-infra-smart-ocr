package com.alinesno.infra.smart.ocr.service.impl;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.smart.ocr.api.*;
import com.alinesno.infra.smart.ocr.service.IOcrService;
import com.alinesno.infra.smart.ocr.utils.IdCardOcrUtils;
import com.benjaminwan.ocrlibrary.OcrResult;
import io.github.mymonstercat.Model;
import io.github.mymonstercat.ocr.InferenceEngine;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OcrServiceImpl implements IOcrService {

    /**
     * 实现通用文字识别服务方法。
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public String recognizeGeneralText(GeneralTextOcrRequestDto request) {

        InferenceEngine engine = InferenceEngine.getInstance(Model.ONNX_PPOCR_V3);
        OcrResult ocrResult = engine.runOcr(request.getFilePath().getAbsolutePath()) ;

        return ocrResult.getStrRes().trim();
    }

    /**
     * 实现个人证照识别服务方法。
     *
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public Map<String, String> recognizeIdCard(PersonalIdOcrRequestDto request) {
        // 实现个人证照识别逻辑

        InferenceEngine engine = InferenceEngine.getInstance(Model.ONNX_PPOCR_V3);
        OcrResult ocrResult = engine.runOcr(request.getFilePath().getAbsolutePath()) ;

        String result =  ocrResult.getStrRes().trim();
        return IdCardOcrUtils.parseIdCardInfo(result) ;
    }

    /**
     * 实现票据凭证识别服务方法。
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public AjaxResult recognizeInvoice(InvoiceOcrRequestDto request) {
        // 实现票据凭证识别逻辑
        return AjaxResult.success("票据凭证识别成功", "模拟识别结果");
    }

    /**
     * 实现企业资质识别服务方法。
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public AjaxResult recognizeBusinessLicense(BusinessLicenseOcrRequestDto request) {
        // 实现企业资质识别逻辑
        return AjaxResult.success("企业资质识别成功", "模拟识别结果");
    }

    /**
     * 实现车辆物流识别服务方法。
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public AjaxResult recognizeVehicleLogistics(VehicleLogisticsOcrRequestDto request) {
        // 实现车辆物流识别逻辑
        return AjaxResult.success("车辆物流识别成功", "模拟识别结果");
    }

    /**
     * 实现教育场景识别服务方法。
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public AjaxResult recognizeEducationScene(EducationSceneOcrRequestDto request) {
        // 实现教育场景识别逻辑
        return AjaxResult.success("教育场景识别成功", "模拟识别结果");
    }

    /**
     * 实现小语种识别服务方法。
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public AjaxResult recognizeMinorityLanguage(MinorityLanguageOcrRequestDto request) {
        // 实现小语种识别逻辑
        return AjaxResult.success("小语种识别成功", "模拟识别结果");
    }

    /**
     * 实现医疗场景识别服务方法。
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public AjaxResult recognizeMedicalScene(MedicalSceneOcrRequestDto request) {
        // 实现医疗场景识别逻辑
        return AjaxResult.success("医疗场景识别成功", "模拟识别结果");
    }

    /**
     * 实现票证核验服务方法。
     * @param request 包含图片Base64编码和识别类型的请求对象
     * @return 返回包含识别结果的AjaxResult对象
     */
    @Override
    public AjaxResult verifyTicket(TicketVerificationOcrRequestDto request) {
        // 实现票证核验逻辑
        return AjaxResult.success("票证核验成功", "模拟识别结果");
    }
}