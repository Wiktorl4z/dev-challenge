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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.PetProvider
import com.example.androiddevchallenge.data.PetProvider.NAME
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DarkPreview() { pet ->
                startNewActivity(pet)
            }
        }
    }

    fun startNewActivity(pet: Pet) {
        startActivity(
            Intent(this, PetActivity::class.java).apply {
                putExtra(NAME, pet.name)
            }
        )
    }

    // Start building your app here!
    @Composable
    fun MyApp(
        petSelected: (Pet) -> Unit
    ) {
        Surface(color = MaterialTheme.colors.background) {
            mainPicture() { v ->
                petSelected(v)
            }
        }
    }

    @Composable
    fun LightPreview(
        petSelected: (Pet) -> Unit
    ) {
        MyTheme {
            MyApp() { v ->
                petSelected(v)
            }
        }
    }

    @Composable
    fun DarkPreview(
        petSelected: (Pet) -> Unit
    ) {
        MyTheme(darkTheme = true) {
            MyApp() { v ->
                petSelected(v)
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun PetsList(
        pets: List<Pet>,
        petSelected: (Pet) -> Unit
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(pets) { pet ->
                PetCard(pet = pet) { v ->
                    petSelected(v)
                }
            }
        }
    }

    @Composable
    fun PetCard(
        pet: Pet,
        petSelected: (Pet) -> Unit
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(onClick = { petSelected(pet) })
        ) {
            Image(
                painter = painterResource(pet.image),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Name: " + pet.name, style = typography.body1)
                Text("City: " + pet.city, style = typography.body1)
                Text("Age: " + pet.age, style = typography.body1)
            }
        }
    }

    @Composable
    fun mainPicture(
        petSelected: (Pet) -> Unit
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.main),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            PetsList(PetProvider.pets) { v ->
                petSelected(v)
            }
        }
    }
}
