# -*- coding: utf-8 -*-

import cv2
import os
import requests
import time
import uuid
from datetime import timedelta
from flask import Flask, request, jsonify
from paddleocr import PaddleOCR
from werkzeug.utils import secure_filename

from utils.ImageHelper import base64_to_ndarray, bytes_to_ndarray

app = Flask(__name__)

app.config['JSON_AS_ASCII'] = False  # 设置 JSON 编码为 UTF-8，用于处理中文
app.config['SEND_FILE_MAX_AGE_DEFAULT'] = timedelta(hours=1)  # 设置发送文件的默认缓存时间为 1 小时
app.config['MAX_CONTENT_LENGTH'] = 16 * 1024 * 1024  # 设置上传文件的最大尺寸为 16MB

"""
检查文件扩展名是否符合允许的格式。

参数：
    fname (str): 文件名。

返回：
    bool: 如果文件扩展名为 'png'、'jpg' 或 'jpeg'，返回 True；否则返回 False。
"""
def allowed_file(fname):
    return '.' in fname and fname.rsplit('.', 1)[1].lower() in ['png', 'jpg', 'jpeg']

@app.route('/predict-by-url', methods=['POST'])
def predict_by_url():

    image_url= request.form.get('image_url')
    response = requests.get(image_url)

    image_bytes = response.content

    if image_bytes.startswith(b"\xff\xd8\xff") or image_bytes.startswith(b"\x89PNG\r\n\x1a\n"):  # 只处理常见格式图片 (jpg / png)

        start_time = time.time()

        img = bytes_to_ndarray(image_bytes)
        result = ocr.ocr(img , cls=True)  # 使用 PaddleOCR 对图片进行识别

        end_time = time.time()

        return jsonify({
            'status': 'success',
            'data': result,  # 返回识别结果列表
            'usage_time': '{:.4f}s'.format(start_time - end_time)  # 返回识别所用时间
        })

    return jsonify({'服务状态': 'faild'})  # 文件上传失败时返回失败状态信息

@app.route('/predict-by-base64', methods=['POST'])
def predict_by_base64():

    """
    接收表单提交的 Base64 编码的图像数据并将其转换为图片。
    """
    base64_image = request.form.get('base64_image')

    start_time = time.time()

    img = base64_to_ndarray(base64_image)
    result = ocr.ocr(img , cls=True)  # 使用 PaddleOCR 对图片进行识别

    end_time = time.time()

    return jsonify({
        'status': 'success',
        'data': result,  # 返回识别结果列表
        'usage_time': '{:.4f}s'.format(start_time - end_time)  # 返回识别所用时间
    })

@app.route('/predict-by-file', methods=['POST'])
def detect():
    file = request.files['file']
    if file and allowed_file(file.filename):
        ext = file.filename.rsplit('.', 1)[1]

        random_name = '{}.{}'.format(uuid.uuid4().hex, ext)
        savepath = os.path.join('caches', secure_filename(random_name))  # 将上传文件保存到 'caches' 文件夹下
        file.save(savepath)

        start_time = time.time()
        img = cv2.imread(savepath)  # 读取上传的图片文件
        result = ocr.ocr(img , cls=True)  # 使用 PaddleOCR 对图片进行识别

        end_time = time.time()

        return jsonify({
            'status': 'success',
            'data': result,  # 返回识别结果列表
            'usage_time': '{:.4f}s'.format(start_time - end_time)  # 返回识别所用时间
        })
    return jsonify({'服务状态': 'faild'})  # 文件上传失败时返回失败状态信息

if __name__ == '__main__':
    ocr = PaddleOCR(use_angle_cls=True, use_gpu=False)  # 初始化 PaddleOCR 模型，设置使用角度分类，不使用 GPU
    app.run(host='0.0.0.0', port=5002, debug=True, threaded=True, processes=1)  # 运行 Flask 应用
