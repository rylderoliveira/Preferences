# Hawk

O hawk é uma biblioteca externa para armazenamento de dados via CHAVE VALOR.
Essa biblioteca já foi e ainda é utilizada por muitas pessoas devido sua praticidade e confiabilidade.

GitHub Hawk: https://github.com/orhanobut/hawk

Infelizmente, o projeto está parado a algum tempo, o que pode deixa-lo defasado perante às novas implementações.

# Implementação

A implementação do Hawk é bem simples e está bem detalhada no GitHub do projeto.

# Arquivo XML 

Assim como o Shared Preferences e o Shared Preferences Encrypted, o Hawk salva os dados em chave valor em um arquivo XML. No entanto, este arquivo tem um nome padrão `Hawk2`.

O arquivo XML criado pelo Hawk pode ser encontrado utilizando o `Device File Explorer` do Android Studio, seguindo o seguinte caminho:

```
data >> data >> [PACKAGE_NAME] >> shared_prefs >> Hawk2.xml
```

Assim como o Shared Preferences Encrypted, os dados armazenados no XML do Hawk são encriptados como mostrado no exemplo abaixo:

```xml




