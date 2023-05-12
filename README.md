# Shared Preferences

O Shared Preferences salva um conjunto de dados pequenos em um arquivo XML no dispositivo.

Estes dados são salvos utilizando CHAVE-VALOR.

O arquivo XML no qual são salvos os dados deve ser nomeado quando instanciamos a classe. Além disso, devemos passar como parâmetro o modo de privacidade do arquivo, por padrão, recomenda-se utilizar o MODE_PRIVATE.

Os dados que serão salvos no Shared Preferences devem ser dados primitivos:

1. String
2. Int
3. Float
4. Boolean
5. Long

Acesse https://developer.android.com/training/data-storage/shared-preferences?hl=pt-br para caso queira mais informações sobre o Shared Preferences.

# Arquivo XML

O arquivo XML criado pelo Shared Preferences pode ser encontrado utilizando o `Device File Explorer` do Android Studio, seguindo o seguinte caminho:

```
data >> data >> [PACKAGE_NAME] >> shared_prefs >> [NOME_DO_ARQUIVO]
```

No meu caso, o arquivo se chama `mySharedPreferences`.
Esse nome foi dado instanciar o Shared Preference, conforme a documentação:

```kotlin
sharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE)
```

Dentro deste arquivo iremos encontrar um `map` com as chaves e os valores salvos. Exemplo:

```xml
<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <int name="ageKey" value="26" />
    <string name="nameKey">Rylder</string>
</map>
```
# Conclusão 

O Shared Preference é bem simples de ser utilizado e pode ser facilmente aplicado em situações em queremos salvar um conjunto pequeno de dados e estes dados não são sensiveis, visto que, esses dados podem ser facilmente acessados no arquivo criado, sem qualquer tipo de encripitação.

---

# Shared Preferences

Shared Preferences saves a small set of data in an XML file on the device.

This data is saved using KEY-VALUE pairs.

The XML file in which the data is saved must be named when we instantiate the class. Additionally, we must pass the file's privacy mode as a parameter, by default, it is recommended to use MODE_PRIVATE.

The data that will be saved in Shared Preferences must be primitive data types:

String
Int
Float
Boolean
Long
Visit https://developer.android.com/training/data-storage/shared-preferences for more information about Shared Preferences.

# XML File

The XML file created by Shared Preferences can be found using the Android Studio's Device File Explorer, following this path:

```
data >> data >> [PACKAGE_NAME] >> shared_prefs >> [FILE_NAME]
```

In my case, the file is named mySharedPreferences.
This name was given when instantiating the Shared Preference, according to the documentation:

```kotlin
sharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE)
```

Inside this file, we will find a map with the keys and saved values. Example:

```xml
<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <int name="ageKey" value="26" />
    <string name="nameKey">Rylder</string>
</map>
```

# Conclusion

Shared Preference is very simple to use and can be easily applied in situations where we want to save a small set of data and this data is not sensitive, since this data can be easily accessed in the created file without any encryption.
