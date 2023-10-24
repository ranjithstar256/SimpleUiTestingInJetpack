package kp.ran.simpleuitestinginjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import kp.ran.simpleuitestinginjetpack.ui.theme.SimpleUiTestingInJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleUiTestingInJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        var s by remember { mutableStateOf("")   }
        var s2 by remember { mutableStateOf("")   }
        var s3 by remember { mutableStateOf("")   }
        Text(text = s2,Modifier.testTag("tv"))
        OutlinedTextField(value = s, onValueChange = {s=it}, placeholder = {
            Text(text = "one")
        },modifier=Modifier.testTag("one"))
        OutlinedTextField(value = s3, onValueChange = {s3=it}, placeholder = {
            Text(text = "two")
        },modifier=Modifier.testTag("two"))
        Button(onClick = {
            s2=s

          s2=  add(s2,s3).toString()
        }) {
            Text(text = "display")
        }
    }
}

fun add(a:String,b:String):Int{
 var x:Int =0

    x= a.toInt()+ b.toInt()

    return x
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleUiTestingInJetpackTheme {
        Greeting("Android")
    }
}