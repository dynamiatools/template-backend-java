# template-backend-java

Backend template for [DynamiaTools](https://dynamia.tools) using Spring Boot and Java. This repository is consumed
by the [DynamiaTools CLI](https://github.com/dynamiatools/framework/tree/main/platform/packages/cli)
(`dynamia new`) to scaffold new Java backends — it is not meant to be used standalone, though it builds and its
test suite runs as-is (`groupId`/`artifactId`/`package` default to `com.example`/`demo`; the CLI renames them to
your own coordinates during generation).

## Stack

- Java 25 (LTS)
- Spring Boot 4 (`spring-boot-starter-parent`)
- DynamiaTools (`tools.dynamia.app`, `tools.dynamia.domain.jpa`)
- Spring Data JPA + HSQLDB (in-memory, for local/dev runs)
- springdoc-openapi (OpenAPI/Swagger UI)
- Virtual threads enabled (`spring.threads.virtual.enabled: true`) — see
  [JEP 444](https://openjdk.org/jeps/444) / Spring Boot's virtual threads support.

## Requirements

| Tool | Version |
|---|---|
| JDK | 25 (a `.sdkmanrc` is included — run `sdk env` if you use [SDKMAN!](https://sdkman.io)) |
| Maven | none required — use the bundled `./mvnw` wrapper |

## Running locally

```bash
./mvnw spring-boot:run
```

Or build and run the jar:

```bash
./mvnw clean verify
java -jar target/*.jar
```

OpenAPI UI is available at `/swagger-ui.html` once the app is running.

## Template author conventions

This template is consumed by the DynamiaTools CLI's token-replacement pipeline
(`platform/packages/cli/src/utils/replace.ts` in the `framework` repo). When editing this template, keep in mind:

- `groupId`/`artifactId`/`version` in `pom.xml` **must stay valid Maven identifiers** (`com.example` / `demo` /
  `0.0.1-SNAPSHOT`) — Maven rejects `{{TOKEN}}`-style placeholders in those fields outright (`mvn validate` fails
  before the build even starts), so the CLI replaces them via exact-string matching instead of literal tokens.
- The parent's Spring Boot `<version>` and the `<dynamia.version>` property must stay **real, resolvable versions**
  at all times (not placeholders) — this repo needs to build standalone for CI and for local development of the
  template itself.
- The main source package must stay `com.example.demo` (under `src/main/java` and `src/test/java`) — the CLI moves
  this directory tree to the user's computed base package.
- The main application class must stay named `DemoApplication` — the CLI renames the file and class to
  `<ArtifactId>Application`.
- `<description>` is fully replaced by the CLI when the user provides one; keep a sensible default here for
  standalone builds.

## CI

`.github/workflows/build.yml` runs `./mvnw -B verify` on every push/PR to catch template breakage before a user
hits it via `dynamia new`.

## License

Apache-2.0 — © Dynamia Soluciones IT SAS
