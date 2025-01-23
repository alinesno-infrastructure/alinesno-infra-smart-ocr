package com.alinesno.infra.smart.ocr.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdCardOcrUtils {

    /**
     * 身份证完整信息识别
     *
     * @param ocrResult OCR解析返回的身份证信息
     * @return 包含身份证信息的映射表
     */
    public static Map<String, String> parseIdCardInfo(String ocrResult) {
        Map<String, String> userInfoMap = new HashMap<>();

        // Split the input by lines and process each line
        for (String line : ocrResult.split("\\r?\\n")) {
            if (!line.trim().isEmpty()) {
                extractField(userInfoMap, "name", line, ".*名([\\u4e00-\\u9fa5]{1,4})");
                extractField(userInfoMap, "nation", line, ".*民族([\\u4e00-\\u9fa5]{1,4})");
                extractField(userInfoMap, "address", line, "(.*(?:省|市|县|街|乡|村|镇|区|城|组|号|幢|室))");
                extractField(userInfoMap, "cardNumber", line, "(\\d{17}[\\dxX]|\\d{15})");

                // Special handling for sex and birthday as they are derived from card number
                if (userInfoMap.containsKey("cardNumber")) {
                    String cardNumber = userInfoMap.get("cardNumber");
                    userInfoMap.put("sex", determineSex(cardNumber));
                    userInfoMap.put("birthday", extractBirthday(cardNumber));
                }
            }
        }

        return userInfoMap;
    }

    private static void extractField(Map<String, String> map, String key, String line, String pattern) {
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            map.put(key, m.group(1).trim());
        }
    }

    private static String determineSex(String cardNumber) {
        int index = Integer.parseInt(cardNumber.substring(cardNumber.length() - 2, cardNumber.length() - 1));
        return index % 2 == 0 ? "女" : "男";
    }

    private static String extractBirthday(String cardNumber) {
        if (cardNumber.length() == 18) {
            String date = cardNumber.substring(6, 14);
            return date.substring(0, 4) + "年" + date.substring(4, 6) + "月" + date.substring(6, 8) + "日";
        }
        return "";
    }

}