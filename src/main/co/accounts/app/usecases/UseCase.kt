package co.accounts.app.usecases

interface UseCase<T, Params> {

    fun execute(params: Params): T

}