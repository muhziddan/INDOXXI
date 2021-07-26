package com.ziddan.indoxxi.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File

fun main(args: Array<String>) {
    val mapper = jacksonObjectMapper()

    println("=== Kotlin Object to JSON ===")
    val tv = DataDummy.generateDummyTv()

    println("1- String")
    var jsonStr = mapper.writeValueAsString(tv)
    println(jsonStr)

    println("2- Formatted String")
    jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tv)
    println(jsonStr)

    println("3- File -> manually check file for result")
    mapper.writerWithDefaultPrettyPrinter().writeValue(File("newTvShow.json"), tv)
}