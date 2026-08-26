# command-objects-and-forms

Sample app for the apache/grails-static-website guide [command-objects-and-forms](https://grails.apache.org/guides/command-objects-and-forms/4/guide/index.html).

This branch is the Grails 8 companion for **Using Command Objects To Handle Form Data**: data binding, validation, and form handling with a `Player` domain and a `PlayerInfo` command object.

## Layout

| Directory | What it is |
|---|---|
| [`initial/`](initial/) | Grails 8 web starter (`web` profile, Hibernate, Tomcat, DevTools, H2) plus the `Player` domain, scaffold views, and sample data. No `PlayerController` yet — that is what the guide walks through. |
| [`complete/`](complete/) | The same starter with `PlayerController`, the `PlayerInfo` command object, unit tests, and a functional validation test. |

## Running

Requires JDK 21+.

```bash
cd complete
./gradlew bootRun
```

Then browse to http://localhost:8080/player

## Branches

| Branch | Grails version |
|---|---|
| `grails8` | Apache Grails 8.0.0-M5 |
| `grails4` | Apache Grails 4 (published guide) |

## License

Apache License 2.0. See [LICENSE](LICENSE).
