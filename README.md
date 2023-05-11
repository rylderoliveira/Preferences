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

---

# Data Store Preferences

Data Store Preferences emerged as a smaller, faster, and more secure alternative to Shared Preferences. Currently, Google strongly recommends upgrading from Shared Preferences to Data Store Preferences. To accomplish this, it is possible to create a relatively simple migration between both libraries. This migration is not exemplified in this example but can be found in the Data Store documentation.

## Implementation

To access the `Data Store Preferences` class, you need to implement a library in the app's `build.gradle` file:

```gradle
// Data Store
implementation "androidx.datastore:datastore-preferences:1.0.0"

// Lifecycle
implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
```

After implementing and syncing the project, instantiate the dataStore as follows:

```kotlin
private val dataStore: DataStore<Preferences> by preferencesDataStore(name = "myDataStorePreferences")
```

Access the MainActivity.kt class to see the rest of the implementation.

# Storage File

The file that stores the data is a .preferences_pb file. This file stores the data and organizes it with key-value pairs in a format similar to JSON, as shown in the example below:

```preferences_pb
Copy code
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
To access the data, you need to use a special text editor or retrieve the information via the command line. External data acquisition is not demonstrated in this example.

# Conclusion

Data Store Preferences is a method that is easily implemented and utilizes the power of coroutines, executing storage actions on a separate thread, without blocking the UI. The Data Store returns objects through a Flow<T>, which allows for executing various tasks during the data acquisition and storage flow.

In this example, the features of Flow<T> were not used as they were not the focus of the study.

In general, Data Store is superior to Shared Preferences and Shared Preferences Encrypted. The table below presents the advantages and disadvantages of each method (excluding Shared Preferences Encrypted).

![image](https://github.com/rylderoliveira/Preferences/assets/69598626/b0b58529-8caa-4127-aff3-24b422314c3b)

NOTE: Shared Preferences Encrypted is not compatible with API 23 or lower.


