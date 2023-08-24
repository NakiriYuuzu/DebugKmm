package net.yuuzu.media.data


actual interface ImageGallery {
    actual suspend fun getImages(): List<Image>
}
