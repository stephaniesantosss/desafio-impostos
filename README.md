
# Api de imposto

Aplicação que realiza calculo de tarifas para produtos de seguro com base no valor informado e categoria.


## API Reference

#### Calcula tarifa produto de seguro por categoria

```http
  POST localhost:8080/seguros/cotacao
```

Request Body:

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `nome` | `string` | **Required**. Nome do Seguro |
| `categoria` | `string` | **Required**. Nome da Categoria |
| `preco_base` | `double` | **Required**. Preço base do seguro |

Response Body: [201]

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `string` | **Required**. Id do Seguro por categoria |
| `nome` | `string` | **Required**. Nome do Seguro |
| `categoria` | `string` | **Required**. Categoria do Seguro |
| `preco_base` | `double` | **Required**. Preco base do seguro |
| `preco_tarifado` | `double` | **Required**. Preco tarifado com base no calculo do preco base e categoria |

## Pré requisitos para executar a aplicação local

* JDK 17
* Maven 3.8.6
    * Add maven no pom e executar o comando `mvn clean install` no terminal da aplicação ou direto no console do maven localizado do lado direito superior
    ![img.png](img.png)

## Environment Variables

Para executar este projeto, você precisará instalar plugin EnvFile e apontar o arquivo .env nas configurações da sua aplication para que a aplicação consiga ler as variaveis e executar a aplicação com sucesso :)
![img_2.png](img_2.png)

## Curl para executar aplicação local via Insomnia ou Postman

```
curl --request POST \
  --url http://localhost:8080/seguros/cotacao \
  --header 'Content-Type: application/json' \
  --data '{
	"nome": "Seguro de Vida Individual",
	"categoria": "AUTO",
	"preco_base": 55.00
}'

