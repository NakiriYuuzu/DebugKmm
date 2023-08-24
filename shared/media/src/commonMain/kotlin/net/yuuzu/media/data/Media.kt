package net.yuuzu.media.data

data class Media(
    val name: String,
    val path: String,
    val preview: AppBitmap,
    val type: MediaType
)