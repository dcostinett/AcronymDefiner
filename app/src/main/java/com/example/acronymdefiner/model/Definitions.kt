package com.example.acronymdefiner.model

class Definitions : ArrayList<DefinitionItem>()

data class DefinitionItem(
    val lfs: List<LongForm>,
    val sf: String
)

data class LongForm(
    val freq: Int,
    val lf: String,
    val since: Int,
    val vars: List<Variation>
)

data class Variation(
    val freq: Int,
    val lf: String,
    val since: Int
)