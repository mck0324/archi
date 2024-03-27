package com.example.archisketchbackendtest.dto

data class CylinderResponse(
    val name: String?,
    val editorAsset: EditorAsset?,
)

data class EditorAsset(
    val twoD: String?,
    val threeD: String?,
    val dxfUrl: String?,
    val decimate: String?,
)
