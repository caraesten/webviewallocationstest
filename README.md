# Webview Allocations Test
A test to demonstrate how webview passes large strings via copying them in Android

## Screenshot
![application homescreen](https://github.com/caraesten/webviewallocationstest/blob/main/screenshots/app.png?raw=true)

The test is fairly self explanatory: one button allocates a big string, the other button sends that
big string over to Android.

## Observations
![profiling results](https://github.com/caraesten/webviewallocationstest/blob/main/screenshots/profile.png?raw=true)

### The initial allocation of the string doesn't happen within the app process
This is because Webviews in Android 8+ run in [multiprocess](https://developer.android.com/about/versions/nougat/android-7.0#multiprocess) mode.

### When the string is passed to the app process, an initial spike in native memory preceeds the Java allocation
I suspect this is because of a JNI operation that communicates with the webview process.

### Eventually, we can see the 20mb string being held as a reference in Java
It settles down into exactly 20mb more memory usage than it was before the string was transferred.