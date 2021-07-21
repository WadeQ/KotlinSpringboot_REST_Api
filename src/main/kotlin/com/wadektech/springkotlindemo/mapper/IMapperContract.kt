package com.wadektech.springkotlindemo.mapper

interface IMapperContract<Entity , Domain> {

    fun mapToDomain(entity: Entity) : Domain
}