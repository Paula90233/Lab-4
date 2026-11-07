## Requisitos
Colocar todos los `.java` en una misma carpeta (src).

## Para compilar
`javac -d bin src/*.java`

## Para ejecutar
`java -cp bin Main`

## Datos iniciales
Tres oficinas y dos dispositivos de cada tipo. 
Todos inician apagados, menos los sensores de humo. 
La hora comienza en 0.

## Para realizar
- Encender L1, avanzar una hora: con nivel 100 y 1000 W debe consumir 1.000 kWh
- Encender CL1, ajustar a 60 y avanzar: 1.080 kWh
- Encender CI1, ajustar a 10 y avanzar: 0.8 veces el consumo de un climatizador equivalente
- Registrar en CL1 temperaturas 28, 32 y 40 para probar alertas Baja, Alta y Crítica
- Registrar en S1 lecturas 150 y 300 para probar alertas Alta y Crítica
- Encender CA1 y registrar movimiento a la hora 0: alerta Alta
- Avanzar 24 horas para observar facturas automáticas
- Intentar apagar S1, ajustar un dispositivo apagado y registrar valores fuera de rango
Los datos se conservan solo cuando el programa se ejecuta.
