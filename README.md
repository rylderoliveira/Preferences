# Shared Preferences Encrypted

Funciona basicamente como o Shared Preference, a grande diferença entre as duas forma é a segurança.

Uma das grandes falhas do shared preferences padrão é a falta de segurança e o Shared Preference encriptado veio para resolver esse problema.

# Implementação

Para conseguir acessar a classe `EncryptedSharedPreferences` é preciso implementar uma biblioteca ao `build.gradle` no escopo do app.

```gradle
implementation "androidx.security:security-crypto:1.0.0"
```

Após fazer a implementação e sincronizar o projeto, instancie o `sharedPreferences` da seguinte forma:

```kotlin
val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
sharedPreferences = EncryptedSharedPreferences.create(
    "mySharedPreferencesEncrypted",
    mainKeyAlias,
    applicationContext,
    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
)
```

Essa implementação pode ser encontrada [aqui](https://developer.android.com/topic/security/data?hl=pt-br#edit-shared-preferences)

# Arquivo XML

Assim como o Shared Preferences, é possível acesso o arquivo XML criado pelo `Device File Explorer` pelo caminho:

```
data >> data >> [PACKGE_NAME] >> shared_prefs >> [NOME_DO_ARQUIVO]
```

Neste arquivo, as chaves e os valores são encriptados conforme o modelo de encriptação descrito na criação da referência.
Abaixo, está um exemplo de como ficam os dados no novo arquivo XML.

```xml
<map>
    <string name="__androidx_security_crypto_encrypted_prefs_key_keyset__">12a9010cc698dc1bfc58ef73eb336620c9ca5c771b4c23570578cb8e466f1046982a076e47a817efb8492c0bac9154cfe61f628abdc863330188b09fd6be615fbcf3c915482b6c0cf08584a7df27ceacd3f3a7786b9d975aab315c1bc5e2b3bd2331a90631439dc13b5ababccde0c928df131742c57c9baa988c70c1034ec32ccb9b50656d258132919eb9fc4d048399d44d0fb93895222d4200524be5fe6ec1c80ed40bc1472e16f83818871a4408f8948baa07123c0a30747970652e676f6f676c65617069732e636f6d2f676f6f676c652e63727970746f2e74696e6b2e4165735369764b6579100118f8948baa072001</string>
    <string name="AXVCyniAR0Sg0DBF0PW6dhAVDbd99yaWZqYJ">ASiny0LH+Lk51dDNe+juadqarCVX26hoCUG7x0fLpKfD05mxi1y9psk=</string>
    <string name="__androidx_security_crypto_encrypted_prefs_value_keyset__">128801de6a32961d2fd644b2c11a386be7f15ca5dcbd27d4fd682a046d57f7299c3c6717330a41baedb2e20c8392a8fe8fdbfaaff6e569c5083eebd6f76222b96d021c7b21fa0a31dfe955213e975ac91096cb29596933d5b9dea1760a9a7a9cc1f9c847bebdb40b31655a40c0d5bddf491418a44565e140b2a6c9f6868923f7b12b74031eee65530f0e211a4408c2969fc502123c0a30747970652e676f6f676c65617069732e636f6d2f676f6f676c652e63727970746f2e74696e6b2e41657347636d4b6579100118c2969fc5022001</string>
    <string name="AXVCyniG8ocrM5eMRm5rxYouEKqkAlHq270Z5A==">ASiny0LYmNDM054ErwHN+ru2qvkhyhwkXnVhldOnhhwXW91IYHXiS0mpPoEwNjU=</string>
</map>
```

# Conclusão

O Shared Preferences Encrypted é uma ótima opção para salvar alguns dados sensiveis no aparelho do usúario, uma vez que salva os dados de forma encripada, o que dificulta a obtenção e interpretação dos dados. Apesar dos dados salvos serem exatamente iguais em todos os exemplos, o método encriptado salva todas as informações como `String`.

Uma desvantagem desse modelo é o tamanho do arquivo, como o dado armazenado foi encriptado, uma quantidade maior de caracteres é armazenada no lugar do dado puro, o que causa um aumento de até 7x no peso do arquivo. Esse valor, apesar de ser alto, é praticamente **irrisório**, visto que o arquivo **não encriptado tem 150B** e o **encriptado tem 1.1KB**.

---

# Shared Preferences Encrypted

Shared Preferences Encrypted works similarly to Shared Preferences, with the key difference being security.

One of the major flaws of the standard Shared Preferences is the lack of security, and Encrypted Shared Preferences was introduced to solve this problem.

## Implementation

To access the `EncryptedSharedPreferences` class, you need to add a library to the app's `build.gradle` file.

```gradle
implementation "androidx.security:security-crypto:1.0.0"
```

After implementing and syncing the project, instantiate the sharedPreferences as follows:
 
```kotlin
val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
sharedPreferences = EncryptedSharedPreferences.create(
    "mySharedPreferencesEncrypted",
    mainKeyAlias,
    applicationContext,
    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
)
```
You can find this implementation [here](https://developer.android.com/topic/security/data?hl=pt-br#edit-shared-preferences).

# XML File

Similar to Shared Preferences, you can access the XML file created by the Device File Explorer using the following path:

```
data >> data >> [PACKAGE_NAME] >> shared_prefs >> [FILE_NAME]
```

In this file, the keys and values are encrypted according to the encryption scheme described during the reference creation. Below is an example of how the data appears in the new XML file.

```xml
<map>
    <string name="__androidx_security_crypto_encrypted_prefs_key_keyset__">12a9010cc698dc1bfc58ef73eb336620c9ca5c771b4c23570578cb8e466f1046982a076e47a817efb8492c0bac9154cfe61f628abdc863330188b09fd6be615fbcf3c915482b6c0cf08584a7df27ceacd3f3a7786b9d975aab315c1bc5e2b3bd2331a90631439dc13b5ababccde0c928df131742c57c9baa988c70c1034ec32ccb9b50656d258132919eb9fc4d048399d44d0fb93895222d4200524be5fe6ec1c80ed40bc1472e16f83818871a4408f8948baa07123c0a30747970652e676f6f676c65617069732e636f6d2f676f6f676c652e63727970746f2e74696e6b2e4165735369764b6579100118f8948baa072001</string>
    <string name="AXVCyniAR0Sg0DBF0PW6dhAVDbd99yaWZqYJ">ASiny0LH+Lk51dDNe+juadqarCVX26hoCUG7x0fLpKfD05mxi1y9psk=</string>
    <string name="__androidx_security_crypto_encrypted_prefs_value_keyset__">128801de6a32961d2fd644b2c11a386be7f15ca5dcbd27d4fd682a046d57f7299c3c6717330a41baedb2e20c8392a8fe
```

# Conclusion

Shared Preferences Encrypted is an excellent option for storing sensitive data on a user's device since it saves the data in an encrypted form, making it difficult to obtain and interpret. Although the saved data is exactly the same in all examples, the encrypted method stores all information as a `String`.

One disadvantage of this approach is the file size. Since the stored data is encrypted, a larger number of characters is required compared to the raw data, resulting in an increase of up to 7 times the file size. However, this increase is practically **insignificant**, considering that the **unencrypted file is 150B** while the **encrypted file is 1.1KB**.

Therefore, despite the slightly larger file size, the enhanced security provided by Shared Preferences Encrypted makes it a worthwhile choice for storing sensitive data on the user's device.
