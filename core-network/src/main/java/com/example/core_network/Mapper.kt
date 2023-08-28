package com.example.core_android

interface Mapper<DTO: Any, DATA: Any> {

    fun map(list: List<DTO>): List<DATA> = list.map(this::map)

    fun map(item: DTO): DATA

}