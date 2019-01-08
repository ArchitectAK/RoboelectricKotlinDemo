package com.cogitator.roboelectrickotlindemo

import android.content.Intent
import android.widget.Button
import android.widget.TextView
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowActivity
import org.robolectric.shadows.ShadowIntent
import org.hamcrest.CoreMatchers.equalTo

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 *
 */

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, packageName = "com.cogitator.roboelectrickotlindemo")
class ExampleUnitTest {
    private var firstActivity: FirstActivity = null!!
    @Before
    fun init() {
        firstActivity = Robolectric.setupActivity(FirstActivity::class.java)
    }

    @Test
    fun clickingLoginButton_shouldStartSecondActivity() {
        val button = firstActivity.findViewById<Button>(R.id.button1)

        assertNotNull(button)
        button.performClick()


        val showActivity: ShadowActivity = Shadows.shadowOf(firstActivity)
        val intent: Intent = showActivity.nextStartedActivity
        val shadowIntent: ShadowIntent = shadowOf(intent)
        assertThat(shadowIntent.intentClass.name, equalTo(FirstActivity::class.java!!.getName()))
    }

    @Test
    fun checkTextViewString_presentOrNot() {
        val textView = firstActivity.findViewById<TextView>(R.id.textView)
        val stringValue = textView.text.toString()
        assertThat(stringValue, equalTo("Hello World!"))
    }

}
