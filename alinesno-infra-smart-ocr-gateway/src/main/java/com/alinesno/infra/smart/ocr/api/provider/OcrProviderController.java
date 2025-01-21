package com.alinesno.infra.smart.ocr.api.provider;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import com.alinesno.infra.smart.ocr.api.*;
import com.alinesno.infra.smart.ocr.service.IOcrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/infra/smart/ocr")
public class OcrProviderController extends SuperController {

    @Autowired
    private IOcrService ocrService;

    /**
     * 提供通用文字识别API端点
     */
    @PostMapping("/generalText")
    public AjaxResult recognizeGeneralText(@RequestBody GeneralTextOcrRequestDto request) {
        log.info("Received general text OCR request.");
        return ocrService.recognizeGeneralText(request);
    }

    /**
     * 提供个人证照识别API端点
     */
    @PostMapping("/personalId")
    public AjaxResult recognizePersonalId(@RequestBody PersonalIdOcrRequestDto request) {
        log.info("Received personal ID OCR request.");
        return ocrService.recognizePersonalId(request);
    }

    /**
     * 提供票据凭证识别API端点
     */
    @PostMapping("/invoice")
    public AjaxResult recognizeInvoice(@RequestBody InvoiceOcrRequestDto request) {
        log.info("Received invoice OCR request.");
        return ocrService.recognizeInvoice(request);
    }

    /**
     * 提供企业资质识别API端点
     */
    @PostMapping("/businessLicense")
    public AjaxResult recognizeBusinessLicense(@RequestBody BusinessLicenseOcrRequestDto request) {
        log.info("Received business license OCR request.");
        return ocrService.recognizeBusinessLicense(request);
    }

    /**
     * 提供车辆物流识别API端点
     */
    @PostMapping("/vehicleLogistics")
    public AjaxResult recognizeVehicleLogistics(@RequestBody VehicleLogisticsOcrRequestDto request) {
        log.info("Received vehicle logistics OCR request.");
        return ocrService.recognizeVehicleLogistics(request);
    }

    /**
     * 提供教育场景识别API端点
     */
    @PostMapping("/educationScene")
    public AjaxResult recognizeEducationScene(@RequestBody EducationSceneOcrRequestDto request) {
        log.info("Received education scene OCR request.");
        return ocrService.recognizeEducationScene(request);
    }

    /**
     * 提供小语种识别API端点
     */
    @PostMapping("/minorityLanguage")
    public AjaxResult recognizeMinorityLanguage(@RequestBody MinorityLanguageOcrRequestDto request) {
        log.info("Received minority language OCR request.");
        return ocrService.recognizeMinorityLanguage(request);
    }

    /**
     * 提供医疗场景识别API端点
     */
    @PostMapping("/medicalScene")
    public AjaxResult recognizeMedicalScene(@RequestBody MedicalSceneOcrRequestDto request) {
        log.info("Received medical scene OCR request.");
        return ocrService.recognizeMedicalScene(request);
    }

    /**
     * 提供票证核验API端点
     */
    @PostMapping("/ticketVerification")
    public AjaxResult verifyTicket(@RequestBody TicketVerificationOcrRequestDto request) {
        log.info("Received ticket verification request.");
        return ocrService.verifyTicket(request);
    }
}