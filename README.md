This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.

**Links**
jetbrains compose
- https://kmp.jetbrains.com/#newProject
- https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html#examine-the-project-structure
- 

Compose animation
- https://developer.android.com/develop/ui/compose/animation/advanced
- 

Decompose
- https://github.com/arkivanov/Decompose
- https://arkivanov.github.io/Decompose/getting-started/quick-start/
- https://github.com/arkivanov/decompose-multiplatform-template/tree/master
- https://medium.com/@yeldar.nurpeissov/using-kmp-with-decompose-839dae885c15
- https://arkivanov.github.io/Decompose/samples/

Koin
- https://github.com/InsertKoinIO/koin?tab=readme-ov-file
- https://insert-koin.io/docs/reference/koin-compose/compose

Koil
- https://coil-kt.github.io/coil/svgs/
- 

JS interop
- https://kotlinlang.org/docs/wasm-js-interop.html#kotlin-functions-with-javascript-code
- 
