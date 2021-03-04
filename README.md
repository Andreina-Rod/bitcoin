**Problema**
A) Construir un microservicio que haciendo uso del siguiente servicio REST (https://cex.io/api/last_price/BTC/USD)
realice una llamada recurrente cada 10 segundos, almacene los datos y que exponga a través de un API rest las siguientes funcionalidades:

1. Obtener el precio del bitcoin en cierto timestamp.
2. Conocer el promedio de valor entre dos timestamps.

**Solucion**

La solución propuesta consta de un microservicio utilizando:
- Spring Boot
- DB H2 en memoria
- libreria Lombok

Este servicio expone 2 endpoints:
1. /v1/bitcoins/by-timestamp?date={date} para Obtener el precio del bitcoin en cierto timestamp.
2. /v1/bitcoins/average-between-timestamps?date1={date1}&date2={date2} para Conocer el promedio de valor entre dos timestamps.

Además posee un Scheduled para realizar las llamadas al servicio de obtencion de datos que alimenta la base de datos.


**INSTALACIÓN**
- Clonar el repositorio 
    https://github.com/Andreina-Rod/bitcoin.git
- Importar como proyecto maven
- Run BitcoinApplication
