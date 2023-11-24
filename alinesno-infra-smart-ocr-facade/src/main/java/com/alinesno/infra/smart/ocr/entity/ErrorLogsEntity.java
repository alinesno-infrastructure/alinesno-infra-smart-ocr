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
@TableName("error_logs")
public class ErrorLogsEntity extends InfraBaseEntity {
	/**
	 * 日志ID
	 */
	@ColumnType(MySqlTypeConstant.BIGINT)
	@ColumnComment("日志ID")
	@TableField("log_id")
	private Long logId;

	/**
	 * 图片ID
	 */
	@ColumnType(MySqlTypeConstant.BIGINT)
	@ColumnComment("图片ID")
	@TableField("image_id")
	private Long imageId;

	/**
	 * 错误信息
	 */
	@ColumnType(MySqlTypeConstant.TEXT)
	@ColumnComment("错误信息")
	@TableField("error_message")
	private String errorMessage;

	/**
	 * 错误类型
	 */
	@ColumnType(length = 50)
	@ColumnComment("错误类型")
	@TableField("error_type")
	private String errorType;

	/**
	 * 发生时间
	 */
	@ColumnType(value = MySqlTypeConstant.DATETIME, length = 18)
	@ColumnComment("发生时间")
	@TableField("occurred_at")
	private Date occurredAt;


}
