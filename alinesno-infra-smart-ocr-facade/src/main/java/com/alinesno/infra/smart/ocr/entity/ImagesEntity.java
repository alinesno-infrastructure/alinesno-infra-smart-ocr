package com.alinesno.infra.smart.ocr.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;


/**
 * <p>
 *
 * </p>
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Data
@TableName("images")
public class ImagesEntity extends InfraBaseEntity {
	/**
	 * 图片ID
	 */
	@ColumnType(MySqlTypeConstant.BIGINT)
	@ColumnComment("图片ID")
	@TableField("image_id")
	private Long imageId;

	/**
	 * 用户ID
	 */
	@ColumnType(MySqlTypeConstant.BIGINT)
	@ColumnComment("用户ID")
	@TableField("user_id")
	private Long userId;

	/**
	 * 图片URL
	 */
	@ColumnType(length = 255)
	@ColumnComment("图片URL")
	@TableField("image_url")
	private String imageUrl;

	/**
	 * 上传时间
	 */
	@ColumnType(value = MySqlTypeConstant.DATETIME, length = 18)
	@ColumnComment("上传时间")
	@TableField("uploaded_at")
	private Date uploadedAt;


}
