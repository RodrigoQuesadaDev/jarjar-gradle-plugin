# Jar Jar Links Plugin for Gradle

Gradle plugin to allow for easier usage of [Jar Jar Links](https://code.google.com/archive/p/jarjar) in Java and Android projects.

## Usage

Here is a simple example of how to use it in your Gradle project:

```
apply plugin: 'com.rodrigodev.jarjar'

jarjar {
    rules {
        rule pattern: 'com.example.**', result: 'org.company.@0'
        zap pattern: 'com.removeme.**'
        keep pattern: 'com.keepme.**'
    }
    excludes = [
        'excluded_file.sample'
    ]
    output 'libs/repackaged.jar'
}
```

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/RodrigoQuesadaDev/jarjar-gradle-plugin/tags). 

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

