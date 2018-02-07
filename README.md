# Weather-Application
Simple weather application.

Use searchbar to check current weather all over the world.

## Getting Started

These instructions will help you to run a copy of the project on your Android emulator or a real Android device for *development* and testing purposes.

### Prerequisites

It's good to have:
* [AndroidStudio](https://developer.android.com/studio/index.html)

It's vital to have:
* your own [OpenWeatherMap](https://openweathermap.org/) API Key
* your own [Google Maps](https://developers.google.com/maps/) API Key

###  Start Project

* prepare an IDE for development
* clone or download a project
* put your Google Maps API key to AndroidManifest.xml file
```
<meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_maps_key" />
```
* put your OpenWeatherMap API key to Function.java file
```
//Add your Open weather map API key
    private static final String OPEN_WEATHER_MAP_API = "XXXXXXXXXXXXXXXXXXX";
```
* if you want to - change design by using other wallpapers. Just change files on below direction:
```
src/main/res/drawable
```
###  Testing

Don't forget to use shake gesture after finding a current weather information for choosen city.

## Built With

* [AndroidStudio](https://developer.android.com/studio/index.html)- the officail IDE for Android.
* [JSON]http://devdocs.io/javascript/global_objects/json
* [XML](https://developer.android.com/guide/topics/ui/declaring-layout.html) - using Android's XML vocabulary.

## Authors

* **Kasia Vasiluk** - *Hamster Bay* [github: Chomcio](https://github.com/chomcio)
