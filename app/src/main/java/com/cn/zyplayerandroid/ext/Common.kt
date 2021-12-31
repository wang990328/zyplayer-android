package com.cn.zyplayerandroid.ext

import com.google.gson.Gson

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */


fun Any.toJson(): String {
    return Gson().toJson(this)
}