package com.cn.zyplayerandroid.network

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.fastjson.FastJsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Method
import java.util.concurrent.TimeUnit

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
object ApiMgr {

    val retrofit: Retrofit by lazy {
        buildRetrofit()
    }

    /**
     * 反射改变host
     */
    fun changeBaseUrl(newUrlStr: String) {
        try {
            val clz = retrofit::class.java
            val baseUrlField = clz.getDeclaredField("baseUrl")
            baseUrlField.isAccessible = true
            baseUrlField.set(retrofit, newUrlStr.toHttpUrl()) //设置新httpUrl

            val serviceMethodCacheField = clz.getDeclaredField("serviceMethodCache")
            serviceMethodCacheField.isAccessible = true
            val serviceMethodCache: MutableMap<Method, Any> =
                serviceMethodCacheField as MutableMap<Method, Any>
            serviceMethodCache.clear()
            serviceMethodCacheField.set(retrofit, serviceMethodCache)
        } catch (e: Exception) {
        }
    }


    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl("")
            client(buildOKHttp())
            addConverterFactory(GsonConverterFactory.create())
            addConverterFactory(FastJsonConverterFactory.create())
        }.build()
    }

    private fun buildOKHttp(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            writeTimeout(30, TimeUnit.SECONDS)
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
        }.build()

    }
}