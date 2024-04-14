package com.example.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var num1 by remember {
                mutableStateOf("")
            }
            var num2 by remember {
                mutableStateOf("")
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                OutlinedTextField(
                    value = num1,
                    onValueChange = { num1 = it },
                    label = { Text("Number 1") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = num2,
                    onValueChange = { num2 = it },
                    label = { Text("Number 2") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val result = if (num1.isNotEmpty() && num2.isNotEmpty()) num1.toInt() + num2.toInt() else 0
                        Toast.makeText(applicationContext, "result is $result", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Add")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val result = if (num1.isNotEmpty() && num2.isNotEmpty()) num1.toInt() - num2.toInt() else 0
                        Toast.makeText(applicationContext, "result is $result", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Subtract")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val result = if (num1.isNotEmpty() && num2.isNotEmpty()) num1.toInt() * num2.toInt() else 0
                        Toast.makeText(applicationContext, "result is $result", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Multiply")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (num2.isNotEmpty() && num2.toInt() != 0) {
                            val result = if (num1.isNotEmpty()) num1.toInt() / num2.toInt() else 0
                            Toast.makeText(applicationContext, "result is $result", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(applicationContext, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Divide")
                }
            }
        }
    }
}