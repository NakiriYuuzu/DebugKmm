package net.yuuzu.media.player

interface MediaPlayerListener {
    fun onReady()
    fun onVideoCompleted()
    // TODO HIGH add onPlay, onPause events
}