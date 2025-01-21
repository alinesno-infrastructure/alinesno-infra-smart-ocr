package com.alinesno.infra.smart.ocr;

import com.benjaminwan.ocrlibrary.OcrResult;
import io.github.mymonstercat.Model;
import io.github.mymonstercat.ocr.InferenceEngine;

/**
 * 集成参考: https://blog.csdn.net/qq_41793039/article/details/134220607
 */
public class Main {
    public static void main(String[] args) {
        InferenceEngine engine = InferenceEngine.getInstance(Model.ONNX_PPOCR_V3);
        OcrResult ocrResult = engine.runOcr("/Users/luodong/Desktop/1555487731855772.jpg");
        System.out.println(ocrResult.getStrRes().trim());
    }
}
