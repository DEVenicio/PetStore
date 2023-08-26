# PetStore

-O app possui SplashScreen, uma tela inicial com Toolbar e BottomNavigation exibindo uma lista de produtos <br>
- Na tela inicial é exibido uma seção com as categorias e rolagem horizontal <br>
- E uma lista com as categorias e produtos de cada categoria com rolagem vertical e horizontal. <br>
- Ao clicar em um produto é exibido uma tela de detalhes onde é possivel "adicionar o item no carrinho" com um campo de observação 
com limite de caracteres e atualização de limite dinâmica. Um campo para aumentar ou diminuar a quantidade de produtos 
e ao clicar no botão adicionar, você volta para a Home onde é exibido o "valor dos produtos no carrinho" <br>
- Para utilizar o app,  abra no Android Studio e faça o clone do projeto e execute o app no emulador ou um dispositivo fisico <br>
- No app foi feito todo o processo para realizar chamadas a API reais, inclusive está sendo feito uma chamada para a API Via CEP,
  com um endpoint "real" porém o retorno da api é mockado e o que é exibido como retorno da api é um Json que se encontra no projeto e pode ser manipulado.
- As imagens das categorias são consumidas da internet e carregads em tempo real com o Glide. 

- Obs: Ficou faltando implementar o Room para salvar a lista no database e efetuar o filtro e pesquisa dos produtos, mas não por falte de conhecimento e sim tempo. 
- Mas te convido a dar uma olhadinha nesse repositorio de um outro projeto que fiz, que tem exatamente esse comportamento que era esperado. (https://github.com/DEVenicio/Saga-Marvel)
- Nesse projeto é possivel filtrar por nome, adicionar e remover de uma lista de favoritos entre outras coisas. 
- Da uma olhadinha, vale a pena conferir :)


<img src="https://github.com/DEVenicio/PetStore/blob/master/petStoreGif.gif" width="320">



## Tecnologias e Ferramentas utilizadas

- Arquitetura MVVM
- Consumo de API Rest através do Retrofit
- Layout em XML
- RecyclerView
- LiveData
- Coroutines
- Fragments
- Lifecycle
- ViewBinding
- Gson
- Safe Args
- Glide (para carregamento de imagens)
- Navigation Component
- ViewModel
- Injeção de dependência com Koin




:mailbox: Como me achar **---->**   [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/venicio-almeida/)](https://www.linkedin.com/in/venicio-almeida/)                                           [![Gmail Badge](https://img.shields.io/badge/-Gmail-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:engineer.venicio@gmail.com)](mailto:engineer.venicio@gmail.com)

