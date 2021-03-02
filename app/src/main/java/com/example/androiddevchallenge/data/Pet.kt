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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

data class Pet(val name: String, val image: Int, val city: String, val age: String)

object PetProvider {

    val pet = Pet(
        name = "Evie",
        image = R.drawable.pet1,
        city = "Natoton",
        age = "1 year"
    )

    val pets = listOf(
        pet,
        pet.copy("Mrs Proudpop", R.drawable.pet2, "Cape Johnsdge", "7 months"),
        pet.copy("Licorice", R.drawable.pet3, "Port Binggainsnee", "1.5 year"),
        pet.copy("Emily-Rose", R.drawable.pet4, "Gundicombe", "2 months"),
        pet.copy("Elli", R.drawable.pet5, "Gibbridg Under Johnold", "2 years"),
        pet.copy("Ms Uppishtoes", R.drawable.pet6, "West Risbraun", "2 months"),
        pet.copy("Edan", R.drawable.pet7, "West Pinevic", "1.2 years"),
        pet.copy("Eve", R.drawable.pet8, "Dalstead", "2 weeks"),
        pet.copy("Mrs Aloof", R.drawable.pet9, "Abajtown", "3 months"),
        pet.copy("Emaan", R.drawable.pet10, "Grand Carnmaige", "8 months")
    )

    val NAME = "NAME"
}
