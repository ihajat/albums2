
# albums2

1. The language of preference is Kotlin.
2. The architecture that I have used is MVVM.
3. It uses the Android Architecture Components.
4. Uses ktlintFormat. See https://github.com/shyiko/ktlint for more information, but, to summarise, fix all style violations automatically by running a gradle task; so , you get a lot of formatting within minutes.
5. It uses Androidx.
6. DataBinding and LiveData, This allows the components in your app to be able to observe LiveData objects for changes without creating explicit and rigid dependency paths between them. This decouples completely the LiveData object producer from the LiveData object consumer.
7. Includes both unit tests and instrumentation tests. The unit test mainly tests the adapter, and the instrumentation tests that the recycler view is showing the correct number of albums and that the onClick works and shows the detail activity.
8. Has offline capability using ROOM database.
9. I have added an onClick handler, with a detailed activity shown, on click of the recycler view, to demonstrate , how to implement onClick with data binding and MVVM.
10. I have used the principles of singularity of responsibility and integration segregation ( SOLID ) and so kept the services separate.
11. I inject dependencies into the ViewModel. Dependency Injection is a form of Dependency Inversion ( SOLID ). I am using Dagger 2 to facilitate Dependency Injection.
12. I have called the Dagger component interface, ViewModelInjector, instead of the usual naming convention. I hope that wasn’t confusing. Each time we introduce a new ViewModel, it is added to this file.
