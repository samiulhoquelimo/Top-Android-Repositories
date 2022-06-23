package com.brainstation23.topandroidrepositories.ui.base.presenter

import com.androidnetworking.common.ANConstants
import com.androidnetworking.error.ANError
import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.data.network.response.ApiError
import com.brainstation23.topandroidrepositories.ui.base.interactor.MVPInteractor
import com.brainstation23.topandroidrepositories.ui.base.view.MVPView
import com.brainstation23.topandroidrepositories.ui.base.view.UiText
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.net.ssl.HttpsURLConnection

abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(
    protected var interactor: I?,
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable
) : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

    internal fun throwIt(throwable: Throwable) {
        throwable.printStackTrace()
    }

    internal fun println(message: Boolean) {
        kotlin.io.println(message)
    }

    override fun handleApiError(throwable: Throwable) {
        run {
            val anError = throwable as? ANError
            errorHandle(anError)
        }
    }

    private fun errorHandle(anError: ANError?) {
        getView()?.let { view ->
            val errorMessage: UiText = when (anError) {
                null -> UiText.StringResource(R.string.api_default_error)
                else -> when (anError.errorCode) {

                    0 -> when (anError.errorDetail) {
                        ANConstants.CONNECTION_ERROR ->
                            UiText.StringResource(R.string.connection_error)
                        ANConstants.REQUEST_CANCELLED_ERROR ->
                            UiText.StringResource(R.string.api_retry_error)
                        ANConstants.RESPONSE_FROM_SERVER_ERROR ->
                            UiText.StringResource(R.string.some_error)
                        else -> UiText.StringResource(R.string.api_default_error)
                    }

                    else -> when (anError.errorCode) {
                        HttpsURLConnection.HTTP_UNAUTHORIZED ->
                            UiText.StringResource(R.string.unauthorized_access)
                        else -> try {
                            val apiError = anError.getErrorAsObject(ApiError::class.java)
                            var message = ""
                            apiError.errors?.forEach { error ->
                                message = message + error.field + error.code
                            }
                            apiError.toErrorMessage()
                        } catch (e: Exception) {
                            e.printStackTrace()
                            UiText.StringResource(R.string.api_default_error)
                        }
                    }
                }
            }
            Timber.e(view.getResString(errorMessage))
        }
    }

    private fun ApiError.toErrorMessage(): UiText {
        var message = ""
        errors?.forEach { error ->
            message += "Field: ${error.field}, Code: ${error.code}, Resource: ${error.resource}"
        }
        if (message.isNotEmpty()) {
            return UiText.DynamicString(message)
        }

        return UiText.StringResource(R.string.api_default_error)
    }
}
