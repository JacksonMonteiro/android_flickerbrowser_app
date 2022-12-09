package space.jacksonmonteiro.flickerbrowser

//
// Created by Jackson Monteiro on 09/12/2022
// Copyright (c) 2022 GFX Consultoria
//

class Photo(val title: String, val author: String, val authorId: String, val link: String, val tags: String, val image: String) {
    override fun toString(): String {
        return "Photo(title='$title', author='$author', authorId='$authorId', link='$link', tags='$tags', image='$image')"
    }
}