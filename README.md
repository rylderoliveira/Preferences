# Data Store Preferences

O Data Store Preferences surgiu como uma alternativa menor, mais rapida e mais segura ao Shared Preferences.
Atualmente, o Google está indicando fortemente a atualização do Shared Preferences para o Data Store Preferences, para que isso ocorra, é possivel criar uma migração entre ambas as bibliotecas de forma relativamente simples. Essa migração não foi exemplificada neste exemplo, mas pode ser encontrada na documentação do Data Store.

# Implementação

Para conseguir acessar a classe `Data Store Preferences` é preciso implementar uma biblioteca ao `build.gradle` no escopo do app.

```gradle
// Data Store
implementation "androidx.datastore:datastore-preferences:1.0.0"

// Lifecycle
implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
```

Após fazer a implementação e sincronizar o projeto, instancie o `dataStore` da seguinte forma:

```kotlin
private val dataStore: DataStore<Preferences> by preferencesDataStore(name = "myDataStorePreferences")
```

Acesse a classe [MainActivity.kt](app/src/main/java/com/rylderoliveira/preferences/MainActivity.kt) e verique o restante da implementação.

# Arquivo de armazenamento

O arquivo que armazena os dados é um `.preferences_pb`. Este arquivo armazena os dados e os organizam com chave e valor em um formato parecido com um `JSON`, conforme mostra o exemplo abaixo:

```preferences_pb
1 {
    1: "nameKey"
    2 {
        5: "Rylder"
    }
}
1 {
    1: "ageKey"
    2 {
        1: 26
    }
}
```
Para acessar os dados, é preciso usar um editor de texto especial ou pegar as informações via linha de comando.
A aquisição externa dos dados também não será demostrado neste exemplo.

# Conclusão

O Data Store Preferences é um método de simples implementação que utiliza todo o poder das `coroutines`, executando as ações de armazenamento em uma thread separada, não bloqueando a UI. O Data Store retorna os objetos através de um `Flow<T>` esse objeto permite executar diversas tarefas durante o fluxo de aquisição e armazenamento dos dados.

No exemplo não utilizei os recursos do `Flow<T>` por não ser o foco do estudo.

De forma geral, o Data Store é superior ao **Shared Preferences** e o **Shared Preferences Encrypted**.
Abaixo está apresentado um quadro com as vantagens e desvantagens de cada método (exceto Shared Preferences Encrypted).

![image](https://github.com/rylderoliveira/Preferences/assets/69598626/b0b58529-8caa-4127-aff3-24b422314c3b)

**OBS.: O Shared Preferences Encrypted não é compativel com API 23 ou inferior**





