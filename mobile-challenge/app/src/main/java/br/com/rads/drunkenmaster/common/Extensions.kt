package br.com.rads.drunkenmaster.common

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.v4.graphics.drawable.DrawableCompat
import android.view.View

//Views
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

//Float
fun Float.toMoney(): String {
    return if (this <= 0.0) {
        "$ - "
    } else {
        "$ " + this.toString().replace(".", ",")
    }
}

//Drawable
fun Drawable.compatTint(@ColorInt tintColor: Int): Drawable {
    val wrappedDrawable = DrawableCompat.wrap(this)
    DrawableCompat.setTint(wrappedDrawable, tintColor)
    DrawableCompat.setTintMode(wrappedDrawable.mutate(), PorterDuff.Mode.SRC_IN)
    return wrappedDrawable
}