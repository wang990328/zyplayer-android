package com.cn.zyplayerandroid

import android.content.Context
import com.cn.zyplayerandroid.network.ApiMgr
import com.cn.zyplayerandroid.util.ConfigMgr
import com.cn.zyplayerandroid.util.MMKVMgr
import com.drake.logcat.LogCat
import com.tencent.mmkv.MMKV

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
object ApplicationHelper {

    fun loadConfigs(context: Context) {
        configLog()
        configMMKV(context)
        configHost()
    }

    private fun configMMKV(context: Context) {
        MMKVMgr.init(context)
    }

    private fun configLog() {
        LogCat.config {
            defaultTag = "Player-Android"
        }
    }

    private fun configHost() {
        if (ConfigMgr.remoteRepoList.isNotEmpty()) {
            ApiMgr.changeBaseUrl(ConfigMgr.remoteRepoList[0].api)
        }
    }
}