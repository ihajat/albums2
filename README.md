	1.	The language of preference is Kotlin.
	2.	The architecture that I have used is MVVM.
	3.	It uses the Android Architecture Components.
	4.	Uses ktlintFormat. See https://github.com/shyiko/ktlint for more information, but, to summarise, fix all style violations automatically by running a gradle task.
	5.	It uses Androidx.
	6.	LiveData, This allows the components in your app to be able to observe LiveData objects for changes without creating explicit and rigid dependency paths between them. This decouples completely the LiveData object producer from the LiveData object consumer.
	7.	Includes both unit tests and instrumentation tests.
	8.	Has offline capability using ROOM database.
	9.	I have used the principles of singularity of responsibility and integration segregation ( SOLID ) and so kept the services separate.
	10.	I inject dependencies into the Presenter. Dependency Injection is a form of Dependency Inversion ( SOLID ). I am using Dagger 2 to facilitate Dependency Injection
	11.	Regarding Dagger injection, of presenters, if the task was more complicated, and for example, required several presenters ( if MVP was used ) , then I would have created a BasePresenter class, that would setup the injection , so, Presenters wouldn’t have to deal with setting up injection, except the function inject() that requires the object of the Presenter class to be passed into the inject function.
	12.	I have called the Dagger component interface, PresenterInjector, instead of the usual naming convention. I hope that wasn’t confusing. Again, if we had multiple presenters, they would all be included in this file.
# albums2
