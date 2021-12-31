package com.cn.zyplayerandroid.module

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drake.statusbar.immersive
import com.drake.statusbar.setActionBarTransparent

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutRes() != 0){
            setContentView(layoutRes())
        }

        immersive()
        setActionBarTransparent()//// 给ActionBar设置透明背景
        onInit()
    }

    abstract fun layoutRes(): Int

    abstract fun onInit()
}