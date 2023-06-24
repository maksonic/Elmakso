package ru.maksonic.elmakso.core

/**
 * @Author maksonic on 24.06.2023
 */
data class BaseModelComponent(
    val isInitial: Boolean,
    val isLoading: Boolean,
    val isRefreshing: Boolean,
    val successAfterLoading: Boolean,
    val failAfterLoading: Boolean,
    val successAfterRefresh: Boolean,
    val failAfterRefresh: Boolean,
    val isFail: Boolean,
    val failMessage: String?,
) {
    companion object {

        val BaseModelComponent.Initial
            get() = this.copy(
                isInitial = true,
                isLoading = false,
                isRefreshing = false,
                successAfterLoading = false,
                failAfterLoading = false,
                successAfterRefresh = false,
                failAfterRefresh = false,
                isFail = false,
                failMessage = "",
            )

        val BaseModelComponent.Loading
            get() = this.copy(
                isInitial = false,
                isLoading = true,
                isRefreshing = false,
                successAfterLoading = false,
                failAfterLoading = false,
                successAfterRefresh = false,
                failAfterRefresh = false,
                isFail = false,
                failMessage = "",
            )

        val BaseModelComponent.Refresh
            get() = this.copy(
                isInitial = false,
                isLoading = false,
                isRefreshing = true,
                successAfterLoading = false,
                failAfterLoading = false,
                successAfterRefresh = false,
                failAfterRefresh = false,
                isFail = false,
                failMessage = "",
            )

        val BaseModelComponent.loadedSuccess
            get() = this.copy(
                isInitial = false,
                isLoading = false,
                isRefreshing = false,
                successAfterLoading = true,
                failAfterLoading = false,
                successAfterRefresh = false,
                failAfterRefresh = false,
                isFail = false,
                failMessage = "",
            )

        val BaseModelComponent.loadedFailure: (String) -> BaseModelComponent
            get() = { failMessage ->
                this.copy(
                    isInitial = false,
                    isLoading = false,
                    isRefreshing = false,
                    successAfterLoading = false,
                    failAfterLoading = true,
                    successAfterRefresh = false,
                    failAfterRefresh = false,
                    isFail = false,
                    failMessage = failMessage,
                )
            }

        val BaseModelComponent.refreshedSuccess
            get() = this.copy(
                isInitial = false,
                isLoading = false,
                isRefreshing = false,
                successAfterLoading = false,
                failAfterLoading = false,
                successAfterRefresh = true,
                failAfterRefresh = false,
                isFail = false,
                failMessage = "",
            )

        val BaseModelComponent.refreshedFailure: (String) -> BaseModelComponent
            get() = { failMessage ->
                this.copy(
                    isInitial = false,
                    isLoading = false,
                    isRefreshing = false,
                    successAfterLoading = false,
                    failAfterLoading = false,
                    successAfterRefresh = false,
                    failAfterRefresh = true,
                    isFail = false,
                    failMessage = failMessage,
                )
            }

        val BaseModelComponent.failure: (String) -> BaseModelComponent
            get() = { failMessage ->
                this.copy(
                    isInitial = false,
                    isLoading = false,
                    isRefreshing = false,
                    successAfterLoading = false,
                    failAfterLoading = false,
                    successAfterRefresh = false,
                    failAfterRefresh = false,
                    isFail = true,
                    failMessage = failMessage,
                )
            }
    }
}