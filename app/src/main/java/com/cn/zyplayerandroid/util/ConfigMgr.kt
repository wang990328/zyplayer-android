package com.cn.zyplayerandroid.util

import com.cn.zyplayerandroid.App
import com.cn.zyplayerandroid.bean.RepoBean
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
object ConfigMgr {
    val remoteRepoList: MutableList<RepoBean> by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        val bf = BufferedReader(InputStreamReader(App.application.assets.open("config.json")))
        val sb = StringBuilder()
        bf.readLines().forEach {
            sb.append(it)
        }
        return@lazy Gson().fromJson(
            sb.toString(),
            object : TypeToken<MutableList<RepoBean>>() {}.type
        )
    }

}