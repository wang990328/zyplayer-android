package com.cn.zyplayerandroid.bean

import java.io.Serializable

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
data class RepoBean(
    val id: Int,
    val key: String = "",
    val name: String = "",
    val api: String = "" //请求地址
) : Serializable
