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
@TableName("system_logs")
public class SystemLogsEntity extends InfraBaseEntity {
	/**
	 * 日志ID
	 */
	@ColumnType(MySqlTypeConstant.BIGINT)
	@ColumnComment("日志ID")
	@TableField("log_id")
	private Long logId;

	/**
	 * 用户ID
	 */
	@ColumnType(MySqlTypeConstant.BIGINT)
	@ColumnComment("用户ID")
	@TableField("user_id")
	private Long userId;

	/**
	 * 执行的操作
	 */
	@ColumnType(MySqlTypeConstant.TEXT)
	@ColumnComment("执行的操作")
	@TableField("action_performed")
	private String actionPerformed;

	/**
	 * 日志信息
	 */
	@ColumnType(MySqlTypeConstant.TEXT)
	@ColumnComment("日志信息")
	@TableField("log_message")
	private String logMessage;

	/**
	 * 日志时间
	 */
	@ColumnType(value = MySqlTypeConstant.DATETIME, length = 18)
	@ColumnComment("日志时间")
	@TableField("log_time")
	private Date logTime;


}
