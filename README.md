# Data Store Proto

O Data Store Proto é o método de armazenamento de dados mais completo até o momento. Isso acontece devido ele ter todos os beneficios de Data Store Preferences e ser `Type Safety`, dessa forma, é possivel salvar objetos complexos no arquivo de armazenamento.

Este método utiliza o [protocol buffer](https://protobuf.dev/programming-guides/proto3/) para criar os modelos de dados a serem salvos no arquivo de preferencias. Uma vez os modelos declarados, é possivel salvar um objeto por completo no arquivo.

# Implementação

A implementação deste método é bastante complexa caso você não tenha conhecimento prévio ao `protocol buffer`. Sendo assim, sugiro seguir o passo a passo deste [CODELAB](https://developer.android.com/codelabs/android-proto-datastore?hl=pt-br#0).

# Conclusão

O Data Store Proto é um método mais completo de armazenamento, porém, é muito mais complexo de se implementar.
A forma de aplicar os protocolos não é muito clara e existe pouca informação sobre o tema. Acredito que o Data Store Preferences consegue atender muito bem a grande maioria das aplicações.

---

# Data Store Proto

Data Store Proto is the most comprehensive data storage method to date. This is because it combines all the benefits of Data Store Preferences with "Type Safety," allowing you to save complex objects in the storage file.

This method uses [protocol buffer](https://protobuf.dev/programming-guides/proto3/) to create data models to be saved in the preference file. Once the models are declared, it is possible to save a complete object in the file.

## Implementation

The implementation of this method is quite complex if you are not familiar with protocol buffer. Therefore, I suggest following the step-by-step guide in this [CODELAB](https://developer.android.com/codelabs/android-proto-datastore?hl=en#0).

# Conclusion

Data Store Proto is a more comprehensive storage method, but it is much more complex to implement. The process of applying the protocols is not very clear, and there is limited information available on the topic. I believe that Data Store Preferences can meet the needs of the majority of applications very well.
