package com.example.taskmanager

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainImage(textA = getString(R.string.textA), textB = getString(R.string.textB))
                }
            }
        }
    }
}
@Composable
fun TaskText (textA : String, textB : String ) {
    Column(){
        Text(text = textA, fontSize = 24.sp,textAlign =TextAlign.Center, modifier = Modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .wrapContentHeight(align = Alignment.CenterVertically)
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 8.dp))
        Text(text = textB, fontSize = 16.sp, textAlign = TextAlign.Center, modifier = Modifier
            .padding(top = 0.dp, bottom = 0.dp)
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.CenterVertically)
            )
    }
}

@Composable
fun MainImage  (textA : String, textB : String ) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(){
        Image(painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        TaskText(textA = textA, textB = textB)
    }
}


@Preview(showBackground = true)
@Composable
fun MainImagePreview() {
    TaskManagerTheme {
        MainImage(textA = "All tasks completed", textB = "Nice work!")
    }
}