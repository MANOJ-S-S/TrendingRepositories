# TrendingRepositories
To fetch all trending repository

Oveerview :
This is a single screen application which lists the trending repositories from a public api. It is developed in Kotlin following MVVM design pattern. The application lets you to search a repository by its name, supports offline storage to store the fetched repository details.



Libraries used : 

Material Design : - For androidx views / viewgroups.

Glide : - To load image from mock server.

 Circle Image view: - To use circle image view for language colour imageview.
 
 Retrofit : - To make network calls.
 
 RXJava : - For reactive response. 
 
 Jetpack Components: - Room database for offline storage; Livedata to respect activity lifecycle.
 
 Swipe refresh : - To implement swipe refresh for network call.
 
 
 
 
 Development approach :
 
 1) Followed the mvvm architecture structure to organize the different layers ( UI, business logics , data layer )
 2) Used rx java with retrofit builder for network calls.
 3) Used room database to setup offline storage.
 4) Used searchview to query search in the fetched list.
 5) Orientation and configuration handled for all screen sizes.
