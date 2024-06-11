package com.example.mvvmcounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmcounterapp.ui.theme.CounterViewModel
import com.example.mvvmcounterapp.ui.theme.MVVMCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMCounterAppTheme {
                val counterViewModel: CounterViewModel = viewModel()
                CounterApp(counterViewModel = counterViewModel)
            }
        }
    }
}

@Composable
fun CounterApp(counterViewModel: CounterViewModel) {
    Column(
        modifier =
            Modifier
                .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier =
                Modifier
                    .padding(bottom = 16.dp),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            text = counterViewModel.count.value.toString(),
        )

        Row {
            Button(onClick = { counterViewModel.increment() }) {
                Text("Increment")
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = { counterViewModel.decrement() }) {
                Text("Decrement")
            }
        }
    }
}
