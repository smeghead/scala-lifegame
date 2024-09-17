## sbt project compiled with Scala 3

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).


### Development

```bash
docker run --rm -it -v $(pwd):/root sbtscala/scala-sbt:eclipse-temurin-alpine-21.0.2_13_1.10.1_3.5.0 bash
```
