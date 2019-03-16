# MonoSink#onRequest bug
Test that reproduces problem with `MonoSink#onRequest` method not being called although it must be.

Link to issue: https://github.com/reactor/reactor-core/issues/1560

### How to reproduce
`./mvnw clean test`
