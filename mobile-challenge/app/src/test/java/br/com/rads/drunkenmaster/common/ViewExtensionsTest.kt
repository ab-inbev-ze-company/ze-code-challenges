package br.com.rads.drunkenmaster.common

import android.view.View
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RoboSettings
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class ViewExtensionsTest {

    private val view = View(RuntimeEnvironment.application)

    @Test
    fun goingVisible() {
        view.visible()
        assertEquals(View.VISIBLE, view.visibility)
    }

    @Test
    fun goingInvisible() {
        view.invisible()
        assertEquals(View.INVISIBLE, view.visibility)
    }

}