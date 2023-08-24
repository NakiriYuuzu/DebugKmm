package net.yuuzu.media.data

expect interface ImageGallery {
    suspend fun getImages(): List<Image>
}