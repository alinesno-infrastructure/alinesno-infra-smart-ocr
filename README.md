# alinesno-infra-smart-ocr
OCR视觉识别服务，用户可以快速识别和提取图像中的文字信息，实现便捷的图像处理

## 功能列表

- [完成]通用文字识别

## 调用接口

通用文字识别

```shell
curl --location --request POST 'http://localhost:30300/api/infra/smart/ocr/generalText' \
--header 'Content-Type: multipart/form-data; boundary=--------------------------169335550316702674434845' \
--form 'file=@"d043ad4bd11373f086e687d6a90f4bfbfaed0499.jpg"'
```

# 鸣谢

- JavaPaddle集成[RapidOcr-Java](https://github.com/MyMonsterCat/RapidOcr-Java)
- 车牌识别集成[open-anpr](https://gitee.com/open-visual/open-anpr)
- 视觉识别集成[JavaVision](https://gitee.com/giteeClass/java-vision)
- PaddlleOcr部分参考[PaddleOCRFastAPI](https://github.com/switchII/PaddleOCRFastAPI)
- 发票识别[einvoice](https://github.com/sanluan/einvoice)
