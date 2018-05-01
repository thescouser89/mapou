# Mapou lockfile alignment



## Basic workflow

```java
// Object to read, and modify versions in the lockfile
ILockfile lockfile = new ...;

// Object to get the internal versions for public dependencies
ITranslator translator = new ...;

// Get all the public dependencies we want to align to internal versions
Set<PublicDependency> publicDeps = lockfile.getAllDependencies();

// Align the public deps to internal versions
Map<PublicDependency, InternalDependency> translated = translator.translateVersions(Mode.NPM, publicDeps);

// Modify the lockfile to set the version to the internal ones
lockfile.scanAndReplaceDependency(translated);
```

Modules that implement the `ILockfile` interface start with 'lockfile'.
Modules that implement the `ITranslator` interface start with 'translator'.

The Translator might have to use different logic for different types of builds.
This is why the kind of version being aligned is passed to it.

## Extra attributes for Dependency classes

The `PublicDependency` and `PrivateDependency` classes allow for the lockfile
to add extra attributes to help the lockfile implementation and perhaps the
translator in its job. It is optional and will contain implementation specific
data.
