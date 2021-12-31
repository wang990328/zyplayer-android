package com.cn.zyplayerandroid.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tencent.mmkv.MMKV
import java.lang.Exception

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
object MMKVMgr {

    @Volatile
    private var isInited = false
    private val mmkv: MMKV by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        MMKV.defaultMMKV()
    }

    fun init(context: Context) {
        if (isInited) return

        isInited = true
        MMKV.initialize(context)
    }

    fun setBool(k: String, v: Boolean) {
        mmkv.encode(k, v)
    }

    fun getBool(k: String, defaultValue: Boolean = false): Boolean {
        return mmkv.decodeBool(k, defaultValue)
    }

    fun setString(k: String, v: String) {
        mmkv.encode(k, v)
    }

    fun getString(k: String): String {
        return mmkv.decodeString(k) ?: ""
    }

    inline fun <reified T> getObject(key: String): T? {
        getString(key).let {
            try {
                return@let Gson().fromJson(it, object : TypeToken<T>() {}.type)
            } catch (e: Exception) {
            }
        }
        return null
    }
}