package com.cn.zyplayerandroid.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.cn.zyplayerandroid.GlideApp

/**
 * <类说明 必填>
 *
 * @author  shilong
 * @version  [版本号]
 * @see  [参考资料]
 * @since  [历史 创建日期:12/31/21]
 */
object GlideUtil {

    fun loadImage(imageView : ImageView,url : String){
        GlideApp.with(imageView.context)
    }

}