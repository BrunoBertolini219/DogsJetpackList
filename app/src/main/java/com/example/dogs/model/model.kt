package com.example.dogs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class DogBreed(

    @ColumnInfo(name = "breed_id")
    @SerializedName("id")
    val breedId: String,

    @ColumnInfo(name = "dog_name")
    @SerializedName("name")
    val dogBreed: String?,

    @ColumnInfo(name = "dog_lifespan")
    @SerializedName("life_span")
    val lifeSpan: String?,

    @ColumnInfo(name = "dog_group")
    @SerializedName("breed_group")
    val breedGroup: String?,

    @ColumnInfo(name = "dog_for")
    @SerializedName("bred_for")
    val breedFor: String?,

    @ColumnInfo(name = "dog_temperament")
    @SerializedName("temperament")
    val temperament: String?,

    @ColumnInfo(name = "dog_image")
    @SerializedName("url")
    val imgUrl: String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}

data class DogPalette(var color: Int)

data class SmsInfo(var to: String, var text: String,var imageUrl: String? )