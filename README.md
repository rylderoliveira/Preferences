# Data Store Proto

O Data Store Proto é o método de armazenamento de dados mais completo até o momento. Isso acontece devido ele ter todos os beneficios de Data Store Preferences e ser `Type Safety`, dessa forma, é possivel salvar objetos complexos no arquivo de armazenamento.

Este método utiliza o [protocol buffer](https://protobuf.dev/programming-guides/proto3/) para criar os modelos de dados a serem salvos no arquivo de preferencias. Uma vez os modelos declarados, é possivel salvar um objeto por completo no arquivo.

# Implementação

A implementação deste método é bastante complexa caso você não tenha conhecimento prévio ao `protocol buffer`. Sendo assim, sugiro seguir o passo a passo deste [CODELAB](https://developer.android.com/codelabs/android-proto-datastore?hl=pt-br#0).

# Conclusão

O Data Store Proto é um método mais completo de armazenamento, porém, é muito mais complexo de se implementar.
A forma de aplicar os protocolos não é muito clara e existe pouca informação sobre o tema. Acredito que o Data Store Preferences consegue atender muito bem a grande maioria das aplicações.
