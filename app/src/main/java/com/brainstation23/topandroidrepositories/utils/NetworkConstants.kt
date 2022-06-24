package com.brainstation23.topandroidrepositories.utils

object NetworkConstants {
    internal const val API = "API"
    internal const val ACCEPT = "Accept"
    internal const val APPLICATION_JSON = "application/vnd.github.v3.text-match+json"

    internal const val PACKAGE = "package"
    internal const val VERSION = "version"

    internal const val TIMEOUT_CONNECTION: Long = 10 // 10 seconds
    internal const val TIMEOUT_READ: Long = 10 // 10 seconds
    internal const val TIMEOUT_WRITE: Long = 10 // 10 seconds

    internal const val QUERY = "Android"
    internal const val PAGE = "1"
    internal const val PER_PAGE = "50"
    internal const val SORT = "committer-date"
    internal const val ORDER = "asc"
}