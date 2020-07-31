package com.example.aboutme.repositories

import com.example.aboutme.models.Hobby

object HobbiesRepository {

    private var hobbies = mutableListOf<Hobby>(Hobby("Gaming", "Always ready to drop with the boys baby!"))

    fun getHobbies() = hobbies

    fun addHobby(hobby: Hobby) {
        hobbies.add(hobby)
    }
}