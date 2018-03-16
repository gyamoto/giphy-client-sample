package com.gyamoto.giphy.architecturecomponent

/**
 * Guide to App Architecture: https://developer.android.com/topic/libraries/architecture/guide.html#addendum
 */
data class Resource<out T>(
        val status: Status,
        val response: T?,
        val error: Throwable?) {

    companion object {

        sealed class Status {
            object Progress : Status()
            object Success : Status()
            object Error : Status()
        }

        fun <T> progress(data: T?): Resource<T> {
            return Resource(Status.Progress, data, null)
        }

        fun <T> success(data: T): Resource<T> {
            return Resource(Status.Success, data, null)
        }

        fun <T> error(data: T?, error: Throwable): Resource<T> {
            return Resource(Status.Error, data, error)
        }
    }

}
