**Splash Screen**

This package contains a sample Android application demonstrating the implementation of splash screens using various techniques.

### Contents:

- `MainActivity.kt`: This Kotlin file contains the main activity of the application.
- `AnimationSplashActivity.kt`: This Kotlin file contains an activity with an animated splash screen.
- `GifSplashActivity.kt`: This Kotlin file contains an activity with a GIF splash screen.
- `SplashScreen.kt`: This Kotlin file contains the splash screen activity which displays a simple splash screen with a delay before transitioning to the main activity.

### Usage:

To use this package, follow these steps:

1. Include the `splashscreen` package in your Android project.
2. Import the necessary classes in your activity or fragment.
3. Choose the appropriate splash screen implementation based on your requirements.
4. Customize the splash screen layout and animations as needed.

### Example:

```kotlin
// Displaying a simple splash screen with delay
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startHeavyTask()
    }

    private fun startHeavyTask() {
        LongOperation().execute()
    }

    private inner class LongOperation : AsyncTask<String?, Void?, String>() {
        override fun doInBackground(vararg params: String?): String {
            // Simulate heavy task or loading operation
            Thread.sleep(3000)
            return "Result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
```

### Notes:

- Customize the splash screen implementation according to your application's requirements.
- Ensure that the splash screen layout and animations provide a smooth transition to the main activity.

### Dependencies:

No external dependencies are required for this package.

### Author:

This package was created by `DEVANSH SATI` for educational and demonstration purposes.

### License:

This code is provided under the MIT License. See the LICENSE file for details.
