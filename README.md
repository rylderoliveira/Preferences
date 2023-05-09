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

