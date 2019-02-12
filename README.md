
# albums2

The language of preference is Kotlin.
The architecture that I have used is MVVM.
It uses the Android Architecture Components.
Uses ktlintFormat. See https://github.com/shyiko/ktlint for more information, but, to summarise, fix all style violations automatically by running a gradle task.
It uses Androidx.
LiveData, This allows the components in your app to be able to observe LiveData objects for changes without creating explicit and rigid dependency paths between them. This decouples completely the LiveData object producer from the LiveData object consumer.
Includes both unit tests and instrumentation tests.
Has offline capability using ROOM database.
I have used the principles of singularity of responsibility and integration segregation ( SOLID ) and so kept the services separate.
I inject dependencies into the ViewModel. Dependency Injection is a form of Dependency Inversion ( SOLID ). I am using Dagger 2 to facilitate Dependency Injection
Regarding Dagger injection, of presenters, if the task was more complicated, and for example, required several ViewModels ( if MVP was used ) , then I would have created a BaseViewModel class, that would setup the injection , so, ViewModels wouldn’t have to deal with setting up injection, except the function inject() that requires the object of the ViewModel class to be passed into the inject function.
I have called the Dagger component interface, PresenterInjector, instead of the usual naming convention. I hope that wasn’t confusing. Again, if we had multiple presenters, they would all be included in this file.
