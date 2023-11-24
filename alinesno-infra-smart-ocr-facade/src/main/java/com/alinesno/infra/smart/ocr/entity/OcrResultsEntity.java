package com.alinesno.infra.smart.ocr.entity;

import java.util.Date;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;


/**
 * <p>
 *
 * </p>
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Data
@TableName("ocr_results")
public class OcrResultsEntity extends InfraBaseEntity {
	/**
	 * 结果ID
	 */
	@ColumnType(MySqlTypeConstant.BIGINT)
	@ColumnComment("结果ID")
	@TableField("result_id")
	private Long resultId;

	/**
	 * 图片ID
	 */
	@ColumnType(MySqlTypeConstant.BIGINT)
	@ColumnComment("图片ID")
	@TableField("image_id")
	private Long imageId;

	/**
	 * 识别出的文本内容
	 */
	@ColumnType(MySqlTypeConstant.TEXT)
	@ColumnComment("识别出的文本内容")
	@TableField("recognized_text")
	private String recognizedText;

	/**
	 * 经过校对修正的文本内容
	 */
	@ColumnType(MySqlTypeConstant.TEXT)
	@ColumnComment("经过校对修正的文本内容")
	@TableField("corrected_text")
	private String correctedText;

	/**
	 * 输出格式
	 */
	@ColumnType(length = 10)
	@ColumnComment("输出格式")
	@TableField("output_format")
	private String outputFormat;

	/**
	 * 存储时间
	 */
	@ColumnType(value = MySqlTypeConstant.DATETIME, length = 18)
	@ColumnComment("存储时间")
	@TableField("stored_at")
	private Date storedAt;


}
