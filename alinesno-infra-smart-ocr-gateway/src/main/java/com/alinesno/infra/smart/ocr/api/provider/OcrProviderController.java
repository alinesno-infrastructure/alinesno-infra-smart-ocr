package com.alinesno.infra.smart.ocr.api.provider;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import com.alinesno.infra.smart.ocr.api.*;
import com.alinesno.infra.smart.ocr.service.IOcrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

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
    public AjaxResult recognizeGeneralText(@RequestPart("file") MultipartFile file) {
        log.info("Received general text OCR request.");

        // 检查文件是否为空
        if (file.isEmpty()) {
            return AjaxResult.error("File is empty");
        }

        GeneralTextOcrRequestDto  requestDto = new GeneralTextOcrRequestDto();

        File tempFile = null;
        try {
            // 创建临时文件
            tempFile = Files.createTempFile("ocr-", ".tmp").toFile();

            // 将MultipartFile的内容复制到临时文件
            file.transferTo(tempFile);

            log.info("Temporary file created at: " + tempFile.getAbsolutePath());

            // 处理文件和OCR逻辑
            // 例如：检查文件类型、读取文件内容、调用OCR服务等
            requestDto.setFilePath(tempFile);
            String result = ocrService.recognizeGeneralText(requestDto);
            return AjaxResult.success("OCR recognition successful", result);
        } catch (IOException e) {
            log.error("Error creating or writing to temporary file", e);
            return AjaxResult.error("Failed to create temporary file");
        } finally {
            // 清理临时文件（如果需要）
            if (tempFile != null && tempFile.exists()) {
                tempFile.deleteOnExit(); // 在JVM退出时删除临时文件
            }
        }
    }

    /**
     * 提供个人身份证识别
     */
    @PostMapping("/idCard")
    public AjaxResult recognizeIdCard(@RequestPart("file") MultipartFile file) {
        log.info("Received personal ID OCR request.");

        log.info("Received general text OCR request.");

        // 检查文件是否为空
        if (file.isEmpty()) {
            return AjaxResult.error("File is empty");
        }

        PersonalIdOcrRequestDto  requestDto = new PersonalIdOcrRequestDto();

        File tempFile = null;
        try {
            // 创建临时文件
            tempFile = Files.createTempFile("ocr-", ".tmp").toFile();

            // 将MultipartFile的内容复制到临时文件
            file.transferTo(tempFile);

            log.info("Temporary file created at: " + tempFile.getAbsolutePath());

            // 处理文件和OCR逻辑
            // 例如：检查文件类型、读取文件内容、调用OCR服务等
            requestDto.setFilePath(tempFile);
            Map<String, String> result = ocrService.recognizeIdCard(requestDto);
            return AjaxResult.success("OCR recognition successful", result);
        } catch (IOException e) {
            log.error("Error creating or writing to temporary file", e);
            return AjaxResult.error("Failed to create temporary file");
        } finally {
            // 清理临时文件（如果需要）
            if (tempFile != null && tempFile.exists()) {
                tempFile.deleteOnExit(); // 在JVM退出时删除临时文件
            }
        }
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