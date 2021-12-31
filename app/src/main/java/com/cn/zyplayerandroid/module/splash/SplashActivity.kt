package com.cn.zyplayerandroid.module.splash

import android.Manifest
import com.cn.zyplayerandroid.R
import com.cn.zyplayerandroid.ext.toJson
import com.cn.zyplayerandroid.module.BaseActivity
import com.cn.zyplayerandroid.util.ConfigMgr
import com.cn.zyplayerandroid.util.EasyPermissions
import com.drake.logcat.LogCat

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
class SplashActivity : BaseActivity() {
    override fun layoutRes() = R.layout.activity_splash

    override fun onInit() {
        LogCat.e(ConfigMgr.remoteRepoList.toJson())
        requestPermission()

    }

    private fun requestPermission() {
        if (!EasyPermissions.isPermissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE, this)
            || !EasyPermissions.isPermissionGranted(Manifest.permission.READ_EXTERNAL_STORAGE, this)
        ) {
            EasyPermissions.create(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
                .callback { granted ->
                    LogCat.e("获得授权")
                }
                .request(this)
        }

    }

}