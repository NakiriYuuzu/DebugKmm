package net.yuuzu.media.picker

class NoAccessToFileException(path: String) : RuntimeException("no access to $path")