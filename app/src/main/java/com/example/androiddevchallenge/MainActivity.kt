/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.PetList
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
fun getPetList(context: Context) = buildList {
    repeat(20) {
        add(
            Pet(
                imageUrl = "https://placekitten.com/100/100?image=$it",
                name = context.resources.getStringArray(R.array.names)[it],
                years = (1..10).random()
            )
        )
    }
}

@Composable
fun MyApp() {
    val context = LocalContext.current
    val pets = getPetList(context = context)

    Surface(color = MaterialTheme.colors.background) {
        PetList(
            pets = pets,
            onItemClick = { pet ->
                context.startActivity(
                    Intent(context, DetailActivity::class.java).also {
                        it.putExtra(DetailActivity.INTENT_PET, pet)
                    }
                )
            }
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
