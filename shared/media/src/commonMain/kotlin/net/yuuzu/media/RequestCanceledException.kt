package net.yuuzu.media

class RequestCanceledException(
    val permission: Permission,
    message: String? = null
) : Exception(message)
