# -*- coding: utf-8 -*-

import base64

import cv2
import numpy as np

def bytes_to_ndarray(img_bytes: str):
    """字节转numpy数组

    Args:
        img_bytes (str): 图片字节

    Returns:
        _type_: _description_
    """
    image_array = np.frombuffer(img_bytes, dtype=np.uint8)
    image_np2 = cv2.imdecode(image_array, cv2.IMREAD_COLOR)
    return image_np2
