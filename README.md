# Preferences

Este aplicativo tem como objetivo apurar e comparar alguns métodos utilizados para salvamento de dados em memória (CACHE).

Os métodos comparados serão:

1. SharedPreference
2. SharedPreference (Encrypted)
3. Hawk
4. Data Store Preference
5. Data Store Proto

**Cada um dos métodos comparados será demostrado em uma branch separada conforme o nome de cada método apresentado acima.**

# Layout

![image](https://github.com/rylderoliveira/Preferences/assets/69598626/317cce9c-5ac6-4275-be57-001675eccf8b)

O layout do projeto é bem simples e será o mesmo em todas as branchs, visto que o foco principal deste app é comparar os diferentes métodos de salvar dados no dispositivos.

Obs.: Estou utilizando viewBinding no projeto apenas para facilitar a localização das referências no layout sem fazer o `findViewById`.

# Conclusão

Para uma visão de cada método, acesse a branch do respectivo método.

Todos os métodos apresentados podem ser implementados em projetos atuais. Cada método tem suas vantagens e limitações. A aplicabilidade de cada um dos métodos vai depender dos requisitos e do objetivo do projeto. Na minha opnião, o Shared Preferences Encrypted e o Data Store Preference são os melhores métodos, já que conseguem manter a simplicidade de implementação, com um bom nível de segurança.

---

# Preferences

This application aims to evaluate and compare various methods used for data storage in memory (CACHE).

The methods being compared are:

1. SharedPreference
2. SharedPreference (Encrypted)
3. Hawk
4. Data Store Preference
5. Data Store Proto

**Each of the compared methods will be demonstrated in a separate branch according to the name of each method mentioned above.**

# Layout

![image](https://github.com/rylderoliveira/Preferences/assets/69598626/317cce9c-5ac6-4275-be57-001675eccf8b)

The project layout is simple and will be the same across all branches, as the main focus of this app is to compare different methods of data storage on devices.

Note: I am using viewBinding in the project solely to facilitate the localization of references in the layout without using `findViewById`.

# Conclusion

For a detailed view of each method, please access the branch corresponding to the respective method.

All the presented methods can be implemented in current projects. Each method has its advantages and limitations. The applicability of each method will depend on the project's requirements and objectives. In my opinion, Shared Preferences Encrypted and Data Store Preference are the best methods as they maintain simplicity of implementation with a good level of security.

