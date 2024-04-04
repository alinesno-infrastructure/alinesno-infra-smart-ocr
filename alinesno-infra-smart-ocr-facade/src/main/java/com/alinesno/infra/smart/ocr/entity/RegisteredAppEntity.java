package com.alinesno.infra.smart.ocr.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 功能名： 【请填写功能名称】
 * 数据表：  oauth_registered_app
 * 表备注：
 *
 * @author luoxiaondg
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@TableName("registered_app")
@Data
public class RegisteredAppEntity extends InfraBaseEntity {
    // fields
    /**
     * 应用名称
     */
    @Excel(name = "应用名称")
    @TableField("app_name")
    @ColumnType(length=255)
    @ColumnComment("应用名称")
    private String appName;
    /**
     * 应用秘钥
     */
    @Excel(name = "应用秘钥")
    @TableField("app_secret")
    @ColumnType(length=255)
    @ColumnComment("应用秘钥")
    private String appSecret;
    /**
     * 应用简要描述
     */
    @Excel(name = "应用简要描述")
    @TableField("app_desc")
    @ColumnType(length=255)
    @ColumnComment("应用简要描述")
    private String appDesc;
    /**
     * 授权码回调地址
     */
    @Excel(name = "授权码回调地址")
    @TableField("redirec_uri")
    @ColumnType(length=255)
    @ColumnComment("授权码回调地址")
    private String redirecUri;
    /**
     * 是否自动授权
     */
    @Excel(name = "是否自动授权")
    @TableField("auto_approve")
    @ColumnType(length=255)
    @ColumnComment("是否自动授权")
    private Long autoApprove;
    /**
     * 支持的授权模式
     */
    @Excel(name = "支持的授权模式")
    @TableField("authority_grant_type")
    @ColumnType(length=255)
    @ColumnComment("支持的授权模式")
    private String authorityGrantType;

    @TableField(exist = false)
    @ColumnType(length=255)
    @ColumnComment("authorityGrantTypes")
    private List<String> authorityGrantTypes;


    /**
     * 应用授权环境标识
     */
    @Excel(name = "应用授权环境标识")
    @TableField("app_env")
    @ColumnType(length=255)
    @ColumnComment("应用授权环境标识")
    private String appEnv;
    /**
     * 应用类型
     */
    @Excel(name = "应用类型")
    @TableField("app_type")
    @ColumnType(length=255)
    @ColumnComment("应用类型")
    private String appType;
    /**
     * 应用类型
     */
    @Excel(name = "应用服务地址")
    @TableField("server_url")
    @ColumnType(length=255)
    @ColumnComment("应用类型")
    private String serverUrl;

    /**
     * 应用授权范围
     */
    @Excel(name = "应用授权范围")
    @TableField("authority_scope")
    @ColumnType(length=255)
    @ColumnComment("应用授权范围")
    private String authorityScope;

    @TableField(exist = false)
    @ColumnType(length=255)
    @ColumnComment("authorityScopes")
    private List<String> authorityScopes;
}