# README

This is a simple git project for adding a generic "About menu" to a Java Swing
application.  There are a couple of quick demonstration classes showing its
use.

This project is obviously not terribly serious, but just an attempt to use
GitHub.

## Setting up your environment

There are [git smudge and clean filters](https://git-scm.com/book/en/v2/Customizing-Git-Git-Attributes) included in this project which are core to making it work.

### Background
The included  `.gitattributes` file has an entry for the clean/smudge filter name:
```shell
$ cat .gitattributes
*.java filter=datedesc
```

and the filters are in the `bin` subdirectory:
```shell
$ ls bin/java*
bin/javaClean	bin/javaSmudge
```

### One time configuration
Configure your working tree to use these filters:

```shell
$ git config filter.datedesc.smudge $(git rev-parse --show-toplevel)/bin/javaSmudge
$ git config filter.datedesc.clean $(git rev-parse --show-toplevel)/bin/javaClean
```

Update the local files:

```shell
$ bin/updateAbout
```

## Building
Use the included demo script:
```shell
$ bin/runDemos
```
