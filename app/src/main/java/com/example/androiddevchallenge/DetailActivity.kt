package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.PetItem
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    companion object {
        const val INTENT_PET = "pet"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pet = intent.getParcelableExtra(INTENT_PET)
        supportActionBar?.title = pet?.name
        setContent {
            MyTheme {
                Detail()
            }
        }
    }
}

private var pet: Pet? = null

@Composable
fun Detail() {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(text = stringResource(id = R.string.adopt)) },
                    icon = { Icon(Icons.Default.HistoryEdu, "") },
                    onClick = {
                        // Handle onClick event
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.Center
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 0.dp, vertical = 16.dp)
            ) {
                item {
                    pet?.let { PetItem(pet = it) }
                }
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 0.dp)
                            .padding(bottom = 64.dp),
                        text = stringResource(id = R.string.lorem_ipsum)
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun LightPreview() {
    MyTheme {
        Detail()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Detail()
    }
}
