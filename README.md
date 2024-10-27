# ShoeStore

ShoeStore is an app designed to help users catalog and bookmark their favorite shoes, providing a simple and organized way to save and manage a personalized shoe collection.
It was developed as the first Project of the **Udacity Android Kotlin Developer Nanodegree Program**.

The main features of this release are:
* Implement MVVM Design Pattern and Clean Architecture.
* Ability to create your own bookmarked shoes list and save Data inside SharedViewModel.
* Using the App in Landscape and Portrait mode without any data missing or reloading the data.
* Implement simplified layout using ConstraintLayout only or non-nested LinearLayout or FrameLayout.
* Implement the power of DatabindingAdapter.
* Implement Koin for Dependency injection.
* Implement Flow to create dynamic filling forms.
* Implement Single Activity and multiple fragments Design Patterns.
* Implement Jetpack DataStore to store and retrieve user preferences asynchronously.
* Onboarding screen.


What External library used:
-------

* [Koin](https://github.com/johncarl81/parceler), for dependany injection.

* [Timber](https://github.com/JakeWharton/timber), for code logging.

* [Glidev4](http://bumptech.github.io/glide/doc/getting-started.html), for loading and fetching photos.

* [KSP](https://developer.android.com/build/migrate-to-ksp), for annotation processors plugins compiler.

* [DatasStore](https://developer.android.com/topic/libraries/architecture/datastore), for storing and retrieving user preferences asynchronously.

* [Security Crypto](https://developer.android.com/jetpack/androidx/releases/security), for encryption of user-sensitive data.

* [CircleIndicator](https://github.com/ongakuer/CircleIndicator), for ViewPager pages indicator.

* [CircularProgressBar](https://github.com/lopspower/CircularProgressBar), for Circular Progress for Onboarding screens.


Useful links:
-------

* [Android Kotlin Developer Nanodegree Program](https://www.udacity.com/course/android-kotlin-developer-nanodegree--nd940), for the full details of the Program and its related projects.
* [Starter Project Code](https://github.com/udacity/nd940-android-kotlin-course1-starter), for the starter code of the Project.
* [Project Rubric](https://docs.google.com/document/d/1n1vvMoQ_cv2E9NDcej7WDQMTqsY096dTPyh7Alkb1_0/edit?usp=sharing), for the Project Rubric.


Snapshots from the app:
-------
* Phone Screens (Portrait):

<div align="center">
<table>
  <tr>
    <td>
      <div align="center">
      <div style="display: inline-block; margin: 10px;">
      <img src="./images/login.jpg" width="300" height="666" />
      <p>Login Screen</p>
      </div>
    </td>
    <td>
      <div align="center">
      <div style="display: inline-block; margin: 10px;">
      <img src="./images/onboarding.jpg" width="300" height="666" />
      <p>Onboarding Screen</p>
      </div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="center">
      <div style="display: inline-block; margin: 10px;">
      <img src="./images/add_shoe_to_bookmark.jpg" width="300" height="666" />
      <p>Add Shoe to Bookmark</p>
      </div>
    </td>
    <td>
      <div align="center">
      <div style="display: inline-block; margin: 10px;">
      <img src="./images/flow_form.gif" width="300" height="666" />
      <p>Dynamic Filling Form</p>
      </div>
    </td>
  </tr>
</table>
</div>

* Phone Screens (Landscape):

<div align="center">
  <div style="display: inline-block; margin: 10px;">
    <img src="./images/bookmark_list_landscape.jpg" width="666" height="300" />
    <p>Bookmark List in Landscape Mode</p>
  </div>
</div>
