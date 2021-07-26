package com.ziddan.indoxxi.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File

fun main(args: Array<String>) {
    val mapper = jacksonObjectMapper()

    println("=== Kotlin Object to JSON ===")
    val film = DataDummy.generateDummyShows()

    println("1- String")
    var jsonStr = mapper.writeValueAsString(film)
    println(jsonStr)

    println("2- Formatted String")
    jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(film)
    println(jsonStr)

    println("3- File -> manually check file for result")
    mapper.writerWithDefaultPrettyPrinter().writeValue(File("newFilm.json"), film)
}