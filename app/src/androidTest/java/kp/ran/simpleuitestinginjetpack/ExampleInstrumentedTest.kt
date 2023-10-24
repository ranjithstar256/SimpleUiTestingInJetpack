package kp.ran.simpleuitestinginjetpack

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.delay

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("kp.ran.simpleuitestinginjetpack", appContext.packageName)
    }

    @Test
    fun checkText(){
        composeTestRule.setContent { Greeting(name = "") }

    }
    @OptIn(ExperimentalTestApi::class)
    @Test
     fun testGreetingUI() {
        composeTestRule.setContent {
            Greeting(name = "Test User")
        }

        // Perform UI testing actions
        // Enter text into the first OutlinedTextField
        composeTestRule.onNodeWithText("one")
            .performTextInput("5")

        // Enter text into the second OutlinedTextField
        composeTestRule.onNodeWithText("two")
            .performTextInput("6")

        //composeTestRule.onNodeWithText("")
        composeTestRule.onNodeWithText("display").performClick()

        //assertEquals()
      //  composeTestRule.onNodeWithText("tv").equals("11")

        /*// Check if the Text Composable displays the expected text
        composeTestRule.onNodeWithText("Hello, World!", useUnmergedTree = true)
            .assertIsDisplayed()*/
    }

    fun chekres(){
        composeTestRule.setContent {
            Greeting(name = "Test User")
        }
        composeTestRule.onNodeWithText("tv").equals("11")
    }
}