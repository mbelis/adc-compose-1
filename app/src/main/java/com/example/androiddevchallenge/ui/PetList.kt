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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.model.Pet

@Composable
fun PetList(pets: List<Pet>, onItemClick: (Pet) -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(pets) { index, pet ->
                PetItem(
                    pet = pet,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = { onItemClick(pet) })
                )
                if (index < pets.size - 1) {
                    Divider()
                }
            }
        }
    }
}
