package com.alinesno.infra.smart.ocr.api;

import lombok.Data;

/**
 * OCR请求基类，用于封装所有OCR识别请求的共有字段。
 */
@Data
public class OcrRequestDto {
    private String imageBase64; // 图片的Base64编码字符串
    private String recognitionType; // 识别类型标识符
}