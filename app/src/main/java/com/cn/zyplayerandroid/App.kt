package com.cn.zyplayerandroid

import androidx.multidex.MultiDexApplication
import com.drake.logcat.LogCat

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
class App : MultiDexApplication() {
    companion object {
        lateinit var application: App
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        ApplicationHelper.loadConfigs(this)
    }

}