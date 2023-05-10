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
<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <string name="ageKey">java.lang.Integer##0V@AQK7Cb8oKaDGDRmhzz4KRj+Gh8zga27Wi8uTrie3Zgc=</string>
    <string name="nameKey">java.lang.String##0V@AQLdKjf6OL/7CcFQG4jGSo6GcXCY94RNlTioMpcYKFzpdshf1wg=</string>
</map>
```

Se compararmos os dados encriptados deste método com o método de Shared Preferences Encrypted, podemos perceber que com o Hawk, apenas os VALORES são encriptados, enquanto no outro método, ambos (CHAVE-VALOR) são encriptados. O que pode trazer um pouco mais de segurança aos dados armazenados.

Além do arquivo XML que armazena os dados, também é gerado um arquivo contendo a chave de encriptação.

# Conclusão

O armazenamento de dados com o Hawk é bem simples e eficiente. No entanto, está um pouco defasado comparado aos seus novos métodos utilizandos. Uma grande vantagem do Hawk é o tipo genérico em suas operações, isso (apesar de não ser uma boa prática) permite armazenar objetos mais complexos na memória sem qualquer conversão prévia (novamente, isso não é nada indicado) e é compativel com API's inferiores, caso seja necessário no projeto.

As desvantagens de se utilizar o Hawk são: biblioteca externa (dependencia de terceiros para manutenção do código da lib), encriptação apenas dos valores, nome do arquivo não customizavel (não consegui mudar o nome, talvez tenha alguma forma).
