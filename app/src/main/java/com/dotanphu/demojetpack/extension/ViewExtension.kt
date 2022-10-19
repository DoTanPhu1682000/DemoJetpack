package com.dotanphu.demojetpack.extension

import android.view.View

fun View.visible(isShow: Boolean) {;
    visibility = if (isShow) View.VISIBLE else View.GONE
}